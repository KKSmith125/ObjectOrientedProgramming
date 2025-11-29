package assignments.builder_pattern;

public class ComputerDirector {
    public Computer createMicrosoftComputer(IComputerBuilder builder) {
        builder.reset();
        builder.setMake("Microsoft");
        builder.setOperatingSystem("Windows 11 Home");
        builder.setWiFiEnabled(true);
        builder.setBluetoothEnabled(true);
        builder.setGraphicsCardEnabled(true);
        builder.setOpticalDiscDrive(false);

        return builder.getComputerInstance();
    }

    public Computer createAppleComputer(IComputerBuilder builder) {
        builder.reset();
        builder.setMake("MAC");
        builder.setOperatingSystem("macOS Sonoma");
        builder.setWiFiEnabled(true);
        builder.setOpticalDiscDrive(false);
        builder.setGraphicsCardEnabled(true);

        return builder.getComputerInstance();
    }
}
