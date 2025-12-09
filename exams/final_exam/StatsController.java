package exams.final_exam;

public class StatsController {
    Command[] moreHealthCommands;
    Command[] lessHealthCommands;
    Command[] moreXPCommands;

    public StatsController() {
        moreHealthCommands = new Command[7];
        lessHealthCommands = new Command[7];
        moreXPCommands = new Command[7];
        Command noCommand = new NoCommand();

        for (int i = 0; i < 7; i++) {
            moreHealthCommands[i] = noCommand;
            lessHealthCommands[i] = noCommand;
            moreXPCommands[i] = noCommand;
        }
    }   

    public void setCommand(int slot, Command moreHealthCommand, Command lessHealthCommand, Command moreXPCommand) {
        moreHealthCommands[slot] = moreHealthCommand;
        lessHealthCommands[slot] = lessHealthCommand;
        moreXPCommands[slot] = moreXPCommand;
    }

    public void increaseHealthButton(int slot, int amount) {
        moreHealthCommands[slot].execute(amount);
    }

    public void decreaseHealthButton(int slot, int amount) {
        lessHealthCommands[slot].execute(amount);
    }

    public void moreXPButton(int slot, int amount) {
        moreXPCommands[slot].execute(amount);
    }

    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("/n------Stats Controller------");

        for (int i = 0; i < moreHealthCommands.length; i++) {
            stringBuff.append("[slot " + i + "] " + moreHealthCommands[i].getClass().getName() + "    " + lessHealthCommands[i].getClass().getName() + "    " + moreXPCommands[i].getClass().getName() + "\n");
        }
        return stringBuff.toString();
    }
}