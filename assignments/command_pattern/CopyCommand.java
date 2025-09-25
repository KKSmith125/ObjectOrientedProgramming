package assignments.command_pattern;

public class CopyCommand implements Command {
    private Text text;
    private int start;
    private int end;

    public CopyCommand(Text text, int start, int end) {
        this.text = text;
        this.start = start;
        this.end = end;
    }

    @Override
    public void execute() {
        text.copy(start, end);
    }

    @Override
    public void undo() {
        // copying normally does not require an undo function
    }

    @Override
    public void redo() {
        // copying normally does not require an redo function
    }
}
