import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SMS extends Message {
    public SMS(String contactInformation, String name) {
        this.name = name;
        this.contactInformation = contactInformation;
    }

    @Override
    public void sendConfirmation() {
        System.out.println("We are sending an sms to " + name + " at " + contactInformation);
    }

    public static boolean smsVerification(String contactInformation) {
        // Formats
        // 1234567890, 123-456-7890, (123)456-7890 or (123)4567890
        String regex = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
        Pattern regexPattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = regexPattern.matcher(contactInformation);

        return matcher.matches();
    }
}
