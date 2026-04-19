<%@ page language="java" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>

<%
String name = request.getParameter("username");
String timeStr = request.getParameter("time");

int time = Integer.parseInt(timeStr);

// Create session
session.setAttribute("user", name);

// Set session expiry time
session.setMaxInactiveInterval(time);
%>

<h2 style="color:blue;">
    Hello <%= name %>!
</h2>

<h3 style="color:green;">
    Session will expire in <%= time %> seconds.
</h3>

<br>

<a href="check.jsp">Click here to check session</a>

</body>
</html>