package com.selenium.learnings.GenericsSorting;

import java.util.List;

public class Employee implements Comparable<Employee> {

    Integer id;
    String name;

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Employee otherEmployee) {

        if(this.id > otherEmployee.id){
            return 1;
        }
        else if(this.id.equals(otherEmployee.id)){
            return 0;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class StaffEmployee extends Employee {

    public StaffEmployee(Integer id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "StaffEmployee{" +
                "id=" + super.id +
                ", name='" + name + '\'' +
                '}';
    }
    //you can pass T itself or any super class of T for example super class of STaff Employee
    public static <T extends Comparable< ? super T>> void sort(List<T> list) {
        list.sort(null);
    }


}