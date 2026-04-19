<%@ page import="java.sql.*" %>

<html>
<body>

<%
    int empno = Integer.parseInt(request.getParameter("Emp_NO"));
    String empname = request.getParameter("Emp_Name");
    double salary = Double.parseDouble(request.getParameter("Basicsalary"));

    Connection con = null;
    PreparedStatement ps = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/Employee",
            "root",
            "root"
        );

        String query = "UPDATE Emp SET Emp_Name=?, Basicsalary=? WHERE Emp_NO=?";
        ps = con.prepareStatement(query);

        ps.setString(1, empname);
        ps.setDouble(2, salary);
        ps.setInt(3, empno);

        int i = ps.executeUpdate();

        if (i > 0) {
%>
            <h3>Record Updated Successfully!</h3>
<%
        } else {
%>
            <h3>Employee Not Found!</h3>
<%
        }

    } catch (Exception e) {
        out.println(e);
    } finally {
        if (ps != null) ps.close();
        if (con != null) con.close();
    }
%>

<br><br>
<a href="report.jsp">View Salary Report</a><br>
<a href="index.jsp">Back</a>

</body>
</html>