<%--
  Created by IntelliJ IDEA.
  User: muhassan.c.faizal
  Date: 5/23/2025
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>User Details</title>
</head>
<body style="align-items: center">

<h2>User Information</h2>
    <p> First Name : ${userDetailDTO.firstName}</p>
</body>
</html>
