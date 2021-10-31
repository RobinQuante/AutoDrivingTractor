package autodrivingtractor.grafik;

import autodrivingtractor.SouthSideUpdate;

import javax.swing.*;
import java.awt.*;

public class SouthLine extends Container {


    JLabel tempOilValue;
    JLabel tempEngineValue;
    JLabel speedValue;
    JLabel diractionValue;
    JLabel rotationSpeedValue;

    public SouthLine(){
        this.setLayout(new GridLayout(2,5));
        JLabel tempOil = new JLabel("Öl Temperatur");
        JLabel tempEngine = new JLabel("Motor Temperatur");
        JLabel speed    = new JLabel("Geschwindigkeit");
        JLabel diraction = new JLabel("Ausrichtung");
        JLabel rotationSpeed = new JLabel("Umdrehung");
        tempOilValue = new JLabel();
        tempEngineValue = new JLabel();
        speedValue    = new JLabel();
        diractionValue = new JLabel();
        rotationSpeedValue = new JLabel();
        this.add(tempOil);
        this.add(tempEngine);
        this.add(speed);
        this.add(diraction);
        this.add(rotationSpeed);
        this.add(tempOilValue);
        this.add(tempEngineValue);
        this.add(speedValue);
        this.add(diractionValue);
        this.add(rotationSpeedValue);

    }

    public void update(double oilTemp, double engienTemp, double speed, int diraction){
        tempOilValue.setText(oilTemp + "°C");
        tempEngineValue.setText(engienTemp + "°C");
        speedValue.setText(speed + "km/H");
        diractionValue.setText(diraction + "");
    }

    public void updateTemp(double oilTemp, double engienTemp){
        tempOilValue.setText(oilTemp + "°C");
        tempEngineValue.setText(engienTemp + "°C");
    }

    public void updateRotationSpeed(int rotationSpeed){
        rotationSpeedValue.setText(rotationSpeed + "U/min");
    }


}
