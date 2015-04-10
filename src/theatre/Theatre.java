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

            System.out.println("Affichage des spectacles disponibles : \n");
            requetesbd.methode_a_1(conn);

            System.out.println("Donner un nom de spectacle  afin de connaitre son numéro: ");
            requetesbd.methode_a_2(conn, sc.nextLine());
            //Donne le nom d'un spectacle en fonction de son numero
            System.out.println("Donner un numero de spectacle  afin de connaitre son intitule: ");
            requetesbd.methode_a_3(conn, sc.nextInt());
            System.out.println("Donner un numero de spectacle afin de connaitre ses représentations: ");
            requetesbd.methode_a_4(conn, sc.nextInt());
             // Print information about connection warnings

            System.out.println("Donner un numero de zone (methode b): ");
            System.out.println(requetesbd.methode_b(conn, sc.nextInt()));
            System.out.println("Donner un nom de zone (methode c): ");
            sc.skip("\n");
            System.out.println(requetesbd.methode_c(conn, sc.nextLine()));
            System.out.println("Donner un nom de zone (methode d): ");
            System.out.println(requetesbd.methode_d(conn, sc.nextLine()));
            System.out.println("Donner un numero de zone (methode e): ");
            System.out.println(requetesbd.methode_e(conn, sc.nextInt()));
            System.out.println("Donner un numero de vente (methode f): ");
            System.out.println(requetesbd.methode_f(conn, sc.nextInt()));
            System.out.println("Donner un numero de vente (methode g): ");
            System.out.println(requetesbd.methode_f(conn, sc.nextInt()));
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
