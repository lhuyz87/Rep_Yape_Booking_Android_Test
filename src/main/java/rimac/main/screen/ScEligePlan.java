package rimac.main.screen;

import net.serenitybdd.core.Serenity;
import rimac.main.object.ObjEligeTuPlan;
import rimac.main.object.ObjSoatDosMinutos;
import rimac.main.util.BaseDriver;
import rimac.main.util.UtilApp;

public class ScEligePlan extends BaseDriver {

    UtilApp util=UtilApp.getInstancia();
    ObjSoatDosMinutos objSoatDosMinutos = ObjSoatDosMinutos.getInstancia();
    ObjEligeTuPlan objEligeTuPlan= ObjEligeTuPlan.getInstancia();


    public void planDigital() throws Exception {
        try {
            int contador = 0;
            while (element(objEligeTuPlan.lblEligetuPlan).isCurrentlyVisible() == false && contador < 8) {
                util.esperarSegundos(1);
                contador++;
            }
            util.esperarElementoVisible(7, objEligeTuPlan.lblEligetuPlan);
            while (element(objEligeTuPlan.btnContinuar).isCurrentlyVisible() == false && contador < 6) {
                util.mobileSwipeScreenAndroidFinal();
                contador++;
            }
            element(objEligeTuPlan.btnContinuar).click();
        }catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("No se encuentra plan digital");
        }
    }

    public void planVial() throws Exception {
        try {
            int contador = 0;
            while (element(objEligeTuPlan.lblEligetuPlan).isCurrentlyVisible() == false && contador < 8) {
                util.esperarSegundos(1);
                contador++;
            }
            util.esperarElementoVisible(7, objEligeTuPlan.lblEligetuPlan);
            util.esperarElemento(5, objEligeTuPlan.btnVial);
            element(objEligeTuPlan.btnVial).click();
            while (element(objEligeTuPlan.btnContinuar).isCurrentlyVisible() == false && contador < 6) {
                util.mobileSwipeScreenAndroidFinal();
                contador++;
            }
            Serenity.takeScreenshot();
            element(objEligeTuPlan.btnContinuar).click();
        }catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("No se encuentra plan Vial");
        }
    }

    public void planPlus() throws Exception {
        try {
            int contador = 0;
            while (element(objEligeTuPlan.lblEligetuPlan).isCurrentlyVisible() == false && contador < 8) {
                util.esperarSegundos(1);
                contador++;
            }
            util.esperarElementoVisible(7, objEligeTuPlan.lblEligetuPlan);
            util.esperarElemento(5, objEligeTuPlan.btnPlus);
            element(objEligeTuPlan.btnPlus).click();
            while (element(objEligeTuPlan.btnContinuar).isCurrentlyVisible() == false && contador < 6) {
                util.mobileSwipeScreenAndroidFinal();
                contador++;
            }
            Serenity.takeScreenshot();
            element(objEligeTuPlan.btnContinuar).click();
        }catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("No se encuentra plan Plus");
        }
    }

    public void validaPlan() throws Exception{
        util.esperarElementoVisible(10,objSoatDosMinutos.lblTitle);
        int contador=0;
        while(element(objEligeTuPlan.btnContinuar).isCurrentlyVisible()==false && contador<6){
            util.mobileSwipeScreenAndroidFinal();
            contador++;
        }
        element(objEligeTuPlan.rdbNoAfiliar).click();
        element(objEligeTuPlan.rdbPoliticaPrivacidad).click();
        element(objEligeTuPlan.rdbEnvioPoliza).click();
        element(objEligeTuPlan.btnContinuar).click();
    }
}
