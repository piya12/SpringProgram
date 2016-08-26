<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body bgcolor="#6495ED">


	<script src="jquery-1.8.3.js">
		
	</script>



	<div class="container">
		<div class="jumbotron">
			<div>
				<h3><font color="#FAF0E6"><center>Welcome To Signup</center></font></h3>
				
			</div>
		</div>

		<div></div>
	</div>

	<c:if test="${not empty message}">
		<div class="message green">${message}</div>
	</c:if>

	<div class="col-lg-6 col-lg-offset-3">
		<div class="well">
			<div class="container">
				<div class="row">
					<div class="col-lg-6">
						<form:form id="myForm" method="post"
							class="bs-example form-horizontal" commandName="student">
							<fieldset>
								<legend> <h4>Signup Form is here...</h4></legend>

								<div class="form-group">
									<label for="userNameInput" class="col-lg-3 control-label">User
										Name</label>
									<div class="col-lg-9">
										<form:input type="text"  path="userName"
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

								<div class="form-group">
									<label for="firstNameInput" class="col-lg-3 control-label">First
										Name</label>
									<div class="col-lg-9">
										<form:input type="text" class="form-control" path="firstName"
											id="firstNameInput" placeholder="First Name" />
										<form:errors path="firstName" cssClass="error" />
									</div>
								</div>

								<div class="form-group">
									<label for="lastNameInput" class="col-lg-3 control-label">Last
										Name</label>
									<div class="col-lg-9">
										<form:input type="text" class="form-control" path="lastName"
											id="lastNameInput" placeholder="Last Name" />
										<form:errors path="lastName" cssClass="error" />
									</div>
								</div>

								
								<div class="form-group">
									<label for="emailAddressInput" class="col-lg-3 control-label">Email
										Address</label>
									<div class="col-lg-9">
										<form:input type="text" class="form-control"
											path="emailAddress" id="emailAddressInput"
											placeholder="Email Address" />
										<form:errors path="emailAddress" cssClass="error" />
									</div>
								</div>

								<div class="col-lg-9 col-lg-offset-3">
									<button class="btn btn-default">Cancel</button>

									<button class="btn btn-primary" data-toggle="modal"
										data-target="#themodal">Submit</button>
									<div id="themodal" class="modal fade" data-backdrop="static">									
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-hidden="true">&times;</button>
													<h3>Signup Form Submission</h3>
												</div>
												<div class="modal-body">
													<p>Are you sure you want to do this?</p>
													<div class="progress progress-striped active">
														<div id="doitprogress" class="progress-bar"></div>
													</div>
												</div>
												<div class="modal-footer">
													<a href="#" class="btn btn-default" data-dismiss="modal">Close</a>
													<input type="submit" value="Yes" id="yesbutton"
														class="btn btn-primary" data-loading-text="Saving.."
														data-complete-text="Submit Complete!">
												</div>
											</div>
										</div>
									</div>

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