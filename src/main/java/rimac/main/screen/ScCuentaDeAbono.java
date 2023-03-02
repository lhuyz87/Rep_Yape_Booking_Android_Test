package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.WebElement;

//import com.gargoylesoftware.htmlunit.html.Keyboard;
import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PushesFiles;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.pages.PageObject;
import rimac.main.object.*;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilApp;
import rimac.main.util.VariablesAppNativa;


public class ScCuentaDeAbono extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjCuentaDeAbono cuentaDeAbonoObject = ObjCuentaDeAbono.getInstancia();
	protected ObjPaginaPrincipal objPaginaPrincipal = ObjPaginaPrincipal.getInstancia();
	protected ObjComentariosAdicionales comentariosAdicionalesObject = ObjComentariosAdicionales.getInstancia();
	protected ObjSolicitudReembolsoRecibida solicitudReembolsoRecibidaObject = ObjSolicitudReembolsoRecibida.getInstancia();
	// util
	protected MobileObjectUtil pageObjectUtil2 = MobileObjectUtil.getInstancia();
	public static Logger looger = Logger.getLogger(ScCuentaDeAbono.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilApp util = new UtilApp();
	AppiumDriver driver;
	
	@SuppressWarnings("null")
	public void llenarDatosDeCuenta(String entidad, String tipoCuenta, String moneda, String numCuenta, String correo) {
		looger.info("LLenar Cuenta");
		util.esperarElemento(5, cuentaDeAbonoObject.lstEntidadBancaria);
		List<WebElement> elementos = new ArrayList<>();

		//Interbank, BBVA, Scotiabank, Scotiabank
		elementos.add(cuentaDeAbonoObject.getEntidadBancaria(appiumDriver(), "Interbank"));
		elementos.add(cuentaDeAbonoObject.getEntidadBancaria(appiumDriver(), "BBVA"));
		elementos.add(cuentaDeAbonoObject.getEntidadBancaria(appiumDriver(), "Scotiabank"));
		elementos.add(cuentaDeAbonoObject.getEntidadBancaria(appiumDriver(), "BCP"));
		int auxEntidad=util.existeWebElementPorTexto(elementos);
		System.out.println("Cantidad de entidades "   + auxEntidad);
//		util.esperarElemento(5, cuentaDeAbonoObject.txtEntidadBancaria);
//		boolean existeEntidad = util.existeEntidadBancaria(cuentaDeAbonoObject.txtEntidadBancaria);
//		System.out.println("Pasa ");
//		boolean existeEntidad = util.existeEntidadBancaria2(cuentaDeAbonoObject.txtEntBancaria);
		
//		System.out.println("Existe entidad "   + existeEntidad);
		if(auxEntidad==0) {
			util.esperarSegundos(2);
			element(cuentaDeAbonoObject.lstEntidadBancaria).click();
			element(cuentaDeAbonoObject.getEntidadBancaria(appiumDriver(), entidad)).click();
			util.esperarSegundos(4);
			element(cuentaDeAbonoObject.lstTipoCuenta).click();
			element(cuentaDeAbonoObject.getTipoCuenta(appiumDriver(), tipoCuenta)).click();
			try {
				util.scroll();
			} catch (Exception e) {
				// TODO: handle exception
			}
			element(cuentaDeAbonoObject.lstTipoMoneda).click();
			element(cuentaDeAbonoObject.getTipoMoneda(appiumDriver(), moneda)).click();	
			element(cuentaDeAbonoObject.txtNumeroCuenta).click();
			element(cuentaDeAbonoObject.txtNumeroCuenta).sendKeys(numCuenta);
			((HidesKeyboard) appiumDriver()).hideKeyboard();
			try {
				util.scroll();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
//		util.scroll();
//		try {
//			
//			appiumDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Correo electrónico\").instance(0))"));
//			
//			
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
		element(cuentaDeAbonoObject.btnContinuar).click();
		
		util.esperarElemento(3, cuentaDeAbonoObject.txtCorreo);
		element(cuentaDeAbonoObject.txtCorreo).clear();
		element(cuentaDeAbonoObject.txtCorreo).sendKeys(correo);
		//((HidesKeyboard) appiumDriver()).hideKeyboard();
//		appiumDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Continuar\").instance(0))"));
		element(cuentaDeAbonoObject.btnContinuar).click();

	}
	
	public void comentariosAdicionales(String comentarios) {
//		util.esperarElemento(5, comentariosAdicionalesObject.txtDescripcion);
//		element(comentariosAdicionalesObject.txtDescripcion).click();
//		element(comentariosAdicionalesObject.txtDescripcion).sendKeys(comentarios);
//		((HidesKeyboard) appiumDriver()).hideKeyboard();
		util.esperarSegundos(8);
		util.esperarElementoVisible(10,comentariosAdicionalesObject.btnEnviarSolicitud);
		element(comentariosAdicionalesObject.btnEnviarSolicitud).click();
		util.esperarElemento(9,comentariosAdicionalesObject.btnIralinicio);

	}
	
}