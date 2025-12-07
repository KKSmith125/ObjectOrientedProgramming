package assignments.decorator_pattern;

public class Bold extends HtmlDecorator {
    public Bold(HtmlString htmlString) {
        super(htmlString);
    }
    
    public String toString() {
        return "<b>" + htmlString + "</b>";
    }
    
}
