<html>
<head>

    <script>
        function redirectPayment(){

            var url = window.location.href;
            return url + 'payment';
        }
    </script>
</head>
<body>
<h2>Please select the below</h2>


<input type="button" value="Register" onclick="window.location.href =window.location.href+'hello-world'" >
<input type="button" value="Register-Session" onclick="window.location.href =window.location.href+'user-info'" >
<input type="button" value="Payment" onclick="window.location.href=redirectPayment()" >
</body>
</html>
