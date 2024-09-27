package Connection;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection getConnection() {
        Connection con = null;
        try {

            DriverManager.registerDriver(new Driver());
            String url = "jdbc:mySQl://localhost:3306/jdbcbtvn";
            String username = "root";
            String password = "123456";
            con = DriverManager.getConnection(url, username, password);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    public static void close(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
