package com.intuit.challenge.assignment2;

import java.util.*;
import java.util.stream.*;

/**
 * Performs various streaming analyses and prints results.
 */
public class EmployeeAnalysis {

    public static List<Employee> highSalary(List<Employee> list, double threshold){
        return list.stream().filter(e -> e.getSalary() > threshold).collect(Collectors.toList());
    }

    public static Map<String, Long> countByDept(List<Employee> list){
        return list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    }

    public static Optional<Employee> maxSalaryEmployee(List<Employee> list){
        return list.stream().max(Comparator.comparingDouble(Employee::getSalary));
    }

    public static double averageSalary(List<Employee> list){
        return list.stream().collect(Collectors.averagingDouble(Employee::getSalary));
    }

    public static void printAnalysis(List<Employee> employees){
        System.out.println("Employees with salary > 50,000:");
        highSalary(employees, 50000).forEach(e ->
                System.out.println(e.getName() + ": " + e.getSalary()));

        System.out.println("\nEmployee count by department:");
        countByDept(employees).forEach((d,c) ->
                System.out.println(d + ": " + c));

        maxSalaryEmployee(employees).ifPresent(e ->
                System.out.println("\nMax salary employee: " + e.getName() + " - " + e.getSalary()));

        System.out.println("\nAverage salary: " + averageSalary(employees));
    }

    public static void main(String[] args) {
        List<Employee> employees = CsvReaderUtil.readCSV("employees.csv");

        if (employees.isEmpty()) {
            System.out.println("No employee data loaded.");
            return;
        }

        printAnalysis(employees);
    }
}
