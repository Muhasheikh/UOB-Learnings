<%--
  Created by IntelliJ IDEA.
  User: muhassan.c.faizal
  Date: 5/15/2025
  Time: 12:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${message}</title>
</head>
<body>
<p>User Name : ${userDetailDTO.firstName}</p>
<p>Country : ${userDetailDTO.country}</p>
<p>Hobbies : ${userDetailDTO.hobby}</p>
<p>Mobile : ${userDetailDTO.communication.mobileNumber}</p>
</body>
</html>
