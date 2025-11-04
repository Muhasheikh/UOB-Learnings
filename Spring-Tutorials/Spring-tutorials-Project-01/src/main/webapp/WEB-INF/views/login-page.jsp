<%--
  Created by IntelliJ IDEA.
  User: muhassan.c.faizal
  Date: 5/24/2025
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login Page</title>
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
<h2>Login Page : Enter User Information</h2>
<div >
    <form:form method="POST" action="process-login"  modelAttribute="loginDetails" onsubmit="return validateLogin()">
        <label for="username">UserName</label>
        <form:input path="userName" id="username"/>
        <form:errors path="userName" cssClass="errors"/>
        <br/>
        <label for="password">Password</label>
        <form:input path="password" id="password"/>
        <form:errors path="password" cssClass="errors"/>
        <button type="submit">Login</button>
    </form:form>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>

</html>
