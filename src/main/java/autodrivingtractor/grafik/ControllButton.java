package autodrivingtractor.grafik;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import autodrivingtractor.inout.Sequenz;

import java.awt.*;
import java.awt.event.ActionListener;

public class ControllButton extends Container {

    JButton buttonDown;
    JButton buttonUp;
    JButton buttonStop;
    public ControllButton(String text){
        this.setLayout(new GridLayout(3,1));
        buttonUp = new JButton("AUF");
        buttonDown = new JButton("AB");
        buttonStop = new JButton(text + " STOP");
        buttonDown.setIcon(new ImageIcon("src/main/resources/icons/arrowDown.png"));
        buttonUp.setIcon(new ImageIcon("src/main/resources/icons/arrowUp.png"));
        buttonStop.setIcon(new ImageIcon("src/main/resources/icons/stop.png"));
        this.add(buttonUp);
        this.add(buttonStop);
        this.add(buttonDown);
        buttonStop.setBackground(Color.RED);
    }

    public int getDirection(Object obj){
        if(obj == buttonUp) {return 1;}
        if(obj == buttonDown) {return -1;}
        return 0;
    }

    public void setActionListener(ActionListener event){
        buttonDown.addActionListener(event);
        buttonUp.addActionListener(event);
        buttonStop.addActionListener(event);
    }

    public JButton getButtonUp(){
        return buttonUp;
    }

    public JButton getButtonDown(){
        return buttonDown;
    }

    public JButton getButtonStop(){
        return buttonStop;
    }

}
