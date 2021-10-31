package autodrivingtractor;

import com.pi4j.io.w1.W1Device;
import com.pi4j.io.w1.W1Master;
import com.pi4j.util.StringUtil;

import java.io.*;
import java.util.List;

public class Config {

    private W1Device waterDevice;
    private W1Device oilDevice;
    final private String path = "src/main/resources/config.txt";
    final private String oilTempId = "oilTempDevice=";
    final private String waterTempId = "waterTempDevice=";

    public Config(){
try {
    loadConfig();
    System.out.println("Config Load: ");
    System.out.println("Oil ID: " + oilDevice.getId());
    System.out.println("Oil FamilyId: " + oilDevice.getFamilyId());
    System.out.println("Oil Name: " + oilDevice.getName());
    System.out.println("Water ID: " + oilDevice.getId());
    System.out.println("Water FamilyId: " + oilDevice.getFamilyId());
    System.out.println("Water Name: " + oilDevice.getName());
    System.out.println("Config End");
}catch (NullPointerException npe){
    System.out.println("Config wird neu geladen");
    W1Master master = new W1Master();
    List<W1Device> devices = master.getDevices();
    oilDevice = devices.get(0);
    waterDevice = devices.get(devices.size()-1);
    saveConfig();
}
    }

    public W1Device getWaterDevice() {
        return waterDevice;
    }

    public void setWaterDevice(W1Device waterDevice) {
        this.waterDevice = waterDevice;
    }

    public W1Device getOilDevice() {
        return oilDevice;
    }

    public void setOilDevice(W1Device oilDevice) {
        this.oilDevice = oilDevice;
    }

    public void saveConfig(){
        Writer fileWriter = null;
        try {
            fileWriter = new FileWriter(path);

            fileWriter.write(oilTempId + oilDevice.getName());
            fileWriter.write(waterTempId + waterDevice.getName());
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadConfig(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));

        String data;
        while((data = reader.readLine()) != null) {
            W1Master master = new W1Master();
            System.out.println("Line : " + data);
            if (data.replace(" ", "").startsWith(oilTempId)) {
                String addresse = data.replace(" ", "").split("=")[1];
                System.out.println(addresse);
               oilDevice = master.getDeviceById(addresse);
            }
            if (data.replace(" ", "").startsWith(waterTempId)) {
                String addresse = data.replace(" ", "").split("=")[1];
                System.out.println(addresse);
                waterDevice = master.getDeviceById(addresse);
            }
        }
        reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
