public class Server extends MessageCreator {
    @Override
    protected Message createMessage(String type, String name, String contactInformation) {
        Message message = null;

        if (type.equals("email")) {
            message = new Email(contactInformation, name);
        } else if (type.equals("sms")) {
            message = new SMS(contactInformation, name);
        } else if (type.equals("mail")) {
            message = new Mail(contactInformation, name);
        }

        return message;
    }
}
