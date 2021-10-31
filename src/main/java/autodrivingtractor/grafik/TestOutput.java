package autodrivingtractor.grafik;

import autodrivingtractor.inout.TractorFunctions;
import autodrivingtractor.inout.TractorFunctionsTest;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TestOutput extends JDialog {

    public TestOutput(TractorFunctions function){

        this.setSize(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getSize());
        JButton mainLiftUp = new JButton("Main Up");
        mainLiftUp.addChangeListener(e -> function.cutterMainLift(1));
        JButton mainLiftDown = new JButton("Main Down");
        mainLiftDown.addChangeListener(e -> function.cutterMainLift(-1));
        JButton leftLiftUp = new JButton("Left Up");
        leftLiftUp.addChangeListener(e -> function.cutterLeftLift(1));
        JButton leftLiftDown = new JButton("Left Down");
        leftLiftDown.addChangeListener(e -> function.cutterLeftLift(-1));
        JButton rightLiftUp = new JButton("Right Up");
        rightLiftUp.addChangeListener(e -> function.cutterRightLift(1));
        JButton rightLiftDown = new JButton("Right Down");
        rightLiftDown.addChangeListener(e -> function.cutterRightLift(-1));


        JToggleButton cutter = new JToggleButton("Cutter");
        cutter.addChangeListener(e -> function.setCutterleftonly(cutter.isSelected()));
        JToggleButton leftOnly = new JToggleButton("LeftOnly");
        leftOnly.addChangeListener(e -> function.setCutterleftonly(leftOnly.isSelected()));
        JToggleButton dumping = new JToggleButton("Dumping");
        dumping.addChangeListener(e -> function.setCutterMainDamping(dumping.isSelected()));
        JToggleButton drivingLight = new JToggleButton("Driving Light");
        drivingLight.addChangeListener(e -> function.setDrivinglight(drivingLight.isSelected()));
        JToggleButton standingLight = new JToggleButton("StandingLight");
        standingLight.addChangeListener(e -> function.setStandinglight(standingLight.isSelected()));
        JToggleButton workLight = new JToggleButton("Work Light");
        workLight.addChangeListener(e -> function.setWorklight(workLight.isSelected()));
        JToggleButton drivingFast = new JToggleButton("Driving Fast");
        drivingFast.addChangeListener(e -> function.setDrivingfast(drivingFast.isSelected()));
        JButton horn = new JButton("Horn");
        horn.addChangeListener(e -> function.setHorn(horn.isSelected()));
        JToggleButton allWheel = new JToggleButton("All Wheel");
        allWheel.addChangeListener(e -> function.setAllwheel(allWheel.isSelected()));
        JToggleButton hydraulik = new JToggleButton("Hydraulik");
        hydraulik.addChangeListener(e -> function.setHydraulik(hydraulik.isSelected()));

        this.setLayout(new GridLayout(4,4));
        this.add(cutter);
        this.add(mainLiftUp);
        this.add(mainLiftDown);
        this.add(leftLiftUp);
        this.add(leftLiftDown);
        this.add(rightLiftUp);
        this.add(rightLiftDown);

        this.add(leftOnly);
        this.add(dumping);
        this.add(drivingLight);
        this.add(standingLight);
        this.add(workLight);
        this.add(drivingFast);
        this.add(horn);
        this.add(allWheel);
        this.add(hydraulik);

        this.setVisible(true);
        this.repaint();
        this.revalidate();
        this.setVisible(true);

    }

}
