package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PushesFiles;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.pages.PageObject;
import rimac.main.util.PageObjectUtil2;
import rimac.main.util.UtilDef;
import rimac.main.util.VariablesAppNativa;
import rimac.main.object.LoginObject;
import rimac.main.object.ConfirmarDatosReembolsoSaludObject;


public class ConfirmarDatosReembolsoSaludScreen extends BaseScreen{

private long wdwTimeOut = 300L;
	
	protected ConfirmarDatosReembolsoSaludObject confirmarDatosReembolsoSaludObject = ConfirmarDatosReembolsoSaludObject.getInstancia();

	// util
	public static Logger looger = Logger.getLogger(ConfirmarDatosReembolsoSaludScreen.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilDef util = new UtilDef();
	AppiumDriver driver;
	
	public void llenarDatosDireccion(String departamento, String provincia, String distrito, String direccion) {
		util.esperarElemento(15, confirmarDatosReembolsoSaludObject.lblDni);
		appiumDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Dirección\").instance(0))"));
		System.out.println("******"   + confirmarDatosReembolsoSaludObject.selDepartamento.getText());
		if(confirmarDatosReembolsoSaludObject.selDepartamento.getText()=="Departamento") {
			element(confirmarDatosReembolsoSaludObject.selDepartamento).click();
			element(confirmarDatosReembolsoSaludObject.departamento(appiumDriver(), departamento)).click();
				
		}
		
		appiumDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Distrito\").instance(0))"));
		if(confirmarDatosReembolsoSaludObject.selProvincia.getText()=="Provincia") {
			element(confirmarDatosReembolsoSaludObject.selProvincia).click();
			element(confirmarDatosReembolsoSaludObject.provincia(appiumDriver(), provincia)).click();
	
		}
		
		if(confirmarDatosReembolsoSaludObject.selDistrito.getText()=="Distrito") {
			element(confirmarDatosReembolsoSaludObject.selDistrito).click();
			element(confirmarDatosReembolsoSaludObject.distrito(appiumDriver(), distrito)).click();
			
		}
		
		System.out.println("******"   + direccion);
		try {
			util.scroll();
		} catch (Exception e) {
			System.out.println("****** FAlla");
		}
		
		element(confirmarDatosReembolsoSaludObject.direccion()).click();
		element(confirmarDatosReembolsoSaludObject.direccion()).sendKeys(direccion);
		((HidesKeyboard) appiumDriver()).hideKeyboard();
		element(confirmarDatosReembolsoSaludObject.btnContinuar).click();
		util.esperarSegundos(5);
	}
	
}