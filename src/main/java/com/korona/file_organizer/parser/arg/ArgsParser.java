package com.korona.file_organizer.parser.arg;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.parser.arg.handlers.ArgHandler;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class ArgsParser {
    public static final String KEY_VALUE_SEPARATOR = "=";

    private final Map<String, ArgHandler> handlers;

    public Config parse(String[] args) {
        Config config = new Config();

        for (int i = 0; i < args.length; i++) {
            String[] keyValue = args[i].split(KEY_VALUE_SEPARATOR, 2);
            String key = keyValue[0];
            String value = keyValue.length > 1 ? keyValue[1] : null;

            ArgHandler handler = handlers.get(key);
            if (handler == null) {
                throw new IllegalArgumentException("Неизвестный параметр: " + key);
            }

            handler.handle(key, value, config, i);
        }

        return config;
    }
}
