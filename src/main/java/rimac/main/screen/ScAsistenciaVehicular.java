package rimac.main.screen;

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
    static String placaVehiculo;
    static String tipoAsistencia;
    private long wdwTimeOut = 300L;
    UtilApp util = new UtilApp();
    public long getWdwTimeOut() {
        return wdwTimeOut;
    }

    public void terminosCondicionesAsistencia(){
        util.esperarSegundos(3);
        int contador = 0;
        if(element(objAsistenciaVehicular.titSolicitaAsistencia).isCurrentlyVisible()){
            while (element(objAsistenciaVehicular.chktermsAsistencia).isCurrentlyVisible()== false && contador < 7) {
                util.mobileSwipeScreenAndroid();
                contador++;
            }
            element(objAsistenciaVehicular.chktermsAsistencia).click();
            element(objAsistenciaVehicular.btnContinuar).click();
        }
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

    public void se_indica_asistencia_vehicular(String asistencia, String placa){
        tipoAsistencia=asistencia;
        placaVehiculo=placa;
    }

    public void seleccionar_Vehiculo(String placa){
        placaVehiculo = placa;
        util.esperarElemento(15,objAsistenciaVehicular.titTusVehiculosAfiliados);
        util.esperarSegundos(1);
        util.esperarElemento(15,objAsistenciaVehicular.btnVehiculo(placaVehiculo));
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

    public void selecciona_asistencia(String asistencia){
        tipoAsistencia=asistencia;
        try {
            util.esperarElemento(5,objAsistenciaVehicular.titQueNecesitas);
            util.esperarSegundos(2);
            int contador = 0;
            while (element(objAsistenciaVehicular.btnAsistencia(tipoAsistencia)).isCurrentlyVisible() == false && contador < 7) {
                util.mobileSwipeScreenAndroid();
                contador++;
            }
            element(objAsistenciaVehicular.btnAsistencia(tipoAsistencia)).click();
            util.esperarElemento(20, objAsistenciaVehicular.btnContinuar);
            Serenity.takeScreenshot();
            element(objAsistenciaVehicular.btnContinuar).click();
        }catch(Exception e){
            throw new IllegalAccessError("Error para seleccionar la asistencia:  "+tipoAsistencia);
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
        try {
            util.esperarElemento(10, objAsistenciaVehicular.titConfirmacionAsistencia);
            int contador = 0;
            while (element(objAsistenciaVehicular.chk_terminos).isCurrentlyVisible() == false && contador<10) {
                util.mobileSwipeScreenAndroid();
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

    public void validacion_mensaje_confirmacion(){
        try{
            WebElement asistencia = null;
                switch (tipoAsistencia) {
                    case "Auxilio mecánico": {
                        asistencia=objAsistenciaVehicular.msjConfirmacionAuxilioM;
                        break;
                    }
                    case "Grúa": {
                        asistencia=objAsistenciaVehicular.msjConfirmacionGrua;
                        break;
                    }
                    default: {
                        System.out.println("Elemento no encontrado");
                    }
                }
                int intentos=0;
                while(element(asistencia).isCurrentlyVisible()==false && intentos<20){
                    if(element(objCommons.btnCerrarmodal).isCurrentlyVisible()){
                        element(objCommons.btnCerrarmodal).click();
                    }
                    if(element(objAsistenciaVehicular.titYaTienesunServicio).isCurrentlyVisible()){
                        break;
                    }
                    intentos++;
                }
                if(element(objCommons.btnCerrarmodal).isCurrentlyVisible()){
                    element(objCommons.btnCerrarmodal).click();
                }
                String mensaje = element(objAsistenciaVehicular.msjSolicitudEnviada).getText();
                assertEquals(mensaje,"¡Solicitud enviada!");
                util.esperarSegundos(3);
                Serenity.takeScreenshot();
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
        util.esperarElemento(10,objAsistenciaVehicular.msjSolicitudAsistenciaHome(placaVehiculo,tipoAsistencia));
        assertTrue(element(objAsistenciaVehicular.msjSolicitudAsistenciaHome(placaVehiculo,tipoAsistencia)).isCurrentlyVisible());
        Serenity.takeScreenshot();
    }




}
