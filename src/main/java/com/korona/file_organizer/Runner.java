package com.korona.file_organizer;

import com.korona.file_organizer.model.Config;
import com.korona.file_organizer.parser.ArgsParser;
import com.korona.file_organizer.parser.handlers.ArgHandlerFactory;

public class Runner {
    public static void main(String[] args) {
        try {
            ArgsParser argsParser = new ArgsParser(ArgHandlerFactory.handlers);
            Config config = argsParser.parse(args);

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
