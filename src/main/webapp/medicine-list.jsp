<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./styles/style.css">
<link rel="stylesheet" href="./styles/medicine-style.css">
<title>Manage Medicine</title>
</head>
<body>
	<div class="container flex">
        <div class="side-nav flex flex-column">
            <a href="logout">Logout</a>
            <a href="listStores">Manage Store</a>
            <a href="medicines" class="selected-link">Manage Medicine</a>
        </div>
        <div class="content-area">
            <div class="header-section"><h2>Manage Medicine</h2></div>
            <div class="content-section">
            	<form action="addMedicine" method="post">
            		<button type="submit" class="btn btn-primary">
	                    <!-- <svg height="10" viewBox="0 0 426.66667 426.66667" fill="currentColor" width="10" xmlns="http://www.w3.org/2000/svg"><path d="m405.332031 192h-170.664062v-170.667969c0-11.773437-9.558594-21.332031-21.335938-21.332031-11.773437 0-21.332031 9.558594-21.332031 21.332031v170.667969h-170.667969c-11.773437 0-21.332031 9.558594-21.332031 21.332031 0 11.777344 9.558594 21.335938 21.332031 21.335938h170.667969v170.664062c0 11.777344 9.558594 21.335938 21.332031 21.335938 11.777344 0 21.335938-9.558594 21.335938-21.335938v-170.664062h170.664062c11.777344 0 21.335938-9.558594 21.335938-21.335938 0-11.773437-9.558594-21.332031-21.335938-21.332031zm0 0"/></svg> -->
	                    <img src="./icons/plus-heaven.svg" alt="" height="13px">
	                    Add
	                </button>
            	</form>
                <c:if test="${error != null}">
                	<div class="error">
	                	${error}
	                </div>
                </c:if>
                <table cellspacing="0">
                    <tr>
                        <th>Action</th>
                        <th>Medicine Name</th>
                        <th>Medicine Price</th>
                        <th>Expiry Date</th>
                        <th>Medicine Type</th>
                        <th>Store Name</th>
                    </tr>
                    <c:forEach var="medicine" items="${medicines}">
	                    <tr>
	                        <td>
	                            <a href="editMedicine?id=${medicine.getId()}">Edit</a>
	                            <a href="deleteMedicine?id=${medicine.getId()}">Delete</a>
	                        </td>
	                        <td>${medicine.getName()}</td>
	                        <td>${medicine.getPrice()}</td>
	                        <td>${medicine.getExpiryDate()}</td>
	                        <td>${medicine.getMedicineTypeName()}</td>
	                        <td>${medicine.getStoreName()}</td>
	                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</body>
</html>