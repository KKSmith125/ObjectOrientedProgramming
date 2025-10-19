package assignments.command_pattern;

public class CutCommand implements Command {
    private Text text;
    private String removedText;
    private int start;
    private int end;

    public CutCommand(Text text, int start, int end) {
        this.text = text;
        this.start = start;
        this.end = end;
    }

    @Override
    public void execute() {
        removedText = text.cut(start, end);
    }

    @Override
    public void undo() {
        text.insert(start, removedText);
    }

    @Override
    public void redo() {
        execute();
    }
}
