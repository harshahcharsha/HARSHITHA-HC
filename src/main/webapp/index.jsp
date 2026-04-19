<%-- 
Question:
Build a Session Management using JSP program set with one minute session expiry time 
to get your name through text box and press submit to display the message by greeting 
Hello your name!. Check the expiry of the session after one minute.
--%>

<html>
<head>
    <title>Enter Name</title>
</head>
<body>
    <h2>Enter Your Name</h2>

    <form action="welcome.jsp" method="post">
        Name: <input type="text" name="username" required />
        <input type="submit" value="Submit" />
    </form>

</body>
</html>