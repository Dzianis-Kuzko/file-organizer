package com.korona.file_organizer.service.impl;

import com.korona.file_organizer.model.Manager;
import com.korona.file_organizer.repository.Repository;
import com.korona.file_organizer.service.Service;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class ManagerService implements Service<Manager> {
    private final Repository<Manager> repository;

    @Override
    public Optional<Manager> add(Manager manager) {
        repository.add(manager);
        return Optional.of(manager);
    }
}
