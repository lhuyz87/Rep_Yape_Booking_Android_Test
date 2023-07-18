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
        //permite realizar la espera del listado de tarjetas o del boton agregar tarjeta
        while(element(objMediodePago.listTarjetas).isCurrentlyVisible()== false && contador < 5){
            if(element(objMediodePago.btnAgregarTarjeta).isCurrentlyVisible()){
                break;
            }
            contador++;
        }
        if (element(objMediodePago.listTarjetas).isCurrentlyVisible()) {
            while (element(objMediodePago.opcTarjeta(numTarjeta)).isCurrentlyVisible() == false && contador < 5) {
                util.mobileSwipeScreenAndroid();
            }
            element((WebElement) objMediodePago.opcTarjetaSinSeguros(numTarjeta)).click();
            element(objMediodePago.btnEliminarTarjeta).click();
            element(objMediodePago.btnSiEliminar).click();
            new WebDriverWait(androidDriver(), Duration.ofSeconds(20))
                    .until(ExpectedConditions.visibilityOf(objMediodePago.lblMisTarjetas));
            Serenity.takeScreenshot();
        }
        while(element(objMediodePago.listTarjetas).isCurrentlyVisible()== false && contador < 5){
            if(element(objMediodePago.btnAgregarTarjeta).isCurrentlyVisible()){
                break;
            }
            contador++;
        }
    }
    public void ingresarDatosTarjeta(String numTarjeta, String nombre, String apellido, StringBuilder mmaa, String cvv, String correo) throws Exception{
       try{
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
       }catch(Exception e){
           Serenity.takeScreenshot();
           throw new IllegalAccessError("Error para ingresar los datos de la tarjeta");
       }

    }

    public void guardarTarjeta() throws Exception {
        Serenity.takeScreenshot();
        Dimension dimension = appiumDriver().manage().window().getSize();
        Point start= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.8));
        Point end= new Point((int)(dimension.width*0.2), (int)(dimension.height*0.2));
        util.doSwipe(appiumDriver(), start, end, 1000);
        element(objAnadirTarjeta.btnGuardarTarjetanew).click();
    }

    public void guardarFuturosPagos() throws Exception {
        Serenity.takeScreenshot();
        Dimension dimension = appiumDriver().manage().window().getSize();
        Point start= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.8));
        Point end= new Point((int)(dimension.width*0.2), (int)(dimension.height*0.2));
        util.doSwipe(appiumDriver(), start, end, 1000);
        element(objAnadirTarjeta.chkGuardarTarjeta).click();
    }
    public void pagar(){
        Serenity.takeScreenshot();
        Dimension dimension = appiumDriver().manage().window().getSize();
        Point start= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.8));
        Point end= new Point((int)(dimension.width*0.2), (int)(dimension.height*0.2));
        util.doSwipe(appiumDriver(), start, end, 1000);
        element(objAnadirTarjeta.btnPagarNew).click();
    }

    public void agregarTarjetaNueva(){
        Dimension dimension = appiumDriver().manage().window().getSize();
        Point start= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.8));
        Point end= new Point((int)(dimension.width*0.2), (int)(dimension.height*0.2));
        int contador=0;
        while(element(objMediodePago.btnAnadirNuevaTarjeta).isCurrentlyVisible()==false && contador<15) {
            util.doSwipe(appiumDriver(), start, end, 1000);
            contador++;
        }
        util.esperarElemento(5, objMediodePago.btnAnadirNuevaTarjeta);
        util.esperarSegundos(1);
        element(objMediodePago.btnAnadirNuevaTarjeta).click();
    }
    public void esperarListadoTarjetas() throws Exception {
        new WebDriverWait(androidDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(objMediodePago.lblMisTarjetas));
        util.esperarElementoVisible(5,objMediodePago.listTarjetas);
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
            element(objAnadirTarjeta.btnAfiliarTarjeta).click();
        }catch(Exception e){
            throw new IllegalAccessError("Error para ingresar los datos de la tarjeta");
        }
    }
    public boolean existeTarjeta(String numTarjeta){
        boolean tarjetaExiste=false;
        try{
            util.esperarElementoVisible(9,objMediodePago.opcTarjeta(numTarjeta));
            int contador=0;
            while(contador<8){
                if(objMediodePago.opcTarjetaList(numTarjeta).size() != 0){
                    break;
                }
                contador++;
            }
            tarjetaExiste = objMediodePago.opcTarjetaList(numTarjeta).size() != 0;
            Serenity.takeScreenshot();

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
        util.esperarSegundos(3);
        util.esperarElemento(10, objectPrincipal.btnPerfil);
        element(objectPrincipal.btnPerfil).click();
    }

    public void regresarSelecOpcionPerfil() {
        if(element(objTusSeguros.btnCerrarmodal).isCurrentlyVisible())
        { element(objTusSeguros.btnCerrarmodal).click();}
        util.esperarSegundos(10);
        util.esperarElemento(10, objTusSeguros.tbSeguroVehicular);
        element(objTusSeguros.tbSeguroVehicular).click();
        util.esperarSegundos(3);
        util.esperarElemento(10, objectPrincipal.btnPerfil);
        element(objectPrincipal.btnPerfil).click();
    }
    public void pagarTarjetaAsociada() throws Exception {
        util.esperarElementoVisible(5,objMediodePago.listTarjetas);
        element(objMediodePago.rdbPrimeraTarjeta).click();
        element(objMediodePago.btnPagar).click();
    }

    public void añadir_tarjeta() throws InterruptedException {
        int contador=0;
        while(element(objMediodePago.btnAnadirTarjeta).isCurrentlyVisible()==false && contador<8){
            if(element(objMediodePago.listTjetas).isCurrentlyVisible()){
                break;
            }
            Thread.sleep(500);
            contador++;
        }
        Thread.sleep(1000);
        if(element(objMediodePago.btnAnadirTarjeta).isCurrentlyVisible()){
            element(objMediodePago.btnAnadirTarjeta).click();
        }
        else{
            int intentos=0;
            Dimension dimension = appiumDriver().manage().window().getSize();
            Point start= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.8));
            Point end= new Point((int)(dimension.width*0.2), (int)(dimension.height*0.2));
            while(element(objMediodePago.btnAnadirNuevaTarjeta).isCurrentlyVisible()==false  && intentos<5){
                util.doSwipe(appiumDriver(), start, end, 1000);
                intentos++;
            }
            element(objMediodePago.btnAnadirNuevaTarjeta).click();
        }
    }

    public void pagarTarjetaAfil() {
        try{
            Dimension dimension = appiumDriver().manage().window().getSize();
            Point start= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.8));
            Point end= new Point((int)(dimension.width*0.2), (int)(dimension.height*0.2));
            util.doSwipe(appiumDriver(), start, end, 1000);
            util.esperarElemento(3, objAnadirTarjeta.btnPagoAuto);
            element(objAnadirTarjeta.btnPagoAuto).click();
            element(objAnadirTarjeta.btnPagarNew).click();

        }catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("Error para ingresar los datos de la tarjeta");
        }

    }

    public void guardarTarjetaCuotas() {
        try{
            Dimension dimension = appiumDriver().manage().window().getSize();
            Point start= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.8));
            Point end= new Point((int)(dimension.width*0.2), (int)(dimension.height*0.2));
            util.doSwipe(appiumDriver(), start, end, 1000);
            util.esperarElemento(3, objAnadirTarjeta.btnGuardarTarjetanew);
            element(objAnadirTarjeta.chkGuardarTarjeta).click();
            element(objAnadirTarjeta.btnPagarNew).click();

        }catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("Error para ingresar los datos de la tarjeta");
        }
    }
}
