package assignments.builder_pattern;

public class MacBookAirBuilder implements IComputerBuilder {
    private String make = "not set";
    private String operatingSystem = "not set";
    private boolean graphicsOn = false;
    private boolean wifiOn = false;
    private boolean opticalDisc = false;
    private boolean bluetoothOn = true;

    public Computer getComputerInstance() {
        return new Computer(make, "MacBook Air", "512 GB SSD", "16 GB Unified Memory", operatingSystem,
                "Apple M3 GPU", graphicsOn, bluetoothOn, wifiOn, opticalDisc);
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public void setGraphicsCardEnabled(boolean graphicsOn) {
        this.graphicsOn = graphicsOn;
    }

    public void setWiFiEnabled(boolean wifiOn) {
        this.wifiOn = wifiOn;
    }

    public void setBluetoothEnabled(boolean bluetoothOn) {
        this.bluetoothOn = bluetoothOn;
    }

    public void setOpticalDiscDrive(boolean opticalDisc) {
        this.opticalDisc = opticalDisc;
    }

    public void reset() {
        make = "not set";
        operatingSystem = "not set";
        graphicsOn = false;
        wifiOn = false;
        opticalDisc = false;
    }
}
