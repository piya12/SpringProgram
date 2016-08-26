<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Success</title>
<link href="assets/css/bootstrap-united.css" rel="stylesheet" />

</head>
<body>
	
	<
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">Student Enrollment Login success</h3>
		</div>
		<div class="panel-body">
		<div class="alert alert-dismissable alert-success">
              
              <strong><font color="red">Well done!</font></strong> <br>
              You successfully logged-into the system. 
              Now you can explore the complete features!
            </div>
		</div>
	</div><br><br><br>
	<div><center>
	<input type="submit" value="GO AHEAD" id="yesbutton"></center></div>
	<div></div>
	<a class="btn btn-primary" href="<spring:url value="login.html"/>">Login
		as different user?</a>
</body>
</html>