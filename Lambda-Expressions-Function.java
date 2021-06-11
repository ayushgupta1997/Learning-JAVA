package com.ayush;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
	    new Thread(()-> System.out.println("Printing from the runnable")).start();
	    Employee ayush =new Employee("ayush gupta", 23);
	    Employee ajay = new Employee("ajay singh", 40);
	    Employee tim = new Employee("tim bit", 34);
	    Employee snow = new Employee("snow whit", 54);

	    List<Employee> employeeList = new ArrayList<>();
	    employeeList.add(ayush);
	    employeeList.add(ajay);
	    employeeList.add(tim);
	    employeeList.add(snow);

        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') +1);
        };
        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };
        String lastName = getAName(getLastName, employeeList.get(1));
        String firstName = getAName(getFirstName, employeeList.get(1));
        System.out.println(lastName + firstName);

    }

    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
    }
}

class Employee {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}
