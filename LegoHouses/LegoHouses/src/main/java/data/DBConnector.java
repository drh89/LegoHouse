/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Dennis
 */
public class DBConnector {
    
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://142.93.160.41:3306/LegoHouses";
    private static String user = "Dennis";
    private static String password = "Dennis123";

    private static PreparedStatement stmt;
    private static Connection conn = null;

    /**
     *
     * @return
     */
    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException | SQLException ex) {
            }
        }

        return conn;
    }

    /**
     *
     * @param SQLString
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static PreparedStatement preparedStatement(String SQLString) throws ClassNotFoundException, SQLException {
        stmt = DBConnector.getConnection().prepareStatement(SQLString, 0);
        return stmt;
    }

    /**
     *
     * @param SQLString
     * @param i
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static PreparedStatement prepareKeys(String SQLString, int i) throws ClassNotFoundException, SQLException {
        stmt = DBConnector.getConnection().prepareStatement(SQLString, 1);
        return stmt;
    }
    
}
