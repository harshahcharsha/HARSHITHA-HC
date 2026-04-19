<html>
<body>

<h2>Student Result</h2>

<p>Roll No: <%= request.getAttribute("roll") %></p>
<p>Name: <%= request.getAttribute("name") %></p>

<p>Sub1: <%= request.getAttribute("s1") %></p>
<p>Sub2: <%= request.getAttribute("s2") %></p>
<p>Sub3: <%= request.getAttribute("s3") %></p>
<p>Sub4: <%= request.getAttribute("s4") %></p>
<p>Sub5: <%= request.getAttribute("s5") %></p>

<p><b>Average: <%= request.getAttribute("avg") %></b></p>
<p><b>Result: <%= request.getAttribute("result") %></b></p>

<br>
<a href="index.jsp">Go Back</a>

</body>
</html>