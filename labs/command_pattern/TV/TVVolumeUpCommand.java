package labs.command_pattern.TV;

import labs.command_pattern.Command;

public class TVVolumeUpCommand implements Command {
    TV tv;

    public TVVolumeUpCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.up();
    }

    public void undo() {
        tv.down();
    }
}
