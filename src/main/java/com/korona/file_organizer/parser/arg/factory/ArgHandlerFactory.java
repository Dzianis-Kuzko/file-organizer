package com.korona.file_organizer.parser.arg.factory;

import com.korona.file_organizer.config.enums.impl.OrderFlag;
import com.korona.file_organizer.config.enums.impl.OutputPathForStatsFlag;
import com.korona.file_organizer.config.enums.impl.OutputTypeForStats;
import com.korona.file_organizer.config.enums.impl.SortFlag;
import com.korona.file_organizer.config.enums.impl.StatsFlag;
import com.korona.file_organizer.config.enums.impl.Valued;
import com.korona.file_organizer.parser.arg.handlers.ArgHandler;
import com.korona.file_organizer.parser.arg.handlers.impl.OrderHandler;
import com.korona.file_organizer.parser.arg.handlers.impl.OutputPathForStatsHandler;
import com.korona.file_organizer.parser.arg.handlers.impl.OutputTypeForStatsHandler;
import com.korona.file_organizer.parser.arg.handlers.impl.SortHandler;
import com.korona.file_organizer.parser.arg.handlers.impl.StatsHandler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class ArgHandlerFactory {
    private ArgHandlerFactory() {
        throw new UnsupportedOperationException("Utility class, should not be instantiated");
    }

    public static Map<String, ArgHandler> createHandlers() {
        Map<String, ArgHandler> handlers = new HashMap<>();

        registerHandler(handlers, SortFlag.class, new SortHandler());
        registerHandler(handlers, OrderFlag.class, new OrderHandler());
        registerHandler(handlers, StatsFlag.class, new StatsHandler());
        registerHandler(handlers, OutputTypeForStats.class, new OutputTypeForStatsHandler());
        registerHandler(handlers, OutputPathForStatsFlag.class, new OutputPathForStatsHandler());

        return Map.copyOf(handlers);
    }

    private static <T extends Enum<T> & Valued> void registerHandler(
            Map<String, ArgHandler> handlers,
            Class<T> flagEnum,
            ArgHandler handler) {

        Arrays.stream(flagEnum.getEnumConstants())
                .map(Valued::getValue)
                .forEach(flag -> handlers.put(flag, handler));
    }
}