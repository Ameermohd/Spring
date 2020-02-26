<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>

<html>

<head>
	<title>Login Form</title>
	<style>
		.error {color: red}	
	</style>
</head>

<body>
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
	
	<c:if test="${param.error!=null}">
		<i class="error">Enter valid credentials</i>
	</c:if>
	
	<p>
	Username:<input type="text" name="username">
	</p>
	
	<p>
	Password:<input type="text" name="password">
	</p>
	
	<input type="submit" value="Login"/>
	
	</form:form>



</body>