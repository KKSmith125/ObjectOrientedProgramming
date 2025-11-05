package assignments.builder_pattern;

public interface IComputerBuilder {
    public Computer getComputerInstance();

    public void setMake(String make);

    public void setOperatingSystem(String operatingSystem);

    public void setGraphicsCardEnabled(boolean graphicsOn);

    public void setWiFiEnabled(boolean wifiOn);

    public void setBluetoothEnabled(boolean bluetoothOn);

    public void setOpticalDiscDrive(boolean opticalDisc);

    public void reset();
}
