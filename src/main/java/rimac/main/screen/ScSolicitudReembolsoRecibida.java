package rimac.main.screen;


import java.util.logging.Logger;

//import com.gargoylesoftware.htmlunit.html.Keyboard;


import io.appium.java_client.AppiumDriver;
import net.serenitybdd.core.Serenity;
import rimac.main.object.ObjCommons;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilApp;
import rimac.main.object.ObjSolicitudReembolsoRecibida;


public class ScSolicitudReembolsoRecibida extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjSolicitudReembolsoRecibida objSolicitudReembolsoRecibida = ObjSolicitudReembolsoRecibida.getInstancia();
	protected ObjCommons objCommons = ObjCommons.getInstancia();
	// util
	protected MobileObjectUtil pageObjectUtil2 = MobileObjectUtil.getInstancia();
	public static Logger looger = Logger.getLogger(ScSolicitudReembolsoRecibida.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilApp util = new UtilApp();
	AppiumDriver driver;
	
	public String  obtenerMensaje() {
		looger.info("Ultimo Paso");
		int contador=0;
		while(element(objSolicitudReembolsoRecibida.lblSolicitudRecibida).isCurrentlyVisible()==false && contador<20){
			//Permite cerrar el modal de recomendación para calificar la app en la playstore
			if(element(objCommons.btnCerrarmodal).isCurrentlyVisible()){
				element(objCommons.btnCerrarmodal).click();
			}
			util.esperarSegundos(1);
			contador++;
		}
		String mensajeObtenido = element(objSolicitudReembolsoRecibida.lblSolicitudRecibida).getText();
		Serenity.takeScreenshot();
		while(element(objSolicitudReembolsoRecibida.btnIrInicio).isCurrentlyVisible()==false && contador<10){
			if(element(objCommons.btnCerrarmodal).isCurrentlyVisible()){
				element(objCommons.btnCerrarmodal).click();
			}
			contador++;
		}
		element(objSolicitudReembolsoRecibida.btnIrInicio).click();
		util.esperarSegundos(5);
		return mensajeObtenido;
	}
	
	
	
}