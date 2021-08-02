package autodrivingtractor.inout;

import autodrivingtractor.inout.TractorFunctions;


public class Sequenz {


    final private TractorFunctions functions;

    public Sequenz(){
        functions = new TractorFunctions();
    }

    public Boolean sequenzMainCutterDumpingOn(Boolean state){
        try {
            if(state) {
                functions.cutterMainLift(-1);
                Thread.sleep(400);
                functions.setCutterMainDamping(true);
                Thread.sleep(400);
                functions.cutterMainLift(1);
                Thread.sleep(2000);
            } else {
                functions.setCutterMainDamping(false);
            }

        }catch (InterruptedException ie){ie.printStackTrace(); return false;}
        return true;
    }

    public Boolean sequenzCutterMain(Boolean state){
        try {
            if(state) {
                functions.cutterRightLift(1);
                functions.cutterLeftLift(1);
                functions.cutterMainLift(1);
                Thread.sleep(400);
                functions.setCutterleftonly(true);
                functions.setCutterMain(true);
                Thread.sleep(400);
                functions.setCutterleftonly(false);
                Thread.sleep(400);
            } else {
                functions.setCutterMain(false);
                functions.setCutterleftonly(true);
            }
        }catch (InterruptedException ie){ie.printStackTrace();return false;}
        return true;
    }

    public Boolean sequenzMainCutterLift(int diraction){
        try {
            functions.cutterMainLift(diraction);
            Thread.sleep(200);

        }catch (InterruptedException ie){ie.printStackTrace();return false;}
        return true;
    }

    public Boolean sequenzLeftCutterLift(int diraction){
        try {
            functions.cutterLeftLift(diraction);
            Thread.sleep(200);

        }catch (InterruptedException ie){ie.printStackTrace();return false;}
        return true;
    }


    public Boolean sequenzRightCutterLift(int diraction){
        try {
            functions.cutterRightLift(diraction);
            Thread.sleep(200);

        }catch (InterruptedException ie){ie.printStackTrace();return false;}
        return true;
    }

    public Boolean sequenzAllWheel(Boolean state){
        if(state){
            functions.setAllwheel(state);
        }
        return true;
    }

    public Boolean sequenzDrivingFast(Boolean state){
        functions.setDrivingfast(state);
        return true;
    }

    public Boolean sequenzHydraulikAn(Boolean state){
        try {
            if (state) {
                functions.setHydraulik(true);
            } else {
                sequenzCutterMain(false);
                Thread.sleep(200);
                functions.cutterLeftLift(1);
                functions.cutterRightLift(1);
                Thread.sleep(200);
                sequenzMainCutterDumpingOn(true);
                functions.setHydraulik(false);
            }

        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Boolean sequenzWorklight(Boolean state){
        functions.setWorklight(state);
        return true;
    }
    public Boolean sequenzStandingLight(Boolean state){
        functions.setStandinglight(state);
        return true;
    }
    public Boolean sequenzDrivingLight(Boolean state){
        functions.setDrivinglight(state);
        return true;
    }

    public Boolean sequenzHorn(){
        try{
            functions.setHorn(true);
            Thread.sleep(500);
            functions.setHorn(false);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
