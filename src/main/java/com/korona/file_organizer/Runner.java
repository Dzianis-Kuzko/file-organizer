package com.korona.file_organizer;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.controller.AppController;
import com.korona.file_organizer.controller.DataLoadingController;
import com.korona.file_organizer.controller.DepartmentWriterController;
import com.korona.file_organizer.controller.InvalidDataWriterController;
import com.korona.file_organizer.controller.StatsWriterController;
import com.korona.file_organizer.parser.arg.ArgsParser;
import com.korona.file_organizer.parser.arg.factory.ArgHandlerFactory;
import com.korona.file_organizer.parser.line.LineParser;
import com.korona.file_organizer.parser.line.factory.WorkerLineHandlerFactory;
import com.korona.file_organizer.reader.FileFinder;
import com.korona.file_organizer.reader.FileReader;
import com.korona.file_organizer.repository.DepartmentRepository;
import com.korona.file_organizer.repository.InvalidDataRepository;
import com.korona.file_organizer.repository.PendingDataRepository;
import com.korona.file_organizer.service.DepartmentService;
import com.korona.file_organizer.service.DepartmentStatsService;
import com.korona.file_organizer.service.InvalidDataService;
import com.korona.file_organizer.service.PendingDataService;
import com.korona.file_organizer.validation.SalaryValidator;
import com.korona.file_organizer.validation.config.ConfigValidator;
import com.korona.file_organizer.validation.config.factory.ConfigValidatorFactory;

public class Runner {
    public static void main(String[] args) {
        ArgsParser argsParser = new ArgsParser(ArgHandlerFactory.createHandlers());
        Config config = argsParser.parse(args);

        ConfigValidator configValidator = new ConfigValidator(ConfigValidatorFactory.createRules());
        configValidator.validate(config);



        InvalidDataRepository invalidDataRepo = new InvalidDataRepository();
        DepartmentRepository departmentRepo = new DepartmentRepository();

        InvalidDataService invalidDataService = new InvalidDataService(invalidDataRepo);
        DepartmentService departmentService = new DepartmentService(config, departmentRepo);
        DepartmentStatsService departmentStatsService = new DepartmentStatsService();

        FileFinder fileFinder = new FileFinder();
        FileReader fileReader = new FileReader();
        LineParser lineParser = new LineParser(WorkerLineHandlerFactory.createWorkerLineHandlers());


        DataLoadingController dataLoadingController = new DataLoadingController(
                fileFinder,
                fileReader,
                lineParser,
                invalidDataService,
                new PendingDataService(new PendingDataRepository(), new SalaryValidator()),
                departmentService

        );

        DepartmentWriterController departmentWriterController = new DepartmentWriterController(departmentService, config);
        InvalidDataWriterController invalidDataWriterController = new InvalidDataWriterController(invalidDataService);
        StatsWriterController statsWriterController = new StatsWriterController(departmentService, departmentStatsService, config);

        new AppController(dataLoadingController, departmentWriterController, invalidDataWriterController, statsWriterController, config).process();


        try {

        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка параметров: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Неожиданная ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
