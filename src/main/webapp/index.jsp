<html>
<head>
<script>
function validateForm() {
    var name = document.forms["f"]["name"].value;
    if (name == "") {
        alert("Name must be filled");
        return false;
    }
    return true;
}
</script>
</head>

<body>

<h2>Student Form</h2>

<form name="f" action="result" method="post" onsubmit="return validateForm()">

Roll No: <input type="text" name="rollno"><br><br>
Name: <input type="text" name="name"><br><br>

Sub1: <input type="number" name="sub1"><br>
Sub2: <input type="number" name="sub2"><br>
Sub3: <input type="number" name="sub3"><br>
Sub4: <input type="number" name="sub4"><br>
Sub5: <input type="number" name="sub5"><br><br>

<input type="submit" value="Submit">

</form>

</body>
</html>