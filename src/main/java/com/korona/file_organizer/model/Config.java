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
    private PositionalParam<OutputType> output;
    private PositionalParam<Path> outputPath;
}
