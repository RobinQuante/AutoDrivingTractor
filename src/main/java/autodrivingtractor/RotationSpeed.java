package autodrivingtractor;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.trigger.GpioCallbackTrigger;
import com.pi4j.io.gpio.trigger.GpioTrigger;
import autodrivingtractor.grafik.SouthLine;

import java.util.List;
import java.util.concurrent.Callable;

public class RotationSpeed extends Thread{

    long time;
    public RotationSpeed(SouthLine sl, Pin raspiPin){

                // create gpio controller
                final GpioController gpio = GpioFactory.getInstance();

                // provision gpio pin #02 as an input pin with its internal pull down resistor enabled
                time = System.nanoTime();
                final GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(raspiPin , PinPullResistance.PULL_DOWN);

        myButton.addTrigger(new GpioCallbackTrigger(new Callable<Void>() {
            public Void call() throws Exception {
                sl.updateRotationSpeed((int)(60000000000l/(System.nanoTime() - time)));
                time = System.nanoTime();
                return null;
            }
        }));



        }

    }

