package assignments.iterator_pattern;

import java.util.NoSuchElementException;

//Concrete Iterator for Dinner
public class DinnerMenuIterator implements MyIterator {
    private int currentIndex = 0;
    private MenuItem[] menuItems;

    public DinnerMenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < menuItems.length;
    }

    @Override
    public MenuItem next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        MenuItem returnItem = menuItems[currentIndex];

        currentIndex += 1;

        return returnItem;
    }
}