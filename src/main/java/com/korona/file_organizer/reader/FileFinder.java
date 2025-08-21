package com.korona.file_organizer.reader;

import com.korona.file_organizer.exceptions.FileOperationException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class FileFinder {

    public List<Path> findFiles(String dirPath, String fileExtension) {
        try (Stream<Path> files = Files.list(Path.of(dirPath))) {
            return files
                    .filter(Files::isRegularFile)
                    .filter(p -> p.getFileName().toString()
                            .toLowerCase()
                            .endsWith(fileExtension.toLowerCase()))
                    .toList();

        } catch (IOException e) {
            throw new FileOperationException(
                    "Cannot access directory: " + dirPath, e);
        }
    }
}
