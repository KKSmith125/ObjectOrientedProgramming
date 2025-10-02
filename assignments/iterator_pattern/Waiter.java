package assignments.iterator_pattern;

// The Client
public class Waiter {
    private Menu breakfastMenu;
    private Menu dinnerMenu;

    public Waiter(Menu breakfastMenu, Menu dinnerMenu) {
        this.breakfastMenu = breakfastMenu;
        this.dinnerMenu = dinnerMenu;
    }

    public void printMenu() {
        System.out.println("------ Breakfast ------");
        printMenu(breakfastMenu.createIterator());
        System.out.println("------ Dinner ------");
        printMenu(dinnerMenu.createIterator());
    }

    public void printMenu(MyIterator myIterator) {
        while (myIterator.hasNext()) {
            MenuItem item = myIterator.next();
            System.out.println("Item: " + item.getName());
            System.out.println("Description: " + item.getDescription());
            System.out.println("Price: $" + item.getPrice());
            if (item.isVegertarian() == true) {
                System.out.println("Vegetarian: Yes");
            } else {
                System.out.println("Vegetarian: No");
            }
            System.out.println();
        }
    }
}