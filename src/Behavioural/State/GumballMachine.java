package Behavioural.State;

public class GumballMachine {
    private final State soldOutState;
    private final State noQuarterState;
    private final State hasQuarterState;
    private final State soldState;
    private final State winnerState;

    private State state;
    private int count;

    public GumballMachine(int n) {
        count = 0;
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);

        state = soldOutState;
        count = n;
        if (count > 0) {
            state = noQuarterState;
        }
    }

    public void insert() {
        state.insert();
    }

    public void eject() {
        state.eject();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    void setState(State s) {
        state = s;
    }

    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count > 0) {
            --count;
        }
    }

    int getCount() {
        return count;
    }

    void refill(int c) {
        count += c;
        System.out.println("The gumball machine was just refilled; its new count is: " + count);
        state.refill();
    }

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004");
        result.append("\nInventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is " + state + "\n");
        return result.toString();
    }
}
