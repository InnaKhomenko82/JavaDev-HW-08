<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
    <%@ include file="../headers.jsp" %>
</head>
<body>
<%@ include file="../navigation.jsp" %>
<div class="container">
    <div class="row">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2" role="group" aria-label="Second group">
                <a href="/product" type="button" class="btn btn-success">All products</a>
            </div>
        </div>
    </div><div class="row"><p> </p></div>
    <form:form id="form">
        <div class="row">
            <div class="mb-3">
                <label for="id" class="form-label">id</label>
                <input type="text" class="form-control" disabled name="id" id="id" placeholder="${product.id}" value="${product.id}">
            </div>
            <div class="mb-3">
                <label for="name" class="form-label">name</label>
                <input type="text" class="form-control" name="name" id="name" placeholder="${product.name}" value="${product.name}">
            </div>
            <div class="mb-3">
                <label for="price" class="form-label">price</label>
                <input type="text" class="form-control" name="price" id="price" placeholder="${product.price}" value="${product.price}">
            </div>
            <div class="mb-3">
                <label for="producer" class="form-label">producer</label><select class="form-select"
                        aria-label="Default select example"
                        id="producer" name="producer">
                    <option selected disabled>${product.producer.name}</option>
                    <c:forEach var="element" items="${listProducer}">
                        <c:choose>
                            <c:when test="${element.id == product.producer.id}">
                                <option selected value='${element.id}'>${element.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value='${element.id}'>${element.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>

            </div>
        </div>
        <button onclick="save()" type="submit" class="btn btn-primary">Save</button>
    </form:form>
</div>
</body>
</html>