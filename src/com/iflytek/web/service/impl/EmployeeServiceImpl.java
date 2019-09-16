package com.iflytek.web.service.impl;

import com.iflytek.web.dao.EmployeeDao;
import com.iflytek.web.pojo.Employee;
import com.iflytek.web.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public int login(String username, String password) {
        Employee emp = employeeDao.query(username, password);
        if (emp == null) {
            return -1;
        }
        return 1;
    }

    @Override
    public int add(Employee emp) {
        return employeeDao.addEmployee(emp);
    }

    @Override
    public int update(Employee emp) {
        return employeeDao.updateEmployee(emp);
    }

    @Override
    public int del(Integer id) {
        return employeeDao.delEmployee(id);
    }

    @Override
    public List<Employee> queryAll() {
        return employeeDao.getEmployees();
    }
}
