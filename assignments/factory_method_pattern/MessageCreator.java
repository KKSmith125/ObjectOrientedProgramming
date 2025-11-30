//Creator (Abstract)
public abstract class MessageCreator {
    public Message sendMessage(String type, String name, String contactInformation) {
        return createMessage(type, contactInformation, name);
    }

    protected abstract Message createMessage(String type, String contactInformation, String name);
}
