import java.util.Scanner;

public class Controller {

    static Scanner in = new Scanner(System.in);
    public static void menu() {

        System.out.print(UiClass.MENU_OPTIONS);

        while (true) {
            String choices = in.nextLine();


            if (choices.equals("1")) {

                System.out.println(UiClass.OPTION_TABLE);
                String firstChoice = in.nextLine();

                if (firstChoice.equals("1")) {
                    while (true) {
                        System.out.println("Du har valgt at se dataen fra cars\nVil du se alt data fra biler eller en specific data" +
                                "\nTast 1 for at for at se alle data\nTast 2 for at se fra en specifik id");
                        String secondChoice = in.nextLine();

                        switch (secondChoice) {
                            case "1":
                                SqlMetoder.sqlMethodForAll(UiClass.CARS_TABLE);
                                break;
                            case "2":
                                System.out.println("Tast det bil-ID du vil se oplysninger over");
                                String thirdChoice = in.nextLine();
                                SqlMetoder.sqlMethodForCriteria(UiClass.CARS_TABLE, "car_id", thirdChoice);
                                break;
                            default:
                                System.out.println("Vælg en gyldig mulighed");
                                continue;
                        }
                        break;
                    }
                }
                if (firstChoice.equals("2")) {
                    while (true) {
                        System.out.println("Du har valgt at se dataen fra drivers\nVil du se alt data fra drivers eller en specific data" +
                                "\nTast 1 for at for at se alle data\nTast 2 for at se data fra en specifik driver_id");
                        String secondChoice = in.nextLine();
                        switch (secondChoice) {
                            case "1":
                                SqlMetoder.sqlMethodForAll(UiClass.DRIVERS_TABLE);
                                break;
                            case "2":
                                System.out.println("Hvilken id vil du se på?");
                                String thirdChoice = in.nextLine();
                                SqlMetoder.sqlMethodForCriteria(UiClass.DRIVERS_TABLE, "driver_id", thirdChoice);
                                break;
                            default:
                                System.out.println("Vælg en gyldig mulighed");
                                continue;
                        }
                        break;
                    }
                }
                if (firstChoice.equals("3"))
                    while (true) {
                        System.out.println("Du har valgt at se dataen fra rental_contracts\nVil du se alt data fra kontrakterne eller en specific data" +
                                "\nTast 1 for at for at se alle data\nTast 2 for at se data fra en specifik rental_contract_id");
                        String secondChoice = in.nextLine();
                        switch (secondChoice) {
                            case "1":
                                SqlMetoder.sqlMethodForAll(UiClass.RENTAL_CONTRACTS_TABLE);
                                break;
                            case "2":
                                System.out.println("Hvilken id vil du se på?");
                                String thirdChoice = in.nextLine();
                                SqlMetoder.sqlMethodForCriteria(UiClass.DRIVERS_TABLE, "rental_id", thirdChoice);
                                break;
                            default:
                                System.out.println("Vælg en gyldig mulighed");
                                continue;
                        }
                        break;
                    }
                System.out.println(UiClass.REPEAT_MSG);
                String repeatOption = in.nextLine();

                if (repeatOption.equals("ja")) {
                    System.out.print(UiClass.MENU_OPTIONS);
                } else {
                    System.out.println(UiClass.LOGOUT_MSG);
                    break;
                }
            } else if (choices.equals("2")) {
                System.out.println("Du har valgt at indsætte data ind.\nVælg tilhørende tabel du vil indsætte data hos" +
                        "\nTast 1 for cars\nTast 2 for drivers\nTast 3 for rental_contracts");
                while (true) {

                    String secondChoice = in.nextLine();

                    switch (secondChoice) {
                        case "1":
                            boolean continueAddingCars = true;
                            while (continueAddingCars) {
                                SqlMetoder.InsertForCar();
                                System.out.println(UiClass.addingMoreValue);
                                String moredata = in.nextLine();
                                if (moredata.equalsIgnoreCase("ja")) {
                                    continueAddingCars = true;
                                } else if (moredata.equalsIgnoreCase("nej")) {
                                    continueAddingCars = false;
                                } else {
                                    System.out.println("Ugyldigt valg. Prøv igen.");
                                }
                            }
                            break;

                        case "2":
                            boolean continueAddingDrivers = true;
                            while (continueAddingDrivers) {
                                SqlMetoder.InsertForDriver();
                                System.out.println(UiClass.addingMoreValue);
                                String moredata = in.nextLine();
                                if (moredata.equalsIgnoreCase("ja")) {
                                    continueAddingDrivers = true;
                                } else if (moredata.equalsIgnoreCase("nej")) {
                                    continueAddingDrivers = false;
                                } else {
                                    System.out.println("Ugyldigt valg. Prøv igen.");
                                }
                            }
                            break;

                        case "3":
                            boolean continueAddingContracts = true;
                            while (continueAddingContracts) {

                                System.out.println("Nævn din driver_id");
                                String driver_id = in.nextLine();
                                System.out.println("Nævn din car_id");
                                String car_id = in.nextLine();

                                System.out.println("Nævn begyndelsesdatoen (YYYY-MM-DD) ");
                                String beginning_time = in.nextLine();
                                System.out.println("Nævn sluttedatoen (YYYY-MM-DD) ");
                                String ending_time = in.nextLine();
                                SqlMetoder.sqlMethodForContract(driver_id,car_id,beginning_time,ending_time);
                                System.out.println(UiClass.addingMoreValue);
                                String moredata = in.nextLine();
                                if (moredata.equalsIgnoreCase("ja")) {
                                    continueAddingContracts = true;
                                } else if (moredata.equalsIgnoreCase("nej")) {
                                    continueAddingContracts = false;
                                } else {
                                    System.out.println("Ugyldigt valg. Prøv igen.");
                                }
                            }
                            break;

                        default:
                            System.out.println("Vælg en gyldig mulighed");
                            continue;
                    }
                    break;
                }
                System.out.println(UiClass.REPEAT_MSG);
                String repeatOption = in.nextLine();

                if (repeatOption.equals("ja")) {
                    System.out.print(UiClass.MENU_OPTIONS);
                } else {
                    System.out.println(UiClass.LOGOUT_MSG);
                    break;
                }

            }
            else if (choices.equals("3")){
                System.out.println("Du har valgt at slette data");
                System.out.println("Nævn hvad fra en tabel du vil slette fra");
                System.out.println("Skriv 1 for cars\nSkriv 2 for drivers\nSkriv 3 for rental_contracts");
                String tabel = in.nextLine();

                if (tabel.equals("1")){
                    System.out.println("Du har nu valgt cars");
                    System.out.println("Hvilken car_id vil du gerne slette");
                    String deleteId = in.nextLine();
                    SqlMetoder.sqlMethodForDeletion(UiClass.CARS_TABLE,"car_id",deleteId);
                } else if (tabel.equals("2")) {
                    System.out.println("Du har nu valgt drivers");
                    System.out.println("Hvilken driver_id vil du gerne slette");
                    String deleteId = in.nextLine();
                    SqlMetoder.sqlMethodForDeletion(UiClass.DRIVERS_TABLE,"driver_id",deleteId);
                } else if (tabel.equals("3")) {
                    System.out.println("Du har nu valgt rental_contracts");
                    System.out.println("Hvilken rental_id vil du gerne slette");
                    String deleteId = in.nextLine();
                    SqlMetoder.sqlMethodForDeletion(UiClass.RENTAL_CONTRACTS_TABLE,"rental_id",deleteId);
                }
                System.out.println(UiClass.REPEAT_MSG);
                String repeatOption = in.nextLine();

                if (repeatOption.equals("ja")) {
                    System.out.print(UiClass.MENU_OPTIONS);
                } else {
                    System.out.println(UiClass.LOGOUT_MSG);
                    break;
                }


            } else if (choices.equals("4")){
               updateMethod();
                System.out.println(UiClass.REPEAT_MSG);
                String repeatOption = in.nextLine();

                if (repeatOption.equals("ja")) {
                    System.out.print(UiClass.MENU_OPTIONS);
                } else {
                    System.out.println(UiClass.LOGOUT_MSG);
                    break;
                }


            } else if (choices.equals("9")) {
                System.out.println(UiClass.LOGOUT_MSG);
                break;

            } else {
                System.out.println("Indput venligst noget gyldigt 1-2-3-4-9");
            }

        }

    }

    public static void updateMethod() {

        System.out.println("Du har valgt at opdatere data");
        System.out.println("Nævn hvad fra en tabel du vil opdatere fra");
        System.out.println("Skriv 1 for cars\nSkriv 2 for drivers\nSkriv 3 for rental_contracts");
        String tabel = in.nextLine();

        if (tabel.equals("1")) {
            System.out.println("Du har nu valgt cars");
            System.out.println("Hvilken car_id vil du gerne opdatere");
            String updateId = in.nextLine();

            System.out.println(UiClass.UPDATE_MSG_Cars);
            String updateChoice = in.nextLine();


            switch (updateChoice) {
                case "1":
                    System.out.println("Du har valgt at ændre brand/model\nHvad vil du opdatere værdien til");
                    String changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.CARS_TABLE, "brand_and_model", changeValue, "car_id", updateId);
                    break;
                case "2":
                    System.out.println("Du har valgt at ændre fueltype\nHvad vil du opdatere værdien til");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.CARS_TABLE, "fuel_type", changeValue, "car_id", updateId);
                    break;
                case "3":
                    System.out.println("Du har valgt at ændre registration number\nHvad vil du opdatere værdien til");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.CARS_TABLE, "registration_number", changeValue, "car_id", updateId);
                    break;
                case "4":
                    System.out.println("Du har valgt at ændre registration year/month\nHvad vil du opdatere værdien til");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.CARS_TABLE, "registration_year_month", changeValue, "car_id", updateId);
                    break;
                case "5":
                    System.out.println("Du har valgt at ændre odometer reading\nHvad vil du opdatere værdien til");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.CARS_TABLE, "odometer_reading", changeValue, "car_id", updateId);
                    break;
                case "6":
                    System.out.println("Du har valgt at ændre car type\nHvad vil du opdatere værdien til");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.CARS_TABLE, "car_type", changeValue, "car_id", updateId);
                    break;
                default:
                    System.out.println("Ugyldigt input. Prøv igen.");
                    break;
            }

        } else if (tabel.equals("2")) {
            System.out.println("Du har nu valgt drivers");
            System.out.println("Hvilken driver_id vil du gerne opdatere");
            String updateId = in.nextLine();
            System.out.println(UiClass.UPDATE_MSG_Drivers);
            String updateChoice = in.nextLine();

            switch (updateChoice) {
                case "1":
                    System.out.println("Du har valgt at ændre fornavn\nHvad vil du opdatere værdien til");
                    String changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.DRIVERS_TABLE, "firstname", changeValue, "driver_id", updateId);
                    break;
                case "2":
                    System.out.println("Du har valgt at ændre efternavn\nHvad vil du opdatere værdien til");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.DRIVERS_TABLE, "lastname", changeValue, "driver_id", updateId);
                    break;
                case "3":
                    System.out.println("Du har valgt at ændre adresse\nHvad vil du opdatere værdien til");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.DRIVERS_TABLE, "address", changeValue, "driver_id", updateId);
                    break;
                case "4":
                    System.out.println("Du har valgt at ændre postnummer\nHvad vil du opdatere værdien til");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.DRIVERS_TABLE, "zip", changeValue, "driver_id", updateId);
                    break;
                case "5":
                    System.out.println("Du har valgt at ændre by\nHvad vil du opdatere værdien til");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.DRIVERS_TABLE, "city", changeValue, "driver_id", updateId);
                    break;
                case "6":
                    System.out.println("Du har valgt at ændre mobilnummer\nHvad vil du opdatere værdien til");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.DRIVERS_TABLE, "mobile_phone", changeValue, "driver_id", updateId);
                    break;
                case "7":
                    System.out.println("Du har valgt at ændre telefonnummer\nHvad vil du opdatere værdien til");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.DRIVERS_TABLE, "phone", changeValue, "driver_id", updateId);
                    break;
                case "8":
                    System.out.println("Du har valgt at ændre email\nHvad vil du opdatere værdien til");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.DRIVERS_TABLE, "email", changeValue, "driver_id", updateId);
                    break;
                case "9":
                    System.out.println("Du har valgt at ændre kørekortnummer\nHvad vil du opdatere værdien til");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.DRIVERS_TABLE, "driver_license_number", changeValue, "driver_id", updateId);
                    break;
                case "10":
                    System.out.println("Du har valgt at ændre dato for erhvervelse af kørekort\nHvad vil du opdatere værdien til");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.DRIVERS_TABLE, "driver_since_date", changeValue, "driver_id", updateId);
                    break;
                default:
                    System.out.println("Ugyldigt input.");
                    break;
            }

        } else if (tabel.equals("3")) {
            System.out.println("Du har nu valgt rental_contracts");
            System.out.println("Hvilken rental_id vil du gerne opdatere");
            String updateId = in.nextLine();
            System.out.println(UiClass.UPDATE_MSG_RentalContracts);
            String updateChoice = in.nextLine();
            switch (updateChoice) {
                case "1":
                    System.out.println("Du har valgt at ændre lejers navn\nHvad vil du opdatere værdien til");
                    String changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.RENTAL_CONTRACTS_TABLE, "renters_name", changeValue, "rental_id", updateId);
                    break;
                case "2":
                    System.out.println("Du har valgt at ændre lejers adresse\nHvad vil du opdatere værdien til");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.RENTAL_CONTRACTS_TABLE, "renters_address", changeValue, "rental_id", updateId);
                    break;
                case "3":
                    System.out.println("Du har valgt at ændre lejers postnummer\nHvad vil du opdatere værdien til");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.RENTAL_CONTRACTS_TABLE, "renters_zip", changeValue, "rental_id", updateId);
                    break;
                case "4":
                    System.out.println("Du har valgt at ændre lejers by\nHvad vil du opdatere værdien til");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.RENTAL_CONTRACTS_TABLE, "renters_city", changeValue, "rental_id", updateId);
                    break;
                case "5":
                    System.out.println("Du har valgt at ændre lejers kørekortnummer\nHvad vil du opdatere værdien til");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.RENTAL_CONTRACTS_TABLE, "driver_license_number", changeValue, "rental_id", updateId);
                    break;
                case "6":
                    System.out.println("Du har valgt at ændre lejens startdato\nHvad vil du opdatere værdien til");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.RENTAL_CONTRACTS_TABLE, "from_date_time", changeValue, "rental_id", updateId);
                    break;
                case "7":
                    System.out.println("Du har valgt at ændre lejens slutdato\nHvad vil du opdatere værdien til");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.RENTAL_CONTRACTS_TABLE, "to_date_time", changeValue, "rental_id", updateId);
                    break;
                case "8":
                    System.out.println("Du har valgt at ændre max antal km for lejen\nHvad vil du opdatere værdien til");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.RENTAL_CONTRACTS_TABLE, "max_km", changeValue, "rental_id", updateId);
                    break;
                case "9":
                    System.out.println("Du har valgt at ændre start km\nHvad vil du opdatere værdien til");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.RENTAL_CONTRACTS_TABLE, "km_at_start", changeValue, "rental_id", updateId);
                    break;
                case "10":
                    System.out.println("Du har valgt at ændre registreringsnummer\nHvad vil du opdatere værdien til");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.RENTAL_CONTRACTS_TABLE, "registration_number", changeValue, "rental_id", updateId);
                    break;
                case "11":
                    System.out.println("Du har valgt at ændre driver id\nHvad vil du opdatere værdien til");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.RENTAL_CONTRACTS_TABLE, "driver_id", changeValue, "rental_id", updateId);
                    break;
                case "12":
                    System.out.println("Du har valgt at ændre car id\nHvad vil du opdatere værdien til");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.RENTAL_CONTRACTS_TABLE, "car_id", changeValue, "rental_id", updateId);
                    break;
                default:
                    System.out.println("Ugyldigt valg");
                    break;
            }
        }
    }

        public static void main (String[]args) throws InterruptedException {
            menu();

        }
    }



