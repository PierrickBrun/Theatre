/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theatre;

/**
 *
 * @author triton
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * To change this license header, choose License Headers in
 Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * *
 * @author catherineberrut
 */
public class requetesbd {

    /**
     * Afficher toutes les informations sur tous les spectacles.
     *     
* @param conn connexion � la base de donn�es
     * @throws SQLException en cas d'erreur d'acc�s � la base de donn�es
     */
    public static void nbartistes(Connection conn) throws SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT count(*)FROM Artiste");
        while (rs.next()) {
            System.out.println("Nombre d'artistes : "
                    + rs.getInt(1));

        }
// Close the result set, statement and the connection

        rs.close();
        stmt.close();
    }

    public static void artistes(Connection conn) throws SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT * FROM Artiste");
        while (rs.next()) {
            System.out.print("idartiste : "
                    + rs.getInt(1) + " ");
            System.out.print("nom : " + rs.getString(2) + " ");
            System.out.println("categ : " + rs.getString(3));

        }
        rs.close();
        stmt.close();

    }

    public static void artistes_preferes(Connection conn) throws SQLException {

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT id FROM Preferences"
                + "WHERE typeid='artiste' AND NiveauP=1");
        while (rs.next()) {
            System.out.println("id : " + rs.getInt(1));
        }
        rs.close();
        stmt.close();
    }

    public static void CD(Connection conn) throws SQLException {

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM CD");
        while (rs.next()) {
            System.out.print("idcd: " + rs.getInt(1) + " ");
            System.out.print("id artiste : " + rs.getInt(2) + " ");
            System.out.print("Titre : " + rs.getString(3) + " ");
            System.out.println("Date : " + rs.getString(4) + " ");
        }
        rs.close();
        stmt.close();
    }

    public static void spectacles(Connection conn) throws SQLException {

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM LesSpectacles");
        while (rs.next()) {
            System.out.print("Nums: " + rs.getInt(1) + " ");
            System.out.println("Noms : " + rs.getString(2));
        }
        rs.close();
        stmt.close();
    }

    public static void representations(Connection conn) throws SQLException {

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM LesRepresentations");
        while (rs.next()) {
            System.out.print("Nums: " + rs.getInt(1) + " ");
            System.out.println("Dates : " + rs.getString(2));
        }
        rs.close();
        stmt.close();
    }
    
    public static boolean spectacle_et_nom(Connection conn, boolean aff, int num) throws SQLException {
        boolean found = false;
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT noms FROM LesSpectacles where nums = " + num);

        if (!rs.next()) {
            if (aff) {
                System.out.println("Pas de spectacle de numero :" + num);
            }

        } else {
            if (aff) {
                System.out.println("Noms : " + rs.getString(1));
            }
            found = true;
        }

        rs.close();
        stmt.close();
        return found;
    }

    public static void spectacle_et_representation(Connection conn, int num) throws SQLException {

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(" select noms ,to_char (daterep, 'DD/MM/YYYY') from lesspectacles natural left outer join lesrepresentations where nums=" + num);

        if (!rs.next()) {
            System.out.println("Pas de spectacle de numero :" + num);
        } else if (!spectacle_et_nom(conn, false, num)) {
            System.out.println("Le numero" + num + "N'existe pas dans la base de donnees");
        } 
        else {

            do{
                if(rs.wasNull()){
                  System.out.println("L'artiste numero "+num+"n'a aucune representation prevue");
                }
                System.out.print("Noms : " + rs.getString(1)+" ");
                System.out.println("Date : "+rs.getString(2));
            }while (rs.next());
        }

        rs.close();
        stmt.close();
    }

}
// Close the result set, statement and the connection
