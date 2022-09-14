
<%@page import="javax.management.MBeanAttributeInfo"%>
<%@page
	import="java.sql.Connection, java.util.*, javax.sql.*, tw.jacky.controller.*, javax.naming.*,java.io.*,java.sql.* ,tw.jacky.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>AdminHomePage</title>
<link href="https://img.onl/DOO7l" rel="icon" type="image/png" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style>
table {
	border: 2px solid;
	margin-top: 10px;
}

th {
	border: 2px solid;
}

td {
	border: 2px solid;
}
</style>


</head>
<body>
	<header> <nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: lightblue">
	<div>
		<img src="images/chitou.png" /> <a
			href="http://localhost:8080/ChiTou/kang-DisplayUser.jsp"
			class="navbar-brand"> ChiTou </a>
	</div>

	<ul class="navbar-nav">
		<li><a href="http://localhost:8080/Project2/Jacky-Login.jsp"
			class="nav-link">會員登入界面</a></li>
		<li><a href="http://localhost:8080/Project2/Georgia-Article.jsp"
			class="nav-link">討論區功能</a></li>
		<li><a href="http://localhost:8080/Project2/kang-DisplayUser.jsp"
			class="nav-link">景點功能</a></li>
		<li><a
			href="http://localhost:8080/Project2/Trista-FlightTicket.jsp"
			class="nav-link">機票功能</a></li>
		<li><a
			href="http://localhost:8080/Project2/weber-journeyMain.jsp"
			class="nav-link">行程表</a></li>
		<li><a href="http://localhost:8080/Project2/Luana-index.jsp"
			class="nav-link">購物車與訂單</a></li>
	</ul>
	</nav> </header>

	<hr>
	<br>
	<label>會員資料更改</label>
	<div>
	
			<%
			MemberBasicInfo bean = (MemberBasicInfo) request.getSession().getAttribute("modifymemberbean");
			%>

			<tr>
				<form action="adminupdatemember" method="post" modelAttribute="memberlistinfo">

				<input type="hidden" name="memberid" value="<%=bean.getMemberid()%>"><br>
				<input type="hidden" name="statusid" value="<%=bean.getStatusid()%>"><br>
				<input type="text" name="username" value="<%=bean.getUsername()%>"><br>
				<input type="text" name="password" value="<%=bean.getPassword()%>"><br>
				<input type="text" name="photo" value="<%=bean.getPhoto()%>"><br>
				<input type="text" name="email" value="<%=bean.getEmail()%>"><br>

				<input type=submit name="modifyfromadmin" value="更改">
					
				</form>
			</tr>


	</div>
	<hr>
	<form action="adminhomepage">
		<button onclick="">返回登入界面</button>
	</form>
</body>
</html>