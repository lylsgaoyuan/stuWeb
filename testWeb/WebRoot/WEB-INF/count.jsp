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

<title>My JSP 'count.jsp' starting page</title>

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
		//if (application.getAttribute("set") == null) {
		//Set<String> set = new HashSet<String>();
		//application.setAttribute("set", set);
		//}
		//int num = 0;
		//if (application.getAttribute("num") != null) {
		//	num = (Integer) application.getAttribute("num");
		//}
		//String ip = request.getRemoteAddr();
		//Set<String> set=(Set<String>)application.getAttribute("set");
		//boolean flag = set.add(ip);
		//System.out.println(ip);
		//if (session.isNew()) {
		//	num++;
		//}

		//application.setAttribute("num", num);
	%>


	共有${num}人访问页面
</body>
</html>
