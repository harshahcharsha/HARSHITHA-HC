<%@ page import="java.util.*" %>

<%
    // Set session expiry to 60 seconds
    session.setMaxInactiveInterval(60);

    String name = request.getParameter("username");

    // If session already has name, use it
    if (name == null || name.equals("")) {
        name = (String) session.getAttribute("username");
    } else {
        session.setAttribute("username", name);
    }
%>

<html>
<body>

<%
    if (name != null) {
%>
        <h2>Hello <%= name %>!</h2>
        <p>Session will expire in 60 seconds of inactivity.</p>
<%
    } else {
%>
        <h3>Session expired! Please enter your name again.</h3>
        <a href="index.jsp">Go Back</a>
<%
    }
%>

</body>
</html>