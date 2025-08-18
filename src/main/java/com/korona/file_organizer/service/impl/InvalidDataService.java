package com.korona.file_organizer.service.impl;

import com.korona.file_organizer.model.InvalidData;
import com.korona.file_organizer.repository.impl.InvalidDataRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class InvalidDataService {
    private final InvalidDataRepository invalidDataRepository;

    public Optional<InvalidData> add(InvalidData invalidData) {
        invalidDataRepository.add(invalidData);
        return Optional.of(invalidData);
    }

    public List<InvalidData> getAllInvalidData() {
        return invalidDataRepository.getAllInvalidData();
    }
}
