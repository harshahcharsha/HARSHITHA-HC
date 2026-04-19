<%-- Display submitted data --%>

<html>
<body>

<h2>Submitted Details</h2>

<p>Username: <%= request.getAttribute("username") %></p>
<p>Email: <%= request.getAttribute("email") %></p>
<p>Designation: <%= request.getAttribute("designation") %></p>

<br>
<a href="index.jsp">Go Back to Form</a>

</body>
</html>