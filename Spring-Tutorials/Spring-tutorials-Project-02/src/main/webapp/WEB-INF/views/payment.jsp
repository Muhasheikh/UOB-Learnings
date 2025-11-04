<%--
  Created by IntelliJ IDEA.
  User: muhassan.c.faizal
  Date: 5/19/2025
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Payment Page</title>
</head>
<body>

<form:form action="process-payment" method="get" modelAttribute="paymentInfo">
    <label for="creditCard">Credit Card</label>
    <form:input path="creditCardNumber" id="creditCard"/>
    <form:errors path="creditCardNumber.firstFourDigits"/>
    <form:errors path="creditCardNumber.secondFourDigits"/>
    <form:errors path="creditCardNumber.thirdFourDigits"/>
    <form:errors path="creditCardNumber.lastFourDigits"/>
    <br/>

    <label for="amount">Amount</label>
    <form:input path="amount" id="amount"/>
    <form:errors path="amount"/>
    <br/>

    <label for="currency">Currency</label>
    <form:input path="currency" id="currency"/>
    <form:errors path="currency"/>
    <br/>

    <label for="Date">Date</label>
    <form:input path="date" id="date"/>
    <form:errors path="date"/>
    <br/>

    <button type="submit"> Pay </button>
</form:form>
</body>
</html>
