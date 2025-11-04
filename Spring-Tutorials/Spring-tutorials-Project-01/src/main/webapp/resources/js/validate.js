function validateLogin()
{
    console.log("Validationg")
    var username = document.getElementById("username").value
    var password = document.getElementById("pasword").value

    if(username.length<=3  && password.length<=3){
        return false;
    }

    return true;
}