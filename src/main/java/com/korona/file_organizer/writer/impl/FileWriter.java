package com.korona.file_organizer.writer.impl;

import com.korona.file_organizer.writer.OutputWriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriter implements OutputWriter {
    private final PrintWriter writer;

    public FileWriter(Path filePath) {
        try {
            Files.createDirectories(filePath.getParent());
            this.writer = new PrintWriter(Files.newBufferedWriter(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Ошибка открытия файла для записи: " + filePath, e);
        }
    }

    public void writeLine(String line) {
        writer.println(line);
    }

    @Override
    public void close() {
        writer.close();
    }
}