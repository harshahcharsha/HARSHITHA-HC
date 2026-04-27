<!DOCTYPE html>
<html>
<head>
<title>Report by Ailment</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<div class="form-box">
<h2>Patients by Ailment</h2>

<form action="ReportServlet" method="get">
Enter Ailment:
<input type="text" name="ailment" required>

<input type="submit" value="Search">
</form>

<a class="back" href="reports.jsp">Back</a>
</div>

</body>
</html>