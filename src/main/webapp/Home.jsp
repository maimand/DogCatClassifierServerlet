<%@page import="model.Bean.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Dashboard</title>
</head>
<body>
	<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	display: flex;
	justify-content: center;
	min-height: 100vh;
	background: #FFF;
}

header {
	width: 980px;
	height: 100px;
	background: #cb7802;
	text-align: center;
}

footer {
	text-align: center;
	position: absolute;
	bottom: 0;
	width: 980px;
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
.upload {
	background: #CCFFFF;
	height: 300px;
}

.container {
	width: 980px;
	margin: 0 auto;
}

nav {
	height: 35px;
	background: #cb7802;
}

nav .menu ul {
	list-style: none;
}

nav .menu ul li {
	line-height: 35px;
	padding: 0 15px;
}

.right {
	float: right;
}

.left {
	float: left;
}

nav .menu ul li a {
	color: #fff;
	font-size: 14px;
}

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

.tt {
	color: #fff;
	margin: 0 80px;
	font-size: 50px;
}
</style>
	<div class="container">
		<header>
			<a href="#"><img src="dogcat.jpg" alt="DogCat"></a> <a
				class="tt">DOG&CAT CLASSIFIER</a>
		</header>

		<nav>
			<div class="menu">
				<ul>

					<li class="right"><a
						href="<%=request.getContextPath()%>/logout">Log out</a></li>
				</ul>
			</div>
		</nav>

		<%
		User user = (User) request.getSession().getAttribute("user");
		if (user != null)
		{
			String name = user.username;
		%>
		<p>
			Hello
			<%=name%></p>
		<div id="upload" class="upload">
			<button class="btn" onclick="window.location.href='PickImage.jsp'">Choose
				Picture</button>
			<a href="<%=request.getContextPath()%>/history"
				class="btn btn-success">History</a>
		</div>
		<%
		} else {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/login");
		}
		%>
	</div>
	<footer>
		<p>
			Contact: <a href="">hege@example.com</a>
		</p>
	</footer>

</body>
</html>
