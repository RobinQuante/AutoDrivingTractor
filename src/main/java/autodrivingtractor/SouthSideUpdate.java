package autodrivingtractor;

import autodrivingtractor.grafik.SouthLine;
import com.pi4j.component.temperature.TemperatureSensor;
import com.pi4j.io.w1.W1Device;
import com.pi4j.io.w1.W1Master;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;


public class SouthSideUpdate implements Runnable {
    private Thread t;
    private SouthLine sl;
    private Config cfg;

    public SouthSideUpdate(SouthLine sl, Config cfg) {
        this.sl = sl;
        this.cfg = cfg;
    }
    public void run(){

        W1Master master = new W1Master();

    while (true) {
        try {
            System.out.println("SL Update start");
            double tempOil = 0d;
            double tempWater = 0d;
            if (master.getDevices().isEmpty()) return;
            if (cfg.getOilDevice() != null) {
                System.out.println("Temp Oil Value: "+ cfg.getOilDevice().getValue());
                tempOil = ((TemperatureSensor) cfg.getOilDevice()).getTemperature();
            } else {
                System.out.println("OilTempSensor Not Found:  #"+cfg.getOilDevice()+"#");
                for (String dev:master.getDeviceIDs()) {
                    System.out.println(dev);
                }

            }

            if (cfg.getWaterDevice() != null) {
                tempWater = ((TemperatureSensor) cfg.getWaterDevice()).getTemperature();
                System.out.println("Temp Water: "+ tempWater);
            } else {
                System.out.println("WaterTempSensor Not Found:  #"+cfg.getWaterDevice().getId()+"#");
                for (String dev:master.getDeviceIDs()) {
                    System.out.println(dev);
                }
            }
            System.out.println("update gui");
            sl.updateTemp(tempOil, tempWater);
            Thread.sleep(5000);
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            JOptionPane.showInputDialog(null, e.getMessage(), "Temperaturabfrage", JOptionPane.ERROR_MESSAGE);
        }
    }
    }

    public void start () {
        System.out.println("Starting SouthlineUpdate");
        if (t == null) {
            t = new Thread (this, "SouthlineUpdate");
            t.start ();
        }
    }
}

