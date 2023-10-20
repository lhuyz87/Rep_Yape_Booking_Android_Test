package yape.main.screen;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.html5.Location;
import com.github.dockerjava.api.model.Driver;

//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.PushesFiles;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import yape.main.object.ObjLogin;
import yape.main.screen.ScLogin;
import yape.main.util.BaseDriver;
import yape.main.util.MobileObjectUtil;
import yape.main.util.UtilApp;
import yape.main.util.VariablesAppNativa;

import static org.junit.Assert.assertFalse;

public class ScLogin extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjLogin objLogin = ObjLogin.getInstancia();

	
	
	public static Logger looger = Logger.getLogger(ScLogin.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilApp util = new UtilApp();
	protected MobileObjectUtil mobil = MobileObjectUtil.getInstancia();
	AppiumDriver driver;
	
	public void ingresarCuentaGoogle() {
		// TODO Auto-generated method stub
		
		util.esperarElementoClick(3, objLogin.btnIngresarGoogle);
		Serenity.takeScreenshot();
		util.clickOn(objLogin.btnIngresarGoogle);
		util.esperarSegundos(4);
		util.clickOn(objLogin.btnCorreo);
		Serenity.takeScreenshot();
	}
}