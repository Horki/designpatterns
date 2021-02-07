package Structural.Proxy;

import java.rmi.Naming;

public class ProxyMain {
    public static void main(String[] args) {
        String[] location = {
                "rmi://santafe.mightygumball.com/gumballmachine",
                "rmi://boulder.mightygumball.com/gumballmachine",
                "rmi://austin.mightygumball.com/gumballmachine"
        };
        System.out.println("run $ rmiregistry");
        GumballMonitor[] monitor = new GumballMonitor[location.length];
        for (int i = 0; i < location.length; ++i) {
            try {
                System.out.println(location[i]);
                GumballMachineRemote machine =
                        (GumballMachineRemote) Naming.lookup(location[i]);
                monitor[i] = new GumballMonitor(machine);
                System.out.println(monitor[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < monitor.length; ++i) {
            monitor[i].report();
        }
    }
}
