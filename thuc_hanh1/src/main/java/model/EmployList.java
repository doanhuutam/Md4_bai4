package model;

import java.util.ArrayList;

public class EmployList {
    public ArrayList<Employee> list=new ArrayList<>();

    public EmployList() {
        list.add(new Employee("doan","huu","tam"));
        list.add(new Employee("doan","thanh","tung"));
    }
    public void save(Employee employee){
        list.add(employee);
    }
}
