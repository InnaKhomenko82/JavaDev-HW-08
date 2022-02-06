<%@ page import="ua.goit.models.Producer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Producer</title>
    <%@ include file="../headers.jsp" %>
</head>
<body>
<%@ include file="../navigation.jsp" %>

<%ua.goit.models.Producer producer = (Producer) request.getAttribute("producer"); %>

<div class="container">
    <div class="row">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2" role="group" aria-label="Second group">
                <a href="/producer" type="button" class="btn btn-success">All producers</a>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="mb-3">
            <label for="id" class="form-label">id</label>
            <input type="text" disabled class="form-control"
                   value="${producer.id}"
                   id="id" placeholder="id">
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">name</label>
            <input type="text" class="form-control"
                   value="${producer.name}"
                   id="name" placeholder="name">
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

    function save() {
        let body = {
            <% if(producer.getId() != null) {%>
            id: id.value, <% } %>
            name: name.value,
        }
        <% if(producer.getId() == null) {%>
        let url = '/producer';
        let method = 'POST';
        <% } else { %>
        let url = '/producer/<%= producer.getId() %>';
        let method = 'PUT';
        <% } %>
        fetch(url, {
            method: method,
            body: JSON.stringify(body)
        })
            .then( _ => {
                    window.location.href = '/producer';
                }
            );
    }
</script>
</body>
</html>
