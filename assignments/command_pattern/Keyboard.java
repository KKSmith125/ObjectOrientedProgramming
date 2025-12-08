package assignments.command_pattern;

import java.util.Map;
import java.util.HashMap;

public class Keyboard {
    private Map<String, Command> keyBindings = new HashMap<>();
    private Command lastCommand = new NoCommand();
    private Command redoCommand = new NoCommand();

    public void setCommand(String key, Command command) {
        keyBindings.put(key, command);
    }

    public void pressKey(String key) {
        Command command = keyBindings.getOrDefault(key, new NoCommand());
        command.execute();
        lastCommand = command;
        redoCommand = new NoCommand();
    }

    public void undoKey() {
        lastCommand.undo();
        redoCommand = lastCommand;
        lastCommand = new NoCommand();
    }

    public void redoKey() {
        redoCommand.redo();
        lastCommand = redoCommand;
        redoCommand = new NoCommand();
    }
}