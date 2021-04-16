package com.ifmo.jjd.hw13.employee;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class EmployeeTask {
    public static void main(String[] args) {
        List<Employee> employees = Employee.employeeGenerator(20);
        // Дописать метод employeeGenerator и
        // отсортировать его по:
        // имени
        // имени и зарплате
        // имени, зарплате, возрасту и компании
        System.out.println(employees);
        Comparator<Employee> byName = new Employee.nameComparator();
        TreeSet<Employee> sortedByName = new TreeSet<>(byName);
        sortedByName.addAll(employees);
        System.out.println(sortedByName);
        Comparator<Employee> byNameSalary = new Employee.nameComparator().thenComparing(new Employee.salaryComparator());
        TreeSet<Employee> sortedByNameSalary = new TreeSet<>(byNameSalary);
        sortedByNameSalary.addAll(employees);
        System.out.println(sortedByNameSalary);
        Comparator<Employee> byNameSalaryAgeCompany = new Employee.nameComparator().thenComparing(new Employee.salaryComparator().thenComparing(new Employee.ageComparator().thenComparing(new Employee.companyComparator())));
        TreeSet<Employee> sortByNameSalaryAgeCompany = new TreeSet<>(byNameSalaryAgeCompany);
        sortByNameSalaryAgeCompany.addAll(employees);
        System.out.println(sortByNameSalaryAgeCompany);
    }
}
