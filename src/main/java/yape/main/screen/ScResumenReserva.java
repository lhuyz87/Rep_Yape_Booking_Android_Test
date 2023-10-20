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

import yape.main.object.ObjDatosCliente;
import yape.main.object.ObjResumenReserva;
import yape.main.screen.ScResumenReserva;
import yape.main.util.BaseDriver;
import yape.main.util.MobileObjectUtil;
import yape.main.util.UtilApp;
import yape.main.util.VariablesAppNativa;

import static org.junit.Assert.assertFalse;

public class ScResumenReserva extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjResumenReserva objResumenReserva = ObjResumenReserva.getInstancia();

	
	
	public static Logger looger = Logger.getLogger(ScResumenReserva.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilApp util = new UtilApp();
	protected MobileObjectUtil mobil = MobileObjectUtil.getInstancia();
	AppiumDriver driver;

	public void confirmarReserva() {
		// TODO Auto-generated method stub
		util.esperarElemento(3, objResumenReserva.btnUltimoPaso);
		element( objResumenReserva.btnUltimoPaso).click();
		
		util.esperarSegundos(10);
	}
	


	
}