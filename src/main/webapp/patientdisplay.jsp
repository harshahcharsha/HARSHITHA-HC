<%@ page import="java.util.*,com.model.Patient" %>

<!DOCTYPE html>
<html>
<head>
    <title>Patient List</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>

<div class="form-box">

<h2>Patient List</h2>

<%
String msg = (String) request.getAttribute("msg");
if(msg != null){
%>
<p style="color: green; font-weight: bold;"><%= msg %></p>
<%
}
%>

<%
List<Patient> list = (List<Patient>) request.getAttribute("data");

if(list != null && !list.isEmpty()){
%>

<table border="1" cellpadding="10" cellspacing="0" width="100%">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
    <th>Gender</th>
    <th>Date</th>
    <th>Ailment</th>
    <th>Doctor</th>
</tr>

<%
for(Patient p : list){
%>

<tr>
    <td><%=p.getPatientId()%></td>
    <td><%=p.getPatientName()%></td>
    <td><%=p.getAge()%></td>
    <td><%=p.getGender()%></td>
    <td><%=p.getAdmissionDate()%></td>
    <td><%=p.getAilment()%></td>
    <td><%=p.getAssignedDoctor()%></td>
</tr>

<%
}
%>

</table>

<%
} else {
%>

<p>No Data Found</p>

<%
}
%>

<br><br>

<a class="back" href="index.jsp"> Back to Home</a>

</div>

</body>
</html>