package com.korona.file_organizer.parser.arg;

import com.korona.file_organizer.model.Config;
import com.korona.file_organizer.parser.arg.handlers.ArgHandler;

import java.util.List;

public class ArgsParser {
    private final List<ArgHandler> handlers;

    public ArgsParser(List<ArgHandler> handlers) {
        this.handlers = handlers;
    }

    public Config parse(String[] args) {
        Config config = new Config();

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            boolean handled = false;

            for (ArgHandler handler : handlers) {
                if (handler.support(arg)) {
                    handler.handle(args, i, config);
                    handled = true;
                    break;
                }
            }

            if (!handled) {
                throw new IllegalArgumentException("Неизвестный параметр: " + arg);
            }
        }

        return config;
    }
}
