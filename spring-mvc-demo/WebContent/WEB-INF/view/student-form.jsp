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
			
				<form:options items="${student.countryOptions}" />
				
			</form:select>
			
			<br><br>
			
			Favorite Language:
			
			Java <form:radiobutton path="FavoriteLanguage" value="Java"/>		
			C# <form:radiobutton path="FavoriteLanguage" value="C#"/>	
			PHP <form:radiobutton path="FavoriteLanguage" value="PHP"/>	
			Ruby <form:radiobutton path="FavoriteLanguage" value="Ruby"/>		
			
			<input type="submit" value="submit">
			
		</form:form>
		
		
		
	</body>
	
</html>