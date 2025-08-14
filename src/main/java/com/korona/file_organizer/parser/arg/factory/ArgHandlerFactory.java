package com.korona.file_organizer.parser.arg.factory;

import com.korona.file_organizer.parser.arg.handlers.ArgHandler;
import com.korona.file_organizer.parser.arg.handlers.impl.OrderHandler;
import com.korona.file_organizer.parser.arg.handlers.impl.OutputPathHandler;
import com.korona.file_organizer.parser.arg.handlers.impl.OutputTypeHandler;
import com.korona.file_organizer.parser.arg.handlers.impl.SortHandler;
import com.korona.file_organizer.parser.arg.handlers.impl.StatHandler;

import java.util.List;

public class ArgHandlerFactory {
    public List<ArgHandler> createHandlers() {
        return List.of(
                new SortHandler(),
                new OrderHandler(),
                new StatHandler(),
                new OutputTypeHandler(),
                new OutputPathHandler()
        );
    }
}