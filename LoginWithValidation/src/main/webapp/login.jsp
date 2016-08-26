<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form method="post" action="check.form" commandName="loginFormBackingObject">
Username: <form:input path="uname"/> <form:errors path="uname"/><br>
Password: <form:password path="pwd"/><form:errors path="pwd"/><br>
<input type=submit value="click"/>
</form:form>

