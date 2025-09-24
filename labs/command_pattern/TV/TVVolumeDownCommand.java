package labs.command_pattern.TV;

import labs.command_pattern.Command;

public class TVVolumeDownCommand implements Command {
    TV tv;

    public TVVolumeDownCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.down();
    }

    public void undo() {
        tv.up();
    }
}
