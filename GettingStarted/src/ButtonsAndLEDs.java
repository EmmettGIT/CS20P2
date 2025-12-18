
//Add Phidgets Library | You added a file called phidget22 when configuring your project. Import gives you access to the Phidgets library code inside that file. 
import com.phidget22.*;

public class ButtonsAndLEDs {
    //Handle Exceptions | Exceptions will happen in your code from time to time. These are caused by unexpected things happening. Make sure you’ve added "throws Exception" to your main method.
    public static void main(String[] args) throws Exception{

        //Create | Create objects for your buttons and LEDs.
        DigitalInput redButton = new DigitalInput();
        DigitalOutput redLED = new DigitalOutput();
        DigitalInput greenButton = new DigitalInput();
        DigitalOutput greenLED = new DigitalOutput();

        //Address | Address your four objects which lets your program know where to find them.
        redButton.setHubPort(0);
        redButton.setIsHubPortDevice(true);
        redButton.open(1000);
        redLED.setHubPort(1);
        redLED.setIsHubPortDevice(true);
        redLED.open(1000);
        greenButton.setHubPort(5);
        greenButton.setIsHubPortDevice(true);
        greenButton.open(1000);
        greenLED.setHubPort(4);
        greenLED.setIsHubPortDevice(true);
        greenLED.open(1000);

        //Use your Phidgets | This code will turn on the LED when the matching button is pressed and turns off the LED when the matching button is released. The sleep function slows down the loop so the button state is only checked every 150ms.
        while(true){

            if( redButton.getState()){
                redLED.setState(true);
            } else {
                redLED.setState(false);
            }

            if(greenButton.getState()){
                greenLED.setState(true);
            } else {
                greenLED.setState(false);
            }

            Thread.sleep(150);
        }
    }
}
  