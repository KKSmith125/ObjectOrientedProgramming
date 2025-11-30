//Product (Abstract)

public abstract class Message {
    String contactInformation;
    String name;
    String product = "car";

    public abstract void sendConfirmation();

    public String getContactInformation() {
        return contactInformation;
    }

    public String getName() {
        return name;
    }

    public String getProduct() {
        return product;
    }
}