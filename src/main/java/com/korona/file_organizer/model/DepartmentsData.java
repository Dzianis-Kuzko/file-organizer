package com.korona.file_organizer.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentsData {
    public final static Map<String, Manager> managerByDepartmentName = new HashMap<>();
    public final static Map<Integer, List<Employee>> employeesByManagerId  = new HashMap<>();
}
