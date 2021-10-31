package autodrivingtractor.inout;

import com.pi4j.io.gpio.*;

public class TractorFunctions {

    final static int LiftUp = 1;
    final static int LiftDown = -1;
    final static int LiftStop = 0;
    private Boolean worklight;
    private Boolean cutterMain;
    private Boolean cutterMainDamping;
    private Boolean cutterLeftOnly;
    private Boolean cutterMainUp;
    private Boolean cutterMainDown;
    private Boolean cutterRightUp;
    private Boolean cutterRightDown;
    private Boolean cutterLeftUp;
    private Boolean cutterLeftDown;

    private Boolean drivingFast;
    private Boolean allWheel;
    private Boolean horn;
    private Boolean standingLight;
    private Boolean drivingLight;
    private Boolean hydraulik;

    Boolean off =false;
    Boolean on = true;

    public TractorFunctions() {
    }

    public void cutterMainLift(int diraction) {
        switch (diraction) {
            case LiftUp:
                cutterMainUp= on;
                cutterMainDown= off;
                break;
            case LiftDown:
                cutterMainUp= off;
                cutterMainDown= on;
                break;
            default:
                cutterMainUp= off;
                cutterMainDown= off;
        }
    }

    public void cutterRightLift(int diraction) {
        switch (diraction) {
            case LiftUp:
                cutterRightUp= on;
                cutterRightDown= off;
                break;
            case LiftDown:
                cutterRightUp= off;
                cutterRightDown= on;
                break;
            default:
                cutterRightUp= off;
                cutterRightDown= off;
        }
    }


    public void cutterLeftLift(int diraction) {
        switch (diraction) {
            case LiftUp:
                cutterLeftUp= on;
                cutterLeftDown= off;
                break;
            case LiftDown:
                cutterLeftUp= off;
                cutterLeftDown= on;
                break;
            case LiftStop:
                cutterLeftUp= off;
                cutterLeftDown= off;
        }
    }
    public void setWorklight(Boolean stat) {
        if (stat){
            worklight= on;
        } else {
            worklight= off;
        }
    }

    public void setCutterMain(Boolean stat) {

        if (stat){
            cutterMain= on;
        } else {
            cutterMain= off;
        }
    }

    public void setCutterleftonly(Boolean stat) {
        if (stat){
            cutterLeftOnly= off;
        } else {
            cutterLeftOnly= on;
        }
    }

    public Boolean getLeftonlyState(){
        if(cutterLeftOnly == off){
            return true;
        }else {
            return false;
        }
    }


    public void setDrivingfast(Boolean stat) {
        if (stat){
            drivingFast= on;
        } else {
            drivingFast= off;
        }
    }

    public void setAllwheel(Boolean stat) {
        if (stat){
            allWheel= on;
        } else {
            allWheel= off;
        }
    }


    public void setHorn(Boolean stat) {
        if (stat){
            horn= on;
        } else {
            horn= off;
        }
    }

    public void setStandinglight(Boolean stat) {
        if (stat){
            standingLight= on;
        } else {
            standingLight= off;
        }
    }

    public void setCutterMainDamping(Boolean stat){
        if (stat){
            cutterMainDamping= on;
        } else {
            cutterMainDamping= off;
        }
    }

    public void setDrivinglight(Boolean stat) {
        if (stat){
            drivingLight= on;
        } else {
            drivingLight= off;
        }
    }

    public void setHydraulik(Boolean stat){
        if (stat){
            hydraulik= on;
            System.out.println("Hydraulik An");
        } else {
            hydraulik= off;
            System.out.println("Hydraulik Aus");
        }
    }
}