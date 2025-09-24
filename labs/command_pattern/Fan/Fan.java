package labs.command_pattern.Fan;

public class Fan {
    private static final int OFF = 0;
    private static final int LOW = 1;
    private static final int MED = 2;

    String name = "Fan";
    int setting = OFF;

    public Fan(String name, int setting) {
        this.name = name;
        this.setting = setting;
    }

    public void on() {
        setting = (setting + 1) % 4;
        System.out.println("The " + name + " is on " + getSettingName() + "!");
    }

    public void off() {
        setting = 0;
        System.out.println("The " + name + " is off!");
    }

    public String getSettingName() {
        if (setting == OFF) {
            return "off";
        } else if (setting == LOW) {
            return "low";
        } else if (setting == MED) {
            return "medium";
        } else {
            return "high";
        }
    }
}
