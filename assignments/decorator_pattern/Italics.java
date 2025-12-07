package assignments.decorator_pattern;

public class Italics extends HtmlDecorator {
     public Italics(HtmlString htmlString) {
        super(htmlString);
    }
    
    public String toString() {
        return "<i>" + htmlString + "</i>";
    }
}
