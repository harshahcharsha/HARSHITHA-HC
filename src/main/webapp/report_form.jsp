<!DOCTYPE html>
<html>
<head>
    <title>Search Patients</title>

    <!-- ✅ CSS LINK -->
    <link rel="stylesheet" href="style.css">
</head>

<body>

<div class="form-box">

<h2>Search Patients by Doctor</h2>

<form action="ReportServlet" method="get">

Enter Doctor Name:
<input type="text" name="doctor" 
       pattern="[A-Za-z. ]+" 
       title="Only letters, dot and spaces allowed" 
       required>

<input type="submit" value="Search">

</form>

<a class="back" href="index.jsp"> Back to Home</a>

</div>

</body>
</html>