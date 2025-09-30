package com.korona.file_organizer.reader;

import com.korona.file_organizer.exception.FileOperationException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class FileFinder {

    public List<Path> findFiles(Path path, String fileExtension) {
        try (Stream<Path> files = Files.list(path)) {
            return files
                    .filter(Files::isRegularFile)
                    .filter(p -> p.getFileName().toString()
                            .toLowerCase()
                            .endsWith(fileExtension.toLowerCase()))
                    .toList();

        } catch (IOException e) {
            throw new FileOperationException("Error. Cannot access directory: " + path, e);
        }
    }
}
