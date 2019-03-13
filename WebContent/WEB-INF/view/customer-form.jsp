<!-- ADD SUPPORT FOR SPRING MVC FORM TAGS -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title> Save Customer</title>
	<!-- REFERENCE FOR CSS -->
	<link type ="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
	<link type ="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>

</head>

<body>

	<div id="wapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Customer</h3>
		
		<!-- SAVE CUSTOMER MAPPING -->
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
		
		<!-- SOCIATE THE DATA WITH CUSTOMER -->
		<form:hidden path="id"/>
		<table>
			<tbody>
				<tr>
					<td><label>First name: </label></td>
					<td><form:input path="firstName"/>
				</tr>
				<tr>
					<td><label>Last name: </label></td>
					<td><form:input path="lastName"/>
				</tr>
				<tr>
					<td><label>Email: </label></td>
					<td><form:input path="email"/>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save"></td>
				</tr>
				
			</tbody>
		
		</table>
				
		</form:form>
	
		<div style="clean; both"></div>
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Go Back</a>
		</p>
		
	</div>

</body>

</html>