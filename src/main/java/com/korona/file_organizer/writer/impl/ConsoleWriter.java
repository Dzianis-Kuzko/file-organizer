package com.korona.file_organizer.writer.impl;

import com.korona.file_organizer.writer.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }

    @Override
    public void close() {
    }
}
