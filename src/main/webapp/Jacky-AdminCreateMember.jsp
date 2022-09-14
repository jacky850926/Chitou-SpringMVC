<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", -1); // Prevents caching at the proxy server
%>

<html>
<head>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8" />
<TITLE>管理員創建會員</TITLE>
<link href="https://img.onl/DOO7l" rel="icon" type="image/png" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style>
form label {
	display: inline-block;
	width: 100px;
}

form div {
	margin-bottom: 10px;
}

.error {
	color: red;
	margin-left: 5px;
}

label.error {
	display: inline;
}
</style>

<script>
	function getTime() {
		var currentTime = new Date();
		return currentTime
	}
</script>



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
	<H1>管理員創建會員</H1>

	<h5>jQuery 驗證其中幾個欄目</h5>
	<FORM ACTION="admininsertmember" method="post" id="form"
		modelAttribute="memberinfo">
		<!--  ><div><input type="hidden" name="memberid" value="1"></div> -->

		<div>
			<label> userID</label> <br> </a><input type="text" id="username"
				name="username" autocomplete="off" size="10">
		</div>

		<div>
			<label for=""> password</label> <br> </a><input type="text"
				id="password" name="password" autocomplete="off" size="10">
		</div>

		<div>
			<label for=""> photo</label> <br> </a><input type="text"
				id="photo" name="photo" autocomplete="off" size="10">
		</div>


		<div>
			<label for=""> email</label> <br> </a><input type="text" id="email"
				name="email" autocomplete="off" size="10">
		</div>


		<hr>


		<INPUT TYPE="submit" id="createmember" name="submit" value="提交">

	</form>
	<br>
	<FORM ACTION="./Jacky-AdminHomePage.jsp" method="post">
		<button onclick="">返回</button>
	</form>








</body>
</html>