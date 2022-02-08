<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
    <%@ include file="../headers.jsp" %>
</head>
<body>
<%@ include file="../navigation.jsp" %>
<div class="container">
    <div class="row">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2" role="group" aria-label="Second group">
                <a href="/user" type="button" class="btn btn-success">All users</a>
            </div>
        </div>
    </div><div class="row"><p> </p></div>
    <form:form id="form">
        <div class="row">
            <div class="mb-3">
                <label for="id" class="form-label">id</label>
                <input type="text" disabled name="id" id="id" placeholder="${user.id}" value="${user.id}">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">e-mail</label>
                <input type="text" name="email" id="email" placeholder="${user.email}" value="${user.email}">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">password</label>
                <input type="text" name="password" id="password" placeholder="${user.password}" value="${user.password}">
            </div>
            <div class="mb-3">
                <label for="firstName" class="form-label">first name</label>
                <input type="text" name="firstName" id="firstName" placeholder="${user.firstName}" value="${user.firstName}">
            </div>
            <div class="mb-3">
                <label for="lastName" class="form-label">last name</label>
                <input type="text" name="lastName" id="lastName" placeholder="${user.lastName}" value="${user.lastName}">
            </div>
            <div class="mb-3">
                <label for="role" class="form-label">role</label>
                <select class="form-select" aria-label="Default select example"
                        name="role" id="role" placeholder="Select role from menu">
                    <option selected disabled>${user.role}</option>
                    <option value="USER">user</option>
                    <option value="ADMIN">admin</option>
                </select>
            </div>
        </div>
        <button onclick="save()" type="submit" class="btn btn-primary">Save</button>
    </form:form>
</div>
</body>
</html>
