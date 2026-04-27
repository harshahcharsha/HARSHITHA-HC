<!DOCTYPE html>
<html>
<head>
    <title>Delete Patient</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>

<div class="form-box">

<h2>Delete Patient</h2>

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

<form action="DeletePatientServlet" method="post">

Enter ID: 
<input type="number" name="id" min="1" required>

<input type="submit" value="Delete Patient">

</form>

<a class="back" href="index.jsp">⬅ Back to Home</a>

</div>

</body>
</html>