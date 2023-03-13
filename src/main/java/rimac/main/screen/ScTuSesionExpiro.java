package rimac.main.screen;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.ScreenOrientation;
import rimac.main.object.ObjAsistenciaVehicular;
import rimac.main.object.ObjLogin;
import rimac.main.object.ObjTuSesionExpiro;
import rimac.main.util.BaseDriver;

import rimac.main.util.UtilApp;


import static org.junit.Assert.assertTrue;

public class ScTuSesionExpiro extends BaseDriver {

    protected ObjLogin objLogin = ObjLogin.getInstancia();
    protected ObjTuSesionExpiro objTuSesionExpiro = ObjTuSesionExpiro.getInstancia();
    UtilApp util = new UtilApp();
    public void inactividad_del_modulo() {
        util.esperarSegundos(5);
        //androidDriver().activateApp("com.google.android.apps.maps");
        //androidDriver().activateApp("com.rimac.rimac_surrogas.qa");
        //androidDriver().runAppInBackground(Duration.ofSeconds(10));
        //androidDriver().pressKey(new KeyEvent(AndroidKey.MENU));
        //androidDriver().pressKey(new KeyEvent(AndroidKey.CAMERA));
        //androidDriver().pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        //androidDriver().activateApp("com.android.chrome");
        androidDriver().pressKey(new KeyEvent(AndroidKey.CAMERA));
        //androidDriver().rotate(ScreenOrientation.PORTRAIT);
        Serenity.takeScreenshot();
        int contadorMinutos=0;
        while(contadorMinutos<15){
            util.mobileSwipeScreenAndroid();
            util.esperarSegundos(30);
            util.mobileSwipeScreenAndroid();
            util.esperarSegundos(30);
            System.out.println(contadorMinutos);
            contadorMinutos++;
        }
        androidDriver().pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        util.esperarSegundos(2);
        androidDriver().pressKey(new KeyEvent(AndroidKey.ENTER));
        androidDriver().pressKey(new KeyEvent(AndroidKey.ENTER));
        //element(objTuSesionExpiro.screen).click();
    }

    public void validacion_mensaje_TimeOut(){
        try{
            int contador=0;
            while(element(objTuSesionExpiro.titTusesionExpiro).isCurrentlyVisible()==false && contador<3){
                util.esperarSegundos(1);
                contador++;
            }
            assertTrue(element(objTuSesionExpiro.titTusesionExpiro).isCurrentlyVisible());
            Serenity.takeScreenshot();
            element(objTuSesionExpiro.btnEntendido).click();
        }catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("No aparece mensaje de Inactividad para retornar al login");
        }
    }

}
