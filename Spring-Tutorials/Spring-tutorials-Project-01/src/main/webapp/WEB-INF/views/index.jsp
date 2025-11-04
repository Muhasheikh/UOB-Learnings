
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>

    <script>
        function redirectPayment(){

            var url = window.location.href;
            return url + 'payment';
        }
    </script>
</head>
<body >
<h2>Welcome ${user.userName}</h2>

<sec:authorize access="hasRole('ROLE_USER')">
    <div style="align-items: center">
        <input type="button" value="Sign Up" onclick="window.location.href =window.location.href+'register'" >
        <input type="button" value="Login" onclick="window.location.href =window.location.href+'login'" >
    </div>
</sec:authorize>


</body>
</html>
