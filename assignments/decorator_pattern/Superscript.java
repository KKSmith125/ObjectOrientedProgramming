package assignments.decorator_pattern;

public class Superscript extends HtmlDecorator {
    public Superscript(HtmlString htmlString) {
        super(htmlString);
    }
    
    public String toString() {
        return "<sup>" + htmlString + "</sup>";
    }
}
