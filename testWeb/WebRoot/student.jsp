<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="utf-8"%>
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

<title>My JSP 'student.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">

<style>
table {
	border-collapse: collapse;
}

.table {
	width: 400px;
	margin: 20px auto;
}
</style>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("thead tr").css("background", "#90EE90");
		$("tbody tr:odd").css("background", "#FFE1FF");
		$("tbody tr:even").css("background", "	#F2F2F2");
		var oldColor;
		$("tbody tr").hover(function() {
			oldColor = $(this).css("background");
			$(this).css("background", "#C1FFC1");
		}, function() {
			$(this).css("background", oldColor);
		})
	})
</script>
</head>

<body>
	<%
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager
				.getConnection(
						"jdbc:mysql://localhost:3306/school?characterEncoding=utf-8",
						"root", "123456");
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("select * from student");
	%>
	<table class='table  table-bordered'>
		<thead>
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
			</tr>
		</thead>
		<%
			while (rs.next()) {
		%>
		<tr>
			<td>
				<%
					out.println(rs.getInt("id"));
				%>
			</td>
			<td>
				<%
					out.println(rs.getString("name"));
				%>
			</td>
			<td>
				<%
					out.println(rs.getString("sex"));
				%>
			</td>
			<td>
				<%
					out.println(rs.getInt("age"));
				%>
			</td>
		</tr>
		<%
			}
			conn.close();
		%>
	</table>

</body>
</html>
