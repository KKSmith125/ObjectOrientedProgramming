package assignments.state_pattern;

//State Interface
//Should showcase actions on the state only
public interface GumballMachineState {
    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();

    String getStateToString();
}
