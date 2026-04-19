<%@ page import="javax.servlet.http.Cookie" %>

<html>
<head>
    <title>Active Cookies</title>
</head>
<body>

<h2>Active Cookie List</h2>

<%
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie c : cookies) {
%>
            <p>
                <b>Name:</b> <%= c.getName() %> |
                <b>Value:</b> <%= c.getValue() %>
            </p>
<%
        }
    } else {
%>
        <p>No cookies found</p>
<%
    }
%>

<br>
<a href="index.jsp">Back</a>

</body>
</html>