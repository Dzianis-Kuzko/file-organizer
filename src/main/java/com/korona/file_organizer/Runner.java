package com.korona.file_organizer;

import com.korona.file_organizer.file.FileFinder;
import com.korona.file_organizer.file.FileReader;
import com.korona.file_organizer.model.Config;
import com.korona.file_organizer.model.DepartmentsData;
import com.korona.file_organizer.model.InvalidData;
import com.korona.file_organizer.parser.arg.ArgsParser;
import com.korona.file_organizer.parser.arg.factory.ArgHandlerFactory;
import com.korona.file_organizer.parser.line.LineParser;
import com.korona.file_organizer.parser.line.factory.WorkerLineHandlerFactory;
import com.korona.file_organizer.service.FileDataLoadingService;
import com.korona.file_organizer.validation.ConfigValidator;
import com.korona.file_organizer.validation.factory.ConfigValidatorFactory;

public class Runner {
    public static void main(String[] args) {
        try {
            ArgHandlerFactory argHandlerFactory = new ArgHandlerFactory();
            ArgsParser argsParser = new ArgsParser(argHandlerFactory.createHandlers());
            Config config = argsParser.parse(args);

            ConfigValidatorFactory validatorFactory = new ConfigValidatorFactory();
            ConfigValidator validator = new ConfigValidator(validatorFactory.createRules());
            validator.validate(config);

            FileFinder fileFinder = new FileFinder();
            FileReader fileReader = new FileReader();
            LineParser lineParser = new LineParser(new WorkerLineHandlerFactory().createWorkerLineHandlers());
            FileDataLoadingService fileDataLoadingService = new FileDataLoadingService(fileFinder, fileReader,lineParser);
            fileDataLoadingService.loadAndValidateData();

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
