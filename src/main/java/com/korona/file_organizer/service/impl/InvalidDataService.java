package com.korona.file_organizer.service.impl;

import com.korona.file_organizer.repository.Repository;
import com.korona.file_organizer.service.Service;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class InvalidDataService implements Service<String> {
    private final Repository<String> repository;

    public Optional<String> add(String invalidString) {
        repository.add(invalidString);
        return Optional.of(invalidString);
    }
}
