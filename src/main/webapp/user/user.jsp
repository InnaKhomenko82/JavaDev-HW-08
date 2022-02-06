<%@ page import="ua.goit.models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
    <%@ include file="../headers.jsp" %>
</head>
<body>
<%@ include file="../navigation.jsp" %>
<%ua.goit.models.User user = (User) request.getAttribute("user"); %>
<div class="container">
    <div class="row">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2" role="group" aria-label="Second group">
                <a href="/user" type="button" class="btn btn-success">All users</a>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="mb-3">
            <label for="id" class="form-label">id</label>
            <input type="text" disabled class="form-control"
                   value="${user.id}"
                   id="id" placeholder="id">
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">email</label>
            <input type="text" class="form-control"
                   value="${user.email}"
                   id="email" placeholder="email">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">password</label>
            <input type="text" class="form-control"
                   value="${user.password}"
                   id="password" placeholder="password">
        </div>
        <div class="mb-3">
            <label for="firstName" class="form-label">firstName</label>
            <input type="text" class="form-control"
                   value="${user.firstName}"
                   id="firstName" placeholder="firstName">
        </div>
        <div class="mb-3">
            <label for="lastName" class="form-label">lastName</label>
            <input type="text" class="form-control"
                   value="${user.lastName}"
                   id="lastName" placeholder="lastName">
        </div>
        <div class="mb-3">
            <label for="role" class="form-label">role</label>
            <select class="form-select" aria-label="Default select example"
                    value="${user.role}" id="role" placeholder="Select role from menu">
                <option selected disabled>${user.role}</option>
                <option value="USER">user</option>
                <option value="ADMIN">admin</option>
            </select>
        </div>
    </div>
    <div class="row">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2" role="group" aria-label="Second group">
                <button onclick="save()" type="button" class="btn btn-primary">Save</button>
            </div>
        </div>
    </div>
</div>
<script>
    let id = document.getElementById('id');
    let skillsField = document.getElementById('skillsField');
    let skillsLevel = document.getElementById('skillsLevel');
    function save() {
        let body = {
            <% if(user.getId() != null) {%>
            id: id.value, <% } %>
            email: email.value,
            password: password.value,
            firstName: firstName.value,
            lastName: lastName.value,
            role: role.value
        }
        <% if(user.getId() == null) {%>
        let url = '/user';
        let method = 'POST';
        <% } else { %>
        let url = '/user/<%= user.getId() %>';
        let method = 'PUT';
        <% } %>
        fetch(url, {
            method: method,
            body: JSON.stringify(body)
        })
            .then( _ => {
                    window.location.href = '/user';
                }
            );
    }
</script>
</body>
</html>
