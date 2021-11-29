<%@page import="model.Bean.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
</head>
<body>
	<style>
* {
	padding: 15px;
	box-sizing: border-box;
}

body {
	display: flex;
	justify-content: center;
	min-height: 100vh;
	background: #CCFFFF;
}

.frm {
	width: 400px;
	height: 200px;
	background: #fff;
	border-radius: 20px;
	color: #1b2a49;
}

h1 {
	padding-top: 50px;
	color: #c47135;
}

.inp {
	margin: 10px;
	padding: 10px;
}
/*.btn{
   background-color: #1b2a49;
   font-weight: bold;
   font-size: 1em;
   letter-spacing: 0.1em;
   text-decoration: none;
   color: #ffffff;
   display: inline-block;
   padding: 10px 40px 10px 40px;
   position: relative;
   border: 3px solid #ffffff;
   border-radius: 20px;
 }*/
@import url(https://fonts.googleapis.com/css?family=BenchNine:700);

.btn {
	background-color: #c47135;
	border: none;
	color: #ffffff;
	cursor: pointer;
	display: inline-block;
	font-family: 'BenchNine', Arial, sans-serif;
	font-size: 1em;
	font-size: 16px;
	line-height: 1em;
	margin: 15px 65px;
	outline: none;
	padding: 12px 40px 10px;
	position: relative;
	text-transform: uppercase;
	font-weight: 700;
	position: relative;
	border: 3px solid #ffffff;
	border-radius: 20px;
}

.btn:before, .btn:after {
	border-color: transparent;
	-webkit-transition: all 0.25s;
	transition: all 0.25s;
	border-style: solid;
	border-width: 0;
	content: "";
	height: 24px;
	position: absolute;
	width: 24px;
}

.btn:before {
	border-color: #c47135;
	border-top-width: 2px;
	left: 0px;
	top: -5px;
}

.btn:after {
	border-bottom-width: 2px;
	border-color: #c47135;
	bottom: -5px;
	right: 0px;
}

.btn:hover, .btn.hover {
	background-color: #c47135;
}

.btn:hover:before, .btn.hover:before, .btn:hover:after, .btn.hover:after
	{
	height: 100%;
	width: 100%;
}
</style>
	<%
	User user = (User) request.getSession().getAttribute("user");
	if (user == null) {
	%>
	<div style="text-align: center">
		<h1>LOGIN</h1>
		<form class="frm" class="frm" action="<%=request.getContextPath()%>/login" method="post">
			<input name="username" class="inp" placeholder="Email" size="30" />
			<input type="password" class="inp" name="password"
				placeholder="Password" size="30" />
			<button type="submit" class="btn">Login</button>
		</form>
	</div>
	<%
	} else {
	String contextPath = request.getContextPath();
	response.sendRedirect(contextPath + "/");
	}
	%>
</body>
</html>