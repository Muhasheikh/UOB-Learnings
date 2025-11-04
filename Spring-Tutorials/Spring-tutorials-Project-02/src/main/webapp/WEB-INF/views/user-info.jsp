<%--
  Created by IntelliJ IDEA.
  User: muhassan.c.faizal
  Date: 5/23/2025
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
<form:form method="get" action="show-user-details" modelAttribute="userDetailDTO">
    <label for="firstName">First Name</label>
    <form:input path="firstName" id="firstName"/>
    <form:button>Submit</form:button>
</form:form>
</body>
</html>
