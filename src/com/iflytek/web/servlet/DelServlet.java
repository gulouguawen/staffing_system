package com.iflytek.web.servlet;

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
 * Servlet implementation class DelServlet
 */
@WebServlet("/del")
public class DelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EmployeeService employeeService;

    public void init() throws ServletException {
        WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
        employeeService = applicationContext.getBean(EmployeeService.class);
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        employeeService.del(Integer.parseInt(id));
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
