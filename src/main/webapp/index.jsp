<%-- 
Question:
Build an Application to get Username, Email and Designation through JSP 
with client-side validation and submit to servlet.
--%>

<html>
<head>
<script>
function validateForm() {
    var name = document.forms["myForm"]["username"].value;
    var email = document.forms["myForm"]["email"].value;
    var desig = document.forms["myForm"]["designation"].value;

    if (name == "" || email == "" || desig == "") {
        alert("All fields must be filled out");
        return false;
    }

    var emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
    if (!email.match(emailPattern)) {
        alert("Enter valid email");
        return false;
    }

    return true;
}
</script>
</head>

<body>

<h2>User Form</h2>

<form name="myForm" action="user" method="post" onsubmit="return validateForm()">
    Username: <input type="text" name="username"><br><br>
    Email: <input type="text" name="email"><br><br>
    Designation: <input type="text" name="designation"><br><br>

    <input type="submit" value="Submit">
</form>

</body>
</html>