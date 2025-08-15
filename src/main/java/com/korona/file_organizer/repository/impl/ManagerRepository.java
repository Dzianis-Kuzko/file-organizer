package com.korona.file_organizer.repository.impl;

import com.korona.file_organizer.model.Manager;
import com.korona.file_organizer.repository.Repository;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ManagerRepository implements Repository<Manager> {
    private final Map<String, Manager> managersByDepartmentName = new HashMap<String, Manager>();

    @Override
    public void add(Manager manager) {
        managersByDepartmentName.put(manager.getDepartmentName(), manager);
    }
}
