// Add Phidgets Library
import com.phidget22.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class ThumbStick {
    public static void main(String[] args) throws Exception {

        // Create thumbstick and button inputs
        DigitalInput numberButton = new DigitalInput(); // your existing number-cycling button
        DigitalInput leftClickButton = new DigitalInput();
        DigitalInput rightClickButton = new DigitalInput();
        VoltageRatioInput horizontal = new VoltageRatioInput();
        VoltageRatioInput vertical = new VoltageRatioInput();

        // Set channels
        vertical.setChannel(1);
        horizontal.setChannel(2);
        numberButton.setChannel(3); // your previous number button (change as needed)
        rightClickButton.setChannel(0); // right click on port 0
        leftClickButton.setChannel(5);  // left click on port 5

        // Open
        vertical.open(1000);
        horizontal.open(1000);
        numberButton.open(1000);
        rightClickButton.open(1000);
        leftClickButton.open(1000);

        // Create Robot for mouse and keyboard
        Robot robot = new Robot();

        // Sensitivity and deadzone
        double sensitivity = 25.0;
        double deadZone = 0.03;

        // Number cycling
        int currentNumber = 1;
        boolean lastNumberButtonState = false;
        boolean lastLeftClickState = false;
        boolean lastRightClickState = false;

        while (true) {
            // Read thumbstick
            double x = horizontal.getVoltageRatio();
            double y = vertical.getVoltageRatio();
            if (Math.abs(x) < deadZone) x = 0;
            if (Math.abs(y) < deadZone) y = 0;

            // Move cursor
            PointerInfo info = MouseInfo.getPointerInfo();
            Point p = info.getLocation();
            int moveX = (int)(x * sensitivity);
            int moveY = (int)(y * sensitivity);
            robot.mouseMove(p.x + moveX, p.y + moveY);

            // Number button (cycle 1-9)
            boolean numberButtonState = numberButton.getState();
            if (numberButtonState && !lastNumberButtonState) {
                int keycode = KeyEvent.VK_0 + currentNumber;
                robot.keyPress(keycode);
                robot.keyRelease(keycode);

                currentNumber++;
                if (currentNumber > 9) currentNumber = 1;
            }
            lastNumberButtonState = numberButtonState;

            // Left click button
            boolean leftState = leftClickButton.getState();
            if (leftState && !lastLeftClickState) {
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            }
            lastLeftClickState = leftState;

            // Right click button
            boolean rightState = rightClickButton.getState();
            if (rightState && !lastRightClickState) {
                robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
            }
            lastRightClickState = rightState;

            Thread.sleep(10); // loop every 10ms
        }
    }
}
