import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mail extends Message {
    public Mail(String contactInformation, String name) {
        this.name = name;
        this.contactInformation = contactInformation;
    }

    @Override
    public void sendConfirmation() {
        System.out.println(
                "We are sending mail to " + name + " at " + contactInformation + ". It will take some time to verify");
    }

    public static boolean mailVerification(String contactInformation) {
        // Format:
        // 1 Main Street, North Adams, MA 12345
        String regex = "^(\\d{1,}) [a-zA-Z0-9\\s]+(\\,)? [a-zA-Z\\s]+(\\,)? [A-Z]{2} [0-9]{5,6}$";
        Pattern regexPattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = regexPattern.matcher(contactInformation);

        return matcher.matches();
    }
}
