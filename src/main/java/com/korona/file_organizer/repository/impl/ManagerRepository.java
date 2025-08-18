package com.korona.file_organizer.repository.impl;

import com.korona.file_organizer.model.Manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ManagerRepository {
    private final Map<Integer, Manager> managers = new HashMap<>();


    public void add(Manager manager) {
        managers.put(manager.getId(), manager);
    }

    public List<Manager> getAllManagers() {
        return managers.values().stream().toList();
    }

    public Set<Integer> getAllManagerIds() {
        return managers.keySet();
    }
}