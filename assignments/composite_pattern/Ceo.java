package assignments.composite_pattern;

import java.util.ArrayList;
import java.util.List;

public class Ceo implements EmployeeNode{
    private final String name;
    private final String position;
    private List<Manager> team = new ArrayList<>();

    public Ceo(String name, String position){
        this.name = name;
        this.position = position;
    }

    public void add(Manager manager){
        team.add(manager);
    }

    public void display(){
        System.out.printf("(%s) %s \n", position, name);
        for (Manager manager : team) {
            manager.display("   ");
        }
    }

    public void display(String indentAmount){
        System.out.printf("%s(%s) %s \n", indentAmount, position, name);
        for (Manager manager : team) {
           manager.display(indentAmount + "   ");
        }
    }
}