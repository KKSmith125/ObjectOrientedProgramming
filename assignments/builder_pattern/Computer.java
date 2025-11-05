package assignments.builder_pattern;

public class Computer {
    private String make;
    private String model;
    // required parameters
    // Example 300 GB
    private String hardDriveSize;
    // Example 16 GB
    private String memoryRAM;
    private String operatingSystem;
    private String graphicsCard;

    // optional parameters
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;
    private boolean isWiFiEnabled;
    private boolean opticalDiscDrive;

    public Computer(String make, String model, String hardDriveSize, String memoryRAM, String operatingSystem,
            String graphicsCard, boolean isGraphicsCardEnabled, boolean isBluetoothEnabled, boolean isWiFiEnabled,
            boolean opticalDiscDrive) {
        this.make = make;
        this.model = model;
        this.hardDriveSize = hardDriveSize;
        this.memoryRAM = memoryRAM;
        this.operatingSystem = operatingSystem;
        this.graphicsCard = graphicsCard;
        this.isGraphicsCardEnabled = isGraphicsCardEnabled;
        this.isBluetoothEnabled = isBluetoothEnabled;
        this.isWiFiEnabled = isWiFiEnabled;
        this.opticalDiscDrive = opticalDiscDrive;
    }

    public String toString() {
        return "This " + make + " " + model + " has a " + operatingSystem
                + " operating system and the following specs:\n" +
                "Hard Drive Size: " + hardDriveSize + "\nMemory: " + memoryRAM + "\nGraphics Card: " + graphicsCard +
                "\nGraphics Card Enabled: " + isGraphicsCardEnabled + "\nBluetooth Enabled: " + isBluetoothEnabled
                + "\nWifi Enabled: " + isWiFiEnabled + "\nOptical Disc Drive: " + opticalDiscDrive;
    }

}