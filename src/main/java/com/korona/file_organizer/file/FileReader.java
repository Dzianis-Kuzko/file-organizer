package com.korona.file_organizer.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileReader {
    public Stream<String> readLines(Path file) {
        try {
            return Files.lines(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}