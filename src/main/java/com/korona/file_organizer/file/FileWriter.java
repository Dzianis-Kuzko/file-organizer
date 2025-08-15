package com.korona.file_organizer.file;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriter implements AutoCloseable {
    private final BufferedWriter writer;

    public FileWriter(Path filePath) {
        try {
            Files.createDirectories(filePath.getParent());
            this.writer = Files.newBufferedWriter(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка открытия файла для записи: " + filePath, e);
        }
    }

    public void writeLine(String line) {
        try {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи строки в файл", e);
        }
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка закрытия файла", e);
        }
    }
}