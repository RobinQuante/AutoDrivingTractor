package autodrivingtractor.inout;

import com.pi4j.io.gpio.*;

import autodrivingtractor.inout.TractorFunctions;

public class TractorFunctions {

    static final int LiftUp = 1;
    static final int LiftDown = -1;
    static final int LiftStop = 0;
    final GpioPinDigitalOutput worklight;
    final GpioPinDigitalOutput cutterMain;
    final GpioPinDigitalOutput cutterMainDamping;
    final GpioPinDigitalOutput cutterLeftOnly;
    final GpioPinDigitalOutput cutterMainUp;
    final GpioPinDigitalOutput cutterMainDown;
    final GpioPinDigitalOutput cutterRightUp;
    final GpioPinDigitalOutput cutterRightDown;
    final GpioPinDigitalOutput cutterLeftUp;
    final GpioPinDigitalOutput cutterLeftDown;

    final GpioPinDigitalOutput drivingFast;
    final GpioPinDigitalOutput allWheel;
    final GpioPinDigitalOutput horn;
    final GpioPinDigitalOutput standingLight;
    final GpioPinDigitalOutput drivingLight;
    final GpioPinDigitalOutput hydraulik;

    public TractorFunctions() {
        final GpioController gpio = GpioFactory.getInstance();
        allWheel = gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_02, "Alrad ein", PinState.LOW);
        drivingFast = gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_03, "Schnellgang", PinState.LOW);
        standingLight = gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_12, "Standlicht", PinState.LOW);
        drivingLight = gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_13, "Fahrlicht", PinState.LOW);
        worklight = gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_14, "Arbeitslicht", PinState.LOW);
        cutterMainUp = gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_21, "Schneidwerk heben", PinState.LOW);
        cutterMainDown = gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_22, "Schneidwerk Senken", PinState.LOW);
        cutterMainDamping = gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_23, "Schneidwerk Links", PinState.LOW);
        cutterLeftUp = gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_24, "Links Heben", PinState.LOW);
        cutterLeftDown = gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_25, "Links Senken", PinState.LOW);

        //Rechte Pinreihe
        cutterMain = gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_04, "Schneidwerk An", PinState.LOW);
        cutterLeftOnly = gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_05, "Schneidwerk Links", PinState.LOW);
        horn = gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_06, "Hupe", PinState.LOW);
        // RotationSpeed GPIO 26
        cutterRightUp = gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_27, "Rechts Heben", PinState.LOW);
        cutterRightDown = gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_28, "Rechts Senken", PinState.LOW);
        hydraulik = gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_29, "Hydraulik", PinState.LOW);




    }

    public void cutterMainLift(int diraction) {
        switch (diraction) {
            case LiftUp:
                cutterMainUp.high();
                cutterMainDown.low();
                break;
            case LiftDown:
                cutterMainUp.low();
                cutterMainDown.high();
                break;
            default:
                cutterMainUp.low();
                cutterMainDown.low();
        }
    }

    public void cutterRightLift(int diraction) {
        switch (diraction) {
            case LiftUp:
                cutterRightUp.high();
                cutterRightDown.low();
                break;
            case LiftDown:
                cutterRightUp.low();
                cutterRightDown.high();
                break;
            default:
                cutterRightUp.low();
                cutterRightDown.low();
        }
    }


    public void cutterLeftLift(int diraction) {
        switch (diraction) {
            case LiftUp:
                cutterLeftUp.high();
                cutterLeftDown.low();
                break;
            case LiftDown:
                cutterLeftUp.low();
                cutterLeftDown.high();
                break;
            default:
                cutterLeftUp.low();
                cutterLeftDown.low();
        }
    }
    public void setWorklight(Boolean stat) {
        if (stat){
            worklight.high();
        } else {
            worklight.low();
        }
    }

    public void setCutterMain(Boolean stat) {

        if (stat){
            cutterMain.high();
        } else {
            cutterMain.low();
        }
    }

    public void setCutterleftonly(Boolean stat) {
        if (stat){
            cutterLeftOnly.high();
        } else {
            cutterLeftOnly.low();
        }
    }

    public void setDrivingfast(Boolean stat) {
        if (stat){
            drivingFast.high();
        } else {
            drivingFast.low();
        }
    }

    public void setAllwheel(Boolean stat) {
        if (stat){
            allWheel.high();
        } else {
            allWheel.low();
        }
    }


    public void setHorn(Boolean stat) {
        if (stat){
            horn.high();
        } else {
            horn.low();
        }
    }

    public void setStandinglight(Boolean stat) {
        if (stat){
            standingLight.high();
        } else {
            standingLight.low();
        }
    }

    public void setCutterMainDamping(Boolean stat){
        if (stat){
            cutterMainDamping.high();
        } else {
            cutterMainDamping.low();
        }
    }

    public void setDrivinglight(Boolean stat) {
        if (stat){
            drivingLight.high();
        } else {
            drivingLight.low();
        }
    }

    public void setHydraulik(Boolean stat){
        if (stat){
            hydraulik.high();
        } else {
            hydraulik.low();
        }
    }
}