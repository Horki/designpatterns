package Behavioural.Observer;

import Behavioural.Observer.ImplementsJava.CurrentConditions;
import Behavioural.Observer.ImplementsJava.Forecast;
import Behavioural.Observer.ImplementsJava.HeatIndex;
import Behavioural.Observer.ImplementsJava.WeatherData;

public class ObserverAPIMain {
    public static void main(String[] args) {
        System.out.println("Run JAVA API Observer========");
        WeatherData w = new WeatherData();
        CurrentConditions c = new CurrentConditions(w);
        Forecast f = new Forecast(w);
        HeatIndex h = new HeatIndex(w);

        w.setMeasurements(80f, 65f, 30.4f);
        w.setMeasurements(82f, 70f, 29.2f);
        w.deleteObserver(h);
        w.setMeasurements(78f, 90f, 29.2f);
        System.out.println("=============================");
    }
}
