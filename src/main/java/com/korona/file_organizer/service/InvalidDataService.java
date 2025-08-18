package com.korona.file_organizer.service;

import com.korona.file_organizer.model.InvalidData;
import com.korona.file_organizer.repository.InvalidDataRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class InvalidDataService {
    private final InvalidDataRepository invalidDataRepository;

    public void add(InvalidData invalidData) {
        invalidDataRepository.add(invalidData);

    }

    public List<InvalidData> getAllInvalidData() {
        return invalidDataRepository.getAllInvalidData();
    }
}
