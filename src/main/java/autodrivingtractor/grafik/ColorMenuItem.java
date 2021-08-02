package autodrivingtractor.grafik;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Method;

public class ColorMenuItem extends JMenuItem {
    public Color colorOn= new Color(0,255,0,100);
    public Color colorOff= new Color(255,0,0,100);
    Method method;

    public ColorMenuItem(String text, Method method){
        super(text);
        this.method = method;
        this.setBackground(colorOff);
    }

    public void toggleColor(){
        if (this.getBackground() == colorOff){
            this.setBackground(colorOn);
        } else {
            this.setBackground(colorOff);
        }
    }

}
