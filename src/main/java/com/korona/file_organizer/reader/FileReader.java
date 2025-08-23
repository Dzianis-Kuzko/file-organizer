package com.korona.file_organizer.reader;

import com.korona.file_organizer.exception.FileOperationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileReader {
    private static final Logger logger = LogManager.getLogger(FileReader.class);

    public Stream<String> readLines(Path file) {
        logger.info("Reading file: {}", file);

        try {
            return Files.lines(file);
        } catch (IOException e) {
            throw new FileOperationException("Failed to read file: " + file, e);
        }
    }
}