package com.iflytek.web.service;

import com.iflytek.web.pojo.Employee;

import java.util.List;


public abstract class EmployeeService {
    public abstract int login(String username, String password);

    public abstract int add(Employee emp);

    public abstract int update(Employee emp);

    public abstract int del(Integer id);

    public abstract List<Employee> queryAll();

    public abstract Employee query(Integer id);
}
