<%--
  Created by IntelliJ IDEA.
  User: muhassan.c.faizal
  Date: 5/15/2025
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Hello World</title>
    <script>
        function validateUserDetails(){
            var userName = document.getElementById("firstName").value;
            var password = document.getElementById("password").value;
            var isChecked = document.getElementById("checkboxAgree").checked;
            if(userName.length < 5 && password.length < 5){
                alert("user name cannot be less than 5 characters");
                return false;

            }else if(!isChecked){
                alert("You have to accept the terms and conditions")
                return false
            }
            else{
                console.log("true")
                return true;
            }



        }
    </script>

    <style>
        .errors{
            color:red;
        }

        .checkBoxAgree{

            margin: 10px;
        }
    </style>
</head>
<body>

<div style="align-items: center">

<form:form action="process" method="get" modelAttribute="userDetailDTO" onsubmit="return validateUserDetails()" >
    <label for="firstName">First Name</label>
    <form:input type="text" path="firstName" id="firstName"/>
    <br/>
    <form:errors cssClass="errors" path="firstName"/>
    <br/>
    <label for="lastName">Last Name</label>
    <form:input type="text" path="lastName" id="lastName"/>
    <form:errors path="lastName" cssClass="errors"/>
    <br>
    <label for="age">Age</label>
    <form:input path="age" id="age"/>
    <form:errors path="age" cssClass="errors"/>
    <br/>
    <label for="password">Password</label>
    <form:password  path="password" id="password"/>
    <br/>
    <label for="country">Country</label>
    <form:select path="country" id="country">
        <form:option placeholder="select a country" value=""/>
        <form:options items="${countryList}"/>
    </form:select>
    <form:errors path="country" cssClass="errors"/>
    <br/>
    <form:checkboxes items="${hobbies}" path="hobby"/>
    <br/>
    <h4>Communication</h4>
    <form:errors cssClass="errors" path="communication.email"/>
    <label for="email">email</label>
    <form:input path="communication.email" id="email" />
    <label for="phone">Mobile number</label>
    <form:input path="communication.mobileNumber" id="phone" />
    <form:errors cssClass="errors" path="communication.mobileNumber.number"/>
    <br/>
    <form:errors cssClass="errors" path="isAgree"/>
    <br/>
    <form:checkbox path="isAgree"  id="checkboxAgree" label="I accept the terms and conditions" cssClass="checkBoxAgree"/>
    <br/>
    <button type="submit">Submit</button>
</form:form>
</div>

</body>
</html>
