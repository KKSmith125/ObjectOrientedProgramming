package assignments.command_pattern;

public interface Command {
    void execute();

    void undo();

    void redo();
}
