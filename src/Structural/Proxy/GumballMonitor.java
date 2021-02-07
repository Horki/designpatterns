package Structural.Proxy;

import java.rmi.RemoteException;

public class GumballMonitor {
    private final GumballMachineRemote machine;

    public GumballMonitor(GumballMachineRemote m) {
        machine = m;
    }

    public void report() {
        try {
            System.out.println("Gumball machine: " + machine.getLocation());
            System.out.println("Current inventory: " + machine.getCount() + " gumballs");
            System.out.println("Current state: " + machine.getState());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
