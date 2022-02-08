<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Producer</title>
    <%@ include file="../headers.jsp" %>
</head>
<body>
    <%@ include file="../navigation.jsp" %>
    <div class="container">
        <div class="row">
            <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                <div class="btn-group me-2" role="group" aria-label="Second group">
                    <a href="/producer" type="button" class="btn btn-success">All producers</a>
                </div>
            </div>
        </div><div class="row"><p> </p></div>
        <form:form id="form">
            <div class="row">
            <div class="mb-3">
            <label for="id">id</label>
            <input type="text" class="form-control" disabled name="id" id="id" placeholder="${producer.id}" value="${producer.id}">
            </div>
            <div class="mb-3">
            <label for="name">name</label>
            <input type="text" class="form-control" name="name" id="name" placeholder="${producer.name}" value="${producer.name}">
            </div>
            </div>
            <button onclick="save()" type="submit" class="btn btn-primary">Save</button>
        </form:form>
    </div>
</body>
</html>
