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
		
		looger.info("LLena datos dirección");
		System.out.println("***************************************************");
		util.esperarSegundos(3);
		util.esperarElemento(15, confirmarDatosReembolsoSaludObject.lblDni);
		appiumDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Dirección\").instance(0))"));
//		util.esperarElemento(5, confirmarDatosReembolsoSaludObject.selDepartamento);
		util.esperarSegundos(3);
		
		//
		int depAux=0;
		try {
			if(confirmarDatosReembolsoSaludObject.departamento(appiumDriver(), departamento).isDisplayed()==true) {
				depAux++;	
			}}catch (Exception e) {
			System.out.println( "Mensaje 1: " + e.getMessage());
		}
		
//		try {
//			if(confirmarDatosReembolsoSaludObject.txtDepartamento.getText()=="Departamento") {
//				depAux++;	
//			}}catch (Exception e) {
//			System.out.println(e.getMessage());
//			System.out.println( "Mensaje 2: " + e.getMessage());
//		}
		
		
			if(depAux==0) {
				System.out.println("ENTRA a llenar departamento");
				util.esperarSegundos(3);
				element(confirmarDatosReembolsoSaludObject.selDepartamento).click();
				element(confirmarDatosReembolsoSaludObject.departamento(appiumDriver(), departamento)).click();
				appiumDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Distrito\").instance(0))"));
				element(confirmarDatosReembolsoSaludObject.selProvincia).click();
				element(confirmarDatosReembolsoSaludObject.provincia(appiumDriver(), provincia)).click();
				element(confirmarDatosReembolsoSaludObject.selDistrito).click();
				element(confirmarDatosReembolsoSaludObject.distrito(appiumDriver(), distrito)).click();
				
			}
		
		try {
			util.scroll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			element(confirmarDatosReembolsoSaludObject.direccion()).click();
			element(confirmarDatosReembolsoSaludObject.direccion()).sendKeys(direccion);
			((HidesKeyboard) appiumDriver()).hideKeyboard();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		element(confirmarDatosReembolsoSaludObject.btnContinuar).click();
		util.esperarSegundos(5);
	}
	
}