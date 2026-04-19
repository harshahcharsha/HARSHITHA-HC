package com.mysql;
/*  Read all the existing records from the table coffee which is from the database test and query coffee name starting with ‘D’   in the table.

*/
import java.sql.*;
import java.util.Properties;

public class Mysql_Query {

    public static void main(String[] args) {

        Connection dbConnection = null;

        try {

            // ✅ LOAD DRIVER
            Class.forName("com.mysql.cj.jdbc.Driver");

            // ✅ CORRECT URL (PORT 3307)
            String url = "jdbc:mysql://localhost:3307/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "");

            // ✅ CONNECT
            dbConnection = DriverManager.getConnection(url, info);

            System.out.println("Successfully connected to MySQL database test");

            // ✅ CORRECT QUERY (ONE LINE)
            String query = "SELECT * FROM coffee WHERE coffee_name LIKE 'D%'";

            // ✅ CREATE STATEMENT
            Statement st = dbConnection.createStatement();

            // ✅ EXECUTE QUERY
            ResultSet rs = st.executeQuery(query);

            // ✅ DISPLAY DATA
            while (rs.next()) {
                int id = rs.getInt("id");
                String coffee_name = rs.getString("coffee_name");
                int price = rs.getInt("price");

                System.out.println(id + "  " + coffee_name + "  " + price);
            }

            // ✅ CLOSE
            rs.close();
            st.close();
            dbConnection.close();

        } catch (Exception e) {
            System.out.println("❌ ERROR:");
            e.printStackTrace();
        }
    }
}
