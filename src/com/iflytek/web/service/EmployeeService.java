package com.iflytek.web.service;

import com.iflytek.web.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    public int login(String username, String password);

    public int add(Employee emp);

    public int update(Employee emp);

    public int del(Integer id);

    public List<Employee> queryAll();
}
