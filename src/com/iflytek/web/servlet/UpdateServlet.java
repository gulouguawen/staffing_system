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

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	private EmployeeService employeeService;

    public void init() throws ServletException {
		// final 修饰变量 必须是一个常量 而且不能修改
		WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
        employeeService = applicationContext.getBean(EmployeeService.class);
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Employee emp = employeeService.query(Integer.parseInt(id));
        emp.setSalary(emp.getSalary() * 130 / 100);
        employeeService.update(emp);
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
