package autodrivingtractor.grafik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Method;

public class ColorButton extends JToggleButton implements ItemListener {


    public Color colorOn= new Color(0,255,0,100);
    public Color colorOff= new Color(255,0,0,100);
    public ColorButton(String text){
        super(text);
        this.setBackground(colorOff);
        this.setPreferredSize(new Dimension(60, 48));
        this.addItemListener(this);
        setSize(new Dimension(60, 48));
    }

    public void itemStateChanged(ItemEvent eve) {
        if(this.isSelected()) {
            this.setBackground(colorOn);
            System.out.println("Set Color of " + this.getText() + " to red");
        } else {
            this.setBackground(colorOff);
        System.out.println("Set Color of " + this.getText() + " to green");}
        this.repaint();
        this.validate();
    }

}
