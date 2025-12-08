package assignments.command_pattern;

public class PasteCommand implements Command {
    private Text text;
    private String clipBoard;
    private int start;

    public PasteCommand(Text text, int start) {
        this.text = text;
        this.start = start;
    }

    @Override
    public void execute() {
        clipBoard = text.getClipBoard();
        text.insert(start, clipBoard);
    }

    @Override
    public void undo() {
        text.delete(start, start + clipBoard.length());
    }

    @Override
    public void redo() {
        text.insert(start, clipBoard);
    }
}
