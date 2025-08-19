package com.korona.file_organizer;

import com.korona.file_organizer.controller.AppController;
import com.korona.file_organizer.controller.FileDataLoadingController;
import com.korona.file_organizer.controller.FileDepartmentWriterController;
import com.korona.file_organizer.controller.FileInvalidDataWriterController;
import com.korona.file_organizer.controller.StatsWriterController;
import com.korona.file_organizer.file.FileFinder;
import com.korona.file_organizer.file.FileReader;
import com.korona.file_organizer.model.Config;
import com.korona.file_organizer.parser.arg.ArgsParser;
import com.korona.file_organizer.parser.arg.factory.ArgHandlerFactory;
import com.korona.file_organizer.parser.line.LineParser;
import com.korona.file_organizer.parser.line.factory.WorkerLineHandlerFactory;
import com.korona.file_organizer.repository.DepartmentRepository;
import com.korona.file_organizer.repository.InvalidDataRepository;
import com.korona.file_organizer.repository.PendingDataRepository;
import com.korona.file_organizer.service.ComparatorFactory;
import com.korona.file_organizer.service.DepartmentService;
import com.korona.file_organizer.service.DepartmentStatsService;
import com.korona.file_organizer.service.InvalidDataService;
import com.korona.file_organizer.service.PendingDataService;
import com.korona.file_organizer.validation.SalaryValidator;

public class Runner {
    public static void main(String[] args) {
        ArgHandlerFactory argHandlerFactory = new ArgHandlerFactory();
        ArgsParser argsParser = new ArgsParser(argHandlerFactory.createHandlers());
        Config config = argsParser.parse(args);


        InvalidDataRepository invalidDataRepo = new InvalidDataRepository();
        DepartmentRepository departmentRepo = new DepartmentRepository();

        InvalidDataService invalidDataService = new InvalidDataService(invalidDataRepo);
        DepartmentService departmentService = new DepartmentService(config, departmentRepo);
        DepartmentStatsService departmentStatsService = new DepartmentStatsService();

        FileFinder fileFinder = new FileFinder();
        FileReader fileReader = new FileReader();
        LineParser lineParser = new LineParser(new WorkerLineHandlerFactory().createWorkerLineHandlers());


        FileDataLoadingController fileDataLoadingController = new FileDataLoadingController(
                fileFinder,
                fileReader,
                lineParser,
                invalidDataService,
                new PendingDataService(new PendingDataRepository(), new SalaryValidator()),
                departmentService

        );

        ComparatorFactory comparatorFactory = new ComparatorFactory();
        FileDepartmentWriterController departmentWriterController = new FileDepartmentWriterController(departmentService, comparatorFactory, config);
        FileInvalidDataWriterController invalidDataWriterController = new FileInvalidDataWriterController(invalidDataService);
        StatsWriterController statsWriterController = new StatsWriterController(departmentService, departmentStatsService, config);

        new AppController(fileDataLoadingController, departmentWriterController, invalidDataWriterController, statsWriterController, config).process(args);


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
