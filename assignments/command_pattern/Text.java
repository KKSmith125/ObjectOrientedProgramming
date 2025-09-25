package assignments.command_pattern;

public class Text {
    private StringBuilder textBlock = new StringBuilder();
    private String clipBoard = "";

    public Text(String initialTextBlock) {
        this.textBlock.append(initialTextBlock);
    }

    public String getClipBoard() {
        return clipBoard;
    }

    public void setClipBoard(String text) {
        this.clipBoard = text;
    }

    public String getTextBlock() {
        return textBlock.toString();
    }

    public String copy(int start, int end) {
        clipBoard = textBlock.substring(start, end);
        return clipBoard;
    }

    public String cut(int start, int end) {
        clipBoard = textBlock.substring(start, end);
        textBlock.delete(start, end);
        return clipBoard;
    }

    public void insert(int start, String word) {
        textBlock.insert(start, word);
    }

    public void delete(int start, int end) {
        textBlock.delete(start, end);
    }
}
