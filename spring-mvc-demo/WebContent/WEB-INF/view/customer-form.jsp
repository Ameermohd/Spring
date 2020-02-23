<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Customer Registration Form</title>
	<style>
		.error {color: red}	
	</style>
</head>

<body>

 
 <form:form action="processform"  modelAttribute="Customer">
 
 	<br/>
			
			FirstName:<form:input path="firstname"/> 
			<br><br>
			LastName:<form:input path="lastname"/>
			<form:errors path="lastname" cssClass="error"/>
			<br><br>
			Freepasses:<form:input path="freepasses"/>
			<form:errors path="freepasses" cssClass="error"/>
			<br><br>
			PostalCode:<form:input path="postalcode"/>
			<form:errors path="postalcode" cssClass="error"/>
			<br><br>
			CourseCode:<form:input path="coursecode"/>
			<form:errors path="coursecode" cssClass="error"/>
			
			
 <br><br>
 
 	<input type="submit" value="Submit"/>
 
 
 
 
 </form:form>



</body>
