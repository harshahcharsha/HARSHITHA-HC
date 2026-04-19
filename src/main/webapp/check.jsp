<%@ page language="java" %>
<html>
<head>
    <title>Check Session</title>
</head>
<body>

<%
String user = (String) session.getAttribute("user");

if (user != null) {
%>

<h2 style="color:blue;">
    Hello again <%= user %>!
</h2>

<h3 style="color:green;">
    Session is still active.
</h3>

<%
} else {
%>

<h2 style="color:red;">
    Session expired! Please login again.
</h2>

<a href="index.jsp">Go back</a>

<%
}
%>

</body>
</html>