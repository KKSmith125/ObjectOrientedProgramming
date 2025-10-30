import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageCenter {
    public static void main(String[] args) {
        String contactInformation;
        String name;
        String product = "car";
        int choice;
        boolean quit = false;
        Scanner scnr = new Scanner(System.in);
        MessageCreator server = new Server();

        System.out.println("Hello what is your name?");
        name = scnr.nextLine();

        while (!quit) {
            System.out.printf("How would you like to be contacted about deals on our %ss?\n", product);
            System.out.println("1) Email \n2) SMS \n3) Mail \n4) Opt Out");
            choice = scnr.nextInt();

            scnr.nextLine();

            if (choice == 1) {
                contactInformation = getContact(scnr);

                // Create new email
                Message email = server.sendMessage("email", contactInformation, name);
                email.sendConfirmation();

                quit = true;
            } else if (choice == 2) {
                if (name.equals("")) {
                    System.out.println(
                            "Please enter a valid name, if you do not wish to add a name you can send an email!");
                    name = scnr.nextLine();

                    if (!name.equals("")) {
                        contactInformation = getContact(scnr);

                        // Create new sms
                        Message sms = server.sendMessage("sms", contactInformation, name);
                        sms.sendConfirmation();

                        quit = true;
                    }
                } else {
                    contactInformation = getContact(scnr);

                    // Create new sms
                    Message sms = server.sendMessage("sms", contactInformation, name);
                    sms.sendConfirmation();

                    quit = true;
                }
            } else if (choice == 3) {
                if (checkName(name)) {
                    contactInformation = getContact(scnr);

                    // Create new letter
                    Message mail = server.sendMessage("mail", contactInformation, name);
                    mail.sendConfirmation();

                    quit = true;
                } else {
                    System.out.println(
                            "Please enter a valid first and last name separated by a space, otherwise choose another message option!");
                    name = scnr.nextLine();

                    if (checkName(name)) {
                        contactInformation = getContact(scnr);

                        // Create new sms
                        Message sms = server.sendMessage("sms", contactInformation, name);
                        sms.sendConfirmation();

                        quit = true;
                    }
                }

            }

            if (choice == 4) {
                System.out.println("You have opted out of messaging.");
                quit = true;
            }
        }
    }

    public static boolean checkName(String name) {
        String regex = "[a-zA-Z]+\\s[a-zA-Z]+";
        Pattern regexPattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = regexPattern.matcher(name);

        return matcher.matches();
    }

    public static String getContact(Scanner scnr) {
        System.out.println("What is your contact information for your choice?");
        return scnr.nextLine();
    }
}