package rimac.main.screen;


import java.util.logging.Logger;

//import com.gargoylesoftware.htmlunit.html.Keyboard;


import io.appium.java_client.AppiumDriver;
import net.serenitybdd.core.Serenity;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilApp;
import rimac.main.object.ObjSolicitudReembolsoRecibida;


public class ScSolicitudReembolsoRecibida extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjSolicitudReembolsoRecibida objSolicitudReembolsoRecibida = ObjSolicitudReembolsoRecibida.getInstancia();
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
		util.esperarElementoVisible(15, objSolicitudReembolsoRecibida.lblSolicitudRecibida);
		Serenity.takeScreenshot();
		String mensajeObtenido= objSolicitudReembolsoRecibida.lblSolicitudRecibida.getText();
		util.esperarElemento(5, objSolicitudReembolsoRecibida.btnIrInicio);
		element(objSolicitudReembolsoRecibida.btnIrInicio).click();
		util.esperarSegundos(5);
		
		return mensajeObtenido;
	}
	
	
	
}