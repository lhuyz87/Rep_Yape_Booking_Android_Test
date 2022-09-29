package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import com.gargoylesoftware.htmlunit.html.Keyboard;
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
import rimac.main.object.CuentaDeAbonoObject;
import rimac.main.object.ComentariosAdicionalesObject;
import rimac.main.object.SolicitudReembolsoRecibidaObject;


public class CuentaDeAbonoScreen extends BaseScreen{

private long wdwTimeOut = 300L;
	
	protected CuentaDeAbonoObject cuentaDeAbonoObject = CuentaDeAbonoObject.getInstancia();
	protected ComentariosAdicionalesObject comentariosAdicionalesObject = ComentariosAdicionalesObject.getInstancia();
	protected SolicitudReembolsoRecibidaObject solicitudReembolsoRecibidaObject = SolicitudReembolsoRecibidaObject.getInstancia();
	// util
	protected PageObjectUtil2 pageObjectUtil2 = PageObjectUtil2.getInstancia();
	public static Logger looger = Logger.getLogger(CuentaDeAbonoScreen.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilDef util = new UtilDef();
	AppiumDriver driver;
	
	public void llenarDatosDeCuenta(String entidad, String tipoCuenta, String moneda, String numCuenta, String correo) {
		looger.info("Registro de Huella");
		
		util.esperarElemento(10, cuentaDeAbonoObject.lstEntidadBancaria);
		util.esperarSegundos(4);
		element(cuentaDeAbonoObject.lstEntidadBancaria).click();
		element(cuentaDeAbonoObject.getEntidadBancaria(appiumDriver(), entidad)).click();
		util.esperarSegundos(4);
		element(cuentaDeAbonoObject.lstTipoCuenta).click();
		element(cuentaDeAbonoObject.getTipoCuenta(appiumDriver(), tipoCuenta)).click();
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
		element(cuentaDeAbonoObject.txtCorreo).click();
		element(cuentaDeAbonoObject.txtCorreo).sendKeys(correo);
		((HidesKeyboard) appiumDriver()).hideKeyboard();		
//		appiumDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Continuar\").instance(0))"));
		element(cuentaDeAbonoObject.btnContinuar).click();

	}
	
	public void comentariosAdicionales(String comentarios) {
//		util.esperarElemento(5, comentariosAdicionalesObject.txtDescripcion);
//		element(comentariosAdicionalesObject.txtDescripcion).click();
//		element(comentariosAdicionalesObject.txtDescripcion).sendKeys(comentarios);
//		((HidesKeyboard) appiumDriver()).hideKeyboard();
		util.esperarSegundos(5);
		element(comentariosAdicionalesObject.btnEnviarSolicitud).click();
		util.esperarSegundos(10);
		
	}
	
}