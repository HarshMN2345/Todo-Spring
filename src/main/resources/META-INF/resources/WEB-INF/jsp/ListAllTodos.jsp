<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
<%--<nav class="navbar navbar-expand-md navbar-light mb-3 p-1">--%>
<%--    <a class="navbar-brand m-1" href="https://www.linkedin.com/in/mahajan-harsh/">Harsh Mahajan</a>--%>
<%--    <div class="collapse navbar-collapse">--%>
<%--        <ul class="navbar-nav">--%>
<%--            <li class="nav-item"><a class="nav-link" href="/list-todos">Home</a></li>--%>
<%--            <li class="nav-item"><a class="nav-link" href="/add-todo">Add a Todo</a></li>--%>
<%--        </ul>--%>
<%--    </div>--%>
<%--    <ul class="navbar-nav">--%>
<%--        <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>--%>
<%--    </ul>--%>
<%--</nav>--%>
<%@ include file="common/navbar.jspf"%>
<h2>Welcome to todo list ${name}</h2>
<h2>Your  Todos are </h2>
<div class="container">
    <table class="table">
        <thead>
        <th>title</th>
        <th>description</th>
        <th>due date</th>
        <th>Completed</th>
        <th></th>
        <th></th>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
           <tr>
               <td>${todo.title}</td>
               <td>${todo.description}</td>
               <td>${todo.dueDate}</td>
               <td>${todo.completed}</td>
               <td><a href="delete-todo?id=${todo.id}" class="btn btn-outline-danger">Delete</a></td>
               <td><a href="update-todo?id=${todo.id}" class="btn btn-outline-warning">Update</a></td>

           </tr>
        </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-danger" href="add-todo">
        Add Todo
    </a>
</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>