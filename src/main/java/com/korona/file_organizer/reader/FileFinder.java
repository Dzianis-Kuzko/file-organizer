package com.korona.file_organizer.reader;

import com.korona.file_organizer.exceptions.InvalidPathException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class FileFinder {

    public List<Path> findFiles(String dirPath, String fileExtension)
            throws InvalidPathException {
        try {
            //Path directory = validateDirectory(dirPath);


            try (Stream<Path> files = Files.list(Path.of(dirPath))) {
                return files
                        .filter(Files::isRegularFile)
                        .filter(p -> p.getFileName().toString()
                                .toLowerCase()
                                .endsWith(fileExtension.toLowerCase()))
                        .toList();
            }
        } catch (IOException e) {
            throw new InvalidPathException(
                    "Некорректный путь: " + dirPath, e);
        }
    }

//    private Path validateDirectory(String dirPath) throws InvalidPathException {
//        try {
//            Path path = Path.of(dirPath);
//            if (!Files.isDirectory(path)) {
//                throw new InvalidPathException("Путь не является директорией: " + dirPath);
//            }
//            return path;
//        } catch (SecurityException e) {
//            throw new InvalidPathException("Нет прав доступа к директории: " + dirPath, e);
//        }
//    }
}
