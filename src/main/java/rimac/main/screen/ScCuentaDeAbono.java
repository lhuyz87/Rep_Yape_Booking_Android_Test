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
	public void llenarDatosDeCuenta(String entidad, String tipoCuenta, String moneda, String numCuenta, String correo) throws Exception {
		looger.info("LLenar Cuenta");
		util.mobileSwipeScreenAndroidFinal();
		util.esperarElementoVisible(7,cuentaDeAbonoObject.lstEntidadBancaria);
		util.esperarSegundos(2);
		List<WebElement> elementos = new ArrayList<>();
		//Interbank, BBVA, Scotiabank, Scotiabank
		elementos.add(cuentaDeAbonoObject.getEntidadBancaria(androidDriver(), "Interbank"));
		elementos.add(cuentaDeAbonoObject.getEntidadBancaria(androidDriver(), "BBVA"));
		elementos.add(cuentaDeAbonoObject.getEntidadBancaria(androidDriver(), "Scotiabank"));
		elementos.add(cuentaDeAbonoObject.getEntidadBancaria(androidDriver(), "BCP"));
		int auxEntidad=util.existeWebElementPorTexto(elementos);
		System.out.println("Cantidad de entidades "   + auxEntidad);
		if(auxEntidad==0) {
			element(cuentaDeAbonoObject.lstEntidadBancaria).click();
			element(cuentaDeAbonoObject.getEntidadBancaria(androidDriver(), entidad)).click();
			util.esperarElementToClic(androidDriver(),cuentaDeAbonoObject.lstTipoCuenta);
			element(cuentaDeAbonoObject.lstTipoCuenta).click();
			element(cuentaDeAbonoObject.getTipoCuenta(androidDriver(), tipoCuenta)).click();
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

		element(cuentaDeAbonoObject.btnContinuar).click();
		util.esperarVisibilityElement(androidDriver(),cuentaDeAbonoObject.txtCorreo,15);
		element(cuentaDeAbonoObject.txtCorreo).clear();
		element(cuentaDeAbonoObject.txtCorreo).sendKeys(correo);
		util.esperarElementoVisible(5,cuentaDeAbonoObject.btnContinuar);
		element(cuentaDeAbonoObject.btnContinuar).click();

	}
	
	public void comentariosAdicionales(String comentarios) throws Exception {
		util.esperarElementoVisible(10,comentariosAdicionalesObject.btnEnviarSolicitud);
		element(comentariosAdicionalesObject.btnEnviarSolicitud).click();
	}
	
}