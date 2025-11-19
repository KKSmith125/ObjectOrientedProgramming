package assignments.decorator_pattern;

public class Strikethrough extends HtmlDecorator {
     public Strikethrough(HtmlString htmlString) {
        super(htmlString);
    }
    
    public String toString() {
        return "<s>" + htmlString + "</s>";
    }
}
