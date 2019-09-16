package com.iflytek.web.test;

import com.iflytek.web.pojo.Employee;
import com.iflytek.web.service.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class SpringTest {
    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testLogin() {
        String username = "user1";
        String password = "123456";
        int rlt = employeeService.login(username, password);
        Assert.assertEquals(1, rlt);
        System.out.println("test Login ok...");
    }

    @Test
    public void testAdd() {
        Employee emp = new Employee();
        String name = "张三";
        String username = "zhangsan";
        String password = "123456";
        int age = 22;
        Double salary = 8000D;
        emp.setName(name);
        emp.setAge(age);
        emp.setUsername(username);
        emp.setPassword(password);
        emp.setSalary(salary);
        int rlt = employeeService.add(emp);
        Assert.assertEquals(1, rlt);
        List<Employee> list = employeeService.queryAll();
        Employee e = list.get(list.size() - 1);
        Assert.assertEquals(emp, e);

        System.out.println("test Add ok...");
    }

    @Test
    public void testUpdate() {
        int index = 6;
        Integer id = 6;
        Integer age = 18;
        String empNo = "upt6";
        String name = "李四";
        String username = "root";
        String password = "root";
        Double salary = 18888D;

        Employee emp = new Employee();
        emp.setId(id);
        emp.setAge(age);
        emp.setEmpNo(empNo);
        emp.setName(name);
        emp.setUsername(username);
        emp.setPassword(password);
        emp.setSalary(salary);

        List<Employee> list = employeeService.queryAll();
        Employee old_emp = null;
        for (Employee e : list) {
            if (e.getId().equals(id)) {
                old_emp = e;
                break;
            }
        }

        System.out.println("修改前的记录" + old_emp);
        int rlt = employeeService.update(emp);

        Assert.assertEquals(1, rlt);// 验证代码有没有异常
        Employee new_emp6 = null;
        for (Employee e : list) {
            if (e.getId().equals(id)) {
                new_emp6 = e;
                break;
            }
        }
        System.out.println("修改后的值为：" + new_emp6);
        assert new_emp6 != null;
        Assert.assertEquals(id, new_emp6.getId());
        Assert.assertEquals(age, new_emp6.getAge());
        Assert.assertEquals(empNo, new_emp6.getEmpNo());
        Assert.assertEquals(name, new_emp6.getName());
        Assert.assertEquals(username, new_emp6.getUsername());
        Assert.assertEquals(password, new_emp6.getPassword());
        Assert.assertEquals(salary, new_emp6.getSalary());
        System.out.println("Test update ok...");
    }

    @Test
    public void testDel() {
        Integer id = 3; // 第3个 下标为2的那个用户   1-10
        List<Employee> list = employeeService.queryAll();
        int size = list.size(); // 7
        System.out.println("testDel:size=" + size);
        Assert.assertEquals(11, size);
        int rlt = employeeService.del(id); // 没有异常 删除也成功的 逻辑上没有错误
        Assert.assertEquals(10, employeeService.queryAll().size());
        Assert.assertEquals(1, rlt);// 验证代码有没有异常
        // 验证结果
        Assert.assertEquals(size - 1, list.size());
        boolean bool = true;
        for (Employee e : list) {
            if (e.getId().equals(id)) {
                bool = false;
                break;
            }
        }
        Assert.assertTrue(bool);
        System.out.println("Test Del ok...");
    }
}
