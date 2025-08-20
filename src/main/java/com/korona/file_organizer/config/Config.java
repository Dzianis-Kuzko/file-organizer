package com.korona.file_organizer.config;

import com.korona.file_organizer.config.enums.OutputTypeForStats;
import com.korona.file_organizer.config.enums.SortField;
import com.korona.file_organizer.config.enums.SortOrder;
import lombok.Getter;
import lombok.Setter;

import java.nio.file.Path;

@Getter
@Setter
public class Config {
    private SortField sortBy;
    private SortOrder order;
    private boolean statEnabled;
    private PositionalParam<OutputTypeForStats> outputType;
    private boolean outputTypeDefaulted;
    private PositionalParam<Path> outputPath;

    public Config() {
        this.outputType= new PositionalParam<>();
        this.outputType.setValue(OutputTypeForStats.CONSOLE);
        this.outputTypeDefaulted = true;
        this.outputPath= new PositionalParam<>();
    }
}
