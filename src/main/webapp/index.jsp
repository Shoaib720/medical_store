<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./styles/style.css">
<link rel="stylesheet" href="./styles/index-style.css">
<title>Medical Store Management</title>
</head>
<body>
	<div class="brand">
        <h1>Medical Store Management</h1>
    </div>
    <div class="login-area">
    	<c:if test="${error != null}">
       		<div class="error">
   				<c:out value="${error}"/>
   			</div>
        </c:if>
        <form action="login" method="post">
            Username: <input type="text" name="username" required><br>
            Password: <input type="password" name="password" required><br>
            <button class="btn btn-primary" type="submit">Login</button>
        </form>
    </div>
</body>
</html>