package com.korona.file_organizer.constant;

public final class ProjectConstant {
    public static final String FILE_EXTENSION = ".sb";
    public static final String INPUT_FILES_DIR  = ".";
    public static final String OUTPUT_FILES_DIR = "output";
    public static final String PATH_FOR_ERROR_LOG = "error.log";

    private ProjectConstant() {
        throw new AssertionError("Нельзя создать экземпляр ProjectConstant");
    }


}
