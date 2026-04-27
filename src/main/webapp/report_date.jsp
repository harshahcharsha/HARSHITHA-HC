<!DOCTYPE html>
<html>
<head>
    <title>Patients by Date</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>

<div class="form-box">

<h2>Patients by Date Range</h2>

<form action="ReportServlet" method="get">

<label>From Date:</label><br>
<input type="date" name="from" required><br><br>

<label>To Date:</label><br>
<input type="date" name="to" required><br><br>

<input type="submit" value="Search">

</form>

<br>
<a class="back" href="reports.jsp"> Back</a>

</div>

</body>
</html>