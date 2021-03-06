package autodrivingtractor.grafik;

import javax.swing.*;

import autodrivingtractor.Config;
import autodrivingtractor.SouthSideUpdate;
import autodrivingtractor.inout.Sequenz;

import java.awt.*;
import java.util.ArrayList;


public class Frame extends JFrame {

    SouthLine southLine;

    public Frame(){
        System.out.println("Sequenz Start");
        Sequenz sequenz = new Sequenz();
        System.out.println("Sequenz Ende");
        setUndecorated(true);
        //this.setSize(800, 480);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        System.out.println("Menubar Start");
        Menubar menubar = new Menubar(sequenz.getFunctions());
        this.setJMenuBar(menubar);
        this.setLayout(new BorderLayout());
        this.add(getFunctionContainer(sequenz), BorderLayout.CENTER);
        System.out.println("Menubar Ende");
        System.out.println("Southline Start");
        southLine = new SouthLine();
        this.add(southLine, BorderLayout.SOUTH);
        System.out.println("Southline Ende");
        System.out.println("Southline Update Start");
        SouthSideUpdate slu = new SouthSideUpdate(southLine, menubar.getConfig());
        slu.start();
        System.out.println("Southline Update Ende");
        this.validate();
        this.repaint();
        this.setVisible(true);


    }

    private Container getFunctionContainer(Sequenz sequenz)  {
        Container container = new Container();
        container.setLayout(new GridLayout(4, 3));

        ControllButton leftCutter = new ControllButton("Links");
        leftCutter.getButtonUp().addActionListener(e -> {sequenz.sequenzLeftCutterLift(1);});
        leftCutter.getButtonDown().addActionListener(e -> {sequenz.sequenzLeftCutterLift(-1);});
        leftCutter.getButtonStop().addActionListener(e -> {sequenz.sequenzLeftCutterLift(0);});
        container.add(leftCutter);

        ControllButton hydraulik = new ControllButton("Hydraulik");
        hydraulik.getButtonUp().addActionListener(e -> {sequenz.sequenzMainCutterLift(1);});
        hydraulik.getButtonDown().addActionListener(e -> {sequenz.sequenzMainCutterLift(-1);});
        hydraulik.getButtonStop().addActionListener(e -> {sequenz.sequenzMainCutterLift(0);});
        container.add(hydraulik);

        ControllButton rightCutter = new ControllButton("Rechts");
        rightCutter.getButtonUp().addActionListener(e -> {sequenz.sequenzRightCutterLift(1);});
        rightCutter.getButtonDown().addActionListener(e -> {sequenz.sequenzRightCutterLift(-1);});
        rightCutter.getButtonStop().addActionListener(e -> {sequenz.sequenzRightCutterLift(0);});
        container.add(rightCutter);

        JToggleButton cutterLeftOnly = new JToggleButton("Schneidwerk Rechts");
        cutterLeftOnly.addActionListener(e ->  sequenz.sequenzCutterLeftOnly(!cutterLeftOnly.isSelected()));
        container.add(cutterLeftOnly);

        JToggleButton cutterOn = new JToggleButton("Schneidwerk");
        cutterOn.addActionListener(e ->  {sequenz.sequenzCutterMain(cutterOn.isSelected());});
        container.add(cutterOn);


        JToggleButton dumpingOn = new JToggleButton( "D??mpfung");
        dumpingOn.addActionListener(e -> sequenz.sequenzMainCutterDumpingOn(dumpingOn.isSelected()));
        dumpingOn.setIcon(new ImageIcon("src/main/resources/icons/dumping.png"));
        container.add(dumpingOn);

        JToggleButton allWheel = new JToggleButton( "Allrad");
        allWheel.addActionListener(e -> sequenz.sequenzAllWheel(allWheel.isSelected()));
        allWheel.setIcon(new ImageIcon("src/main/resources/icons/allWheel.png"));
        container.add(allWheel);

        JToggleButton drivingFast = new JToggleButton("Schnell Fahren");
        drivingFast.addActionListener(e -> {sequenz.sequenzDrivingFast(drivingFast.isSelected());
            if(drivingFast.isSelected())
                drivingFast.setIcon(new ImageIcon("src/main/resources/icons/fast.png")); else
                drivingFast.setIcon(new ImageIcon("src/main/resources/icons/slow.png"));});
        drivingFast.setIcon(new ImageIcon("src/main/resources/icons/slow.png"));
        container.add(drivingFast);

        JToggleButton hydraulikAn = new JToggleButton("Hydraulik System");
        hydraulikAn.addActionListener(e -> sequenz.sequenzHydraulikAn(hydraulikAn.isSelected()));
        hydraulikAn.setIcon(new ImageIcon("src/main/resources/icons/hydraulic.png"));
        container.add(hydraulikAn);

        JButton horn = new JButton("Hupe");
        horn.addActionListener(e -> sequenz.sequenzHorn());
        //horn.setIcon(new ImageIcon("src/main/resources/icons/light.png"));
        container.add(horn);

        JToggleButton worklight = new JToggleButton("Arbeitslicht");
        worklight.addActionListener(e -> sequenz.sequenzWorklight(worklight.isSelected()));
        worklight.setIcon(new ImageIcon("src/main/resources/icons/light.png"));
        container.add(worklight);

        JToggleButton standingLight = new JToggleButton("Standlicht");
        standingLight.addActionListener(e -> sequenz.sequenzStandingLight(standingLight.isSelected()));
        standingLight.setIcon(new ImageIcon("src/main/resources/icons/light.png"));
        container.add(standingLight);

        JToggleButton drivingLight = new JToggleButton("Fahrlicht");
        drivingLight.addActionListener(e -> sequenz.sequenzDrivingLight(drivingLight.isSelected()));
        drivingLight.setIcon(new ImageIcon("src/main/resources/icons/light.png"));
        container.add(drivingLight);

        return container;
    }

    public SouthLine getSouthLine(){
        return southLine;
    }

}
