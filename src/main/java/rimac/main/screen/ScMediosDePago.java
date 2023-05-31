package rimac.main.screen;

import io.appium.java_client.HidesKeyboard;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rimac.main.object.*;
import rimac.main.util.BaseDriver;
import rimac.main.util.UtilApp;

import java.time.Duration;

public class ScMediosDePago extends BaseDriver {

    protected ObjAnadirTarjeta objAnadirTarjeta = ObjAnadirTarjeta.getInstancia();
    protected ObjPerfil objPerfil = ObjPerfil.getInstancia();
    protected ObjAfiliarPago objAfiliarPago=ObjAfiliarPago.getInstancia();
    protected ObjCommons objCommons = ObjCommons.getInstancia();
    protected ObjMediodePago objMediodePago = ObjMediodePago.getInstancia();
    protected ObjPagos objPagos = ObjPagos.getInstancia();
    protected ObjTusSeguros objTusSeguros = ObjTusSeguros.getInstancia();
    protected UtilApp util = UtilApp.getInstancia();
    protected ObjPaginaPrincipal objectPrincipal = ObjPaginaPrincipal.getInstancia();
    public void eliminarTarjeta(String numTarjeta){
        int contador = 0;
        boolean condicion1 = objMediodePago.opcTarjetaList(numTarjeta).size() != 0;
        boolean condicion2 = element(objMediodePago.lblMisTarjetas).isCurrentlyVisible();
        boolean condicion3 = element(objMediodePago.btnAgregarTarjeta).isCurrentlyVisible();
        //Si la tarjeta existe en el listado, borrar la tarjeta
        if (condicion1) {
            while (element(objMediodePago.opcTarjeta(numTarjeta)).isCurrentlyVisible() == false && contador < 5) {
                util.mobileSwipeScreenAndroid();
            }
            element((WebElement) objMediodePago.opcTarjeta(numTarjeta)).click();
            element(objMediodePago.btnEliminarTarjeta).click();
            element(objMediodePago.btnSiEliminar).click();
            new WebDriverWait(androidDriver(), Duration.ofSeconds(20))
                    .until(ExpectedConditions.visibilityOf(objMediodePago.lblMisTarjetas));
            Serenity.takeScreenshot();
        }
        while(contador<10){
            if(condicion2){
                break;
            }
            if(condicion3){
                break;
            }
            util.esperarSegundos(1);
            contador++;
        }
    }
    public void ingresarDatosTarjeta(String numTarjeta, String nombre, String apellido, StringBuilder mmaa, String cvv, String correo) throws Exception{
        util.esperarElemento(3, objAnadirTarjeta.lblNumTarjeta);
        element(objAnadirTarjeta.lblNumTarjeta).sendKeys(numTarjeta);
        element(objAnadirTarjeta.lblNombre).sendKeys(nombre);
        element(objAnadirTarjeta.lblApellido).sendKeys(apellido);
        ((HidesKeyboard) appiumDriver()).hideKeyboard();
        element(objAnadirTarjeta.lblMMAA).sendKeys(mmaa);
        element(objAnadirTarjeta.lblCVV).sendKeys(cvv);
        ((HidesKeyboard) appiumDriver()).hideKeyboard();
        element(objAnadirTarjeta.lblCorreo).sendKeys(correo);
        ((HidesKeyboard) appiumDriver()).hideKeyboard();
        int contador=0;
        while(element(objAnadirTarjeta.btnGuardarTarjeta).isCurrentlyVisible()==false && contador<5){
            util.mobileSwipeScreenAndroid();
            contador++;
        }
        util.esperarElementoVisible(5, objAnadirTarjeta.btnGuardarTarjeta);
        Serenity.takeScreenshot();
        element(objAnadirTarjeta.btnGuardarTarjeta).click();
    }
    public void agregarTarjeta(String numTarjeta, String nombre, String apellido, StringBuilder mmaa, String cvv, String correo) {
        try {


            util.esperarElemento(3, objAnadirTarjeta.lblNumTarjeta);
            element(objAnadirTarjeta.lblNumTarjeta).sendKeys(numTarjeta);
            element(objAnadirTarjeta.lblNombre).sendKeys(nombre);
            element(objAnadirTarjeta.lblApellido).sendKeys(apellido);
            ((HidesKeyboard) appiumDriver()).hideKeyboard();
            element(objAnadirTarjeta.lblMMAA).sendKeys(mmaa);
            element(objAnadirTarjeta.lblCVV).sendKeys(cvv);
            ((HidesKeyboard) appiumDriver()).hideKeyboard();
            element(objAnadirTarjeta.lblCorreo).sendKeys(correo);
            ((HidesKeyboard) appiumDriver()).hideKeyboard();
            Dimension dimension = appiumDriver().manage().window().getSize();
            Point start= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.7));
            Point end= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.1));
            util.doSwipe(appiumDriver(), start, end, 1000);
            util.esperarElemento(4, objAnadirTarjeta.btnGuardarTarjetanew);
            element(objAnadirTarjeta.btnGuardarTarjetanew).click();
            element(objAnadirTarjeta.btnPagarNew).click();

        }
        catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("Error para ingresar los datos de la tarjeta");
        }

    }

    public void afiliarTarjeta(String numTarjeta, String nombre, String apellido, StringBuilder mmaa, String cvv, String correo){
        try{
            int contador = 0;
            Dimension dimension = appiumDriver().manage().window().getSize();
            Point start= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.7));
            Point end= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.1));
            //util.doSwipe(appiumDriver(), start, end, 1000);
            while(element(objMediodePago.lnkAgregarNuevaTarjeta).isCurrentlyVisible()==false && contador<7){
                util.doSwipe(appiumDriver(), start, end, 1000);
                contador++;
            }
            util.esperarSegundos(3);
            Serenity.takeScreenshot();
            element(objMediodePago.lnkAgregarNuevaTarjeta).click();
            ingresarDatosTarjeta(numTarjeta,nombre,apellido,mmaa,cvv,correo);
        }catch(Exception e){
            throw new IllegalAccessError("Error para ingresar los datos de la tarjeta");
        }
    }

    public boolean existeTarjeta(String numTarjeta){
        boolean tarjetaExiste=false;
        try{
            util.esperarElementoVisible(9,objMediodePago.opcTarjeta(numTarjeta));
            Serenity.takeScreenshot();
            tarjetaExiste = objMediodePago.opcTarjetaList(numTarjeta).size() != 0;

        }catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("No se visualiza la tarjeta en el listado de Tarjetas");
        }
        return tarjetaExiste;
    }

    public boolean validarEliminarTarjeta(String numTarjeta){
        boolean tarjetaExiste = false;
        try{
            tarjetaExiste = objMediodePago.opcTarjetaList(numTarjeta).size() == 0;
            Serenity.takeScreenshot();
        }catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("La tarjeta no se eliminó correctamente");
        }
        return tarjetaExiste;
    }

    public void volverTabPagos() throws Exception{
        util.esperarElementoVisible(5,objCommons.btnVolver);
        element(objCommons.btnVolver).click();
    }

    public String validarAfiliacion(){
        String mensajeAfiliacion;
        try{
            util.esperarElemento(4,objAfiliarPago.lblTarjetaAfiliadaExito);
            mensajeAfiliacion = element(objAfiliarPago.lblTarjetaAfiliadaExito).getText();
            Serenity.takeScreenshot();
        }catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("No se visualiza mensaje de Afiliacion de tarjeta exitosa");
        }
        return mensajeAfiliacion;
    }

    public void irPagos(){
        util.esperarElemento(4,objAfiliarPago.btnIrPagos);
        element(objAfiliarPago.btnIrPagos).click();
    }


    public void seleccionarOpcionPerfil() {
        util.esperarSegundos(10);
        util.esperarElemento(10, objTusSeguros.tbSeguroVehicular);
        element(objTusSeguros.tbSeguroVehicular).click();
        util.esperarSegundos(3);
        util.esperarElemento(10, objectPrincipal.btnPerfil);
        element(objectPrincipal.btnPerfil).click();
    }
}
