<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Student Enrollment Login</title>
</head>
<body bgcolor="#6495ED">
	<script src="jquery-1.8.3.js">
		
	</script>

	<div class="container">
		<div class="jumbotron">
			<div>
				<h1><font color="#FAF0E6">Welcome to Online Student Enrollment Login</font>></h1>
				<p>Login to explore the complete features!</p>
			</div>
		</div>

		<div></div>
	</div>

	<div class="col-lg-6 col-lg-offset-3">
		<div class="well">
			<div class="container">
				<div class="row">
					<div class="col-lg-6">
						<form:form id="myForm" method="post"
							class="bs-example form-horizontal" commandName="studentLogin">
							<fieldset>
								<legend>Student Enrollment Login Form</legend>

								<div class="form-group">
								
									<label for="userNameInput" class="col-lg-3 control-label">User
										Name</label>
									<div class="col-lg-9">
										<form:input type="text" class="form-control" path="userName"
											id="userNameInput" placeholder="User Name" />
										<form:errors path="userName" cssClass="error" />
									</div>
								</div>

								<div class="form-group">
									<label for="passwordInput" class="col-lg-3 control-label">Password</label>
									<div class="col-lg-9">
										<form:input type="password" class="form-control"
											path="password" id="passwordInput" placeholder="Password" />
										<form:errors path="password" cssClass="error" />
									</div>
								</div>

								<div class="col-lg-9 col-lg-offset-3">
									<button class="btn btn-default">Cancel</button>

									<button class="btn btn-primary">Login</button>
								</div>

							</fieldset>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>