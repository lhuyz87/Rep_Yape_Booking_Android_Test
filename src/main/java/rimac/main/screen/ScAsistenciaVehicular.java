package rimac.main.screen;

import io.appium.java_client.MobileBy;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import rimac.main.object.*;
import rimac.main.util.BaseDriver;
import rimac.main.util.UtilApp;

import java.util.logging.Logger;

import static org.junit.Assert.*;

public class  ScAsistenciaVehicular extends BaseDriver {

    protected ObjAsistenciaVehicular objAsistenciaVehicular = ObjAsistenciaVehicular.getInstancia();

    protected ObjLogin objLogin = ObjLogin.getInstancia();
    protected ObjTuSesionExpiro objTuSesionExpiro = ObjTuSesionExpiro.getInstancia();
    protected ObjCommons objCommons = ObjCommons.getInstancia();
    protected ObjAlertas objAlertas=ObjAlertas.getInstancia();
    protected ObjCambioLlanta objCambioLlanta = ObjCambioLlanta.getInstancia();
    public static Logger looger = Logger.getLogger(ScTusTramites.class.getName());
    private long wdwTimeOut = 300L;
    UtilApp util = new UtilApp();
    public long getWdwTimeOut() {
        return wdwTimeOut;
    }

    public void terminosCondicionesAsistencia(){
        try{
            util.esperarSegundos(3);
            int contador = 0;
            if(element(objAsistenciaVehicular.titSolicitaAsistencia).isCurrentlyVisible()){
                while (element(objAsistenciaVehicular.chktermsAsistencia).isCurrentlyVisible()== false && contador < 7) {
                    util.mobileSwipeScreenAndroid();
                    contador++;
                }
                element(objAsistenciaVehicular.chktermsAsistencia).click();
                Serenity.takeScreenshot();
                element(objAsistenciaVehicular.btnContinuar).click();
            }
        }catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("Error para ingresar a Asistencias Vehiculares");
        }
    }
    public void ingresar_Datos_de_Contacto(String nombre, String celular){
        try {
            util.esperarElemento(25, objAsistenciaVehicular.titCelulardeContacto);
            util.esperarElementoVisible(15, objAsistenciaVehicular.idtxtNombre);
            element(objAsistenciaVehicular.txtNombre).clear();
            element(objAsistenciaVehicular.txtNombre).sendKeys(nombre);
            util.pressEnter(androidDriver());
            element(objAsistenciaVehicular.txtCelular).clear();
            element(objAsistenciaVehicular.txtCelular).sendKeys(celular);
            util.esperarElemento(20, objAsistenciaVehicular.btnComenzar);
            Serenity.takeScreenshot();
            element(objAsistenciaVehicular.btnComenzar).click();
        }catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("Error para ingresar Datos de Contacto");
        }
    }

    public void seleccionar_Vehiculo(String placa){
        try {
            util.esperarElemento(15, objAsistenciaVehicular.titTusVehiculosAfiliados);
            util.esperarSegundos(5);
            if (element(objAsistenciaVehicular.btnVehiculo(placa)).isCurrentlyVisible() == false) {
                appiumDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + placa + "\").instance(0))"));
            }
            util.esperarElemento(15, objAsistenciaVehicular.btnVehiculo(placa));
            Serenity.takeScreenshot();
            element(objAsistenciaVehicular.btnVehiculo(placa)).click();
        }catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("Error para seleccionar la placa del vehiculo");
        }

    }

    public void confirmar_Ubicacion(){
        try {
            util.esperarSegundos(3);
            if (element(objAsistenciaVehicular.btnNoThanks).isCurrentlyVisible()) {
                element(objAsistenciaVehicular.btnNoThanks).click();
            }
            util.esperarElemento(5, objAsistenciaVehicular.btnContinuar);
            element(objAsistenciaVehicular.btnContinuar).click();
            Serenity.takeScreenshot();
            util.esperarElemento(15, objAsistenciaVehicular.btnOmitir);
            Serenity.takeScreenshot();
            element(objAsistenciaVehicular.btnOmitir).click();
        }catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("Error para seleccionar la ubicación");
        }
    }

    public void selecciona_asistencia(String asistencia){
        try {
            util.esperarElemento(5,objAsistenciaVehicular.titQueNecesitas);
            util.esperarSegundos(2);
            int contador = 0;
            while (element(objAsistenciaVehicular.btnAsistencia(asistencia)).isCurrentlyVisible() == false && contador < 7) {
                util.mobileSwipeScreenAndroid();
                contador++;
            }
            element(objAsistenciaVehicular.btnAsistencia(asistencia)).click();
            util.esperarElemento(20, objAsistenciaVehicular.btnContinuar);
            Serenity.takeScreenshot();
            element(objAsistenciaVehicular.btnContinuar).click();
        }catch(Exception e){
            throw new IllegalAccessError("Error para seleccionar la asistencia:  "+asistencia);
        }
    }

    public void indica_zona_del_vehiculo(){
        try {
            util.esperarElemento(10, objAsistenciaVehicular.titTuVehiculoZona);
            element(objAsistenciaVehicular.opcEspaciofacilAcceso).click();
            element(objAsistenciaVehicular.btnContinuar).click();
            Serenity.takeScreenshot();
        }catch(Exception e){
            throw new IllegalAccessError("Error no se puede validar el seguimiento de asistencias vehiculares en el home");
        }
    }

    public void selecciona_problema_vehiculo(String problema){
        try {
            util.esperarSegundos(2);
            util.esperarElemento(15, objAsistenciaVehicular.tit_problemas);
            util.esperarElemento(15, objAsistenciaVehicular.opcProblema("Batería baja"));
            int contador = 0;
            while (element(objAsistenciaVehicular.opcProblema(problema)).isCurrentlyVisible() == false && contador < 10) {
                util.mobileSwipeScreenAndroid();
                contador++;
            }
            util.esperarElemento(20, objAsistenciaVehicular.opcProblema(problema));
            element(objAsistenciaVehicular.opcProblema(problema)).click();
            Serenity.takeScreenshot();
            util.esperarElemento(10, objAsistenciaVehicular.btnContinuar);
            element(objAsistenciaVehicular.btnContinuar).click();
            if (problema.equals("Cambio de llanta")) {
                element(objCambioLlanta.opcSiTengoRepuesto).click();
                Serenity.takeScreenshot();
                util.esperarActivoClick(10, objAsistenciaVehicular.btnContinuar);
                element(objAsistenciaVehicular.btnContinuar).click();
            }
            util.esperarElemento(15, objAsistenciaVehicular.titConfirmacionAsistencia);
        }catch(Exception e){
            throw new IllegalAccessError("Error para seleccionar el problema del vehiculo");
        }
    }

    public void confirmar_solicitud(){
        try {
            util.esperarElemento(5, objAsistenciaVehicular.titConfirmacionAsistencia);
            int contador = 0;
            while (element(objAsistenciaVehicular.chk_terminos).isCurrentlyVisible() == false && contador<20) {
                util.mobileSwipeScreenAndroid();
                util.esperarSegundos(1);
                contador++;
            }
            element(objAsistenciaVehicular.chk_terminos).click();
            Serenity.takeScreenshot();
            util.esperarElemento(15, objAsistenciaVehicular.btnConfirmarSolicitud);
            Serenity.takeScreenshot();
            element(objAsistenciaVehicular.btnConfirmarSolicitud).click();
        }catch(Exception e){
            throw new IllegalAccessError("Error no se puede confirmar la solicitud ");
        }
    }

    public String obtener_mensaje_confirmacion(){
        try {
            String mensaje = "";
            int contador=0;
            while(element(objAsistenciaVehicular.lblSolicitudEnviada).isCurrentlyVisible()==false && contador<20){
                //Permite cerrar el modal de recomendación para calificar la app en la playstore
                if(element(objCommons.btnCerrarmodal).isCurrentlyVisible()){
                    element(objCommons.btnCerrarmodal).click();
                }
                if(element(objAsistenciaVehicular.titYaTienesunServicio).isCurrentlyVisible()){
                    break;
                }
                util.esperarSegundos(1);
                contador++;
            }
            if(element(objCommons.btnCerrarmodal).isCurrentlyVisible()){
                element(objCommons.btnCerrarmodal).click();
            }
            mensaje = element(objAsistenciaVehicular.lblSolicitudEnviada).getText();
            util.esperarSegundos(3);
            return mensaje;
        } catch (NoSuchElementException ex) {
            throw new IllegalAccessError("No se pudo validar el mensaje de Solicitud enviada ");
        } finally {
            Serenity.takeScreenshot();
        }
    }

    public boolean validacion_AsistenciaVehicular_home(String asistencia, String placa) {
        try {
            boolean solicitudExiste;
            util.esperarElemento(10, objAsistenciaVehicular.msjSolicitudAsistenciaHome(asistencia,placa));
            solicitudExiste = element(objAsistenciaVehicular.msjSolicitudAsistenciaHome(asistencia,placa)).isCurrentlyVisible();
            return solicitudExiste;
        } catch (Exception e) {
            throw new IllegalAccessError("Error no se puede validar el seguimiento de asistencias vehiculares en el home");
        } finally {
            Serenity.takeScreenshot();
        }
    }

}
