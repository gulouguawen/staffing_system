<%--
  Created by IntelliJ IDEA.
  User: shiyao
  Date: 2019/9/16
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.iflytek.web.pojo.*,java.util.*" %>
<html>
<head>
    <title>主界面</title>
</head>
<body>
<button><a href="add">新增</a></button>
<button>修改</button>
<button>删除</button>
<button>查询</button>
<br>

<br/>
<table style="width: 100%;border: aqua 1px solid">
    <tr >
        <td>员工ID</td>
        <td>员工编号</td>
        <td>员工姓名</td>
        <td>员工年龄</td>
        <td>员工薪资</td>
        <td>登录名</td>
        <td>操作</td>
    </tr>
    <%
        List<Employee> list = (List<Employee>) request.getAttribute("list");
        int size = list.size();
        for (Employee employee : list) {
    %>
    <tr>
        <td><%=employee.getId() %>
        </td>
        <td><%=employee.getEmpNo() %>
        </td>
        <td><%=employee.getName() %>
        </td>
        <td><%=employee.getAge() %>
        </td>
        <td><%=employee.getSalary() %>
        </td>
        <td><%=employee.getUsername() %>
        </td>
        <td><a href="update?id=<%=employee.getId()%>">修改</a><a href="del?id=<%=employee.getId()%>">删除</a></td>
    </tr>

    <%
        }
    %>
</table>
</body>
</html>
