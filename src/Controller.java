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

                        System.out.println("You chose to see the data from cars\n" + "Would you like to see the data from all the cars or just from a specific one");
                        System.out.println("\nType 1: to see all the data\ntype 2 to see data from a specific car_id");

                        String secondChoice = in.nextLine();

                        switch (secondChoice) {
                            case "1":
                                SqlMetoder.sqlMethodForAll(UiClass.CARS_TABLE);
                                break;
                            case "2":
                                System.out.println("Type in the car-id you want information about");
                                String thirdChoice = in.nextLine();
                                SqlMetoder.sqlMethodForCriteria(UiClass.CARS_TABLE, "car_id", thirdChoice);
                                break;
                            default:
                                System.out.println("Please select a valid option");
                                continue;
                        }
                        break;
                    }
                }
                if (firstChoice.equals("2")) {
                    while (true) {
                        System.out.println("You chose to see the data from drivers\n" + "Would you like to see the data from all the drivers or just from a specific one");
                        System.out.println("\nType 1: to see all the data\ntype 2 to see data from a specific  driver_id");

                        String secondChoice = in.nextLine();
                        switch (secondChoice) {
                            case "1":
                                SqlMetoder.sqlMethodForAll(UiClass.DRIVERS_TABLE);
                                break;
                            case "2":
                                System.out.println("Type in the driver-id you want information about");
                                String thirdChoice = in.nextLine();
                                SqlMetoder.sqlMethodForCriteria(UiClass.DRIVERS_TABLE, "driver_id", thirdChoice);
                                break;
                            default:
                                System.out.println("Please select a valid option");
                                continue;
                        }
                        break;
                    }
                }
                if (firstChoice.equals("3"))
                    while (true) {
                        System.out.println("You chose to see the data from rental_contracts\n" + "Would you like to see the data from all the contracts or just from a specific one");
                        System.out.println("\nType 1: to see all the data\nType 2 to see data from a specific rental_contract_id");
                        String secondChoice = in.nextLine();
                        switch (secondChoice) {
                            case "1":
                                SqlMetoder.sqlMethodForAll(UiClass.RENTAL_CONTRACTS_TABLE);
                                break;
                            case "2":
                                System.out.println("Type in the rental-id you want information about\"");
                                String thirdChoice = in.nextLine();
                                SqlMetoder.sqlMethodForCriteria(UiClass.DRIVERS_TABLE, "rental_id", thirdChoice);
                                break;
                            default:
                                System.out.println("Please select a valid option");
                                continue;
                        }
                        break;
                    }
                System.out.println(UiClass.REPEAT_MSG);
                String repeatOption = in.nextLine();

                if (repeatOption.equals("yes")) {
                    System.out.print(UiClass.MENU_OPTIONS);
                } else {
                    System.out.println(UiClass.LOGOUT_MSG);
                    break;
                }
            } else if (choices.equals("2")) {
                System.out.println("You have chosen to insert data.\nSelect the corresponding table where you want to insert data" + "" +
                        "\nType 1 for cars\nType 2 for drivers\nType 3 for rental_contracts");

                while (true) {

                    String secondChoice = in.nextLine();

                    switch (secondChoice) {
                        case "1":
                            boolean continueAddingCars = true;
                            while (continueAddingCars) {
                                SqlMetoder.InsertForCar();
                                System.out.println(UiClass.addingMoreValue);
                                String moredata = in.nextLine();
                                if (moredata.equalsIgnoreCase("yes")) {
                                    continueAddingCars = true;
                                } else if (moredata.equalsIgnoreCase("no")) {
                                    continueAddingCars = false;
                                } else {
                                    System.out.println("Invalid option. Please try again.");
                                }
                            }
                            break;

                        case "2":
                            boolean continueAddingDrivers = true;
                            while (continueAddingDrivers) {
                                SqlMetoder.InsertForDriver();
                                System.out.println(UiClass.addingMoreValue);
                                String moredata = in.nextLine();
                                if (moredata.equalsIgnoreCase("yes")) {
                                    continueAddingDrivers = true;
                                } else if (moredata.equalsIgnoreCase("no")) {
                                    continueAddingDrivers = false;
                                } else {
                                    System.out.println("Invalid option. Please try again.");
                                }
                            }
                            break;

                        case "3":
                            boolean continueAddingContracts = true;
                            while (continueAddingContracts) {

                                System.out.println("What is your driver_id");
                                String driver_id = in.nextLine();
                                System.out.println("What is your car_id");
                                String car_id = in.nextLine();

                                System.out.println("What is your start date of your rental? (YYYY-MM-DD) ");
                                String beginning_time = in.nextLine();
                                System.out.println("When is your end date of your rental? (YYYY-MM-DD) ");
                                String ending_time = in.nextLine();
                                SqlMetoder.sqlMethodForContract(driver_id,car_id,beginning_time,ending_time);
                                System.out.println(UiClass.addingMoreValue);
                                String moredata = in.nextLine();
                                if (moredata.equalsIgnoreCase("yes")) {
                                    continueAddingContracts = true;
                                } else if (moredata.equalsIgnoreCase("no")) {
                                    continueAddingContracts = false;
                                } else {
                                    System.out.println("Invalid option. Please try again.");
                                }
                            }
                            break;

                        default:
                            System.out.println("Please select a valid option");
                            continue;
                    }
                    break;
                }
                System.out.println(UiClass.REPEAT_MSG);
                String repeatOption = in.nextLine();

                if (repeatOption.equals("yes")) {
                    System.out.print(UiClass.MENU_OPTIONS);
                } else {
                    System.out.println(UiClass.LOGOUT_MSG);
                    break;
                }

            }
            else if (choices.equals("3")){
                System.out.println("You chose to delete data");
                System.out.println("Please select the number of the table you want to delete");
                System.out.println("Type 1 for cars\nType 2 for drivers\nType 3 for rental_contracts");
                String tabel = in.nextLine();

                if (tabel.equals("1")){
                    System.out.println("You have selected cars");
                    System.out.println("Which car_id would you like to delete?");
                    String deleteId = in.nextLine();
                    SqlMetoder.sqlMethodForDeletion(UiClass.CARS_TABLE,"car_id",deleteId);
                } else if (tabel.equals("2")) {
                    System.out.println("You have selected drivers");
                    System.out.println("Which driver_id would you like to delete?");
                    String deleteId = in.nextLine();
                    SqlMetoder.sqlMethodForDeletion(UiClass.DRIVERS_TABLE,"driver_id",deleteId);
                } else if (tabel.equals("3")) {
                    System.out.println("You have selected rental_contracts");
                    System.out.println("Which rental_id would you like to delete");
                    String deleteId = in.nextLine();
                    SqlMetoder.sqlMethodForDeletion(UiClass.RENTAL_CONTRACTS_TABLE,"rental_id",deleteId);
                }
                System.out.println(UiClass.REPEAT_MSG);
                String repeatOption = in.nextLine();

                if (repeatOption.equals("yes")) {
                    System.out.print(UiClass.MENU_OPTIONS);
                } else {
                    System.out.println(UiClass.LOGOUT_MSG);
                    break;
                }


            } else if (choices.equals("4")){
                updateMethod();
                System.out.println(UiClass.REPEAT_MSG);
                String repeatOption = in.nextLine();

                if (repeatOption.equals("yes")) {
                    System.out.print(UiClass.MENU_OPTIONS);
                } else {
                    System.out.println(UiClass.LOGOUT_MSG);
                    break;
                }


            } else if (choices.equals("9")) {
                System.out.println(UiClass.LOGOUT_MSG);
                break;

            } else {
                System.out.println(" Please type in valid numbers like following 1-2-3-4-9");
            }

        }

    }

    public static void updateMethod() {

        System.out.println("You chose to update data");
        System.out.println("Please select the number of the table you want to update");
        System.out.println("Type 1 for cars\nType 2 for drivers\nType 3 for rental_contracts");
        String tabel = in.nextLine();

        if (tabel.equals("1")) {
            System.out.println("You have selected cars");
            System.out.println("Which car_id would you like to update?");
            String updateId = in.nextLine();

            System.out.println(UiClass.UPDATE_MSG_Cars);
            String updateChoice = in.nextLine();


            switch (updateChoice) {
                case "1":
                    System.out.println("You have selected brand/model\nWhat would you like to update it to?");
                    String changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.CARS_TABLE, "brand_and_model", changeValue, "car_id", updateId);
                    break;
                case "2":
                    System.out.println("You have selected fueltype\nWhat would you like to update it to?");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.CARS_TABLE, "fuel_type", changeValue, "car_id", updateId);
                    break;
                case "3":
                    System.out.println("You have selected registration number\nWhat would you like to update it to?");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.CARS_TABLE, "registration_number", changeValue, "car_id", updateId);
                    break;
                case "4":
                    System.out.println("You have selected registration year/month\nWhat would you like to update it to?");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.CARS_TABLE, "registration_year_month", changeValue, "car_id", updateId);
                    break;
                case "5":
                    System.out.println("You have selected odometer reading\nWhat would you like to update it to?");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.CARS_TABLE, "odometer_reading", changeValue, "car_id", updateId);
                    break;
                case "6":
                    System.out.println("You have selected car type\nWhat would you like to update it to? (lux/family/sport)");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.CARS_TABLE, "car_type", changeValue, "car_id", updateId);
                    break;
                default:
                    System.out.println("Please select a valid option");
                    break;
            }

        } else if (tabel.equals("2")) {
            System.out.println("You have selected drivers");
            System.out.println("Which driver_id would you like to update?");
            String updateId = in.nextLine();
            System.out.println(UiClass.UPDATE_MSG_Drivers);
            String updateChoice = in.nextLine();

            switch (updateChoice) {
                case "1":
                    System.out.println("You have selected firstname\nWhat would you like to update it to?");
                    String changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.DRIVERS_TABLE, "firstname", changeValue, "driver_id", updateId);
                    break;
                case "2":
                    System.out.println("You have selected lastname\nWhat would you like to update it to?");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.DRIVERS_TABLE, "lastname", changeValue, "driver_id", updateId);
                    break;
                case "3":
                    System.out.println("You have selected address\nWhat would you like to update it to?");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.DRIVERS_TABLE, "address", changeValue, "driver_id", updateId);
                    break;
                case "4":
                    System.out.println("You have selected zip code\nWhat would you like to update it to?");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.DRIVERS_TABLE, "zip", changeValue, "driver_id", updateId);
                    break;
                case "5":
                    System.out.println("You have selected city\nWhat would you like to update it to?");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.DRIVERS_TABLE, "city", changeValue, "driver_id", updateId);
                    break;
                case "6":
                    System.out.println("You have selected phone number\nWhat would you like to update it to?");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.DRIVERS_TABLE, "mobile_phone", changeValue, "driver_id", updateId);
                    break;
                case "7":
                    System.out.println("You have selected phone\nWhat would you like to update it to?");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.DRIVERS_TABLE, "phone", changeValue, "driver_id", updateId);
                    break;
                case "8":
                    System.out.println("You have selected e-mail\nWhat would you like to update it to?");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.DRIVERS_TABLE, "email", changeValue, "driver_id", updateId);
                    break;
                case "9":
                    System.out.println("You have selected driver license number\nWhat would you like to update it to?");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.DRIVERS_TABLE, "driver_license_number", changeValue, "driver_id", updateId);
                    break;
                case "10":
                    System.out.println("You have selected date of driver's license issuance a\nWhat would you like to update it to?");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.DRIVERS_TABLE, "driver_since_date", changeValue, "driver_id", updateId);
                    break;
                default:
                    System.out.println("Please select a valid input");
                    break;
            }

        } else if (tabel.equals("3")) {
            System.out.println("You have selected rental_contracts");
            System.out.println("Which rental_id would you like to update?");
            String updateId = in.nextLine();
            System.out.println(UiClass.UPDATE_MSG_RentalContracts);
            String updateChoice = in.nextLine();
            switch (updateChoice) {
                case "1":
                    System.out.println("You have selected the renters name\nWhat would you like to update it to?");
                    String changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.RENTAL_CONTRACTS_TABLE, "renters_name", changeValue, "rental_id", updateId);
                    break;
                case "2":
                    System.out.println("You have selected the renters address\nWhat would you like to update it to?");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.RENTAL_CONTRACTS_TABLE, "renters_address", changeValue, "rental_id", updateId);
                    break;
                case "3":
                    System.out.println("You have selected the renters zip code\nWhat would you like to update it to?");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.RENTAL_CONTRACTS_TABLE, "renters_zip", changeValue, "rental_id", updateId);
                    break;
                case "4":
                    System.out.println("You have selected the renters city\nWhat would you like to update it to?");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.RENTAL_CONTRACTS_TABLE, "renters_city", changeValue, "rental_id", updateId);
                    break;
                case "5":
                    System.out.println("You have selected the renters driver license\nWhat would you like to update it to?");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.RENTAL_CONTRACTS_TABLE, "driver_license_number", changeValue, "rental_id", updateId);
                    break;
                case "6":
                    System.out.println(" You have selected the renters renting date\nWhat would you like to update it to?");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.RENTAL_CONTRACTS_TABLE, "from_date_time", changeValue, "rental_id", updateId);
                    break;
                case "7":
                    System.out.println("You have selected the renters returning date\nWhat would you like to update it to?");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.RENTAL_CONTRACTS_TABLE, "to_date_time", changeValue, "rental_id", updateId);
                    break;
                case "8":
                    System.out.println("You have selected the renters maximum mileage\nWhat would you like to update it to?");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.RENTAL_CONTRACTS_TABLE, "max_km", changeValue, "rental_id", updateId);
                    break;
                case "9":
                    System.out.println("You have selected the renters mileage at start km\nWhat would you like to update it to?");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.RENTAL_CONTRACTS_TABLE, "km_at_start", changeValue, "rental_id", updateId);
                    break;
                case "10":
                    System.out.println("You have selected the renters registration number\nWhat would you like to update it to?");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.RENTAL_CONTRACTS_TABLE, "registration_number", changeValue, "rental_id", updateId);
                    break;
                case "11":
                    System.out.println("You have selected the driver id\nWhat would you like to update it to?");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.RENTAL_CONTRACTS_TABLE, "driver_id", changeValue, "rental_id", updateId);
                    break;
                case "12":
                    System.out.println("You have selected the car id\nWhat would you like to update it to?");
                    changeValue = in.nextLine();
                    SqlMetoder.sqlMethodForUpdating(UiClass.RENTAL_CONTRACTS_TABLE, "car_id", changeValue, "rental_id", updateId);
                    break;
                default:
                    System.out.println("Please select a valid input");
                    break;
            }
        }
    }

    public static void main (String[]args) throws InterruptedException {
        menu();

    }
}



