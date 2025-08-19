package com.korona.file_organizer.file.writer;

public interface OutputWriter extends AutoCloseable {
    void writeLine(String line);

    @Override
    void close();
}
