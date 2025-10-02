package assignments.iterator_pattern;

//Menu Interface for Iterable Menus
public interface Menu {
    public void addItem(String name, String description, boolean vegetarian, double price);

    public MyIterator createIterator();
}
