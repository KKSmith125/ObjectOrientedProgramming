package assignments.iterator_pattern;

import java.util.List;

//Concrete Iterable Menu w/ ArrayList
public class BreakfastMenu implements Menu {
    private List<MenuItem> items;

    public BreakfastMenu(List<MenuItem> items) {
        this.items = items;
    }

    @Override
    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem item = new MenuItem(name, description, vegetarian, price);
        items.add(item);
    }

    @Override
    public BreakfastMenuIterator createIterator() {
        return new BreakfastMenuIterator(items);
    }
}