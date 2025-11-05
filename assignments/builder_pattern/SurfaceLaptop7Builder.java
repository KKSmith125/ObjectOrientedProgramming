package assignments.builder_pattern;

public class SurfaceLaptop7Builder implements IComputerBuilder {
    private String make = "not set";
    private String operatingSystem = "not set";
    private boolean graphicsOn = false;
    private boolean wifiOn = false;
    private boolean bluetoothOn = false;
    private boolean opticalDisc = false;

    public Computer getComputerInstance() {
        return new Computer(make, "Surface Laptop 7", "512 GB SSD", "16 GB LPDDR5", operatingSystem,
                "Intel Arc Graphics", graphicsOn, bluetoothOn, wifiOn, opticalDisc);
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
        bluetoothOn = false;
        opticalDisc = false;
    }
}