package rimac.main.screen;

import java.io.File;
import java.io.IOException;
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
import rimac.main.object.ObjLogin;
import rimac.main.screen.ScValidaIdentid;
import rimac.main.object.ObjAlertas;
import rimac.main.object.ObjRegistrarHuella;
import rimac.main.object.ObjValidaIdentid;

public class ScValidaIdentid extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjValidaIdentid objValidaIdentid = ObjValidaIdentid.getInstancia();

	// util
	protected MobileObjectUtil pageObjectUtil2 = MobileObjectUtil.getInstancia();
	protected ObjAlertas alertasObject = ObjAlertas.getInstancia();
	public static Logger looger = Logger.getLogger(ScValidaIdentid.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilApp util = new UtilApp();
	AppiumDriver driver;

	public void ingresDocumen(String nroDocume) {
		
		
		util.esperarElemento(10, objValidaIdentid.nroDocume);
		element(objValidaIdentid.nroDocume).click();
		element(objValidaIdentid.nroDocume).sendKeys(nroDocume);
	
		try {
			((HidesKeyboard) appiumDriver()).hideKeyboard();
		} catch (Exception e) {
			
		}
		Serenity.takeScreenshot();
		element(objValidaIdentid.btnContinu).click();
	
	}
	
	
	
}