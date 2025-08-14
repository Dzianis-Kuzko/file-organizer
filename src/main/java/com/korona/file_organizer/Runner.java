package com.korona.file_organizer;

import com.korona.file_organizer.controller.FileDataLoadingController;
import com.korona.file_organizer.file.FileFinder;
import com.korona.file_organizer.file.FileReader;
import com.korona.file_organizer.model.Config;
import com.korona.file_organizer.model.DepartmentsData;
import com.korona.file_organizer.model.Employee;
import com.korona.file_organizer.model.InvalidData;
import com.korona.file_organizer.model.Manager;
import com.korona.file_organizer.parser.arg.ArgsParser;
import com.korona.file_organizer.parser.arg.factory.ArgHandlerFactory;
import com.korona.file_organizer.parser.line.LineParser;
import com.korona.file_organizer.parser.line.factory.WorkerLineHandlerFactory;
import com.korona.file_organizer.repository.Repository;
import com.korona.file_organizer.repository.impl.EmployeeRepository;
import com.korona.file_organizer.repository.impl.InvalidDataRepository;
import com.korona.file_organizer.repository.impl.ManagerRepository;
import com.korona.file_organizer.service.Service;
import com.korona.file_organizer.service.impl.EmployeeService;
import com.korona.file_organizer.service.impl.InvalidDataService;
import com.korona.file_organizer.service.impl.ManagerService;
import com.korona.file_organizer.validation.ConfigValidator;
import com.korona.file_organizer.validation.factory.ConfigValidatorFactory;

public class Runner {
    public static void main(String[] args, FileReader fileReader1) {
        try {

            FileFinder fileFinder = new FileFinder();
            FileReader fileReader = new FileReader();
            LineParser lineParser = new LineParser(new WorkerLineHandlerFactory().createWorkerLineHandlers());

            Repository<Employee> employeeRepo = new EmployeeRepository();
            Repository<Manager> managerRepo = new ManagerRepository();
            Repository<String> invalidDataRepo = new InvalidDataRepository();

            Service<Employee> employeeService = new EmployeeService(employeeRepo);
            Service<Manager> managerService = new ManagerService(managerRepo);
            Service<String> invalidDataService = new InvalidDataService(invalidDataRepo);

            FileDataLoadingController fileDataLoadingController = new FileDataLoadingController(
                    fileFinder,
                    fileReader,
                    lineParser,
                    employeeService,
                    managerService,
                    invalidDataService);
            fileDataLoadingController.loadData();

            ArgHandlerFactory argHandlerFactory = new ArgHandlerFactory();
            ArgsParser argsParser = new ArgsParser(argHandlerFactory.createHandlers());
            Config config = argsParser.parse(args);

            ConfigValidatorFactory validatorFactory = new ConfigValidatorFactory();
            ConfigValidator validator = new ConfigValidator(validatorFactory.createRules());
            validator.validate(config);


            System.out.println(DepartmentsData.employeesByManagerId);
            System.out.println("---------------------------------");
            System.out.println(DepartmentsData.managerByDepartmentName);
            System.out.println("---------------------------------");
            System.out.println(InvalidData.invalidWorker);
            System.out.println(config);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка параметров: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Неожиданная ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
