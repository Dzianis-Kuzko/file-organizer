package com.korona.file_organizer;

import com.korona.file_organizer.controller.AppController;
import com.korona.file_organizer.controller.FileDataLoadingController;
import com.korona.file_organizer.controller.FileDepartmentWriterController;
import com.korona.file_organizer.controller.FileInvalidDataWriterController;
import com.korona.file_organizer.file.FileFinder;
import com.korona.file_organizer.file.FileReader;
import com.korona.file_organizer.model.Config;
import com.korona.file_organizer.parser.arg.ArgsParser;
import com.korona.file_organizer.parser.arg.factory.ArgHandlerFactory;
import com.korona.file_organizer.parser.line.LineParser;
import com.korona.file_organizer.parser.line.factory.WorkerLineHandlerFactory;
import com.korona.file_organizer.repository.impl.EmployeeRepository;
import com.korona.file_organizer.repository.impl.InvalidDataRepository;
import com.korona.file_organizer.repository.impl.ManagerRepository;
import com.korona.file_organizer.service.impl.DepartmentService;
import com.korona.file_organizer.service.impl.EmployeeService;
import com.korona.file_organizer.service.impl.InvalidDataService;
import com.korona.file_organizer.service.impl.ManagerService;

public class Runner {
    public static void main(String[] args) {
        ArgHandlerFactory argHandlerFactory = new ArgHandlerFactory();
        ArgsParser argsParser = new ArgsParser(argHandlerFactory.createHandlers());
        Config config = argsParser.parse(args);


        EmployeeRepository employeeRepo = new EmployeeRepository();
        ManagerRepository managerRepo = new ManagerRepository();
        InvalidDataRepository invalidDataRepo = new InvalidDataRepository();

        ManagerService managerService = new ManagerService(managerRepo);
        EmployeeService employeeService = new EmployeeService(employeeRepo, managerService);

        InvalidDataService invalidDataService = new InvalidDataService(invalidDataRepo);
        DepartmentService departmentService = new DepartmentService(managerService, employeeService, config);

        FileFinder fileFinder = new FileFinder();
        FileReader fileReader = new FileReader();
        LineParser lineParser = new LineParser(new WorkerLineHandlerFactory().createWorkerLineHandlers());


        FileDataLoadingController fileDataLoadingController = new FileDataLoadingController(
                fileFinder,
                fileReader,
                lineParser,
                employeeService,
                managerService,
                invalidDataService);
        FileDepartmentWriterController departmentWriterController = new FileDepartmentWriterController(departmentService, managerService);
        FileInvalidDataWriterController invalidDataWriterController = new FileInvalidDataWriterController(invalidDataService, employeeService);

        new AppController(fileDataLoadingController, departmentWriterController, invalidDataWriterController).process(args);


        try {
//            ArgHandlerFactory argHandlerFactory = new ArgHandlerFactory();
//            ArgsParser argsParser = new ArgsParser(argHandlerFactory.createHandlers());
//            Config config = argsParser.parse(args);
//
//            FileFinder fileFinder = new FileFinder();
//            FileReader fileReader = new FileReader();
//            LineParser lineParser = new LineParser(new WorkerLineHandlerFactory().createWorkerLineHandlers());
//
//            EmployeeRepository employeeRepo = new EmployeeRepository();
//            ManagerRepository managerRepo = new ManagerRepository();
//            InvalidDataRepository invalidDataRepo = new InvalidDataRepository();
//
//            EmployeeService employeeService = new EmployeeService(employeeRepo);
//            ManagerService managerService = new ManagerService(managerRepo);
//            InvalidDataService invalidDataService = new InvalidDataService(invalidDataRepo);
//            DepartmentService departmentService = new DepartmentService(managerService, employeeService, config);
//
//            FileDataLoadingController fileDataLoadingController = new FileDataLoadingController(
//                    fileFinder,
//                    fileReader,
//                    lineParser,
//                    employeeService,
//                    managerService,
//                    invalidDataService);
//            fileDataLoadingController.loadData();
//
//
//            ConfigValidatorFactory validatorFactory = new ConfigValidatorFactory();
//            ConfigValidator validator = new ConfigValidator(validatorFactory.createRules());
//            validator.validate(config);
//
//            FileDepartmentWriterController departmentWriterController = new FileDepartmentWriterController();
//            FileInvalidDataWriterController invalidDataWriterController = new FileInvalidDataWriterController(invalidDataService);
//            AppController appController = new AppController(employeeService, managerService, departmentService, departmentWriterController, invalidDataWriterController);
//            appController.process();
//
//
//            System.out.println(((EmployeeRepository) employeeRepo).getEmployeesByManagerId());
//            System.out.println("---------------------------------");
//            System.out.println(((ManagerRepository) managerRepo).getManagers());
//            System.out.println("---------------------------------");
//            System.out.println(((InvalidDataRepository) invalidDataRepo).getInvalidData());
//            System.out.println(config);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка параметров: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Неожиданная ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
