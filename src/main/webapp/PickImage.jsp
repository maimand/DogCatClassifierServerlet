<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>ChoosePicture</title>
</head>
<body>
<style>
*{
      padding: 15px;
      box-sizing: border-box;  
}
 body{
      display: flex;
      justify-content: center;
      min-height: 100vh;
      background: #CCFFFF;
      }
  .frm{
   width: 400px;
   height: 200px;
   background:#fff;
   border-radius: 20px;
   color: #1b2a49;
  }
   h2{
  padding-top: 50px;
  color: #c47135;
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

.btn:before,
.btn:after {
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

.btn:hover,
.btn.hover {
  background-color: #c47135;
}

.btn:hover:before,
.btn.hover:before,
.btn:hover:after,
.btn.hover:after {
  height: 100%;
  width: 100%;
}
</style>
<div style="text-align: center">
<h2>CHOOSE PICTURE</h2>
	<form class="frm" method="post" action="<%=request.getContextPath()%>/home" enctype="multipart/form-data">
		Select file to upload the picture: </br></br><input type="file" name="file" size="60" accept=".jpg, .png" multiple/> 
		 <input type="submit" class="btn" value="Upload" />
	</form>
</div>
</body>
</html>