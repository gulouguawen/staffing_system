package com.iflytek.web.servlet;

import com.iflytek.web.service.EmployeeService;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // final 修饰变量 必须是一个常量 而且不能修改
    private WebApplicationContext applicationContext;

    @Resource
    private EmployeeService employeeService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
        applicationContext = ContextLoader.getCurrentWebApplicationContext();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 此时，实现登录功能，需要一个service 来处理登录的业务逻辑
        // 还需要一个dao来实现数据库的相关操作
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int rlt = employeeService.login(username, password);
        String view = "";
        if (rlt == 1) {
            // 成功的
            view = "main.jsp";
        } else if (rlt == -1) {
            // 失败的
            view = "failed.jsp";
        }
        // 页面跳转
        request.getRequestDispatcher(view).forward(request, response);
    }
}