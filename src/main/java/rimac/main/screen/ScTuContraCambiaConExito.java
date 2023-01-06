package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.PushesFiles;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilApp;
import rimac.main.util.VariablesAppNativa;
import rimac.main.object.ObjTuContraCambiaConExito;


public class ScTuContraCambiaConExito extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjTuContraCambiaConExito objTuContraCambiaConExito = ObjTuContraCambiaConExito.getInstancia();
	protected MobileObjectUtil pageObjectUtil2 = MobileObjectUtil.getInstancia();
	public static Logger looger = Logger.getLogger(ScTuContraCambiaConExito.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilApp util = new UtilApp();
	AppiumDriver driver;


	public String getTituloMensaje() {
		
		String mensaje="";
		
		util.esperarActivoClick(10, objTuContraCambiaConExito.lblMensaj);

		Serenity.takeScreenshot();
		mensaje=objTuContraCambiaConExito.lblMensaj.getText();
		System.out.println("Mensaje mostrado " + mensaje);
		util.esperarSegundos(5);
		
		return mensaje;
		
	}
	
	
	
}