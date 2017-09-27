<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>

	<form action="user" method="post">
		<input type="hidden" name="type" value="doLogin" /> 账号：<input
			type="text" name="name" value="${name}" /><br /> 密码：<input
			type="password" name="password" /><br /> <input type="radio"
			name="time" value="1">不保存 <input type="radio" name="time"
			value="2" checked>保存30秒 <input type="radio" name="time"
			value="3">保存1分钟 <br />
		<input type="submit" value="登录" />
	</form>
</body>
</html>
