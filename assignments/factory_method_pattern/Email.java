import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email extends Message {
    public Email(String contactInformation, String name) {
        if (!name.equals("")) {
            this.name = name;
        } else {
            this.name = "Customer";
        }

        this.contactInformation = contactInformation;
    }

    @Override
    public void sendConfirmation() {
        System.out.println("We are sending an email to " + name + " at " + contactInformation);
    }

    public static boolean emailVerification(String contactInformation) {
        // Formats
        // something@somplace.dotcom
        String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern regexPattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = regexPattern.matcher(contactInformation);

        return matcher.matches();
    }
}