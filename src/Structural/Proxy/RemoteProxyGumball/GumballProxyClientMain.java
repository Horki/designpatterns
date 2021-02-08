package Structural.Proxy.Gumball;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class GumballProxyClientMain {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        String[] location = {
                "rmi://santafe.mightygumball.com/gumballmachine",
//                "rmi://boulder.mightygumball.com/gumballmachine",
//                "rmi://austin.mightygumball.com/gumballmachine"
        };
        System.out.println("Run GumballProxyClientMain");
        GumballMonitor[] monitor = new GumballMonitor[location.length];
        for (int i = 0; i < location.length; ++i) {
            try {
                System.out.println(location[i]);
                GumballMachineServer machine =
                        (GumballMachineServer) Naming.lookup(location[i]);
                System.out.println(machine.getCount());
                monitor[i] = new GumballMonitor(machine);
                System.out.println(monitor[i]);
            } catch (RemoteException | MalformedURLException | NotBoundException e) {
                e.printStackTrace();
            }
        }
        System.out.println("tusam");

        for (GumballMonitor gumballMonitor : monitor) {
            gumballMonitor.report();
        }
    }
}
