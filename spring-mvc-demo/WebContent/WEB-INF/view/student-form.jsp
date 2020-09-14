<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

	<head>
		<title>Student Registration form</title>
	</head>
	
	<body>
		
		<form:form action="processForm" modelAttribute="student">
			
			First Name: <form:input path="firstName"/>
			<br><br>
			Last Name: <form:input path="lastName"/>
			<br><br>
			
			Country:
			
			<form:select path="country">
			
				<form:option value="Brazil" label="Brazil"></form:option>
				<form:option value="Argentina" label="Argentina"></form:option>
				<form:option value="Germany" label="Germany"></form:option>
				<form:option value="France" label="France"></form:option>
				
			</form:select>
			
			<br><br>
			
			<input type="submit" value="submit">
			
		</form:form>
		
		
		
	</body>
	
</html>