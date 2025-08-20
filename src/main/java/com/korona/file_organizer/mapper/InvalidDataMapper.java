package com.korona.file_organizer.mapper;

import com.korona.file_organizer.model.InvalidData;

public final class InvalidDataMapper {
    private InvalidDataMapper() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static String mapToString(InvalidData invalidData) {
        return invalidData.getData();
    }
}
