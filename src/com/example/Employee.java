package com.example;

import java.time.LocalDate;
import java.util.Date;

public class Employee {
    private String lastName;
    private String department;
    private String position;
    private Double yearsOfService;
    private Integer yearOfBirth;
    private Double salary;
    private Integer age;

    @Override
    public String toString() {
        return "Employee{" +
                "lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", yearsOfService=" + yearsOfService +
                ", yearOfBirth=" + yearOfBirth +
                ", age=" + age +
                ", salary=" + salary +
                "}\n";
    }

    public Employee(String lastName, String department, String position, Double yearsOfService, Integer yearOfBirth, Double salary) {
        this.lastName = lastName;
        this.department = department;
        this.position = position;
        this.yearsOfService = yearsOfService;
        this.yearOfBirth = yearOfBirth;
        this.salary = salary;

        age = LocalDate.now().getYear() - yearOfBirth;
    }

    public String printSpecific(){
        return  "lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", yearsOfService=" + yearsOfService;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(Double yearsOfService) {
        this.yearsOfService = yearsOfService;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
