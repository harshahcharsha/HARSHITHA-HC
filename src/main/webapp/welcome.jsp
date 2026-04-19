<%@ page session="true" %>

<%
    // Get name from form
    String name = request.getParameter("username");

    // Create session and store name
    session.setAttribute("user", name);

    // Set session timeout to 1 minute (60 seconds)
    session.setMaxInactiveInterval(60);
%>

<html>
<head>
    <title>Welcome</title>
</head>
<body>

    <h2>Hello <%= name %>!</h2>
    <p>Your session will expire in 1 minute.</p>

    <a href="check.jsp">Check Session Status</a>

</body>
</html>>