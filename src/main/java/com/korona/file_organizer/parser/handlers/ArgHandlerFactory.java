package com.korona.file_organizer.parser.handlers;

import java.util.List;

public class ArgHandlerFactory {
    public static List<ArgHandler> handlers = List.of(
            new SortHandler(),
            new OrderHandler(),
            new StatHandler(),
            new OutputHandler(),
            new OutputPathHandler()
    );
}
