package autodrivingtractor.grafik;

import autodrivingtractor.Config;
import autodrivingtractor.inout.TractorFunctions;
import com.pi4j.component.temperature.TemperatureSensor;
import com.pi4j.component.temperature.impl.TmpDS18B20DeviceType;
import com.pi4j.io.w1.W1Device;
import com.pi4j.io.w1.W1Master;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Menubar extends JMenuBar {
    private Config config;
    public Menubar(TractorFunctions functions){
        this.add(getDatei());
        this.add(getInfo());
        this.add(getConfigContent());
        this.add(getTest(functions));
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

    private JMenu getConfigContent(){
        JMenu cfg = new JMenu("Config");
        JMenuItem allTempSensors = new JMenuItem("Termperatursensoren");
        JMenuItem waterTemp = new JMenuItem("Wassertemperatur");
        JMenuItem oilTemp = new JMenuItem("Öltemperatur");
        String[] devices = getDevices();
        W1Master master = new W1Master();
        allTempSensors.addActionListener(e -> getTempSensors());
        waterTemp.addActionListener(e -> {config.setWaterDevice  (master.getDeviceById((String) JOptionPane.showInputDialog(null ,"WasserTempSensorID","Variablenänderung", JOptionPane.QUESTION_MESSAGE,null,  devices, devices[0] ))); System.out.println(config.getWaterDevice()); config.saveConfig();});
        oilTemp.addActionListener(e -> {config.setOilDevice      (master.getDeviceById( (String) JOptionPane.showInputDialog(null ,"OilTempSensorID"   ,"Variablenänderung", JOptionPane.QUESTION_MESSAGE,null,  devices, devices[0] ))); System.out.println(config.getOilDevice()); config.saveConfig();});
        cfg.add(allTempSensors);
        cfg.add(waterTemp);
        cfg.add(oilTemp);
        return cfg;
    }

    public void getTempSensors(){
	System.out.println("Devices");
        W1Master master = new W1Master();
        List<W1Device> w1Devices = master.getDevices();
        String allSensors = "";
        for (W1Device device : w1Devices) {
            System.out.println("Temperature: " + ((TemperatureSensor) device).getTemperature());

            try {
		        System.out.println("ID: " + device.getId() + "\n" + " value: "+ device.getValue() + "\n" + ((TemperatureSensor) device).getTemperature());
                allSensors += ("ID: " + device.getId() +  " value: " + device.getValue() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(null, allSensors ,"Temperatur Sensoren", JOptionPane.INFORMATION_MESSAGE);
    }

    public String[] getDevices(){
        System.out.println("Devices");
        W1Master master = new W1Master();
        List<W1Device> w1Devices = master.getDevices();
        ArrayList<String> allSensors = new ArrayList<String>();
        int i = 0;
        String[] strings = new String[w1Devices.size()];
        for (W1Device device : w1Devices) {
            strings[i] = device.getName();
            i++;
        }
        return strings;
    }

    private JMenu getTest(TractorFunctions functions){
        JMenu test = new JMenu("Test");
        JMenuItem testOutput = new JMenuItem("TestOutput");
        testOutput.addActionListener(e -> new TestOutput(functions));
        test.add(testOutput);
        return test;
    }

    public Config getConfig() {
        if (config == null){
            config = new Config();
        }
        return config;
    }
}
