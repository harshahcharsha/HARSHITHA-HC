<%@ page import="java.sql.*" %>

<%
try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3307/Employee?useSSL=false&serverTimezone=UTC",
        "root",
        ""
    );

    PreparedStatement ps = con.prepareStatement(
        "DELETE FROM Emp WHERE Emp_Name LIKE 'S%'"
    );

    int rows = ps.executeUpdate();

    ps.close();
    con.close();

    // Redirect to report after delete
    response.sendRedirect("report.jsp");

} catch(Exception e) {
    out.println(e);
}
%>