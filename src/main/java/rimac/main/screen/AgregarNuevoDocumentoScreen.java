package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

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
import rimac.main.object.AgregarNuevoDocumentoObject;
import rimac.main.object.DocumentosObject;

public class AgregarNuevoDocumentoScreen extends BaseScreen{

private long wdwTimeOut = 300L;
	
	protected AgregarNuevoDocumentoObject agregarNuevoDocumentoObject = AgregarNuevoDocumentoObject.getInstancia();
	protected DocumentosObject documentosObject = DocumentosObject.getInstancia();

	// util
	public static Logger looger = Logger.getLogger(AgregarNuevoDocumentoScreen.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilDef util = new UtilDef();

	
	public void seleccionarTipoDocuem(String tipoDocumento) {
		looger.info("Iniciar Seleccionar Tipo de Documento");

		util.esperarElemento(10, agregarNuevoDocumentoObject.lstTipoDocumento);
		element(agregarNuevoDocumentoObject.lstTipoDocumento).click();
		element(documentosObject.getTipoDocumento(appiumDriver(), tipoDocumento)).click();
	}
	
	public void llenarDatosFactura(String serie, String documento, String moneda, String monto) {
		util.esperarElementoClick(5, agregarNuevoDocumentoObject.txtSerieDocumento);
		element(agregarNuevoDocumentoObject.txtSerieDocumento).click();
		element(agregarNuevoDocumentoObject.txtSerieDocumento).sendKeys(serie);
		((HidesKeyboard) appiumDriver()).hideKeyboard();
		element(agregarNuevoDocumentoObject.txtNroDocumento).click();
		element(agregarNuevoDocumentoObject.txtNroDocumento).sendKeys(documento);
		((HidesKeyboard) appiumDriver()).hideKeyboard();
		element(agregarNuevoDocumentoObject.lstMoneda).click();
		element(agregarNuevoDocumentoObject.getMoneda(appiumDriver(), moneda)).click();
		element(agregarNuevoDocumentoObject.txtMonto).click();
		element(agregarNuevoDocumentoObject.txtMonto).sendKeys(monto);
		((HidesKeyboard) appiumDriver()).hideKeyboard();
		try {
			util.scroll();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		element(agregarNuevoDocumentoObject.lstFechaEmision).click();
		element(agregarNuevoDocumentoObject.btnAceptar).click();
		element(agregarNuevoDocumentoObject.btnSubirDocumento).click();
		util.esperarSegundos(10);
	}
	
	
	public void llenarDatosRecetaMedica(String descripcion) {
//		element(agregarNuevoDocumentoObject.txtDescipcion).click();
//		element(agregarNuevoDocumentoObject.txtDescipcion).sendKeys(descripcion);
//		((HidesKeyboard) appiumDriver()).hideKeyboard();
		element(agregarNuevoDocumentoObject.btnSubirDocumento).click();
		util.esperarSegundos(5);
	}
	
	
	
}