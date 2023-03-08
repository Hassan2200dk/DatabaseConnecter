import java.sql.*;
import java.util.Scanner;

public class Controller {

    private static String username;
    private static String password;
    private static int failAttempts = 0;
    static Scanner in = new Scanner(System.in);

    public static final String database_url="jdbc:mysql://localhost:3306/kailua_car_rental";
    public static java.sql.Connection con;

    public static void enterPassword() throws InterruptedException {

        while (true) {

            System.out.println("Indtast brugernavn");
            username = in.nextLine();
            System.out.println("Indtast dit kodeord");
            password = in.nextLine();

            if (username.equalsIgnoreCase("admin") && password.equals("admin")) {
                System.out.print("Du er logget ind!");
                break;

            } else {
                failAttempts++;
                if (failAttempts<3) {

                    System.out.println("Forkert brugernavn eller kode");
                    System.out.println("Prøv igen");
                }

            }
            if (failAttempts >= 3) {
                System.out.println("Du har indtasted for mange gange");
                System.out.println("Prøv igen efter 5 sek");

                for (int i = 5; i >0 ; i--) {
                    System.out.print(i+"\r");
                    Thread.sleep(1000);
                }


            }

        }

    }

    public static void sqlmethod(String input){


        try {
            con = DriverManager.getConnection(database_url, "root", "root");
            Statement s = con.createStatement();
            String sql = "SELECT * FROM " + input;


            System.out.println(sql);

            ResultSet rs = s.executeQuery(sql);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            if (rs!=null){
                while (rs.next()){
                    for (int i = 1; i <= columnCount; i++) {
                        String kolonneNavn = metaData.getColumnName(i);
                        System.out.println(kolonneNavn + ": " + rs.getString(i) +" " );
                    }
                    System.out.println();
                }
            }
            s.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Der er en sql exception " + e.getMessage());
            System.exit(1);
        }
    }


    public static void main(String[] args) throws InterruptedException {
       // enterPassword();
        sqlmethod("cars");
    }
    }


