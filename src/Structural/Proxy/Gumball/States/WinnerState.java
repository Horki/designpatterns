package Structural.Proxy.Gumball.States;

import Structural.Proxy.Gumball.GumballMachineServer;
import Structural.Proxy.Gumball.State;

public class WinnerState implements State {
    private final transient GumballMachineServer gumballMachine;

    public WinnerState(GumballMachineServer g) {
        gumballMachine = g;
    }

    @Override
    public void insert() {
        System.out.println("Please wait, we're already giving you a Gumball");

    }

    @Override
    public void eject() {
        System.out.println("Please wait, we're already giving you a Gumball");

    }

    @Override
    public void turnCrank() {
        System.out.println("Turning again doesn't get you another gumball!");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() == 0) {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        } else {
            gumballMachine.releaseBall();
            System.out.println("YOU'RE A WINNER! You got two gumballs for your quarter");
            if (gumballMachine.getCount() > 0) {
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            } else {
                System.out.println("Oops, out of gumballs!");
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        }
    }

    @Override
    public void refill() {
        //
    }

    public String toString() {
        return "Dispensing two gumballs for your quarter, because YOU'RE A WINNER!";
    }
}