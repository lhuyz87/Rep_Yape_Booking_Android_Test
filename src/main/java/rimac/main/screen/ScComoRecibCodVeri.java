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
import rimac.main.util.UtilDef;
import rimac.main.util.VariablesAppNativa;
import rimac.main.object.ObjLogin;
import rimac.main.screen.ScComoRecibCodVeri;
import rimac.main.object.ObjAlertas;
import rimac.main.object.ObjComoRecibCodVeri;
import rimac.main.object.ObjRegistrarHuella;
import rimac.main.object.ObjValidaIdentid;

public class ScComoRecibCodVeri extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjComoRecibCodVeri objComoRecibCodVeri = ObjComoRecibCodVeri.getInstancia();

	// util
	protected MobileObjectUtil pageObjectUtil2 = MobileObjectUtil.getInstancia();
	protected ObjAlertas alertasObject = ObjAlertas.getInstancia();
	public static Logger looger = Logger.getLogger(ScComoRecibCodVeri.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilDef util = new UtilDef();
	AppiumDriver driver;
	
public void seleccResponPregun() {
		
		util.esperarElemento(5,objComoRecibCodVeri.btnRespoPregun);
		Serenity.takeScreenshot();
//		mobileObjectUtil.esperarElemento(10, objEligeComoRecibiCodigoVerifi.lblEligeComoRecibiCodigoVerifi);
		element(objComoRecibCodVeri.btnRespoPregun).click();

	}

	
	
	
	
}