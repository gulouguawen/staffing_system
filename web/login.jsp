<%--
  Created by IntelliJ IDEA.
  User: shiyao
  Date: 2019/9/16
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>登录</title>
</head>
<body>
<form action="login" method="post">
  <h3>用户名：</h3>
  <label>
    <input name="username"/>
  </label>
  <h3>密码：</h3>
  <label>
    <input name="password"/>
  </label>
  <input type="submit" value="login">
</form>
</body>
</html>

