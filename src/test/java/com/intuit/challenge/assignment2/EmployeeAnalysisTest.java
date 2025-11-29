package com.intuit.challenge.assignment2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeAnalysisTest {

    @Test
    void testHighSalary() {
        List<Employee> list = List.of(
            new Employee("A", "IT", 50000),
            new Employee("B", "HR", 60000)
        );
        assertEquals(1, EmployeeAnalysis.highSalary(list, 55000).size());
    }

    @Test
    void testCountByDept() {
        List<Employee> list = List.of(
            new Employee("A", "IT", 50000),
            new Employee("B", "IT", 60000),
            new Employee("C", "HR", 40000)
        );
        Map<String, Long> map = EmployeeAnalysis.countByDept(list);
        assertEquals(2, map.get("IT").intValue());
        assertEquals(1, map.get("HR").intValue());
    }

    @Test
    void testMaxSalary() {
        List<Employee> list = List.of(
            new Employee("A", "IT", 50000),
            new Employee("B", "IT", 80000)
        );
        assertEquals("B", EmployeeAnalysis.maxSalaryEmployee(list).get().getName());
    }

    @Test
    void testAverageSalary() {
    List<Employee> list = List.of(
        new Employee("A","IT",50000),
        new Employee("B","IT",70000)
    );
    assertEquals(60000.0, EmployeeAnalysis.averageSalary(list));
}

}
