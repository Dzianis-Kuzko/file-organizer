package com.korona.file_organizer.controller;

import com.korona.file_organizer.constant.ProjectConstant;
import com.korona.file_organizer.writer.OutputWriter;
import com.korona.file_organizer.writer.impl.FileWriter;
import com.korona.file_organizer.mapper.InvalidDataMapper;
import com.korona.file_organizer.model.InvalidData;
import com.korona.file_organizer.service.InvalidDataService;
import lombok.AllArgsConstructor;

import java.nio.file.Path;
import java.util.List;

@AllArgsConstructor
public class InvalidDataWriterController {
    private final InvalidDataService invalidDataService;

    public void writeInvalidData() {
        List<InvalidData> invalidDataList = invalidDataService.getAllInvalidData();

        Path path = buildFilePath();

        try (OutputWriter writer = new FileWriter(path)) {
            for (InvalidData invalidData : invalidDataList) {
                writer.writeLine(InvalidDataMapper.mapToString(invalidData));
            }
        }
    }

    private Path buildFilePath() {
        return Path.of(ProjectConstant.OUTPUT_FILES_DIR, ProjectConstant.FILE_NANE_FOR_INVALID_DATA);
    }
}
