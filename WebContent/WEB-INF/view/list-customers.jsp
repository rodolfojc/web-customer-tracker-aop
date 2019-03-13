<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<title>List Customer</title>
	
	<!-- REFERENCE FOR CSS -->
	<link type ="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
	
</head>


<body>

	<div id="wrapper">
		<div id="header">
			<h2> CRM - Customer Relation Manager</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
		<input type="button" value="Add Customer" onclick = "window.location.href='showFormForAdd'; return false;"
		class="add-button"/>
		
		
		<!-- HTML TABLE -->
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
		
		<!-- LOOP OVEER CONTOMERS -->
		
		<c:forEach var="tempCustomer" items="${customers}">
		
		<!-- UPDATE LINK UPDATE -->
		<c:url var="updateLink" value="/customer/showFormForUpdate">
			<c:param name="customerId" value="${tempCustomer.id}"></c:param>
		
		</c:url>
		
		<!-- UPDATE LINK DELETE-->
		<c:url var="deleteLink" value="/customer/delete">
			<c:param name="customerId" value="${tempCustomer.id}"></c:param>
		
		</c:url>
		
			<tr>
				<td>${tempCustomer.firstName}</td>
				<td>${tempCustomer.lastName}</td>
				<td>${tempCustomer.email}</td>
				<!-- DISPLAY LINK UPDATE-->
				<td><a href="${updateLink}">Update</a>
				<!-- DISPLAY LINK DELETE-->
				<a href="${deleteLink}"
				onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a></td>
				
			</tr>
		</c:forEach>
		
		
		</table>
		
		
		</div>
	
	</div>

</body>

</html>