package Behavioural.Observer;

import Behavioural.Observer.Implements.CurrentConditionsDisplay;
import Behavioural.Observer.Implements.ForecastDisplay;
import Behavioural.Observer.Implements.HeatIndexDisplay;
import Behavioural.Observer.Implements.WeatherDataSubject;
import Behavioural.Observer.ImplementsJava.CurrentConditions;
import Behavioural.Observer.ImplementsJava.Forecast;
import Behavioural.Observer.ImplementsJava.HeatIndex;
import Behavioural.Observer.ImplementsJava.WeatherData;

public class ObserverMain {
    private static void runCustom() {
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

    private static void runJavaApi() {
        System.out.println("Run JAVA Observer============");
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

    public static void main(String[] args) {
        runCustom();
        runJavaApi();
    }
}
