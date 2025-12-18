import com.phidget22.*;

public class HotOrCold {

    public static void main(String[] args) throws Exception {

        TemperatureSensor tempSensor = new TemperatureSensor();
        DigitalOutput greenLED = new DigitalOutput();
        DigitalOutput redLED = new DigitalOutput();

        // ---- Temperature Sensor ----
        // DO NOT set IsHubPortDevice for TemperatureSensor
        tempSensor.setHubPort(2);
        tempSensor.open(1000);

        // ---- Green LED ----
        greenLED.setHubPort(4);
        greenLED.setIsHubPortDevice(true);
        greenLED.open(1000);

        // ---- Red LED ----
        redLED.setHubPort(1);
        redLED.setIsHubPortDevice(true);
        redLED.open(1000);

        tempSensor.addTemperatureChangeListener(e -> {
            double temp = e.getTemperature();
            System.out.printf("Temperature: %.2f °C%n", temp);

            try {
                if (temp >= 20.0 && temp <= 24.0) {
                    greenLED.setState(true);
                    redLED.setState(false);
                } else {
                    greenLED.setState(false);
                    redLED.setState(true);
                }
            } catch (PhidgetException ex) {
                ex.printStackTrace();
            }
        });

        System.out.println("Temperature monitoring started...");
        Thread.sleep(Long.MAX_VALUE);
    }
}
