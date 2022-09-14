
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="tw.jacky.model.*"%>

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
<TITLE>創建會員界面</TITLE>
<link href="https://img.onl/DOO7l" rel="icon" type="image/png" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style>
span{
color:red
}

.test{
margin-left: 45%;
}

.test2{
margin-left: 45%;
}

fieldset{
bordr :2px solid;

}


</style>


</head>


<body>

<fieldset>

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

<div class="test">

	<H1>註冊帳號</H1>
	<h3>JS驗證</h3>

	<FORM ACTION="./Project2Servlet" method="post">
		<div>
			<input type="hidden" id="statusid" name="statusid" autocomplete="off"
				size="10" value="1">
		</div>

		<div>
			<label>userID</label> <br> </a><input type="text" id="userid"
				name="userid" autocomplete="off" size="10"> <span
				id="useriderror"></span>
		</div>

		<div>
			<label >password</label> <br> </a><input
				type="text" id="password" name="password" autocomplete="off"
				size="10"> 
		</div>

		<div>
			<label >password</label> <br> </a> 
			<input
				type="password" id="password2" name="password2"
				autocomplete="off" size="10"> 
				<span id="passworderror"></span>
		</div>

		<br> <INPUT TYPE="submit" id="createmember" name="createmember" value="提交" >
		</div>

		<br>
		
		<input type="hidden" id="name" name="name" autocomplete="off"
				size="10" value=" ">
		<input type="hidden" id="nickname" name="nickname" autocomplete="off"
				size="10" value=" ">
		<input type="hidden" id="phone" name="phone" autocomplete="off"
				size="10" value=" ">
		<input type="hidden" id="nationality" name="nationality" autocomplete="off"
				size="10" value=" ">		
		<input type="hidden" id="birth" name="birth" autocomplete="off"
				size="10" value=" ">	
		<input type="hidden" id="gender" name="gender" autocomplete="off"
				size="10" value=" ">	
		<input type="hidden" id="address" name="address" autocomplete="off"
				size="10" value=" ">		
		<input type="hidden" id="email" name="email" autocomplete="off"
				size="10" value=" ">		
		<input type="hidden" id="createtime" name="createtime" autocomplete="off"
				size="10" value=" ">		
		<input type="hidden" id="modifytime" name="modifytime" autocomplete="off"
				size="10" value=" ">		

		<script>
			window.onload = function() {
				var usernameElt = document.getElementById('userid')
				var usernameerror = document.getElementById('useriderror')
				usernameElt.onblur = function() {
					var username = usernameElt.value;
					username = username.trim()
					if (username === "") {
						usernameerror.innerHTML = "用戶名不能爲空"
						document.querySelector('#createmember').disabled = true;
					}else{
						//用戶名不能為空
						//判斷賬號是否在合理的字串範圍内
						if(username.length < 4 || username.length > 14){
							usernameerror.innerHTML = "賬號需要介於4-14個字之間"	
							document.querySelector('#createmember').disabled = true;
						}else{
							//不要有特殊符號,判斷有沒有特殊符號
							var RegExp = /^[A-Za-z0-9]+$/;
							var ok = RegExp.test(username);
							if(ok){
								
							}else{
								usernameerror.innerHTML= "用戶名只能由數字以及字母組成"
								document.querySelector('#createmember').disabled = true;
							}
								
						}
					}
				}
				
				usernameElt.onfocus= function(){
					//紅字不會產生的時候
					if(usernameerror.innerText != ""){
						usernameElt.value="";
					document.querySelector('#createmember').disabled = false;
					document.getElementById('infoerror').style.display = 'none';
					
					}
					usernameerror.innerHTML="";
					document.getElementById('infoerror').style.display = 'none';
				}
				
				var password2Elt = document.getElementById('password2')
				var passworderror = document.getElementById('passworderror')
				
				password2Elt.onblur = function(){
				var passwordElt = document.getElementById('password')
				var	password= passwordElt.value;
				var	password2= password2Elt.value;
				
				if (password2 != password){
					passworderror.innerHTML="密碼不一致"
					document.querySelector('#createmember').disabled = true;
				}else{
					document.querySelector('#createmember').disabled = false;
				}	
				}
				password2Elt.onfocus= function(){
					//紅字不會產生的時候
					if(password2Elt.innerText != ""){
						password2Elt.value="";
					}
					passworderror.innerHTML="";
				}
			}
		</script>
		
	</form>

<div class="test2">



	<FORM ACTION="./Jacky-Login.jsp" method="post">
		<br>
		<button onclick="">返回</button>
	</form>
<%
MemberBean nullbean =(MemberBean)request.getAttribute("loginBean2");
if(nullbean != null){
%>
<span id="infoerror" >賬號已存在</span>
<% 
}
else{
%>
<span id="infoerror" ></span>
<% 
}
%>	
</div>

</fieldset>
</body>
</html>