import java.util.Scanner;

public class UiClass {
    public static final String MENU_OPTIONS = "Du har nu en række muligheder. Vælg tilsvarende tal til denne operation du vil indføre\n"
            + "Skriv 1 hvis du vil se dataen fra en specifik tabel.\n"
            + "Skriv 2 hvis du vil indsætte data i tabellerne.\n"
            + "Skriv 3 hvis du vil slette data i tabellerne.\n"
            +"Skriv 4 hvis du vil opdatere data i tabellerne.\n"
            + "Skriv 9 hvis du vil se logge ud\n";

    public static final String CARS_TABLE = "cars";

    public static final String DRIVERS_TABLE = "drivers";

    public static final String addingMoreValue = "Vil du indtaste mere data\nTast Ja hvis du vil, ellers tast Nej";

    public static final String RENTAL_CONTRACTS_TABLE = "rental_contracts";
    public static final String REPEAT_MSG = ("Vil du fortsætte\nSkriv ja hvis du fortsætte eller skriv noget andet");
    public static final String LOGOUT_MSG = "Du har nu valgt at logge ud...";
    public static final String OPTION_TABLE = "Hvilken tabel vil du gerne se\nSkriv 1 for cars\n"
            + "Skriv 2 drivers\nSkriv 3 rental_contracts";


    public static final String UPDATE_MSG_Cars= "Hvilken Kolonne vil du ændr?\nTast 1 for brand/model" +
            "\nTast 2 for fueltype" +
            "\nTast 3 for registration number" +
            "\nTast 4 for registration year/month" +
            "\nTast 5 for odometer reading" +
            "\nTast 6 for car type";

    public static final String UPDATE_MSG_Drivers= "Hvilken kolonne vil du ændre?\nTast 1 for fornavn" +
            "\nTast 2 for efternavn" +
            "\nTast 3 for adresse" +
            "\nTast 4 for postnummer" +
            "\nTast 5 for by" +
            "\nTast 6 for mobiltelefon" +
            "\nTast 7 for telefon" +
            "\nTast 8 for e-mail" +
            "\nTast 9 for kørekortnummer" +
            "\nTast 10 for kørekort udstedt dato (åååå-mm-dd)";
}
