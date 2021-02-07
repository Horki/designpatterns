package Structural.Proxy.Gumball.States;

import Structural.Proxy.Gumball.GumballMachine;
import Structural.Proxy.Gumball.State;

import java.util.Random;

public class HasQuarterState implements State {
    private final transient GumballMachine gumballMachine;
    private final Random randomWinner;

    public HasQuarterState(GumballMachine g) {
        gumballMachine = g;
        randomWinner = new Random(System.currentTimeMillis());
    }

    @Override
    public void insert() {
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void eject() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        int winner = randomWinner.nextInt(10);
        if ((winner == 0) && (gumballMachine.getCount() > 1)) {
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    @Override
    public void refill() {
        //
    }

    public String toString() {
        return "Waiting for turn of Crank";
    }
}
