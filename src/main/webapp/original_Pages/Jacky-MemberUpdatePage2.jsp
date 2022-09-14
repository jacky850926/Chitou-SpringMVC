<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>

<%
response.setContentType("text/html;charset=UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增會員</title>
<link href="https://img.onl/DOO7l" rel="icon" type="image/png" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<style>
h1{
color:navy
}

</style>
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
					href="http://localhost:8080/Project2/weber-JourneyMain.jsp"
					class="nav-link">行程表</a></li>
								<li><a
					href="http://localhost:8080/Project2/Luana-index.jsp"
					class="nav-link">購物車與訂單</a></li>	
			</ul>
		</nav>

	</header>
<FORM ACTION="./Project2Servlet" method="post">
<h1>更改會員資料成功</h1>
<br>
<input type="submit" name="returntomemberhomepage" value="返回上一頁">
</form>

</body>
</html>