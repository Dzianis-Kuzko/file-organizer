package com.korona.file_organizer;

import com.korona.file_organizer.controller.Controller;
import com.korona.file_organizer.model.Config;
import com.korona.file_organizer.parser.arg.ArgsParser;
import com.korona.file_organizer.parser.arg.factory.ArgHandlerFactory;
import com.korona.file_organizer.service.WorkerService;
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

            WorkerService workerService = new WorkerService();
            Controller controller = new Controller(workerService);
            controller.run(config);


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
