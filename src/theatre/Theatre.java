/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theatre;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pierrick_2
 */
public class Theatre {

    final static String jdbcDriverName = "com.mysql.jdbc.Driver";
    final static String urlDB = "jdbc:mysql://localhost/theatre";
// ouverture d’une nouvelle connexion à la BD

    private static void loadDriver() throws ClassNotFoundException {
        try {
            Class.forName(jdbcDriverName).newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(Theatre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Theatre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Connection newConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(
                urlDB, "root", "");
        return conn;
    }

    public static void listPersons(Connection conn) throws SQLException {
        Statement st = null;
        try {
// create new statement
            st = conn.createStatement();
            String query = "SELECT * FROM achat";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println("lol : " + rs.getString(1) + rs.getString(2) + rs.getString(3));
            }
        } finally {
// close statement and connection
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            // chargement du pilote
            loadDriver();
// ouverture de connexion
            Connection conn = newConnection();
// exécution d'une requête
            listPersons(conn);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Theatre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException se) {
            Logger.getLogger(Theatre.class.getName()).log(Level.SEVERE, null, se);
        }

    }

}
