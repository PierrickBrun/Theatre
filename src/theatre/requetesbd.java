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


    public static void methode_a_1(Connection conn) throws SQLException {

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM LesSpectacles order by IdSpec");
        while (rs.next()) {
            System.out.print("Identifiant: " + rs.getInt(1) + " ");
            System.out.println("Intitule : " + rs.getString(2));
        }
        System.out.println();
        rs.close();
        stmt.close();
    }

    public static void methode_a_2(Connection conn, String nom) throws SQLException {

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT IdSpec FROM LesSpectacles where LOWER(NomSpec)=" + "'" + nom.toLowerCase() + "'");

        if (!rs.next()) {
            System.out.println("Pas de spectacle de ce nom");
        } else {
            System.out.println("Identifiant: " + rs.getInt(1) + " ");
        }
        System.out.println();
        rs.close();
        stmt.close();
    }
  
    

    public static void methode_a_3(Connection conn, int num) throws SQLException {
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT NomSpec FROM LesSpectacles where IdSpec = " + num);

        if (!rs.next()) {
            System.out.println("Pas de spectacle identifie par " + num);

        } else {
            System.out.println("Intitule(s) : " + rs.getString(1));
        }
        System.out.println();
        rs.close();
        stmt.close();
    }

    public static void methode_a_4(Connection conn, int num) throws SQLException {

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(" select distinct nomspec ,to_char(daterep, 'DD/MM/YYYY hh24:mi:ss') from lesspectacles natural left outer join lesrepresentations where Idspec=" + num);

        if (!rs.next()) {
            System.out.println("Pas de spectacle de numero :" + num);
        } else {
            do {
                System.out.print("Noms : " + rs.getString(1) + " ");
                System.out.println("Date : " + rs.getString(2));
            } while (rs.next());
        }
        System.out.println();
        rs.close();
        stmt.close();
    }

    public static String methode_b(Connection conn, int num) throws SQLException {
        String result = "";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select NomZone, Tarif from LesZones where IdZone = " + num);

        if (!rs.next()) {
            result = "Pas de zone de numero :" + num;
        } else {
            do {
                result += "Nom : " + rs.getString(1) + "\n";
                result += "Tarif : " + rs.getInt(2) + "\n";
            } while (rs.next());
        }
        rs.close();
        stmt.close();
        return result;
    }

    public static String methode_c(Connection conn, String categorieZone) throws SQLException {
        String result = "";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select IdZone from LesZones where LOWER(nomZone) ="+"'" + categorieZone.toLowerCase() + "'");

        if (!rs.next()) {
            result = "Pas de zone de nom :" + categorieZone;
        } else {
            do {
                result += "Num : " + rs.getInt(1) + "\n";
            } while (rs.next());
        }
        rs.close();
        stmt.close();
        return result;
    }

    public static String methode_d(Connection conn, String zone) throws SQLException {
        String result = "";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select p.numRang, p.numPlace from LesZones z left join LesPlaces p on (z.idZone = p.idZone) where LOWER(NomZone) ="+"'"+ zone.toLowerCase() + "'");

        if (!rs.next()) {
            result = "Pas de zone :" + zone;
        } else {
            result += "Zone : " + zone +"\n";
            do {
                result += "rang : " + rs.getInt(1) + "\n";
                result += "place : " + rs.getInt(2) + "\n\n";
            } while (rs.next());
        }
        rs.close();
        stmt.close();
        return result;
    }

    public static String methode_e(Connection conn, int num) throws SQLException {
        String result = "";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select NomZone,numRang, numPlace from LesZones natural join LesPlaces  where IdZone = " + num);

        if (!rs.next()) {
            result = "Pas de zone de numero :" + num;
        } else {
            result += "Zone : " + rs.getString(1) + "\n";
            do {
                result += "rang : " + rs.getInt(2) + "\n";
                result += "place : " + rs.getInt(3) + "\n";
            } while (rs.next());
        }
        rs.close();
        stmt.close();
        return result;
    }
    
    public static String methode_f(Connection conn, int num) throws SQLException {
        String result = "";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select nomSpec, to_char(DateRep, 'DD/MM/YYYY hh24:mi:ss'), IdZone, NumPlace, Numrang from LesTickets natural join (Select * from LesSpectacles natural join LesPlaces) where IdTicket = " + num);

        if (!rs.next()) {
            result = "Pas de zone de numero :" + num;
        } else {
                result += "Nom : " + rs.getString(1) + "\n";
                result += "Date : " + rs.getString(2) + "\n";
                result +="Zone :" + rs.getInt(3) +"\n";
                result += "Place : " + rs.getInt(4) + "\n";
                result += "Rang : " + rs.getInt(5) + "\n";
        }
        rs.close();
        stmt.close();
        return result;
    }

}
