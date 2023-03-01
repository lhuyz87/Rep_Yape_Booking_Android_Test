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
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilApp;
import rimac.main.util.VariablesAppNativa;
import rimac.main.object.ObjLogin;
import rimac.main.object.ObjConfirmarDatosReembolsoSalud;


public class ScConfirmarDatosReembolsoSalud extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjConfirmarDatosReembolsoSalud confirmarDatosReembolsoSaludObject = ObjConfirmarDatosReembolsoSalud.getInstancia();

	// util
	public static Logger looger = Logger.getLogger(ScConfirmarDatosReembolsoSalud.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilApp util = new UtilApp();
	AppiumDriver driver;
	
	public void llenarDatosDireccion(String departamento, String provincia, String distrito, String direccion) {
		
		looger.info("LLena datos dirección");
		System.out.println("***************************************************");
		util.esperarElementoVisible(15,confirmarDatosReembolsoSaludObject.lblDataTitle);
		util.esperarElementoVisible(15, confirmarDatosReembolsoSaludObject.lblDni);
		util.mobileSwipeScreenAndroidFinal();
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
		
		
			if(depAux==0) {
				System.out.println("ENTRA a llenar departamento"  + departamento);
				
				util.esperarElemento(8, confirmarDatosReembolsoSaludObject.selDepartamento);
				element(confirmarDatosReembolsoSaludObject.selDepartamento).click();
				element(confirmarDatosReembolsoSaludObject.departamento(appiumDriver(), departamento)).click();
				util.mobileSwipeScreenAndroidFinal();
				element(confirmarDatosReembolsoSaludObject.selProvincia).click();
				element(confirmarDatosReembolsoSaludObject.provincia(appiumDriver(), provincia)).click();
				util.mobileSwipeScreenAndroidFinal();
				element(confirmarDatosReembolsoSaludObject.selDistrito).click();
				util.mobileSwipeScreenAndroidFinal();
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
			System.out.println(e.getMessage());
		}
		
		try {
			util.scroll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		util.esperarActivoClick(4, confirmarDatosReembolsoSaludObject.btnContinuar);
		element(confirmarDatosReembolsoSaludObject.btnContinuar).click();
		util.esperarSegundos(10);
	}
	
}