<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
<h1>Enter Todo</h1>
<div class="container">
    <%--@elvariable id="todo" type=""--%>
    <form:form method="post" modelAttribute="todo">
        <fieldset class="mb-3">
        Title:<input type="text" path="title"  name="title" required="required"/>
        <form:errors path="title" cssClass="text-danger"/>
            Description:<input type="text" name="description"/>
        </fieldset>
        <fieldset class="mb-3">
            Due Date:<input type="date" path="dueDate"  name="dueDate" required="required"/>
            <form:errors path="title" cssClass="text-danger"/>
        </fieldset>
        <form:input type="hidden" path="id"/>
        <form:input type="hidden" path="completed"/>
        <input type="submit" class="btn btn-danger"/>
    </form:form>

</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>