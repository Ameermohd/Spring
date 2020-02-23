<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
		<!-- Add button for add customer -->
		<input type="button" value="Add Customer"  
					onclick="window.location.href='showFormForAdd'; return flase;"
					class="add-button"
					/ >
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th> 
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">
				
				<!--  Storing the sutomer id in parameter customerId -->
				<c:url var="updatelink"  value="showformforupdate">
					<c:param name="customerId" value="${tempCustomer.id}" />
				</c:url>
				<c:url var="deletelink"  value="showformfordelete">
					<c:param name="customerId" value="${tempCustomer.id}" />
				</c:url>
					<tr>
						<td> ${tempCustomer.firstname} </td>
						<td> ${tempCustomer.lastname} </td>
						<td> ${tempCustomer.email} </td>
						<td><a href="${updatelink}">Update</a>
						|
						<a href="${deletelink}" onclick="if(!(confirm('Are you sure?'))) return false else return true">Delete</a></td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









