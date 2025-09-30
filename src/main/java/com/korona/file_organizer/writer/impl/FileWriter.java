package com.korona.file_organizer.writer.impl;

import com.korona.file_organizer.exception.FileOperationException;
import com.korona.file_organizer.writer.OutputWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriter implements OutputWriter {
    private static final Logger logger = LogManager.getLogger(FileWriter.class);

    private final PrintWriter writer;

    public FileWriter(Path filePath) {
        logger.info("Writing file: {}", filePath);

        try {
            Files.createDirectories(filePath.getParent());
            this.writer = new PrintWriter(Files.newBufferedWriter(filePath));
        } catch (IOException e) {
            throw new FileOperationException("Failed to open file for writing: " + filePath, e);
        }
    }

    @Override
    public void writeLine(String line) {
        writer.println(line);
    }

    @Override
    public void close() {
        writer.close();
    }
}