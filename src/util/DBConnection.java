
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class DBConnection {
   private static Connection c;

    public static Connection getConnection() throws Exception {
        if (c == null || c.isClosed()) {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment-ad-db?autoReconnect=true","root", "931012410vBn");
            System.out.println("Sucssefully connected with DB");
        }
        return c;
    }

    public static synchronized void update(String sql) throws Exception {
        getConnection().createStatement().executeUpdate(sql);

    }

    public static synchronized ResultSet query(String sql) throws Exception {
        return getConnection().createStatement().executeQuery(sql);
    }   
}
