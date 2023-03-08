import java.sql.*;
import java.util.Scanner;

public class Main {
    public static final String database_url="jdbc:mysql://localhost:3306/my_favorite_music";
    public static java.sql.Connection con;




    public static void main(String[] args) {


        sqlmethod("music", "genre", "bjkghkjgukl");

        System.out.println("Tast tilhørende tal for at se muligheder");

        Scanner in = new Scanner(System.in);

        int nummerindtaser = in.nextInt();

        switch (nummerindtaser){
            case 1:
                break;
            case 2:
                break;
        }

    }

    public static void sqlmethod(String input,String column, String qualifier){


        try {
            con = DriverManager.getConnection(database_url, "root", "root");
            Statement s = con.createStatement();
            String sql = "SELECT * FROM " + input + " WHERE " + column + " = " + "'" +qualifier+"'";


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
}