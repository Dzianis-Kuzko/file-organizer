package com.korona.file_organizer.mapper;

import com.korona.file_organizer.model.InvalidData;

public class InvalidDataMapper {
    public static String mapToString(InvalidData invalidData) {
        return invalidData.getData();
    }
}
