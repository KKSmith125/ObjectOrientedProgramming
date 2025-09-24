package labs.command_pattern;

import java.util.Stack;

public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;
    Command[] volumeUpCommands;
    Command[] volumeDownCommands;
    Stack<Command> commandHistory;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];
        volumeUpCommands = new Command[7];
        volumeDownCommands = new Command[7];
        commandHistory = new Stack<>();
        Command noCommand = new NoCommand();

        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
            volumeUpCommands[i] = noCommand;
            volumeDownCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand, Command volumeUpCommand,
            Command volumeDownCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
        volumeUpCommands[slot] = volumeUpCommand;
        volumeDownCommands[slot] = volumeDownCommand;
    }

    public void onButton(int slot) {
        onCommands[slot].execute();
        commandHistory.push(onCommands[slot]);
    }

    public void offButton(int slot) {
        offCommands[slot].execute();
        commandHistory.push(offCommands[slot]);
    }

    public void volumeUpButton(int slot) {
        volumeUpCommands[slot].execute();
        commandHistory.push(volumeUpCommands[slot]);
    }

    public void volumeDownButton(int slot) {
        volumeDownCommands[slot].execute();
        commandHistory.push(volumeDownCommands[slot]);
    }

    public void undoButton() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
        } else {
            System.out.println("No action has been done yet.");
        }
    }

    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------- Remote Control -------\n");

        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName() + "    "
                    + offCommands[i].getClass().getName() + "    " + volumeUpCommands[i].getClass().getName() + "    "
                    + volumeDownCommands.getClass().getName() + "\n");
        }

        return stringBuff.toString();
    }
}
