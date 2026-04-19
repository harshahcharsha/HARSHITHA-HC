<%@ page import="java.sql.*" %>

<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>

<!DOCTYPE html>
<html>
<body>

<pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Salary Report
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre>

<%
try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3307/Employee?useSSL=false&serverTimezone=UTC",
        "root",
        ""
    );

    Statement st = con.createStatement();

    ResultSet rs = st.executeQuery("SELECT * FROM Emp");

    while(rs.next()) {
%>

<pre>
Emp_No     : <%= rs.getInt("Emp_NO") %>
Emp_Name   : <%= rs.getString("Emp_Name") %>
Basic      : <%= rs.getInt("Basicsalary") %>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre>

<%
    }

    rs.close();
    st.close();
    con.close();

} catch(Exception e) {
    out.println(e);
}
%>

<br>
<a href="index.jsp">Back</a>

</body>
</html>