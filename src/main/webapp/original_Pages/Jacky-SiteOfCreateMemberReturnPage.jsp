<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="tw.jacky.model.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", -1); // Prevents caching at the proxy server
%>

<%
MemberBean memberbean = (MemberBean) session.getAttribute("reg_memberbean");
%> 

<html>
<head>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8" />
<TITLE>Project2</TITLE>
<link href="https://img.onl/DOO7l" rel="icon" type="image/png" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script>   
function return() {   
alter("sss")
window.open("http://www.wibibi.com");  
}   
</script>  

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
	<H1>管理員創建會員</H1>

	<FORM ACTION="./Project2Servlet" method="post">
		<div>
			<label for="account1"> statusID</label> <br> </a><input type="text"
				id="account1" name="statusid" value="<%= memberbean.getStatusid() %>"
				autocomplete="off" size="10">
		</div>

		<div>
			<label for="account2"> userID</label> <br> </a><input type="text"
				id="account2" name="userid"  value="<%= memberbean.getUserid() %>"
				autocomplete="off" size="10">
		</div>

		<div>
			<label for="account3"> password</label> <br> </a><input type="text"
				id="account3" name="password" value="<%= memberbean.getPassword() %>"
				autocomplete="off" size="10">
		</div>

		<div>
			<label for="account3"> name</label> <br> </a><input type="text"
				id="account3" name="name" value="<%= memberbean.getName() %>"
				autocomplete="off" size="10">
		</div>

		<div>
			<label for="account3"> nickName</label> <br> </a><input type="text"
				id="account3" name="nickname" value="<%= memberbean.getNickname() %>"
				autocomplete="off" size="10">
		</div>


		<div>
			<label for="account3"> phone</label> <br> </a><input type="text"
				id="account3" name="phone" value="<%= memberbean.getPhone() %>"
				autocomplete="off" size="10">
		</div>

		<div>
			<label for="account3"> nationality</label> <br> </a><input type="text"
				id="account3" name="nationality" autofocus placeholder="Taiwan" value="<%= memberbean.getNationality() %>"
				autocomplete="off" size="10">
		</div>

		<div>
			<label for="account3"> birth</label> <br> </a><input type="date"
				id="account3" name="birth"  value="<%= memberbean.getBirth() %>"
				autocomplete="off" size="10">
		</div>

		<div>
			<label for="account3"> gender</label> <br> </a><input type="text"
				id="account3" name="gender" autofocus placeholder="female" value="<%= memberbean.getGender() %>"
				autocomplete="off" size="10">
		</div>

		<div>
			<label for="account3"> address</label> <br> </a><input type="text"
				id="account3" name="address" value="<%= memberbean.getAddress() %>"
				autocomplete="off" size="10">
		</div>

		<div>
			<label for="account3"> email</label> <br> </a><input type="text"
				id="account3" name="email" value="<%= memberbean.getEmail() %>"
				autocomplete="off" size="10">
		</div>



		<INPUT TYPE="submit" name="submit" value="提交">

	</form>
	<FORM ACTION="./Jacky-AdminHomePage.jsp" method="post">
		<button onclick=""> 返回 </button>  
	</form>
</body>
</html>