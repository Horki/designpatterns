package Structural.Proxy;

import java.io.Serializable;

public interface State extends Serializable {
    void insert();

    void eject();

    void turnCrank();

    void dispense();

    void refill();
}
