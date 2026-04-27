<!DOCTYPE html>
<html>
<head>
    <title>Update Patient</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>

<div class="form-box">

<h2>Update Patient</h2>

<!-- ✅ SHOW ERROR MESSAGE -->
<%
String error = (String) request.getAttribute("error");
if(error != null){
%>
<p style="color:red; font-weight:bold; background:#ffe6e6; padding:8px; border-radius:5px;">
    <%= error %>
</p>
<%
}
%>

<form action="UpdatePatientServlet" method="post">

ID: <input type="number" name="id" min="1" required>

Name: <input type="text" name="name" 
       pattern="[A-Za-z. ]+" 
       title="Only letters allowed" 
       required>

Age: <input type="number" name="age" min="1" required>

Gender: 
<select name="gender" required>
    <option value="">Select</option>
    <option>Male</option>
    <option>Female</option>
</select>

Date: <input type="date" name="date" required>

Ailment: <input type="text" name="ailment" required>

Doctor: <input type="text" name="doctor" 
        pattern="[A-Za-z. ]+" 
        title="Only letters allowed"
        required>

<input type="submit" value="Update Patient">

</form>

<a class="back" href="index.jsp"> Back to Home</a>

</div>

</body>
</html>