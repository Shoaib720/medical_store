<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="./styles/style.css">
    <link rel="stylesheet" href="./styles/store-style.css">
    <title>Store Form</title>
</head>
<body>
	<div class="container flex">
        <div class="side-nav flex flex-column">
            <a href="logout">Logout</a>
            <a href="listStores" class="selected-link">Manage Store</a>
            <a href="medicines">Manage Medicine</a>
        </div>
        <div class="content-area">
            <div class="header-section">
            	<c:if test="${store == null}">
            		<h2>Add Store</h2>
            	</c:if>
            	<c:if test="${store != null}">
            		<h2>Edit Store</h2>
            	</c:if>
            	
            </div>
            <div class="content-section" style="width: 70%;">
            <c:if test="${store != null}">
            	<form action="updateStore" method="post">
            </c:if>
            <c:if test="${store == null}">
            	<form action="insertStore" method="post">
            </c:if>
            		<c:if test="${store != null}">
            			<input type="hidden" name = "store-id" value="${store.getId()}"/>
            		</c:if>
                    <div class="form-fields">
                        <div class="form-row-fields flex justify-between">
                            <div class="form-item">
                                Store Name<sup>*</sup> <input type="text" name="store-name" maxlength="60" required value="${store.getStoreName()}">
                            </div>
                            <div class="form-item">
                                Username<sup>*</sup> <input type="text" name="username" maxlength="60" required value="${store.getUsername()}">
                            </div>
                        </div>
                        
                        <div class="form-row-fields flex justify-between">
                            <div class="form-item">
                                Password<sup>*</sup> <input type="password" name="password" minLength="6" maxlength="10" required value="${store.getPassword()}">
                            </div>
                            <div class="form-item">
                                Email Id <input type="email" name="email" maxlength="60" value="${store.getStoreEmailId()}">
                            </div>
                        </div>
                        <div class="form-row-fields flex justify-between">
                            <div class="form-item">
                                Mobile Number <input type="number" name="mobile" maxlength="20" value="${store.getMobile()}">
                            </div>
                            <div class="form-item">
                                Registration No. <input type="text" name="registration-number" maxlength="60" value="${store.getStoreRegistrationNumber()}">
                            </div>
                        </div>
                        <div class="form-row-fields flex">
                            Store License<sup>*</sup> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <div class="form-item">
                                <label for="retail">Retail Drug License</label>
                                <input type="radio" name="license" id="retail" required value="0" ${ store.getStoreLicense() == 0 || store == null ? 'checked' : '' }>
                            </div>
                            <div class="form-item">
                                <label for="wholesale">Wholesale Drug License</label>
                                <input type="radio" name="license" id="wholesale" value="1" ${ store.getStoreLicense() == 1 ? 'checked' : '' }>
                            </div>
                        </div>
                        <div class="form-row-fields">
                            Store Type<sup>*</sup>
                            <select name="store-type" required>
                            	<c:forEach items="${storeTypes}" var="storeType">
                            		<option value="${storeType.getId()}" ${ store.getStoreTypeId() == storeType.getId() ? 'selected' : '' }>${storeType.getTypeName()}</option>
                            	</c:forEach>
                            </select>
                        </div>
                        <div class="form-row-fields flex justify-between">
                            <div class="form-item">
                                Address 1<sup>*</sup> <br>
                                <textarea name="address1" id="" cols="30" rows="5" maxlength="100" required>${store.getAddress1()}</textarea>
                            </div>
                            <div class="form-item">
                                <label for="address2">Address 2</label> <br>
                                <textarea name="address2" id="address2" cols="30" rows="5" maxlength="100">${store.getAddress2()}</textarea>
                            </div>
                        </div>
                    </div>
                    <div class="actions">
                        <a href="listStores" class="btn-link">Back</a>
                        <button type="submit" class="btn btn-primary">Save</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>