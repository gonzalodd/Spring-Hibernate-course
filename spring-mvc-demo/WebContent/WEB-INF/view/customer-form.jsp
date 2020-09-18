<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

	<head>
		<title>Customer Registration Form</title>
		
		<style>
			.error {color:red} <!-- Hace referencia al cssClass="error" de lastName -->
		</style>
	</head>

	<body>
		
		<i>Fill out the form. Asterisk (*) means required.</i>
		
		<form:form action="processForm" modelAttribute="customer">
			
			<br><br>
			
			First name: <form:input path="firstName" />
			
			<br><br>
			
			Last name (*): <form:input path="lastName"/>
			<form:errors path="lastName" cssClass="error"/>
			
			<br><br>
			
			<input type="submit" value="submit">
			
		</form:form>	
			
	</body>

</html>