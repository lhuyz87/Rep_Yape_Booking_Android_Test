package rimac.main.screen;

import io.appium.java_client.HidesKeyboard;
import net.serenitybdd.core.Serenity;
import rimac.main.object.*;
import rimac.main.util.BaseDriver;
import rimac.main.util.UtilApp;

public class ScPagoConTarjeta extends BaseDriver {

    UtilApp util=UtilApp.getInstancia();
    ObjPagoTarjeta objPagoTarjeta= ObjPagoTarjeta.getInstancia();
    ObjTienda objTienda= ObjTienda.getInstancia();

    public void ingresarDatosContacto(String dni, String correo,String celular){
        util.esperarElementoVisible(7,objPagoTarjeta.lblDni);
        Serenity.takeScreenshot();
        element(objPagoTarjeta.lblDni).sendKeys(dni);
        ((HidesKeyboard) appiumDriver()).hideKeyboard();
        element(objPagoTarjeta.lblCorreo).sendKeys(correo);
        ((HidesKeyboard) appiumDriver()).hideKeyboard();
        element(objPagoTarjeta.lblCelular).sendKeys(celular);
        ((HidesKeyboard) appiumDriver()).hideKeyboard();
        Serenity.takeScreenshot();
        element(objPagoTarjeta.btnContinuar).click();
    }
    public void agregarTarjeta(String dni, String correo,String celular, String numtarjeta, String cvv, StringBuilder fecha , String nombre, String apellido){
        try{
            int contador=0;
            util.esperarElementoVisible(7,objPagoTarjeta.lblPagaInstante);
            while(element(objPagoTarjeta.btnAgregaTarjeta).isCurrentlyEnabled() && contador<1){
                util.mobileSwipeScreenAndroid();
                contador++;
            }
            element(objPagoTarjeta.btnAgregaTarjeta).click();
            ingresarDatosContacto(dni,correo,celular);
            util.esperarElementoVisible(7,objPagoTarjeta.lblTarjeta);
            Serenity.takeScreenshot();
            element(objPagoTarjeta.lblTarjeta).sendKeys(numtarjeta);
            ((HidesKeyboard) appiumDriver()).hideKeyboard();
            element(objPagoTarjeta.lblNombre).sendKeys(nombre);
            ((HidesKeyboard) appiumDriver()).hideKeyboard();
            element(objPagoTarjeta.lblApellido).sendKeys(apellido);
            ((HidesKeyboard) appiumDriver()).hideKeyboard();
            element(objPagoTarjeta.lblMesAnio).sendKeys(fecha);
            ((HidesKeyboard) appiumDriver()).hideKeyboard();
            element(objPagoTarjeta.lblCvv).sendKeys(cvv);
            ((HidesKeyboard) appiumDriver()).hideKeyboard();
            Serenity.takeScreenshot();
            util.esperarElemento(5,objPagoTarjeta.btnPagar);
            Serenity.takeScreenshot();
            element(objPagoTarjeta.btnPagar).click();
        }catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("Error para realizar el pago con la tarjeta");
        }
    }


    public String validaMensaje(){
        String mensaje="";
        try{
            util.esperarElemento(8,objPagoTarjeta.lblCompraSoatExito);
            mensaje=element(objPagoTarjeta.lblCompraSoatExito).getText();
            Serenity.takeScreenshot();
        }
        catch(Exception e){
            throw new IllegalAccessError("Error en el aplicativo, no se puede validar mensaje '¡Listo! Estamos por enviar tu SOAT'");
        }
        return mensaje;
    }

    public void finalizarOperacion(){
       element(objPagoTarjeta.btnFinalizar).click();
       util.esperarElementoVisible(5,objTienda.btnConoceMas);
    }

}
