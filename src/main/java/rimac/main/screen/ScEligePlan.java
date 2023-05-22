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
    public void ingresarPlaca(String placa1, String placa2, String placa3, String placa4, String placa5, String placa6) throws Exception{
        util.esperarElementoVisible(10,objSoatDosMinutos.lblTitle);
        element(objSoatDosMinutos.inputPlaca("1")).sendKeys(placa1);
        element(objSoatDosMinutos.inputPlaca("2")).sendKeys(placa2);
        element(objSoatDosMinutos.inputPlaca("3")).sendKeys(placa3);
        element(objSoatDosMinutos.inputPlaca("5")).sendKeys(placa4);
        element(objSoatDosMinutos.inputPlaca("6")).sendKeys(placa5);
        element(objSoatDosMinutos.inputPlaca("7")).sendKeys(placa6);
        int contador=0;
        while(element(objEligeTuPlan.lblEligetuPlan).isCurrentlyVisible()==false && contador<30){
            util.esperarSegundos(1);
        }
        util.esperarElementoVisible(30,objEligeTuPlan.lblEligetuPlan);
    }

    public void planDigital(){
        int contador=0;
        while(element(objEligeTuPlan.btnContinuar).isCurrentlyVisible()==false && contador<6){
            util.mobileSwipeScreenAndroidFinal();
            contador++;
        }
        element(objEligeTuPlan.btnContinuar).click();
    }

    public void planVial(){
        int contador=0;
        util.esperarElemento(5,objEligeTuPlan.btnVial);
        element(objEligeTuPlan.btnVial).click();
        while(element(objEligeTuPlan.btnContinuar).isCurrentlyVisible()==false && contador<6){
            util.mobileSwipeScreenAndroidFinal();
            contador++;
        }
        Serenity.takeScreenshot();
        element(objEligeTuPlan.btnContinuar).click();
    }

    public void validaPlan() throws Exception{
        util.esperarElementoVisible(20,objSoatDosMinutos.lblTitle);
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
