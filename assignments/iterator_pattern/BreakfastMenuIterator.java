package assignments.iterator_pattern;

import java.util.List;
import java.util.NoSuchElementException;

//Concrete Iterator for Breakfast
public class BreakfastMenuIterator implements MyIterator {
    private int currentIndex = 0;
    private List<MenuItem> menuItems;

    public BreakfastMenuIterator(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < menuItems.size();
    }

    @Override
    public MenuItem next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return menuItems.get(currentIndex++);
    }
}
