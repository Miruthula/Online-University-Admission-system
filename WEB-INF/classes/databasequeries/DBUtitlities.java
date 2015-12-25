package databasequeries;

import java.sql.*;

public class DBUtitlities {

    public static Connection getConnection() throws Exception {
        String dburl = "jdbc:mysql://127.2.2.130:3306/UMC_db";
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(dburl, "root", "sesame");

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return con;
    }

    public static void clean(Connection con, Statement st) {
        try {
            st.close();
            con.close();
        } catch (Exception ex) {
        }
    }

}
