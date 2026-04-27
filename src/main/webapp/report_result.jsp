<!DOCTYPE html>
<html>
<head>
    <title>Report Result</title>

    <!-- ✅ CSS LINK -->
    <link rel="stylesheet" href="style.css">
</head>

<body>

<%@ page import="java.util.*,com.model.Patient" %>

<h2>Report Result</h2>

<table>
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Doctor</th>
</tr>

<%
List<Patient> list = (List<Patient>) request.getAttribute("data");

if(list != null && !list.isEmpty()){
    for(Patient p : list){
%>

<tr>
    <td><%=p.getPatientId()%></td>
    <td><%=p.getPatientName()%></td>
    <td><%=p.getAssignedDoctor()%></td>
</tr>

<%
    }
} else {
%>

<tr>
    <td colspan="3">No Data Found</td>
</tr>

<% } %>

</table>

<br>
<a class="back" href="index.jsp"> Back to Home</a>

</body>
</html>