<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./styles/style.css">
<link rel="stylesheet" href="./styles/medicine-style.css">
<title>Medicine Form</title>
</head>
<body>
	<div class="container flex">
        <div class="side-nav flex flex-column">
            <a href="logout">Logout</a>
            <a href="listStores">Manage Store</a>
            <a href="medicines" class="selected-link">Manage Medicine</a>
        </div>
        <div class="content-area">
            <div class="header-section">
            	<c:if test="${medicine == null}">
            		<h2>Add Medicine</h2>
            	</c:if>
            	<c:if test="${medicine != null}">
            		<h2>Edit Medicine</h2>
            	</c:if>
            	
            </div>
            <div class="content-section" style="width: 70%;">
            
            <c:if test="${medicine == null}">
            	<form action="insertMedicine" method="post">
            </c:if>
            <c:if test="${medicine != null}">
            	<form action="updateMedicine" method="post">
            </c:if>
            	<c:if test="${medicine != null}">
            		<input type="hidden" name="medicine-id" value="${medicine.getId()}"/>
            	</c:if>
                    <div class="form-fields">
                        <div class="form-row-fields flex justify-between">
                            <div class="form-item">
                                Medicine Name<sup>*</sup> <input type="text" name="name" maxLength="60" required value="${medicine.getName()}">
                            </div>
                            <div class="form-item">
                                Price<sup>*</sup> <input type="text" name="price" maxLength="15" pattern="^[-+]?[0-9]*\.?[0-9]+$" required value="${medicine.getPrice()}">
                            </div>
                        </div>
                        
                        <div class="form-row-fields flex justify-between">
                            <div class="form-item">
                                Medicine Details <br>
                                <textarea name="details" id="" cols="30" rows="5" maxLength="100">${medicine.getDetails()}</textarea>
                            </div>
                            <div class="form-item">
                                Quantity <input type="number" name="quantity" maxLength="20" value="${medicine.getQuantity()}">
                            </div>
                        </div>
                        <div class="form-row-fields flex justify-between">
                            <div class="form-item">
                                Medicine Type<sup>*</sup>
                                <select name="type" required>
                                	<c:forEach var="medicineType" items="${ medicineTypes }">
                                		<option value="${ medicineType.getId() }" ${ medicineType.getId() == medicine.getMedicineTypeId() ? 'selected' : '' }>${ medicineType.getMedicineTypeName() } x ${medicineType.getId()}</option>
                                	</c:forEach>
                                </select>
                            </div>
                            <div class="form-item">
                                Store<sup>*</sup>
                                <select name="store" required>
                                    <c:forEach var="store" items="${ stores }">
                                		<option value="${ store.getId() }" ${ store.getId() == medicine.getStoreId() ? 'selected' : '' }>${ store.getStoreName() }</option>
                                	</c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-row-fields flex">
                            Expiry Date<sup>*</sup> <input type="date" name="expiry-date" required value="${medicine.getExpiryDate()}">
                        </div>
                    </div>
                    <div class="actions">
                        <a href="medicines" class="btn-link">Back</a>
                        <button type="submit" class="btn btn-primary">Save</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>