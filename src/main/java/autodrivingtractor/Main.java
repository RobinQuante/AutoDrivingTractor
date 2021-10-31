package autodrivingtractor;

import com.pi4j.io.gpio.RaspiPin;
import autodrivingtractor.grafik.Frame;
import autodrivingtractor.grafik.SouthLine;


public class Main {

    public static void main(String[] args) {
        Frame frame = new Frame();
        //RotationSpeed rotationThread = new RotationSpeed(frame.getSouthLine(), RaspiPin.GPIO_26);
        //rotationThread.start();
    }
}
