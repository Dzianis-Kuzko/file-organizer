package com.korona.file_organizer.model;

import com.korona.file_organizer.model.enums.OutputType;
import com.korona.file_organizer.model.enums.SortField;
import com.korona.file_organizer.model.enums.SortOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.nio.file.Path;

@Getter
@Setter
@ToString
public class Config {
    private SortField sortBy;
    private SortOrder order;
    private boolean statEnabled;
    private PositionalParam<OutputType> outputType;
    private boolean outputTypeDefaulted;
    private PositionalParam<Path> outputPath;

    public Config() {
        this.outputType= new PositionalParam<>();
        this.outputType.setValue(OutputType.CONSOLE);
        this.outputTypeDefaulted = true;
        this.outputPath= new PositionalParam<>();
    }
}
