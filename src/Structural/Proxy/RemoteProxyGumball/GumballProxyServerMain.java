package Structural.Proxy.Gumball;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class GumballProxyServerMain {
    public static void main(String[] args) throws RemoteException {
        System.out.println("run $ rmiregistry");
        try {
            GumballMachineServer gumballMachine = new GumballMachineServer("santafe.mightygumball.com", 100);
            Naming.rebind("//santafe.mightygumball.com/gumballmachine", gumballMachine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
