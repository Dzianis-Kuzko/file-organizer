package com.korona.file_organizer;

import com.korona.file_organizer.model.Config;
import com.korona.file_organizer.parser.ArgsParser;
import com.korona.file_organizer.parser.factory.ArgHandlerFactory;
import com.korona.file_organizer.validation.ConfigValidator;
import com.korona.file_organizer.validation.factory.ConfigValidatorFactory;

public class Runner {
    public static void main(String[] args) {
        try {
            ArgsParser argsParser = new ArgsParser(ArgHandlerFactory.handlers);
            Config config = argsParser.parse(args);

            ConfigValidatorFactory validatorFactory = new ConfigValidatorFactory();
            ConfigValidator validator = new ConfigValidator(validatorFactory.createRules());
            validator.validate(config);

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
