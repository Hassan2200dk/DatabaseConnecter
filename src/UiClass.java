public class UiClass {
    public static final String MENU_OPTIONS = "Welcome to Kailua Car rental company 🖇️🚘 \n " +
            "__________________________________________________________________________________________ \n" +
            "In order to proceed, please select the number for the operation you wish to implement." +
            "\n" + " \n"
            + "Type 1 if you want to view data from a specific table.\n"
            + "Type 2 if you want to insert data in the tables.\n"
            + "Type 3 if you want to delete data from the tables.\n"
            + "Type 4 if you want to update the tables.\n"
            + "Type 9 to log out of the system.\n";

    public static final String CARS_TABLE = "cars";

    public static final String DRIVERS_TABLE = "drivers";

    public static final String addingMoreValue = "Do you want to enter more data?" + "Type 'Yes' if you do, otherwise type 'No'.\n";

    public static final String RENTAL_CONTRACTS_TABLE = "rental_contracts"; //TODO
    public static final String REPEAT_MSG = ("Do you want to continue?\nType 'Yes' or 'no'");
    public static final String LOGOUT_MSG = "\"You have now chosen to log out...\"";
    public static final String OPTION_TABLE = "which table would you like to see\n" + "type 1 for cars\ntype 2 for drivers\ntype 3 rental_contracts ";


    public static final String UPDATE_MSG_Cars= "Which column do you want to change?\nType 1 for brand/model." +
            "\nType 2 for fueltype" +
            "\nType 3 for registration number" +
            "\nType 4 for registration year/month" +
            "\nType 5 for odometer reading" +
            "\nType 6 for car type";

    public static final String UPDATE_MSG_Drivers= "which column do you want to change?\nType 1 for firstname" +
            "\nType 2 for lastname" +
            "\nType 3 for address" +
            "\nType 4 for zip code" +
            "\nType 5 for city" +
            "\nType 6 for phone number" +
            "\nTast 7 for phone" +
            "\nTast 8 for e-mail" +
            "\nTast 9 for driver license number" +
            "\nTast 10 for Date of driver's license issuance.(YYYY- MM-DD)";

    public static final String UPDATE_MSG_RentalContracts = "which column do you want to change?\nType 1 the renter's name" +
            "\nType 2 for renter's address." +
            "\nType 3 for renter's zip code" +
            "\nType 4 for renter's  city" +
            "\nType 5 for the driver's license number" +
            "\nType 6 for renting date" +
            "\nType 7 for returning date" +
            "\nType 8 for Maximum mileage." +
            "\nType 9 for Mileage at start" +
            "\nType 10 for registration number" +
            "\nType 11 for driver-id" +
            "\nType12 for car-id";

}
