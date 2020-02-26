
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head><h1>Homepage</h1></head>
<body>
<h2>Welcome Home!</h2>

	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
							<input type="submit" value="Logout"/>
	 </form:form>
</body>
</html>