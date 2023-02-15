package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import com.github.dockerjava.api.model.Driver;

//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.PushesFiles;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilApp;
import rimac.main.util.VariablesAppNativa;
import rimac.main.object.ObjLogin;
import rimac.main.screen.ScLogin;
import rimac.main.object.ObjAlertas;
import rimac.main.object.ObjRegistrarHuella;

import static org.junit.Assert.assertFalse;

public class ScLogin extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjLogin objLogin = ObjLogin.getInstancia();

	// util
	protected MobileObjectUtil pageObjectUtil2 = MobileObjectUtil.getInstancia();
	protected ObjAlertas alertasObject = ObjAlertas.getInstancia();
	protected ObjRegistrarHuella registrarHuellaObject = ObjRegistrarHuella.getInstancia();
	
	public static Logger looger = Logger.getLogger(ScLogin.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilApp util = new UtilApp();
	protected MobileObjectUtil mobil = MobileObjectUtil.getInstancia();
//	AppiumDriver driver;
	
	public void login(String dniUser, String passUser) {
		looger.info("aplicación iniciada");
		util.esperarElemento(20, objLogin.btnIngresarSesion);
		
		element(objLogin.btnIngresarSesion).click();
		element(objLogin.txtNumDocumento).click();
		element(objLogin.txtNumDocumento).sendKeys(dniUser);
		
		try {
			((HidesKeyboard) appiumDriver()).hideKeyboard();
		} catch (Exception e) {
			
		}

		element(objLogin.txtPassword).click();
		element(objLogin.txtPassword).sendKeys(passUser);
		try {
			((HidesKeyboard) appiumDriver()).hideKeyboard();
		} catch (Exception e) {
			
		}
	
		element(objLogin.btnIngresarSesion).click();
		mobil.esperarSegundosCondicion(7,element(objLogin.mdlCreaUnaCuenta).isEnabled());
		try{
			assertFalse(element(objLogin.txtPassword).isCurrentlyVisible());
			assertFalse(element(objLogin.mdlCreaUnaCuenta).isCurrentlyVisible());
		}catch(AssertionError e){
			throw new IllegalAccessError("No se pudo completar el Login");
		}

	}

	public void seleccOlvidaContra() {
		// TODO Auto-generated method stub
		looger.info("aplicación iniciada");
		util.esperarElemento(4, objLogin.btnIngresarSesion);
		element(objLogin.btnIngresarSesion).click();
		looger.info("aplicación iniciada");
		util.esperarElemento(10, objLogin.btnOlvideContra);
		Serenity.takeScreenshot();
		element(objLogin.btnOlvideContra).click();
		
	}

	public String getMensajeActualizar() {
		// TODO Auto-generated method stub
		util.esperarElemento(6, objLogin.lblActualizarVersion);
		
		return objLogin.lblActualizarVersion.getText();
	}

	public void seleccMasTarde() {
		// TODO Auto-generated method stub
		element(objLogin.btnMasTarde).click();
	}

	public void muestraLogin() {
		util.esperarElemento(4, objLogin.btnIngresarSesion);
		
	}

	public void muestraOpcionActualizar() {
		// TODO Auto-generated method stub
		util.esperarElemento(4, objLogin.btnActualizar);
	}

	public boolean noMostrarOpcionMasTarde() {
		// TODO Auto-generated method stub
		System.out.println("Pasa");
		
		try {
			
			if(objLogin.btnMasTarde.isEnabled())
				return true;
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return false;
		
	}
	
	public boolean noMuestraLogin() {
		// TODO Auto-generated method stub
		boolean result = false;
		System.out.println("Pasa");
		util.esperarElemento(1, objLogin.btnIngresarSesion);
		try {
			
			if(objLogin.btnIngresarSesion.isEnabled()) {
				result = true;
				return result;
			}
				
		}catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
			return result;
	}
}