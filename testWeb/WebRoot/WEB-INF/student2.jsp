<%@ page language="java" import="java.util.*,dao.*,unity.*"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

#contianer {
	width: 500px;
	margin: 20px auto;
}

.pagination {
	margin-left: 150px;
}

.pagination li:hover {
	cursor: pointer;
}
</style>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var ye = ${ye};
		var maxYe = ${maxYe};
		var oldColor;
		$("thead tr").css("background", "#90EE90");
		$("tbody tr:odd").css("background", "#FFE1FF");
		$("tbody tr:even").css("background", "	#F2F2F2");
		$("tbody tr").hover(function() {
			oldColor = $(this).css("background");
			$(this).css("background", "#C1FFC1");
		}, function() {
			$(this).css("background", oldColor);
		});
		$(".pagination li:first a").click(function() {
			if (ye > 1) {
				location.href = "stu?ye=" + (ye - 1);
			}
		});
		$(".pagination li:first a").mouseover(function() {
			if (ye <= 1) {
				$(this).css("cursor", "not-allowed");
			}
		});
		$(".pagination li:last a").click(function() {
			if (ye < maxYe) {
				location.href = "stu?ye=" + (ye + 1);
			}
		});
		$(".pagination li:last a").mouseover(function() {
			if (ye >= maxYe) {
				$(this).css("cursor", "not-allowed");
			}
		});
		$("[name=numPage] a").click(function() {
			ye = $(this).html();
			location.href = "stu?ye=" + ye;
		});
		//$("[name=numPage]").removeClass("active");
		//$("[name=numPage]").eq(0).addClass("active");
	});
</script>
</head>

<body>


	<div id="contianer">
		<table class='table  table-bordered'>
			<thead>
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
				</tr>
			</thead>
			<c:forEach items="${list}" var="stu">
				<tr>
					<td>${stu.id}</td>
					<td>${stu.name}</td>
					<td>${stu.sex}</td>
					<td>${stu.age}</td>
				</tr>
			</c:forEach>
		</table>
		<ul class="pagination">
			<li><a>上一页</a></li>
			<%
				int ye = (Integer) request.getAttribute("ye");
				int begin = ye;
				int maxYe = (Integer) request.getAttribute("maxYe");
				int end = begin + 5;
				if (end >= maxYe) {
					end = maxYe;
					begin = end - 5;
				}
				for (int i = begin; i <= end; i++) {
			%>
			<li name="numPage"
				<%if (ye == i) {
					out.print("class='active'");
				}%>><a><%=i%></a>
			</li>
			<%
				}
			%>
			<li><a>下一页</a>
			</li>
		</ul>
	</div>
</body>
</html>
