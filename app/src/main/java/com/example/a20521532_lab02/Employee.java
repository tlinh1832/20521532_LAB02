package com.example.a20521532_lab02;

public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public double getNetSalary() {
        double i = salary - salary*0.1;
        if (i <= 11000000) return i;
        else {
            return 11000000 + (i - 11000000)*(1-0.05);
        }

    }
}

