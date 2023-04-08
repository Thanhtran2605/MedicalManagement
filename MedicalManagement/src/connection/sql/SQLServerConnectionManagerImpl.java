package connection.sql;

import connection.ConnectionManager;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerConnectionManagerImpl extends ConnectionManager {
    @Override
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QuanLyBenhAn;user=sa;password=thithanh2605");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SQL Server connection failed");
            e.printStackTrace();
            return null;
        }
    }
}
