package com.korona.file_organizer.service.impl;

import com.korona.file_organizer.model.Manager;
import com.korona.file_organizer.repository.impl.ManagerRepository;
import com.korona.file_organizer.service.Service;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
public class ManagerService implements Service<Manager> {
    private final ManagerRepository managerRepository;
    @Override
    public Optional<Manager> add(Manager manager) {
        managerRepository.add(manager);
        return Optional.of(manager);
    }

    public List<Manager> getAllManagers() {
        return managerRepository.getAllManagers();
    }

    public Set<Integer> getAllManagerIds() {
        return managerRepository.getAllManagerIds();
    }
}
