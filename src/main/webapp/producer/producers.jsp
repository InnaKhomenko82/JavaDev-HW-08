<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Producers</title>
    <%@ include file="../headers.jsp" %>
</head>
<body>
<%@ include file="../navigation.jsp" %>
<div class="container">
    <div class="row">
        <h2>Producers</h2>
    </div>
    <div class="row">

        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">id</th>
                <th scope="col">name</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="producer" items="${producers}">
                <tr>
                    <td><c:out value = "${producer.id}"/></td>
                    <td><c:out value = "${producer.name}"/></td>
                    <td>
                        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                            <div class="btn-group me-2" role="group" aria-label="Second group">
                                <a href="/producer/<c:out value = '${producer.id}'/>" type="button" class="btn btn-warning">📝</a>
                                <a href="/producer?delete=<c:out value = '${producer.id}'/>" type="button" class="btn btn-danger">🗑</a>
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2" role="group" aria-label="Second group">
                <a href="/producer/new" type="button" class="btn btn-primary">+</a>
            </div>
        </div>
    </div>

</div>

</body>
</html>
