package assignments.iterator_pattern;

import java.util.ArrayList;
import java.util.List;

//Main
public class MenuTest {
    public static void main(String[] args) {
        List<MenuItem> breakfastList = new ArrayList<>();

        breakfastList.add(new MenuItem("Pancakes", "Sweet Circle Bread", false, 10));
        breakfastList.add(new MenuItem("Eggs", "Non-Meat Protein", false, 8));

        Menu dinnerMenu = new DinnerMenu(new MenuItem[] {
                new MenuItem("Sushi", "Fish", false, 10),
                new MenuItem("Chicken Tenders", "Battered Chicken", false, 10)
        });

        Menu breakfastMenu = new BreakfastMenu(breakfastList);
        Waiter waiter = new Waiter(breakfastMenu, dinnerMenu); // Client

        waiter.printMenu();
    }
}
