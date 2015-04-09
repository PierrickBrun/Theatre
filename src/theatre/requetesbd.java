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
    /*
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
    */
/*
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
    */
 /*
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
    */
    /*
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
*/
    public static void spectacles(Connection conn) throws SQLException {

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
    
    public static void noms_et_spectacle(Connection conn, String nom) throws SQLException {

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT IdSpec FROM LesSpectacles where LOWER(NomSpec)="+"'"+nom.toLowerCase()+"'");
        
        if(!rs.next()){
             System.out.println("Pas de spectacle de ce nom");
        }
        else{
          System.out.println("Identifiant: " + rs.getInt(1) + " ");
        }
        System.out.println();
        rs.close();
        stmt.close();
    }
    
    
    
/*
    public static void representations(Connection conn) throws SQLException {

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM LesRepresentations");
        while (rs.next()) {
            System.out.print("IdSpec: " + rs.getInt(1) + " ");
            System.out.println("Dates : " + rs.getString(2));
        }
        rs.close();
        stmt.close();
    }
  */
    
    public static void spectacle_et_nom(Connection conn, int num) throws SQLException {
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT NomSpec FROM LesSpectacles where IdSpec = " + num);

        if (!rs.next()) {
                System.out.println("Pas de spectacle identifie par " + num);
           
        } 
        else {
                System.out.println("Intitule(s) : " + rs.getString(1));
        }
        System.out.println();
        rs.close();
        stmt.close();
    }

    
 public static void spectacle_et_representation(Connection conn, int num) throws SQLException {

  Statement stmt = conn.createStatement();
  ResultSet rs = stmt.executeQuery(" select distinct nomspec ,to_char(daterep, 'DD/MM/YYYY hh24:mi:ss') from lesspectacles natural left outer join lesrepresentations where Idspec=" + num);

  if (!rs.next()) {
    System.out.println("Pas de spectacle de numero :" + num);
  }
  else {
    do{
      System.out.print("Noms : " + rs.getString(1)+" ");
      System.out.println("Date : "+rs.getString(2));
    }while (rs.next());
  }
  System.out.println();
  rs.close();
  stmt.close();
}   
    
    
}
// Close the result set, statement and the connection
