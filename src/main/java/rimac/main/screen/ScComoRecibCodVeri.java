package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.Logger;

import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilApp;
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
	
	UtilApp util = new UtilApp();
	AppiumDriver driver;
	
public void seleccResponPregun() {

	    util.esperarElemento(5,objComoRecibCodVeri.titEligeComoRecibir);
		int contador=0;
		while(element(objComoRecibCodVeri.btnRespoPregun).isCurrentlyVisible()==false && contador<4){
			util.mobileSwipeScreenAndroid();
			contador++;
		}


//		mobileObjectUtil.esperarElemento(10, objEligeComoRecibiCodigoVerifi.lblEligeComoRecibiCodigoVerifi);
	    new WebDriverWait(androidDriver(), Duration.ofSeconds(5))
			.until(ExpectedConditions.visibilityOf(objComoRecibCodVeri.btnRespoPregun));
	    Serenity.takeScreenshot();
		element(objComoRecibCodVeri.btnRespoPregun).click();

	}

	
	
	
	
}