package assignments.iterator_pattern;

//Concrete Iterable w/ Array
public class DinnerMenu implements Menu {
    private int capacity = 0;
    private MenuItem[] items = new MenuItem[capacity];

    public DinnerMenu(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem item = new MenuItem(name, description, vegetarian, price);
        MenuItem[] increase = new MenuItem[capacity + 1];

        for (int i = 0; i < increase.length; i++) {
            if (i != increase.length) {
                increase[i] = items[i];
            } else {
                increase[i] = item;
            }
        }
    }

    @Override
    public DinnerMenuIterator createIterator() {
        return new DinnerMenuIterator(items);
    }
}
