package com.korona.file_organizer;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.controller.AppController;
import com.korona.file_organizer.controller.DataLoadingController;
import com.korona.file_organizer.controller.DepartmentWriterController;
import com.korona.file_organizer.controller.InvalidDataWriterController;
import com.korona.file_organizer.controller.StatsWriterController;
import com.korona.file_organizer.model.Employee;
import com.korona.file_organizer.model.Manager;
import com.korona.file_organizer.parser.Parser;
import com.korona.file_organizer.parser.arg.ArgsParser;
import com.korona.file_organizer.parser.arg.factory.ArgHandlerFactory;
import com.korona.file_organizer.parser.line.LineParser;
import com.korona.file_organizer.parser.line.factory.WorkerLineHandlerFactory;
import com.korona.file_organizer.parser.line.handlers.WorkerLineHandler;
import com.korona.file_organizer.reader.FileFinder;
import com.korona.file_organizer.reader.FileReader;
import com.korona.file_organizer.repository.DepartmentRepository;
import com.korona.file_organizer.repository.InvalidDataRepository;
import com.korona.file_organizer.repository.PendingDataRepository;
import com.korona.file_organizer.service.DepartmentService;
import com.korona.file_organizer.service.DepartmentStatsService;
import com.korona.file_organizer.service.InvalidDataService;
import com.korona.file_organizer.service.PendingDataService;
import com.korona.file_organizer.validation.Validator;
import com.korona.file_organizer.validation.config.ConfigValidator;
import com.korona.file_organizer.validation.config.factory.ConfigValidatorFactory;
import com.korona.file_organizer.validation.worker.factory.WorkerValidatorFactory;

import java.util.Map;

public final class AppFactory {
    private AppFactory() {
        throw new UnsupportedOperationException("Utility class, should not be instantiated");
    }

    public static AppController createAppController(String[] args) {
        Parser<String[], Config> argsParser = new ArgsParser(ArgHandlerFactory.createHandlers());
        Config config = argsParser.parse(args);

        Validator<Config> configValidator = new ConfigValidator(ConfigValidatorFactory.createRules());
        configValidator.validate(config);

        Validator<Manager> managerValidator = WorkerValidatorFactory.createManagerValidator();
        Validator<Employee> employeeValidator = WorkerValidatorFactory.createEmployeeValidator();

        InvalidDataRepository invalidDataRepo = new InvalidDataRepository();
        DepartmentRepository departmentRepo = new DepartmentRepository();
        PendingDataRepository departmentPendingRepo = new PendingDataRepository();

        InvalidDataService invalidDataService = new InvalidDataService(invalidDataRepo);
        DepartmentService departmentService = new DepartmentService(departmentRepo);
        DepartmentStatsService departmentStatsService = new DepartmentStatsService();
        PendingDataService pendingDataService = new PendingDataService(
                departmentPendingRepo,
                managerValidator,
                employeeValidator);

        FileFinder fileFinder = new FileFinder();
        FileReader fileReader = new FileReader();

        Map<String, WorkerLineHandler> handlers = WorkerLineHandlerFactory.createWorkerLineHandlers();
        LineParser lineParser = new LineParser(handlers);

        DataLoadingController dataLoadingController = new DataLoadingController(
                fileFinder,
                fileReader,
                lineParser,
                invalidDataService,
                pendingDataService,
                departmentService,
                config
        );

        DepartmentWriterController departmentWriterController = new DepartmentWriterController(departmentService, config);
        InvalidDataWriterController invalidDataWriterController = new InvalidDataWriterController(invalidDataService, config);
        StatsWriterController statsWriterController = new StatsWriterController(departmentService, departmentStatsService, config);

        return new AppController(
                dataLoadingController,
                departmentWriterController,
                invalidDataWriterController,
                statsWriterController,
                config
        );
    }
}
