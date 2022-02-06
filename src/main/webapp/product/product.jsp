<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ua.goit.models.Product" %>
<%@ page import="ua.goit.models.Producer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
    <%@ include file="../headers.jsp" %>
</head>
<body>
<%@ include file="../navigation.jsp" %>

<%ua.goit.models.Product product = (Product) request.getAttribute("product"); %>
<% List<Producer> listProducer = (List<Producer>) request.getAttribute("listProducer"); %>


<div class="container">
    <div class="row">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2" role="group" aria-label="Second group">
                <a href="/product" type="button" class="btn btn-success">All products</a>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="mb-3">
            <label for="id" class="form-label">id</label>
            <input type="text" disabled class="form-control"
                   value="${product.id}"
                   id="id" placeholder="id">
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">name</label>
            <input type="text" class="form-control"
                   value="${product.name}"
                   id="name" placeholder="name">
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">price</label>
            <input type="text" class="form-control"
                   value="${product.price}"
                   id="price" placeholder="price">
        </div>
        <div class="mb-3">
            <label for="producer" class="form-label">producer</label>
            <select class="form-select"
                    aria-label="Default select example"
                    value="${product.producer}"
                    id="producer">
                <option selected disabled>${product.producer.name}</option>
                <c:forEach var="element" items="${listProducer}">
                    <c:choose>
                        <c:when test="${element.id == product.producer.id}">
                            <option selected value='${element}'>${element.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value='${element.id}'>${element.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
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
    let name = document.getElementById('name');
    let price = document.getElementById('price');
    let producer = document.getElementById('producer');

    function save() {
        let body = {
            <% if(product.getId() != null) {%>
            id: id.value, <% } %>
            name: name.value,
        }
        <% if(product.getId() == null) {%>
        let url = '/product';
        let method = 'POST';
        <% } else { %>
        let url = '/product/<%= product.getId() %>';
        let method = 'PUT';
        <% } %>
        fetch(url, {
            method: method,
            body: JSON.stringify(body)
        })
            .then( _ => {
                    window.location.href = '/product';
                }
            );
    }
</script>
</body>
</html>
