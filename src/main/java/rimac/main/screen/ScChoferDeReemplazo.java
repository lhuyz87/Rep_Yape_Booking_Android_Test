package rimac.main.screen;

import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import rimac.main.object.*;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilApp;

import java.util.logging.Logger;

public class ScChoferDeReemplazo extends BaseDriver{
    protected ObjChoferReemplazo objChoferReemplazo = ObjChoferReemplazo.getInstancia();

    private long wdwTimeOut = 300L;
    private final int DURATION = 10;
    int i;
    protected ObjTramites tramitesObject = ObjTramites.getInstancia();
    protected ObjAlertas objAlertas = ObjAlertas.getInstancia();
    protected ObjPaginaPrincipal objPaginaPrincipal =ObjPaginaPrincipal.getInstancia();
    protected ObjCommons objCommons = ObjCommons.getInstancia();
    protected MobileObjectUtil mobileObjectUtil = MobileObjectUtil.getInstancia();

    // util
    public static Logger looger = Logger.getLogger(ScTusTramites.class.getName());

    public long getWdwTimeOut() {
        return wdwTimeOut;
    }

    UtilApp util = new UtilApp();

    public void terminosCondicionesChoferDeReemplazo(){
        try{
            util.esperarElementoVisible(5,objChoferReemplazo.titSolicitaChoferR);
            int contador = 0;


                while (element(objChoferReemplazo.chktermsChoferR).isCurrentlyVisible()== false && contador < 7) {
                    util.mobileSwipeScreenAndroid();
                    contador++;
                }
                element(objChoferReemplazo.chktermsChoferR).click();
                Serenity.takeScreenshot();
                element(objChoferReemplazo.btnChoferR).click();

        }catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("Error al seleccionar terminos y condiciones");
        }
    }

    public void ingresar_Datos_de_Contacto(String nombre, String celular,String correo){
        try {
            util.esperarElemento(25, objChoferReemplazo.titCelulardeContacto);
            util.esperarElementoVisible(15, objChoferReemplazo.idtxtNombre);
            element(objChoferReemplazo.txtNombre).clear();
            element(objChoferReemplazo.txtNombre).sendKeys(nombre);
            element(objChoferReemplazo.txtCelular).clear();
            element(objChoferReemplazo.txtCelular).sendKeys(celular);
            element(objChoferReemplazo.txtCorreo).clear();
            element(objChoferReemplazo.txtCorreo).sendKeys(correo);
            util.esperarElemento(20, objChoferReemplazo.btnComenzar);
            Serenity.takeScreenshot();
            element(objChoferReemplazo.btnComenzar).click();
        }catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("Error para ingresar Datos de Contacto");
        }
    }


    public void seleccionar_Vehiculo(String placa){
        try {
            util.esperarElemento(15, objChoferReemplazo.titTusVehiculosAfiliados);
            util.esperarSegundos(5);
            if (element(objChoferReemplazo.btnVehiculo(placa)).isCurrentlyVisible() == false) {
                appiumDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + placa + "\").instance(0))"));
            }
            util.esperarElemento(15, objChoferReemplazo.btnVehiculo(placa));
            Serenity.takeScreenshot();
            element(objChoferReemplazo.btnVehiculo(placa)).click();
        }catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("Error para seleccionar la placa del vehiculo");
        }

    }

    public void buscardestino() {
            util.esperarActivoClick(10, objChoferReemplazo.txtPuntoDestino);
            element(objChoferReemplazo.txtPuntoDestino).click();
            util.esperarSegundos(5);
            ((HidesKeyboard) appiumDriver()).hideKeyboard();
            element(objChoferReemplazo.txtPuntoPartida).click();
            ((HidesKeyboard) appiumDriver()).hideKeyboard();
            element(objChoferReemplazo.txtPuntoDestino).click();
            element(objChoferReemplazo.opcSelecPuntoMapa).click();
            util.esperarSegundos(5);
            element(objChoferReemplazo.opcConfirmarPuntoMapa).click();
            util.mobileSwipeScreenAndroid();
            util.esperarSegundos(5);
            element(objChoferReemplazo.opcContSelecPuntoMapa).click();
            Serenity.takeScreenshot();
            util.esperarActivoClick(10, objChoferReemplazo.btnChoferR);
            element(objChoferReemplazo.btnChoferR).click();
    }

    public void seleccionfecha() {
        try {
        util.esperarActivoClick(10, objChoferReemplazo.selecFecha);
        element(objChoferReemplazo.selecFecha).click();

        util.esperarActivoClick(10, objChoferReemplazo.btnAceptarFecha);
        element(objChoferReemplazo.btnAceptarFecha).click();
        }catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("Error cuando se añaden las fechas");
        }

    }
    public void seleccionhora() {
        try {
        util.esperarActivoClick(10, objChoferReemplazo.selecHora);
        element(objChoferReemplazo.selecHora).click();

        util.esperarActivoClick(10, objChoferReemplazo.btnConfirmarHora);
        element(objChoferReemplazo.btnConfirmarHora).click();

        util.esperarActivoClick(10, objChoferReemplazo.btnConfirmarFechaHora);
        element(objChoferReemplazo.btnConfirmarFechaHora).click();
        }catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("Error cuando se ingresan las horas");
        }
    }


    public void seleccionRequisitos() {

        try {
            util.esperarElemento(15, objChoferReemplazo.titRequisitosServicios);


            util.esperarActivoClick(10, objChoferReemplazo.chcBoxRevisionTecnica);
            element(objChoferReemplazo.chcBoxRevisionTecnica).click();

            util.esperarActivoClick(10, objChoferReemplazo.btnContinuarRevtec);
            element(objChoferReemplazo.btnContinuarRevtec).click();
        }catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("Error cuando se selecciona los requisitos");
        }
    }

    public void seleccionConfirmar() {
        try{
            util.esperarElementoVisible(5,objChoferReemplazo.titConfirmarChofer);
            int contador = 0;


            while (element(objChoferReemplazo.btnConfirmarChofer).isCurrentlyVisible()== false && contador < 7) {
                util.mobileSwipeScreenAndroid();
                contador++;
            }
            element(objChoferReemplazo.btnConfirmarChofer).click();
            Serenity.takeScreenshot();

        }catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("Error en la opcion Confirmar");
        }
    }

    public void irAlInicio(){

        try {
            util.esperarElemento(15, objChoferReemplazo.titChoferReemplazo);
            util.esperarActivoClick(10, objChoferReemplazo.btnIrInicio);
            element(objChoferReemplazo.btnIrInicio).click();
            if(element(objChoferReemplazo.btnCerrarmodal).isCurrentlyVisible())
            { element(objChoferReemplazo.btnCerrarmodal).click();}
            else{  util.esperarActivoClick(10, objChoferReemplazo.opcHome);
                element(objChoferReemplazo.opcHome).click();}

        }catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("Error para ingresar en opción ir Al Inicio");
        }

    }


    public boolean validacion_solicitud_chofer(String placa) {
        try {
            boolean solicitudExiste;
            util.esperarElemento(10, objChoferReemplazo.msjSolicitudChoferHome(placa));
            solicitudExiste = element(objChoferReemplazo.msjSolicitudChoferHome(placa)).isCurrentlyVisible();
            return solicitudExiste;
        } catch (Exception e) {
            throw new IllegalAccessError("Error no se puede validar el seguimiento de Chofer de reemplazo en el home");
        } finally {
            Serenity.takeScreenshot();
        }
    }

}
