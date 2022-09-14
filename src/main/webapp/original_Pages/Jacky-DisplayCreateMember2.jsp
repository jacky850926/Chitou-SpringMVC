<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="tw.jacky.model.*,java.util.*"%>
<%
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", -1); // Prevents caching at the proxy server
%>

<%
MemberBean rgb = (MemberBean) request.getSession(true).getAttribute("confirmed_memberbean");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8" />
<TITLE>編輯會員資料</TITLE>
<link href="https://img.onl/DOO7l" rel="icon" type="image/png" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
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
	<jsp:useBean id="reg_memberbean" class="originalversion.MemberBean"
		scope="session" />


<FORM ACTION="./Project2Servlet" method="post">

<h1>您好 <%= rgb.getUserid() %> !!</h1>

<h3>以下為選填資料 :</h3>

		<div>
			<label>姓名</label> <br> </a><input type="text" id="name"
				name="name" autocomplete="off" size="10" value=" ">
				<span id="nameerror"></span>
		</div>
		
		<div>
			<label>綽號</label> <br> </a><input type="text" id="nickname"
				name="nickname" autocomplete="off" size="10" value=" ">
		</div>
		
		<div>
			<label>電話號碼</label> <br> </a><input type="text" id="phone"
				name="phone" autocomplete="off" size="10" value=" "><span id="phoneerror"></span>
		</div>
		
		<div>
			<label>國家</label> <br> </a><input type="text" id="nationality"
				name="nationality" autocomplete="off" size="10" value=" ">
				<span id="nationalityerror"></span>
				
		</div>
		<div>
			<label>生日</label> <br> </a><input type="date" id="birth"
				name="birth" autocomplete="off" size="10" value=" ">
		</div>
		
		<div>
		<label>性別</label> <br>
		<select name="gender">
		<option value="male">男生</option>
		<option value="female">女生</option>
		</select>
		
		
		</div>
		
		
		
		
		
		<div>
			<label>地址</label> <br> </a><input type="text" id="address"
				name="address" autocomplete="off" size="10" value=" ">
		</div>
		
		<div>
			<label>郵箱</label> <br> </a><input type="text" id="email"
				name="email" autocomplete="off" size="10" value=" ">
				<span id="emailerror"></span>
		</div>
		<hr>

		<input type="submit" name="addnewinfofrommember" value="確認"> <br><br>
		
	</form>
	
	<FORM ACTION="Jacky-Login.jsp" method="post">
			<button onclick="">返回</button>
	</form>
	
	<script>
	window.onload = function(){
		var nameElt = document.getElementById('name')
		var nameerror = document.getElementById('nameerror')
		
		nameElt.onblur =function() {
			var name = nameElt.value;
			name = name.trim()
			if (name === "") {
				nameerror.innerHTML = "名字不能爲空"
				document.querySelector('#addnewinfofrommember').disabled = true;
		}
	}
}
	
	
	
	</script>
</body>
</html>