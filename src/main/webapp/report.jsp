<%@ page import="java.sql.*" %>

<html>
<body>

<pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                        Salary Report
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre>

<%
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    double grandTotal = 0;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/Employee",
            "root",
            "root"
        );

        st = con.createStatement();
        rs = st.executeQuery("SELECT * FROM Emp");

        while (rs.next()) {

            int empno = rs.getInt("Emp_NO");
            String name = rs.getString("Emp_Name");
            double salary = rs.getDouble("Basicsalary");

            grandTotal += salary;
%>

<pre>
Emp_No     : <%= empno %>
Emp_Name   : <%= name %>
Basic      : <%= salary %>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre>

<%
        }
%>

<pre>
Grand Salary : <%= grandTotal %>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre>

<%
    } catch (Exception e) {
        out.println(e);
    } finally {
        if (rs != null) rs.close();
        if (st != null) st.close();
        if (con != null) con.close();
    }
%>

<br>
<a href="index.jsp">Back</a>

</body>
</html>l>