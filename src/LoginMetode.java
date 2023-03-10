import java.util.Scanner;

public class LoginMetode {
    private static String username;
    private static String password;
    private static int failAttempts = 0;
    static Scanner in = new Scanner(System.in);

    public static void enterPassword() throws InterruptedException {

        while (true) {

            System.out.println("Indtast brugernavn");
            username = in.nextLine();
            System.out.println("Indtast dit kodeord");
            password = in.nextLine();

            if (username.equalsIgnoreCase("admin") && password.equals("admin")) {
                System.out.print("Du er logget ind!");
                System.out.println();
                break;

            } else {
                failAttempts++;
                if (failAttempts < 3) {

                    System.out.println("Forkert brugernavn eller kode");
                    System.out.println("Prøv igen");
                }

            }
            if (failAttempts >= 3) {
                System.out.println("Du har indtasted for mange gange");
                System.out.println("Prøv igen efter 5 sek");

                for (int i = 5; i > 0; i--) {
                    System.out.print(i + "\r");
                    Thread.sleep(1000);
                }


            }

        }

    }
}
