<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>History</title>
 </head>
 <body>
 
 <style>
*{
      margin: 0;
      padding: 0;
      box-sizing: border-box;  
  }
 body{
      display: flex;
      justify-content: center;
      min-height: 100vh;
      background: #CCFFFF;
  }
header{
  padding-top: 10px;
  width: 980px;
  height:40px;
  background:#CCFFFF;
  text-align: center;
  }
 .container{
 width:980px;
 margin: 0 auto;
 }
 nav{
 height: 35px;
  background:#CCFFFF;
 }
 nav .menu ul{
 list-style: none;
 }
 nav .menu ul li{
 line-height: 35px;
 padding: 0 15px;
 }
 .right{
  float: right;
 }
 .left{
  float: left;
 }
 nav .menu ul li a{
 color: #c47135;
 font-size: 14px;
 }
 .tt{
color: #c47135;
margin: 0 80px;
font-size: 50px;
}
table{
border: 1px solid white;
}
th{
width:100%;
color: white;
height: 70px;
background-color: #c47135;
font-size: 24px;
padding: 10px;
}
td{
padding: 10px;	
text-align:center;
}

 </style>
 <div class="container">
 <header>
	<a class="tt">HISTORY</a>
	</header>
   	<nav>
	<div class="menu">
	<ul>
	<li class="right"><a href="Login.html">Log out</a></li>
	</ul>
	</div>
	</nav>
	<div id="table">
		<table align="center" border="1" cellpadding="1" cellspacing="0" bgcolor="white" >
    <tr>
          <th>Image</th>
          <th>Result</th>
          <th>Delete</th>
       </tr>    
          <tr>
             <td>Img</td>
             <td>Dog</td>
            
             <td>
                <a href="">Delete</a>
             </td>
          </tr>
           <tr>
             <td></td>
             <td></td>
             <td>
                <a href="">Delete</a>
             </td>
          </tr>
           <tr>
             <td></td>
             <td></td>
             <td>
                <a href="">Delete</a>
             </td>
          </tr>
           <tr>
             <td></td>
             <td></td>
             <td>
                <a href="">Delete</a>
             </td>
          </tr>
           <tr>
             <td></td>
             <td></td>
             <td>
                <a href="">Delete</a>
             </td>
          </tr>
           <tr>
             <td></td>
             <td></td>
             <td>
                <a href="">Delete</a>
             </td>
          </tr>

    </table>
	</div>
</div>
 </body>
</html>