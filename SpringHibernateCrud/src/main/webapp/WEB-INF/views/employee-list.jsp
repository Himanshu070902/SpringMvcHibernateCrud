<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"
%>
<%@ taglib
	uri="http://www.springframework.org/tags/form"
	prefix="form"
%>
<html>
<head>
<title>Employee List</title>
<style>
table {
	width: 80%;
	margin: auto;
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
	padding: 8px;
	text-align: center;
}

th {
	background-color: #f2f2f2;
}

a {
	text-decoration: none;
	padding: 5px 10px;
	background: green;
	color: white;
	border-radius: 5px;
}

.delete-btn {
	background: red;
}
</style>
</head>
<body>
	<h2 style="text-align: center;">Employee List</h2>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Department</th>
			<th>Actions</th>
		</tr>
		<c:forEach
			var="employee"
			items="${employees}"
		>
			<tr>
				<td>${employee.id}</td>
				<td>${employee.name}</td>
				<td>${employee.email}</td>
				<td>${employee.department}</td>
				<td><a
					href="${pageContext.request.contextPath}/employee/edit/${employee.id}"
				>Edit</a> <a
					href="${pageContext.request.contextPath}/employee/delete/${employee.id}"
					class="delete-btn"
				>Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<div style="text-align: center;">
		<a href="${pageContext.request.contextPath}/employee/new">Add New
			Employee</a>
	</div>
</body>
</html>
