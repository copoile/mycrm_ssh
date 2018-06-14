<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--?????-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath %>">
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="description" content="????????">
		<title>注册</title>
	</head>
<body>
	<form action="user_add.action" method="post">
		用户名：<input type="text" name="username"><br>
		密码：<input type="text" name="password"><br>
		地址：<input type="text" name="address">
		<input type="submit" value="提交">
	</form>
</body>
</html>