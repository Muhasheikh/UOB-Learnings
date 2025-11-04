<%--
  Created by IntelliJ IDEA.
  User: muhassan.c.faizal
  Date: 5/27/2025
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <script src="../../resources/js/validate.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        body{
            align-items: center;
        }

        .errors{
            color: red;
        }

        form{
            align-items: center;
        }
    </style>
</head>
<body>
<div  style="text-align: center">
    <h3>Sign Up Information</h3>
    <c:if test="${not empty errorMessage}">
        <div style="color:red">${errorMessage}</div>
        <h1>aa</h1>
    </c:if>
    <form:form action="process-register" method="POST" modelAttribute="registerDTO">
        <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <form:input path="userName" cssClass="form-control-sm" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter username"/>
            <form:errors path="userName" cssClass="errors"/>

        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <form:input path="password" type="password" cssClass="form-control-sm" id="exampleInputPassword1" placeholder="Password"/>
            <form:errors path="password" cssClass="errors"/>

        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>
</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
