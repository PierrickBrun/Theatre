package theatre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

class Theatre {

    private static final String configurationFile
            = "BD.properties";

    public static void main(String args[]) {
        try {
            String jdbcDriver, dbUrl, username, password;
            DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
            jdbcDriver = dap.getJdbcDriver();
            dbUrl = dap.getDatabaseUrl();
            username = dap.getUsername();
            password = dap.getPassword();
            Scanner sc = new Scanner(System.in);
            
            
// Load the database driver
            Class.forName(jdbcDriver);
// Get a connection to the database
            Connection conn = DriverManager.getConnection(dbUrl,
                    username, password);

            //requetesbd.nbartistes(conn);
            //requetesbd.artistes(conn);
            //requetesbd.artistes_preferes(conn);
            //requetesbd.CD(conn);
            System.out.println("Affichage des spectacles disponibles : \n");
            requetesbd.spectacles(conn);
            
           /* requetesbd.representations(conn);*/
            System.out.println("Donner un nom de spectacle  afin de connaitre son numéro: ");         
            requetesbd.noms_et_spectacle(conn, sc.nextLine());
            //Donne le nom d'un spectacle en fonction de son numero
            System.out.println("Donner un numero de spectacle  afin de connaitre son identifiant: ");
            requetesbd.spectacle_et_nom(conn,sc.nextInt());
            System.out.println("Donner un numero de spectacle afin de connaitre ses représentations: ");
            requetesbd.spectacle_et_representation(conn,sc.nextInt());
            // Print information about connection warnings
            SQLWarningsExceptions.printWarnings(conn);
            conn.close();
            
            sc.close();
        } catch (SQLException se) {
            // Print information about SQL exceptions
            SQLWarningsExceptions.printExceptions(se);
            return;
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return;
            
        }
    
    }
}
