package com.example;

import java.io.IOException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Employee> employees = FileController.loadEmployees("in.txt");

        if (employees.size() == 0) {
            System.out.println("Сталася помилка при читанні з файлу");
        } else {
            System.out.println(employees);
        }

        Scanner scan = new Scanner(System.in);

        System.out.println("Введіть вік співробітника:");
        try{
            int i = scan.nextInt();
            List<Employee> emp1 = EmployeeService.getYoungerThanX(employees, i);
            System.out.println("Шукані співробітники: ");
            for (Employee employee: emp1){
                System.out.println(employee.printSpecific());
            }
        } catch (InputMismatchException e){
            System.out.println("Некоректний ввід даних");
        } finally {
            scan.nextLine();
        }

        System.out.println("Введіть відділ:");
        String dep = scan.nextLine();
        double mean = EmployeeService.getMeanYearsOfServiceInDepartment(employees, dep);
        if (Double.isNaN(mean)){
            System.out.println("Відділ не знайдено");
        } else {
            System.out.format("Середній стаж роботи у відділі: %.2f", mean);
        }
//        System.out.println(EmployeeService.getMeanYearsOfServiceInDepartment(employees, "Маркетинг"));
    }
}
