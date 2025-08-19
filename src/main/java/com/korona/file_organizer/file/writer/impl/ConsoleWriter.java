package com.korona.file_organizer.file.writer.impl;

import com.korona.file_organizer.file.writer.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }

    @Override
    public void close() {
    }
}
