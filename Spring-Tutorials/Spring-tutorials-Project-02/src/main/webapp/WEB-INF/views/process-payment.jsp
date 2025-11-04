<%--
  Created by IntelliJ IDEA.
  User: muhassan.c.faizal
  Date: 5/20/2025
  Time: 10:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment Status</title>
</head>
<body>
<h3>Payment success</h3>
<h4>Amount paid in ${paymentInfo.currency} : ${paymentInfo.amount}</h4>
<h4>Credit Card Number : ${paymentInfo.creditCardNumber}</h4>
<h4>Date : ${paymentInfo.date}</h4>
</body>
</html>
