<%@page import="javax.management.MBeanAttributeInfo"%>
<%@page
	import="java.sql.Connection, java.util.*, javax.sql.*, tw.jacky.controller.*, javax.naming.*,java.io.*,java.sql.* ,tw.jacky.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>MemberHomePage</title>
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

<%


MemberBean mb = (MemberBean)request.getSession(true).getAttribute("confirmed_memberbean");
MemberBean mb2 = (MemberBean)request.getSession(true).getAttribute("logintomember");
%>





</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: lightblue">
			<div>
				<img src="images/chitou.png" /> <a
					href="http://localhost:8080/ChiTou/kang-DisplayUser.jsp"
					class="navbar-brand"> ChiTou </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="http://localhost:8080/Project2/Jacky-Login.jsp"
					class="nav-link">會員登入界面</a></li>
				<li><a
					href="http://localhost:8080/Project2/Georgia-Article.jsp"
					class="nav-link">討論區功能</a></li>
				<li><a
					href="http://localhost:8080/Project2/kang-DisplayUser.jsp"
					class="nav-link">景點功能</a></li>
				<li><a
					href="http://localhost:8080/Project2/Trista-FlightTicket.jsp"
					class="nav-link">機票功能</a></li>
				<li><a
					href="http://localhost:8080/Project2/weber-journeyMain.jsp"
					class="nav-link">行程表</a></li>
								<li><a
					href="http://localhost:8080/Project2/Luana-index.jsp"
					class="nav-link">購物車與訂單</a></li>	
			</ul>
		</nav>

	</header>
<fieldset>





	<FORM ACTION="./Project2Servlet" method="post">
		<h1>歡迎使用者 <%= mb2.getUserid() %> !!!!</h1>
		<br>
		<div>
			<input type="submit" name="memberselfupdate" size="10" value="修改個人資料">

		</div>
	</form>
	<hr>
	<form action = "Jacky-Login.jsp">
	
	<button onclick="">返回登入界面</button>
	</form>
</fieldset>




	</div>


</body>
</html>