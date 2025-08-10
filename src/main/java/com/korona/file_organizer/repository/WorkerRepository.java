package com.korona.file_organizer.repository;

import com.korona.file_organizer.model.Employee;
import com.korona.file_organizer.model.Manager;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class WorkerRepository {
    private final List<Manager> managers = new ArrayList<>();
    private final Map<Integer, List<Employee>> employees = new HashMap<>();
    private final List<String> errorWorkers = new ArrayList<>();


}
