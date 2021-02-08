package Structural.Proxy.Gumball.States;

import Structural.Proxy.Gumball.GumballMachineServer;
import Structural.Proxy.Gumball.State;

public class NoQuarterState implements State {
    private final transient GumballMachineServer gumballMachine;

    public NoQuarterState(GumballMachineServer g) {
        gumballMachine = g;
    }

    @Override
    public void insert() {
        System.out.println("You inserted a quarter");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void eject() {
        System.out.println("You haven't inserted a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there's no quarter");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first");
    }

    @Override
    public void refill() {
        //
    }

    public String toString() {
        return "Waiting for a Quarter";
    }
}
