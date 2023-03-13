import java.sql.*;
import java.util.Scanner;

public class SqlMetoder {
    public static final String database_url="jdbc:mysql://localhost:3306/kailua_car_rental";
    public static java.sql.Connection con;


    public static void sqlMethodForAll(String input){


        try {
            con = DriverManager.getConnection(database_url, "root", "root");
            Statement s = con.createStatement();
            String sql = "SELECT * FROM " + input;


            System.out.println(sql);
            System.out.println();

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
            System.out.println("There is an SQL exception: " + e.getMessage());
            System.exit(1);
        }
    }
    public static void sqlMethodForCriteria(String input,String column, String qualifier){


        try {
            con = DriverManager.getConnection(database_url, "root", "root");
            Statement s = con.createStatement();
            String sql = "SELECT * FROM " + input + " WHERE " + column + " = " + "'" +qualifier+"'";


            System.out.println(sql);
            System.out.println();

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
            System.out.println("There is an SQL exception: " + e.getMessage());

            System.exit(1);
        }
    }
    public static void InsertForDriver(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter zip code: ");
        String zip = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter mobile phone: ");
        String mobilePhone = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter driver license number: ");
        String driverLicenseNumber = scanner.nextLine();
        System.out.print("Enter driver since date (YYYY-MM-DD): ");
        String driverSinceDate = scanner.nextLine();


        try {
            con = DriverManager.getConnection(database_url, "root", "root");
            Statement s = con.createStatement();
            String sql = "INSERT INTO drivers (firstname, lastname, address, zip, city, mobile_phone, phone, email, driver_license_number, driver_since_date) " +
                    "VALUES ('" + firstName + "', '" + lastName + "', '" + address + "', '" + zip + "', '" + city + "', '" + mobilePhone + "', '" + phone + "', '" + email + "', '" + driverLicenseNumber + "', '" + driverSinceDate + "')";

            System.out.println(sql);
            System.out.println();

            int rowsConfirmation = s.executeUpdate(sql);
            if (rowsConfirmation > 0) {
                System.out.println("A new driver was inserted successfully!");
            }


            s.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("There is an SQL exception: " + e.getMessage());
            System.exit(1);
        }
    }
    public static void InsertForCar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter brand/model: ");
        String brandAndModel = scanner.nextLine();
        System.out.print("Enter fuel type: ");
        String fuelType = scanner.nextLine();
        System.out.print("Enter registration number: ");
        String registrationNumber = scanner.nextLine();
        System.out.print("Enter registration date (YYYY-MM-DD): ");
        String registrationYearMonth = scanner.nextLine();
        System.out.print("Enter odometer reading: ");
        int odometerReading = scanner.nextInt();
        scanner.nextLine(); // consume newline


        String carType = "";

        while (!carType.equalsIgnoreCase("Lux") && !carType.equalsIgnoreCase("Family")
                && !carType.equalsIgnoreCase("Sport")) {
            System.out.print("Enter car type: choose between Lux/Family/Sport ");
            carType = scanner.nextLine();
        }

        try {
            con = DriverManager.getConnection(database_url, "root", "root");
            Statement s = con.createStatement();
            String sql = "INSERT INTO cars (brand_and_model, fuel_type, registration_number, registration_year_month, odometer_reading, car_type) " +
                    "VALUES ('" + brandAndModel + "', '" + fuelType + "', '" + registrationNumber + "', '" + registrationYearMonth + "', " + odometerReading + ", '" + carType + "')";

            System.out.println(sql);
            System.out.println();

            int rowsConfirmation = s.executeUpdate(sql);

            if (rowsConfirmation > 0) {
                System.out.println("A new car was inserted successfully!");
            }

            s.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("There is a SQL exception: " + e.getMessage());
            System.exit(1);
        }
    }

    public static void sqlMethodForDeletion(String tableName, String qualifier, String value){


        try {
            con = DriverManager.getConnection(database_url, "root", "root");
            Statement s = con.createStatement();
            String sql = "DELETE FROM " + tableName + " WHERE " + qualifier + "="+ value ;



            System.out.println(sql);
            System.out.println();

            int rowsConfirmation = s.executeUpdate(sql);

            if (rowsConfirmation > 0) {
                System.out.println("Deletion was succesful!!!");
            } else {
                System.out.println("ID doesnt exist");
            }
            s.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("There is an SQL exception: " + e.getMessage());
            System.exit(1);
        }
    }

    public static void sqlMethodForUpdating(String tableName, String qualifier, String value, String condition, String id) {
        try {
            con = DriverManager.getConnection(database_url, "root", "root");
            Statement s = con.createStatement();
            String sql = "UPDATE " + tableName + " SET " + qualifier + " = '" + value + "' WHERE " + condition + "=" + id;
            System.out.println(sql);

            System.out.println();
            int rowsConfirmation = s.executeUpdate(sql);

            if (rowsConfirmation > 0) {
                System.out.println("Update was successful!");
            } else {
                System.out.println("No rows were updated.");
            }

            s.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("There is an SQL exception: " + e.getMessage());
            System.exit(1);
        }
    }

    public static void sqlMethodForContract(String driverId, String carId, String contractBeginningTime, String contractEndTime){


        try {
            con = DriverManager.getConnection(database_url, "root", "root");
            Statement s = con.createStatement();
            String sql = "INSERT INTO rental_contracts (renters_name, renters_address, renters_zip, renters_city, driver_license_number, registration_number, from_date_time, to_date_time, max_km, km_at_start, driver_id, car_id) " +
                    "SELECT CONCAT(d.firstname, ' ', d.lastname) AS renters_name, d.address AS renters_address, d.zip AS renters_zip, d.city AS renters_city, d.driver_license_number, c.registration_number, '" + contractBeginningTime + "' AS from_date_time, '" + contractEndTime + "' AS to_date_time, 100 AS max_km, c.odometer_reading AS km_at_start, d.driver_id, c.car_id " +
                    "FROM drivers d, cars c " +
                    "WHERE d.driver_id = " + driverId + " AND c.car_id = " + carId;



            System.out.println(sql);
            System.out.println();

            int rowsConfirmation = s.executeUpdate(sql);

            if (rowsConfirmation > 0) {
                System.out.println("The contract was successfully made!");
            } else {
                System.out.println("Something went wrong");
            }
            s.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("There is an SQL exception: " + e.getMessage());
            System.exit(1);
        }
    }

    public static void main(String[] args) {
            sqlMethodForContract("5","4","2002-02-02", "2005-02-05");
    }

}
