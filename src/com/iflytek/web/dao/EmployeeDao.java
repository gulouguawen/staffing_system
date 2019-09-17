package com.iflytek.web.dao;

import com.iflytek.web.pojo.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeDao {
    private List<Employee> list = new ArrayList<Employee>();

    public EmployeeDao() {
        Employee emp = null;
        for (int i = 0; i < 10; i++) {
            emp = new Employee();
            emp.setAge(23 + i);
            emp.setEmpNo("emp" + (int) Math.ceil(Math.random() * 10000));
            emp.setId(i + 1);  // 1 - 10
            emp.setName("emp" + i);
            emp.setPassword("123456"); // 123456
            emp.setSalary(5000D);
            emp.setUsername("user" + i);// user0-user9
            list.add(emp);
        }
    }

    public Employee query(String username, String password) {
        for (Employee emp : list) {
            if (username.equals(emp.getUsername())
                    && password.equals(emp.getPassword())) {
                return emp;
            }
        }
        return null;
    }

    public Employee query(Integer id) {
        for (Employee emp : list) {
            if (id.equals(emp.getId())) {
                return emp;
            }
        }
        return null;
    }

    public int addEmployee(Employee emp) {
        int id = list.get(list.size() - 1).getId() + 1;
        emp.setId(id);
        emp.setEmpNo("emp" + id + (int) Math.ceil(Math.random() * 10000));
        list.add(emp);
        return 1;
    }

    public int delEmployee(Integer id) {
        Iterator<Employee> iter = list.iterator();
        while (iter.hasNext()) {
            Employee emp = iter.next();
            if (id.equals(emp.getId())) {
                iter.remove();
                return 1;
            }
        }
        return -1;
    }

    public int updateEmployee(Employee emp) {
        for (Employee e : list) {
            if (e.getId().equals(emp.getId())) {
                e.setAge(emp.getAge());
                e.setEmpNo(emp.getEmpNo());
                e.setName(emp.getName());
                e.setPassword(emp.getPassword());
                e.setSalary(emp.getSalary());
                e.setUsername(emp.getUsername());
                break;
            }
        }
        return 1;
    }

    public List<Employee> getEmployees() {
        return list;
    }

}