package assignments.command_pattern;

import java.util.Scanner;

public class TextEditor {
    public static void main(String[] args) {

        // Setting up the StringBuffer element
        StringBuffer currentBuffer = new StringBuffer("Hello! Welcome to my text editor program! \n");
        currentBuffer.append("We are going to learn about copying, cutting, and pasting. \n");
        currentBuffer.append("Are you ready to get started? \n");
        currentBuffer.append("We will only be interacting with the first instance of any text! \n");
        currentBuffer.append("Let's practice on this greeting!");

        // Create the Text, Keyboard, clipboard, and start index elements
        String currentText = currentBuffer.toString();
        Text text = new Text(currentText);
        Keyboard keyboard = new Keyboard();
        int start = 0;
        int end = 0;
        int paste = 0;

        // Get ready to handle user input
        Scanner inputScanner = new Scanner(System.in);
        String userInput;

        // Display Greeting
        System.out.println(currentText);

        // Copy setup
        System.out.println("\nPick a word in the greeting to copy!");
        userInput = inputScanner.nextLine();

        if (currentText.contains(userInput)) {
            start = text.getTextBlock().indexOf(userInput);
            end = start + userInput.length();
            keyboard.setCommand("copy", new CopyCommand(text, start, end));
            keyboard.pressKey("copy");
        } else {
            System.out.println("Could not find: " + userInput);
        }

        // Copy proof
        System.out.println("\nOur clip board");
        System.out.println("\"" + text.getClipBoard() + "\"");
        System.out.println("\nOur current text:");
        System.out.println(text.getTextBlock());

        // Cut setup
        System.out.println("\nPick a word in the greeting to cut!");
        userInput = inputScanner.nextLine();

        if (currentText.contains(userInput)) {
            start = text.getTextBlock().indexOf(userInput);
            end = start + userInput.length();
            keyboard.setCommand("cut", new CutCommand(text, start, end));
            keyboard.pressKey("cut");
        } else {
            System.out.println("Could not find: " + userInput);
        }

        // Cut proof
        System.out.println("\nOur clip board");
        System.out.println("\"" + text.getClipBoard() + "\"");
        System.out.println("\nOur current text:");
        System.out.println(text.getTextBlock());

        // Paste setup
        System.out.println("\nShould we paste our clipboard?");
        userInput = inputScanner.nextLine();

        if (userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("y")) {
            System.out.println("\nWhat index would you like to paste to?");
            paste = inputScanner.nextInt();
            inputScanner.nextLine();
            keyboard.setCommand("paste", new PasteCommand(text, paste));
            keyboard.pressKey("paste");
        }

        // Paste proof
        System.out.println("\nOur clip board");
        System.out.println("\"" + text.getClipBoard() + "\"");
        System.out.println("\nOur current text:");
        System.out.println(text.getTextBlock());

        // Next action setup
        while (true) {
            System.out.println("\nWhat would you like to do now 'copy'/'cut'/'paste'/'redo'/'undo'/'quit'?");
            userInput = inputScanner.nextLine();

            switch (userInput.toLowerCase()) {
                case "copy":
                    keyboard.pressKey("copy");
                    break;
                case "cut":
                    keyboard.pressKey("cut");
                    break;
                case "paste":
                    keyboard.pressKey("paste");
                    break;
                case "undo":
                    keyboard.undoKey();
                    break;
                case "redo":
                    keyboard.redoKey();
                    break;
                case "quit":
                    return;
                default:
                    System.out.println("Unknown command");
            }
            // Next action proof
            System.out.println("\nOur clip board");
            System.out.println("\"" + text.getClipBoard() + "\"");
            System.out.println("\nOur current text:");
            System.out.println(text.getTextBlock());
        }
    }
}