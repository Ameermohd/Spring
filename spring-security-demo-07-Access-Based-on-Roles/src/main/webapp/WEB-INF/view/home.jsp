
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head><h1>Homepage</h1></head>
<body>
<h2>Welcome Home!</h2>
	<hr>
		<div>
		User: <security:authentication property="principal.username"/>
		</div>
		<div>
		Role: <security:authentication property="principal.authorities"/>
		</div>
		
		<security:authorize access="hasRole('MANAGER')">
		<div>
		<p>
		<a href="${pageContext.request.contextPath}/leader">For Managers</a>
		<p>
		</div>
		</security:authorize>
		
		<security:authorize access="hasRole('ADMIN')">
		<div>
		<p>
		<a href="${pageContext.request.contextPath}/admin">For System Admin</a>
		<p>
		</div>
		</security:authorize>

	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
							<input type="submit" value="Logout"/>
	 </form:form>
</body>
</html>