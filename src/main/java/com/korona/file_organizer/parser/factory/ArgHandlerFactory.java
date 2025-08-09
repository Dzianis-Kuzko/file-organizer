package com.korona.file_organizer.parser.factory;

import com.korona.file_organizer.parser.handlers.ArgHandler;
import com.korona.file_organizer.parser.handlers.OrderHandler;
import com.korona.file_organizer.parser.handlers.OutputTypeHandler;
import com.korona.file_organizer.parser.handlers.OutputPathHandler;
import com.korona.file_organizer.parser.handlers.SortHandler;
import com.korona.file_organizer.parser.handlers.StatHandler;

import java.util.List;

public class ArgHandlerFactory {
    public static List<ArgHandler> handlers = List.of(
            new SortHandler(),
            new OrderHandler(),
            new StatHandler(),
            new OutputTypeHandler(),
            new OutputPathHandler()
    );
}
