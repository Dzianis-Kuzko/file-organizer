package com.korona.file_organizer.config;

import com.korona.file_organizer.config.enums.impl.OutputTypeForStats;
import com.korona.file_organizer.config.enums.impl.SortField;
import com.korona.file_organizer.config.enums.impl.SortOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.nio.file.Path;

@Getter
@Setter
@AllArgsConstructor
public class Config {
    private SortField sortBy;
    private SortOrder order;

    private boolean statEnabled;
    private PositionalParam<OutputTypeForStats> outputTypeForStats;
    private boolean outputTypeForStatsDefaulted;
    private PositionalParam<Path> outputPathForStats;

    private Path inputDir = Path.of(".");
    private Path outputDir = Path.of("output");
    private String fileExtension = ".sb";
    private String fileNameForErrorLog = "error.log";

    public Config() {
        this.outputTypeForStats = new PositionalParam<>();
        this.outputTypeForStats.setValue(OutputTypeForStats.CONSOLE);
        this.outputTypeForStatsDefaulted = true;
        this.outputPathForStats = new PositionalParam<>();
    }
}
