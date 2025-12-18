import com.phidget22.*;

public class Thermostat {

    private static int setTemperature = 21;

    public static void main(String[] args) throws Exception {

        // Temperature Sensor (NOT a hub-port device)
        TemperatureSensor temperatureSensor = new TemperatureSensor();
        temperatureSensor.open(1000);

        // Buttons
        DigitalInput greenButton = new DigitalInput();
        greenButton.setHubPort(5);
        greenButton.setIsHubPortDevice(true);

        DigitalInput redButton = new DigitalInput();
        redButton.setHubPort(0);
        redButton.setIsHubPortDevice(true);

        // LEDs
        DigitalOutput greenLED = new DigitalOutput();
        greenLED.setHubPort(4);
        greenLED.setIsHubPortDevice(true);

        DigitalOutput redLED = new DigitalOutput();
        redLED.setHubPort(1);
        redLED.setIsHubPortDevice(true);

        // Open devices
        greenButton.open(1000);
        redButton.open(1000);
        greenLED.open(1000);
        redLED.open(1000);

        // Button listeners
        greenButton.addStateChangeListener(e -> {
            if (e.getState()) {
                setTemperature++;
                System.out.println("Set temperature increased to " + setTemperature + "°C");
            }
        });

        redButton.addStateChangeListener(e -> {
            if (e.getState()) {
                setTemperature--;
                System.out.println("Set temperature decreased to " + setTemperature + "°C");
            }
        });

        // Main loop
        while (true) {

            double currentTemperature = temperatureSensor.getTemperature();

            System.out.println("Current Temperature: " + currentTemperature + "°C");
            System.out.println("Set Temperature: " + setTemperature + "°C");
            System.out.println("--------------------------------");

            if (Math.abs(currentTemperature - setTemperature) <= 2) {
                greenLED.setState(true);
                redLED.setState(false);
            } else {
                greenLED.setState(false);
                redLED.setState(true);
            }

            Thread.sleep(10000);
        }
    }
}
