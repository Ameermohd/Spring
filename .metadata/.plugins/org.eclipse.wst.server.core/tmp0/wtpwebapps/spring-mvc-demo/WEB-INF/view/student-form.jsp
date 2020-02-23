<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Student Registration Form</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="Student">
	
		First name: <form:input path="firstname" />
		
		<br><br>
	
		Last name: <form:input path="lastname" />
		
		<br><br>
		
		Country :<form:select path="country">
		     
		    <!--  <form:option value="EU">Europe</form:option>
		     <form:option value="BR">Brazil</form:option>
		     <form:option value="CH">China</form:option>
		     <form:option value="IN">India</form:option>  -->
		
		
			<form:options items="${Student.countryoptions}"/>
	   
	    <br/>
	    <br/>
	    
	   
	    
	    
	     </form:select>
	     <br/>
	     Favorite Language:
	     
	    <!--  Java<form:radiobutton path="favoritelanguage" value="Java"/>
	    C++<form:radiobutton path="favoritelanguage" value="C++"/>
		  -->
		
		   <form:radiobuttons path="favoritelanguage" items="${Student.favoritelanguageoptions}"  />

		<br/>
		<br/>
		
		OperatingSystems:
		
		Windows<form:checkbox path="operatingsystems" value="Windows"/>
		Linux<form:checkbox path="operatingsystems" value="Linux"/>
		
		<br/>
		<input type="submit" value="Submit" />
	
	
	
	
	</form:form>


</body>

</html>












