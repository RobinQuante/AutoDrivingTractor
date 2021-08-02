package autodrivingtractor.grafik;

import javax.swing.*;
import java.awt.*;

public class Menubar extends JMenuBar {

    public Menubar(){
        this.add(getDatei());
        this.add(getInfo());

    }

    private JMenu getDatei(){
        JMenu datei = new JMenu("Datei");
        datei.add(new JMenuItem("laden"));

        return datei;
    }

    private JMenu getInfo(){
        JMenu info = new JMenu("Info");
        JMenuItem pins = new JMenuItem("Pins");
        pins.addActionListener(e -> { JDialog dialog = new JDialog(); ImageIcon icon = new ImageIcon("src/main/resources/pins.png") ; dialog.getContentPane().add(new JLabel("Pins", icon , JLabel.CENTER));dialog.setSize(icon.getIconWidth(), icon.getIconHeight());dialog.setVisible(true);dialog.repaint();});
        info.add(pins);

        return info;
    }




}
