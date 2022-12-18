<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./styles/style.css">
<link rel="stylesheet" href="./styles/store-style.css">
<title>Manage Store</title>
</head>
<body>
<div class="container flex">
        <div class="side-nav flex flex-column">
            <a href="logout">Logout</a>
            <a href="listStores" class="selected-link">Manage Store</a>
            <a href="medicines">Manage Medicine</a>
        </div>
        <div class="content-area">
            <div class="header-section"><h2>Manage Store</h2></div>
            <div class="content-section">
                <form action="addStore" method="post">
                    <button class="btn btn-primary" type="submit">
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
                        <th>Store Name</th>
                        <th>Username</th>
                        <th>Store License</th>
                        <th>Store Type</th>
                    </tr>
                    <c:forEach var="store" items="${storesList}">
                    	<tr>
	                        <td>
	                            <a href="editStore?id=${store.getId()}">Edit</a>
	                            <a href="deleteStore?id=${store.getId()}">Delete</a>
	                        </td>
	                        <td><c:out value="${store.getStoreName()}"/></td>
	                        <td><c:out value="${store.getUsername()}"/></td>
	                        <td><c:out value="${store.getStoreLicense() == 0 ? 'Retail Drug License' : 'Wholesale Drug License'}"/></td>
	                        <td><c:out value="${store.getStoreTypeName()}"/></td>
                    	</tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</body>
</html>