package rimac.main.screen;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.NoSuchElementException;
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
    static String placaVehiculo;
    private long wdwTimeOut = 300L;
    UtilApp util = new UtilApp();
    public long getWdwTimeOut() {
        return wdwTimeOut;
    }
    public void ingresar_Datos_de_Contacto(String nombre, String celular){

        util.esperarElemento(25,objAsistenciaVehicular.txtNombre);
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

        util.esperarElemento(10,objAsistenciaVehicular.btnContinuar);
        element(objAsistenciaVehicular.btnContinuar).click();
        Serenity.takeScreenshot();
        util.esperarElemento(10,objAsistenciaVehicular.btnOmitir);
        element(objAsistenciaVehicular.btnOmitir).click();

    }

    public void selecciona_asistencia_Auxilio_Mecanico(){

        int contador=0;

        while(element(objAsistenciaVehicular.btnAuxilioMecanico).isCurrentlyVisible()==false && contador<10) {
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
        util.esperarSegundos(2);
        util.esperarElemento(15,objAsistenciaVehicular.opcProblema("Batería baja"));
        int contador=0;
            while(element(objAsistenciaVehicular.opcProblema(problema)).isCurrentlyVisible()==false && contador<10) {
                util.mobileSwipeScreenAndroid();
                contador++;
            }
            util.esperarElemento(20, objAsistenciaVehicular.opcProblema(problema));
            element(objAsistenciaVehicular.opcProblema(problema)).click();
        Serenity.takeScreenshot();
        util.esperarElemento(10,objAsistenciaVehicular.btnContinuar);
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

        while(element(objAsistenciaVehicular.chk_terminos).isCurrentlyVisible()==false && contador<10) {
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
        int intentos=0;
            while(element(objAsistenciaVehicular.msjSolicitudEnviada).isCurrentlyVisible()==false && intentos<30){

                if(element(objCommons.btnCerrarmodal).isCurrentlyVisible()){
                    element(objCommons.btnCerrarmodal).click();
                }
                if(element(objAsistenciaVehicular.msjSolicitudEnviada).isCurrentlyVisible()){
                    String mensaje = element(objAsistenciaVehicular.msjSolicitudEnviada).getText();
                    assertEquals(mensaje,"¡Solicitud enviada!");
                    Serenity.takeScreenshot();
                    break;
                }
                System.out.println("contador mensaje " + intentos);
                util.esperarSegundos(1);
                intentos++;
            }
            if(element(objCommons.btnCerrarmodal).isCurrentlyVisible()){
                element(objCommons.btnCerrarmodal).click();
            }
            element(objAsistenciaVehicular.btnIrAlInicio).click();
        }catch (NoSuchElementException ex){
            Serenity.takeScreenshot();
            if(element(objAlertas.mdlServicioEnProceso).isCurrentlyVisible()){
                throw new IllegalAccessError("Usuario ya tiene solicitud en proceso con la misma placa");
            }
        }catch(AssertionError e){
               Serenity.takeScreenshot();
               throw new IllegalAccessError("No se pudo enviar la solicitud");
        }
    }

    public void validacion_solicitud_home(){

        util.esperarElemento(10,objAsistenciaVehicular.msjSolicitudAsistenciaHome(placaVehiculo));
        assertTrue(element(objAsistenciaVehicular.msjSolicitudAsistenciaHome(placaVehiculo)).isCurrentlyVisible());
        Serenity.takeScreenshot();
    }




}
