package Structural.Proxy.States;

import Structural.Proxy.GumballMachine;
import Structural.Proxy.State;

public class SoldState implements State {
    private final transient GumballMachine gumballMachine;

    public SoldState(GumballMachine g) {
        gumballMachine = g;
    }

    @Override
    public void insert() {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    @Override
    public void eject() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball!");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("Oops, out of gumballs!");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }

    @Override
    public void refill() {
        //
    }

    public String toString() {
        return "Dispensing a Gumball";
    }
}
