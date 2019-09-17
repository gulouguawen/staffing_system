package com.iflytek.web.servlet;

import com.iflytek.web.pojo.Employee;
import com.iflytek.web.service.EmployeeService;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EmployeeService employeeService;

    public void init() throws ServletException {
        WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
        employeeService = applicationContext.getBean(EmployeeService.class);
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee emp = new Employee();
        List<Employee> list = employeeService.queryAll();
        int id = list.get(list.size() - 1).getId() + 1;
        emp.setAge(23);
        emp.setEmpNo("emp" + (int) Math.ceil(Math.random() * 10000));
        emp.setName("emp" + id);
        emp.setPassword("123456"); // 123456
        emp.setSalary(5000D);
        emp.setUsername("user" + id);
        employeeService.add(emp);
        request.setAttribute("list", employeeService.queryAll());
        // 页面跳转
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
