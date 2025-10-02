package assignments.state_pattern;

public class GumballMachine {
    private GumballMachineState soldOutState;
    private GumballMachineState noQuarterState;
    private GumballMachineState hasQuarterState;
    private GumballMachineState soldState;
    private GumballMachineState winnerState;

    private int count = 0;
    private GumballMachineState currentState;

    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);

        this.count = numberGumballs;

        currentState = (numberGumballs > 0) ? noQuarterState : soldOutState;
    }

    public void setState(GumballMachineState currentState) {
        this.currentState = currentState;
    }

    public void insertQuarter() {
        currentState.insertQuarter();
    }

    public void ejectQuarter() {
        currentState.ejectQuarter();
    }

    public void turnCrank() {
        currentState.turnCrank();
        currentState.dispense();
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count > 0) {
            count = count - 1;
        }
    }

    public int getCount() {
        return count;
    }

    public GumballMachineState getNoQuarterState() {
        return noQuarterState;
    }

    public GumballMachineState getHasQuarterState() {
        return hasQuarterState;
    }

    public GumballMachineState getSoldOutState() {
        return soldOutState;
    }

    public GumballMachineState getSoldState() {
        return soldState;
    }

    public GumballMachineState getWinnerState() {
        return winnerState;
    }

    public void refill(int count) {
        this.count += count;
        System.out.println("The gumball machine was just refilled; its new count is: " + this.count);
        if (currentState == soldOutState) {
            currentState = noQuarterState;
        }
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004");
        result.append("\nInventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is " + currentState.getStateToString() + "\n");
        return result.toString();
    }
}