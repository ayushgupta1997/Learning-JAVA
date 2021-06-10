package com.ayush;

import java.util.*;

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

        Collections.sort(employeeList, (o1,o2)-> o1.getAge()- o2.getAge());

        System.out.println("Employees in the sorted order : -");
        for (Employee e: employeeList) {
            System.out.println(e.getName() + " " + e.getAge());
        }
        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
        String sillyString = doStringStuff(uc, employeeList.get(0).getName(), employeeList.get(1).getName());
        System.out.println(sillyString);
    }
    public static final String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
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
