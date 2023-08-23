package rimac.main.screen;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import rimac.main.object.ObjCommons;
import rimac.main.object.ObjEligeTuPlan;
import rimac.main.object.ObjSoatDosMinutos;
import rimac.main.util.BaseDriver;
import rimac.main.util.UtilApp;

public class ScIngresarPlaca extends BaseDriver {

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
    }

    public void ingresarDatosAdic(String tipoUso, String vehiculo,String marca,String modelo,String anio,String serie,String asientos) throws Exception {
        Dimension dimension = appiumDriver().manage().window().getSize();
        Point start= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.5));
        Point end= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.2));
        util.esperarElementoVisible(10,objSoatDosMinutos.cmbTipoUso);
        element(objSoatDosMinutos.cmbTipoUso).click();
        util.esperarVisibilityElement(androidDriver(),objSoatDosMinutos.opcTipoUso(tipoUso),10);
        element(objSoatDosMinutos.opcTipoUso(tipoUso)).click();
        util.esperarVisibilityElement(androidDriver(),objSoatDosMinutos.cmbTipoUso,10);
        element(objSoatDosMinutos.cmbTipoVehiculo).click();
        element(objSoatDosMinutos.opcVehiculo(vehiculo)).click();
        util.esperarVisibilityElement(androidDriver(),objSoatDosMinutos.cmbTipoVehiculo,10);
        util.doSwipe(appiumDriver(), start, end, 1000);
        element(objSoatDosMinutos.cmbMarca).click();
        element(objSoatDosMinutos.opcMarca(marca)).click();
        util.esperarVisibilityElement(androidDriver(),objSoatDosMinutos.cmbMarca,10);
        util.doSwipe(appiumDriver(), start, end, 1000);
        element(objSoatDosMinutos.cmbModelo).click();
        element(objSoatDosMinutos.opcModelo(modelo)).click();
        element(objSoatDosMinutos.txtAnio).sendKeys(anio);
        util.doSwipe(appiumDriver(), start, end, 1000);
        element(objSoatDosMinutos.txtSerie).sendKeys(serie);
        element(objSoatDosMinutos.txtNumAsientos).sendKeys(asientos);
        element(objSoatDosMinutos.btnContinuar).click();
    }
}
