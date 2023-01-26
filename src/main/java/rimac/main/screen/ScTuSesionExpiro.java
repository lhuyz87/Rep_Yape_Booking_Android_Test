package rimac.main.screen;

import rimac.main.object.ObjAsistenciaVehicular;
import rimac.main.object.ObjLogin;
import rimac.main.object.ObjTuSesionExpiro;
import rimac.main.util.BaseDriver;
import rimac.main.util.UtilApp;
import static org.junit.Assert.assertTrue;

public class ScTuSesionExpiro extends BaseDriver {

    protected ObjAsistenciaVehicular objAsistenciaVehicular = ObjAsistenciaVehicular.getInstancia();
    protected ObjLogin objLogin = ObjLogin.getInstancia();
    protected ObjTuSesionExpiro objTuSesionExpiro = ObjTuSesionExpiro.getInstancia();
    UtilApp util = new UtilApp();
    public void inactividad_del_modulo_AsistenciasVehiculares(){
        util.esperarElemento(25,objAsistenciaVehicular.txtNombre);
        util.esperarSegundos(1);
        util.pressEnter(androidDriver());
        util.esperarMinutos(15);
    }

    public void validacion_mensaje_TimeOut(){
        try{
            util.esperarElemento(3,objTuSesionExpiro.titTusesionExpiro);
            assertTrue(element(objTuSesionExpiro.titTusesionExpiro).isCurrentlyVisible());
            element(objTuSesionExpiro.btnEntendido).click();
        }catch(AssertionError e){
            throw new IllegalAccessError("No aparece mensaje de Inactividad para retornar al login");
        }

        try{
            util.esperarElemento(5,objLogin.txtNumDocumento);
            assertTrue(element(objLogin.txtNumDocumento).isCurrentlyVisible());
        }catch(AssertionError e){
            throw new IllegalAccessError("No logro retornar al Login");
        }
    }

}
