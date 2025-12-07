package assignments.decorator_pattern;
public abstract class HtmlDecorator {
    protected HtmlString htmlString;
    
    public HtmlDecorator(HtmlString htmlString) {
        this.htmlString = htmlString;
    }
}
