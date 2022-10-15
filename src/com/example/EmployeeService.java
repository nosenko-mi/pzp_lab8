package com.example;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {

    public static List<Employee> getYoungerThanX(List<Employee> employees, int x){
        return employees
                .stream()
                .filter(employee -> employee.getAge() < x)
                .collect(Collectors.toList());
    }

    public static double getMeanYearsOfServiceInDepartment(List<Employee> employees, String department){
        return employees
                .stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .mapToDouble(Employee::getYearsOfService)
                .average()
                .orElse(Double.NaN);
    }
}
