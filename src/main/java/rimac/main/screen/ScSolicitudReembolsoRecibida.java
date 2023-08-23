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
	
	protected ObjSolicitudReembolsoRecibida objSolicitudReembolsoRecibida = ObjSolicitudReembolsoRecibida.getInstancia();
	protected ObjCommons objCommons = ObjCommons.getInstancia();
	// util
	protected MobileObjectUtil pageObjectUtil2 = MobileObjectUtil.getInstancia();
	public static Logger looger = Logger.getLogger(ScSolicitudReembolsoRecibida.class.getName());

	
	UtilApp util = new UtilApp();
	AppiumDriver driver;
	
	public String  obtenerMensaje() {
		looger.info("Ultimo Paso");
		String mensajeObtenido="";
		int contador=0;
		while(element(objSolicitudReembolsoRecibida.lblSolicitudRecibida).isCurrentlyVisible()==false && contador<20){
			if(element(objCommons.btnCerrarmodal).isCurrentlyVisible()){
				element(objCommons.btnCerrarmodal).click();
			}
			util.esperarSegundos(1);
			contador++;
		}
		Serenity.takeScreenshot();
		while(element(objSolicitudReembolsoRecibida.btnIrInicio).isCurrentlyVisible()==false && contador<10){
			if(element(objCommons.btnCerrarmodal).isCurrentlyVisible()){
				element(objCommons.btnCerrarmodal).click();
			}
			contador++;
		}
		mensajeObtenido= element(objSolicitudReembolsoRecibida.lblSolicitudRecibida).getText();
		element(objSolicitudReembolsoRecibida.btnIrInicio).click();
		util.esperarSegundos(2);
		return mensajeObtenido;
	}
	
	
	
}