package com.korona.file_organizer.parser.arg.factory;

import com.korona.file_organizer.parser.arg.handlers.ArgHandler;
import com.korona.file_organizer.parser.arg.handlers.OrderHandler;
import com.korona.file_organizer.parser.arg.handlers.OutputPathHandler;
import com.korona.file_organizer.parser.arg.handlers.OutputTypeHandler;
import com.korona.file_organizer.parser.arg.handlers.SortHandler;
import com.korona.file_organizer.parser.arg.handlers.StatHandler;

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