package Structural.Proxy.Gumball.States;

import Structural.Proxy.Gumball.GumballMachineServer;
import Structural.Proxy.Gumball.State;

public class SoldOutState implements State {
    private final transient GumballMachineServer gumballMachine;

    public SoldOutState(GumballMachineServer g) {
        gumballMachine = g;
    }

    @Override
    public void insert() {
        System.out.println("You can't insert a quarter, the machine is sold out");
    }

    @Override
    public void eject() {
        System.out.println("You can't eject, you haven't inserted a quarter yet");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there are no gumballs");
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    @Override
    public void refill() {
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    public String toString() {
        return "Sold Out";
    }
}
