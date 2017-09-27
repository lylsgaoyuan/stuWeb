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

<title>My JSP 'testEL.jsp' starting page</title>

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
	<%
		//String name = (String) application.getAttribute("name");
		//String sex = (String) session.getAttribute("sex");
		//int age = (Integer) request.getAttribute("age");
		
		
		
		//out.print(name);
		//out.print(sex);
		//out.print(age);
		
		//就近原则，application>session>request
		//applicationScope 范围
	%>
	
	
	  ${stu.name}
	<br /> ${stu.sex}
	<br /> ${stu.age}
</body>
</html>
