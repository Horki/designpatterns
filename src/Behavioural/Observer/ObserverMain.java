package Behavioural.Observer;

import Behavioural.Observer.Implements.CurrentConditionsDisplay;
import Behavioural.Observer.Implements.ForecastDisplay;
import Behavioural.Observer.Implements.HeatIndexDisplay;
import Behavioural.Observer.Implements.WeatherDataSubject;

public class ObserverMain {
    public static void main(String[] args) {
        System.out.println("Run Custom Observer==========");
        WeatherDataSubject s = new WeatherDataSubject();
        CurrentConditionsDisplay c = new CurrentConditionsDisplay(s);
        ForecastDisplay f = new ForecastDisplay(s);
        HeatIndexDisplay h = new HeatIndexDisplay(s);

        s.setMeasurements(80f, 65f, 30.4f);
        s.setMeasurements(82f, 70f, 29.2f);
        s.removeObserver(h);
        s.setMeasurements(78f, 90f, 29.2f);
        System.out.println("=============================");

    }
}
