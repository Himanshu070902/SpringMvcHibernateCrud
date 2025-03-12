<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Edit Employee</title>
    <style>
        form { width: 50%; margin: auto; padding: 20px; border: 1px solid #ccc; border-radius: 10px; background: #f9f9f9; }
        label { display: block; margin: 10px 0 5px; }
        input { width: 100%; padding: 8px; }
        button { background: orange; color: white; padding: 10px; border: none; cursor: pointer; }
    </style>
</head>
<body>
    <h2 style="text-align: center;">Edit Employee</h2>
    <form:form action="${pageContext.request.contextPath}/employee/update" modelAttribute="employee">
        <form:hidden path="id"/>

        <label>Name:</label>
        <form:input path="name" required="true"/>

        <label>Email:</label>
        <form:input path="email" required="true"/>

        <label>Department:</label>
        <form:input path="department" required="true"/>

        <br><br>
        <button type="submit">Update</button>
    </form:form>
    <br>
    <div style="text-align: center;">
        <a href="${pageContext.request.contextPath}/employee/list">Back to List</a>
    </div>
</body>
</html>
