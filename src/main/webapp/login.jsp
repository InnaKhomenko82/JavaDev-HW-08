<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <%@ include file="headers.jsp" %>
</head>
<body>
<div class="container">
    <div class="row">
        <h3>Log in with your account</h3>
    </div>

    <form:form action="/login" method="POST">
        <div class="mb-3">
            <label class="form-label" for="email">Email</label>
            <input type="email" name="email" id="email" class="form-control" />
        </div>

        <div class="mb-3">
            <label class="form-label" for="password">Password</label>
            <input type="password" name="password" id="password" class="form-control" />
        </div>

        <div class="d-flex justify-content-center">
            <button type="submit" class="btn btn-primary" >Login</button>
        </div>

        <p class="text-center text-muted mt-5 mb-0">or
            <a href="/register" class="fw-bold text-body"><u>Register here</u></a>
        </p>
    </form:form>
</div>
</body>
</html>
