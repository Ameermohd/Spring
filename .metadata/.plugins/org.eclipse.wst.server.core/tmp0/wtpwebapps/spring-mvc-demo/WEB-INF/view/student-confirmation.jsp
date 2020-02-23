<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>

<body>

The Student ${Student.firstname} ${Student.lastname} is Confirmed<br/>

County : ${Student.country}<br/>

Favorite-Language: ${Student.favoritelanguage } <br/>

Operating systems:	${Student.operatingsystems}

<ul>
  <c:forEach var="temp" items="${Student.operatingsystems}">
	<li>${temp}</li>
	</c:forEach>
</ul>

<c:forEach var="window" items="${Student.operatingsystems}">
    <c:out value="${window}"/> 
</c:forEach>



</body>


</html>