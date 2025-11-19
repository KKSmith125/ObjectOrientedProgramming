package assignments.decorator_pattern;

public class HtmlTagTest {
    public static void main(String[] args) {
        HtmlString helloWorld = new HtmlString("Hello World");
        Bold boldText = new Bold(new HtmlString("Bold"));
        Italics italicsText = new Italics(new HtmlString("Italics"));
        Strikethrough strikethroughText = new Strikethrough(new HtmlString("Strikethrough"));
        Superscript superscriptText = new Superscript(new HtmlString("Superscript"));

        System.out.println(helloWorld);
        System.out.println(boldText);
        System.out.println(italicsText);
        System.out.println(strikethroughText);
        System.out.println(superscriptText);
    }

}