<%@ page import="javax.servlet.http.Cookie" %>

<%
    String name = request.getParameter("name");
    String domain = request.getParameter("domain");
    int age = Integer.parseInt(request.getParameter("age"));

    // Create cookie
    Cookie cookie = new Cookie(name, domain);

    // Set max age
    cookie.setMaxAge(age);

    // Add cookie to response
    response.addCookie(cookie);
%>

<html>
<head>
    <title>Cookie Added</title>
</head>
<body>

<h2>Cookie Added Successfully!</h2>

<p><b>Name:</b> <%= name %></p>
<p><b>Domain:</b> <%= domain %></p>
<p><b>Max Age:</b> <%= age %> seconds</p>

<br>
<a href="showCookies.jsp">Go to Active Cookie List</a>

</body>
</html>