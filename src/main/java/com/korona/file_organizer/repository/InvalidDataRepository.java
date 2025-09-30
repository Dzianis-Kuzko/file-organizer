package com.korona.file_organizer.repository;

import com.korona.file_organizer.model.InvalidData;

import java.util.ArrayList;
import java.util.List;


public class InvalidDataRepository {
    private final List<InvalidData> invalidDataList = new ArrayList<>();

    public void add(InvalidData invalidData) {
        invalidDataList.add(invalidData);
    }

    public List<InvalidData> getAllInvalidData() {
        return invalidDataList;
    }
}
