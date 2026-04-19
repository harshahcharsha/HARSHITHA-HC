<%@ page session="true" %>

<html>
<head>
    <title>Session Check</title>
</head>
<body>

<%
    String name = (String) session.getAttribute("user");

    if (name != null) {
%>
        <h2>Hello <%= name %>! Your session is still active.</h2>
<%
    } else {
%>
        <h2>Session expired! Please login again.</h2>
        <a href="index.jsp">Go Back</a>
<%
    }
%>

</body>
</html>