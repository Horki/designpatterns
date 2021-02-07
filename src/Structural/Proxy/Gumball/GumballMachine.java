package Structural.Proxy.Gumball;

import Structural.Proxy.Gumball.States.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {
    private final String location;
    private int count;
    private State state;
    private final State soldOutState;
    private final State noQuarterState;
    private final State hasQuarterState;
    private final State soldState;
    private final State winnerState;

    public GumballMachine(String l, int c) throws RemoteException {
        location = l;
        count = c;
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);

        state = soldOutState;
        if (count > 0) {
            state = noQuarterState;
        }
    }

    public String getLocation() {
        return location;
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

    public void setState(State s) {
        state = s;
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count > 0) {
            --count;
        }
    }

    public int getCount() {
        return count;
    }

    public void refill(int c) {
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
        result.append("Machine is ").append(state).append("\n");
        return result.toString();
    }
}
