
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head><h1>Homepage</h1></head>
<body>
<h2>Welcome Home!</h2>

		<div>
		User: <security:authentication property="principal.username"/>
		</div>
		<div>
		Role: <security:authentication property="principal.authorities"/>
		</div>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
							<input type="submit" value="Logout"/>
	 </form:form>
</body>
</html>