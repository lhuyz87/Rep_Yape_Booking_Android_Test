package rimac.main.screen;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.NoSuchElementException;
import rimac.main.object.ObjAlertas;
import rimac.main.object.ObjAsistenciaVehicular;
import rimac.main.object.ObjCambioLlanta;
import rimac.main.object.ObjCommons;
import rimac.main.util.BaseDriver;

import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilApp;

import java.util.logging.Logger;

import static org.junit.Assert.*;

public class ScAsistenciaVehicular extends BaseDriver {

    protected ObjAsistenciaVehicular objAsistenciaVehicular = ObjAsistenciaVehicular.getInstancia();
    protected ObjCommons objCommons = ObjCommons.getInstancia();
    protected ObjAlertas objAlertas=ObjAlertas.getInstancia();
    protected ObjCambioLlanta objCambioLlanta = ObjCambioLlanta.getInstancia();
    public static Logger looger = Logger.getLogger(ScTusTramites.class.getName());
    static String placaVehiculo;
    private long wdwTimeOut = 300L;
    UtilApp util = new UtilApp();
    public long getWdwTimeOut() {
        return wdwTimeOut;
    }
    public void ingresar_Datos_de_Contacto(String nombre, String celular){

        util.esperarElemento(20,objAsistenciaVehicular.txtNombre);
        util.esperarSegundos(1);
        element(objAsistenciaVehicular.txtNombre).clear();
        element(objAsistenciaVehicular.txtNombre).sendKeys(nombre);
        util.pressEnter(androidDriver());
        element(objAsistenciaVehicular.txtCelular).clear();
        element(objAsistenciaVehicular.txtCelular).sendKeys(celular);
        util.esperarElemento(20,objAsistenciaVehicular.btnComenzar);
        element(objAsistenciaVehicular.btnComenzar).click();

    }

    public void seleccionar_Vehiculo(String placa){
        placaVehiculo = placa;
        util.esperarElemento(25,objAsistenciaVehicular.btnVehiculo(placaVehiculo));
        Serenity.takeScreenshot();
        element(objAsistenciaVehicular.btnVehiculo(placaVehiculo)).click();
    }

    public void confirmar_Ubicacion(){

        util.esperarElemento(15,objAsistenciaVehicular.btnContinuar);
        element(objAsistenciaVehicular.btnContinuar).click();
        Serenity.takeScreenshot();
        element(objAsistenciaVehicular.btnOmitir).click();

    }

    public void selecciona_asistencia_Auxilio_Mecanico(){

        int contador=0;

        while(element(objAsistenciaVehicular.btnAuxilioMecanico).isCurrentlyVisible()==false && contador<7) {
            util.mobileSwipeScreenAndroid();
            contador++;
        }
        element(objAsistenciaVehicular.btnAuxilioMecanico).click();
        Serenity.takeScreenshot();
        util.esperarElemento(20, objAsistenciaVehicular.btnContinuar);
        Serenity.takeScreenshot();
        element(objAsistenciaVehicular.btnContinuar).click();
    }

    public void selecciona_problema_vehiculo(String problema){
        util.esperarElemento(25,objAsistenciaVehicular.tit_problemas);
        int contador=0;
            while(element(objAsistenciaVehicular.opcProblema(problema)).isCurrentlyVisible()==false && contador<5) {
                util.mobileSwipeScreenAndroid();
                contador++;
            }
            util.esperarActivoClick(15, objAsistenciaVehicular.opcProblema(problema));
            element(objAsistenciaVehicular.opcProblema(problema)).click();
        Serenity.takeScreenshot();
        util.esperarActivoClick(10,objAsistenciaVehicular.btnContinuar);
        element(objAsistenciaVehicular.btnContinuar).click();
        if(problema.equals("Cambio de llanta")){
            element(objCambioLlanta.opcSiTengoRepuesto).click();
            Serenity.takeScreenshot();
            util.esperarActivoClick(10,objAsistenciaVehicular.btnContinuar);
            element(objAsistenciaVehicular.btnContinuar).click();
        }
    }

    public void confirmar_solicitud(){

        int contador=0;

        while(element(objAsistenciaVehicular.chk_terminos).isCurrentlyVisible()==false && contador<4) {
            util.mobileSwipeScreenAndroid();
            contador++;
        }
        element(objAsistenciaVehicular.chk_terminos).click();
        Serenity.takeScreenshot();
        util.esperarElemento(15,objAsistenciaVehicular.btnConfirmarSolicitud);
        Serenity.takeScreenshot();
        element(objAsistenciaVehicular.btnConfirmarSolicitud).click();
    }

    public void validacion_mensaje_confirmacion(){

        try{

            util.esperarElemento(10,objAsistenciaVehicular.msjSolicitudEnviada);
            String mensaje = element(objAsistenciaVehicular.msjSolicitudEnviada).getText();
            assertEquals(mensaje,"¡Solicitud enviada!");
            Serenity.takeScreenshot();
        }catch (NoSuchElementException ex){
            Serenity.takeScreenshot();
            if(element(objAlertas.mdlServicioEnProceso).isCurrentlyVisible()){
                throw new IllegalAccessError("Usuario ya tiene solicitud en proceso con la misma placa");
            }
        }catch(AssertionError e){
               Serenity.takeScreenshot();
               throw new IllegalAccessError("No se pudo enviar la solicitud");
        }
        util.esperarSegundos(5);
        if(element(objCommons.btnCerrarmodal).isCurrentlyVisible()){
            element(objCommons.btnCerrarmodal).click();
        }
        util.esperarElemento(10,objAsistenciaVehicular.btnIrAlInicio);
        element(objAsistenciaVehicular.btnIrAlInicio).click();
    }

    public void validacion_solicitud_home(){

        util.esperarElemento(10,objAsistenciaVehicular.msjSolicitudAsistenciaHome(placaVehiculo));
        assertTrue(element(objAsistenciaVehicular.msjSolicitudAsistenciaHome(placaVehiculo)).isCurrentlyVisible());
        Serenity.takeScreenshot();
    }
}
