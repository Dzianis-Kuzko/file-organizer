package com.korona.file_organizer.constant;

public final class ProjectConstant {
    public static final String FILE_EXTENSION = ".sb";
    public static final String INPUT_FILES_DIR = ".";
    public static final String OUTPUT_FILES_DIR = "output/";
    public static final String FILE_NANE_FOR_INVALID_DATA = "error.log";

    private ProjectConstant() {
        throw new UnsupportedOperationException("Utility class, should not be instantiated");
    }
}
