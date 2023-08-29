package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.pages.PageObject;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilApp;
import rimac.main.util.VariablesAppNativa;
import rimac.main.object.ObjLogin;
import rimac.main.object.ObjDocumentoComprobantes;
import rimac.main.object.ObjDocumentos;

public class ScAgregarNuevoDocumento extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjDocumentoComprobantes agregarNuevoDocumentoObject = ObjDocumentoComprobantes.getInstancia();
	protected ObjDocumentos documentosObject = ObjDocumentos.getInstancia();

	// util
	public static Logger looger = Logger.getLogger(ScAgregarNuevoDocumento.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilApp util = new UtilApp();

	
	public void seleccionarTipoDocuem(String tipoDocumento) {
		looger.info("Iniciar Seleccionar Tipo de Documento " + tipoDocumento);

		util.esperarElemento(10, agregarNuevoDocumentoObject.lstTipoDocumento);
		element(agregarNuevoDocumentoObject.lstTipoDocumento).click();
		element(documentosObject.getTipoDocumento(appiumDriver(), tipoDocumento)).click();
	}
	
	public void llenarDatosFactura(String serie, String documento, String moneda, String monto) throws Exception {
		util.esperarSegundos(8);
		util.esperarElementoClick(8, agregarNuevoDocumentoObject.txtSerieDocumento);
		element(agregarNuevoDocumentoObject.txtSerieDocumento).sendKeys(serie);
		((HidesKeyboard) appiumDriver()).hideKeyboard();
		util.mobileSwipeScreenAndroid();
		util.esperarElementoVisible(8,agregarNuevoDocumentoObject.txtNroDocumento);
		element(agregarNuevoDocumentoObject.txtNroDocumento).sendKeys(documento);
		((HidesKeyboard) appiumDriver()).hideKeyboard();
		util.esperarElementoVisible(8,agregarNuevoDocumentoObject.lstMoneda);
		element(agregarNuevoDocumentoObject.lstMoneda).click();
		element(agregarNuevoDocumentoObject.getMoneda(appiumDriver(), moneda)).click();
		util.esperarElementoVisible(8,agregarNuevoDocumentoObject.txtMonto);
		element(agregarNuevoDocumentoObject.txtMonto).sendKeys(monto);
		((HidesKeyboard) appiumDriver()).hideKeyboard();
		util.esperarSegundos(2);
		try {
			util.scroll();
		}catch (Exception e) {
			// TODO: handle exception
		}
		util.esperarElementoVisible(3,agregarNuevoDocumentoObject.lstFechaEmision);
		element(agregarNuevoDocumentoObject.lstFechaEmision).click();
		util.esperarElementoVisible(3,agregarNuevoDocumentoObject.btnAceptar);
		element(agregarNuevoDocumentoObject.btnAceptar).click();
		util.esperarElementoVisible(3,agregarNuevoDocumentoObject.btnSubirDocumento);
		element(agregarNuevoDocumentoObject.btnSubirDocumento).click();
		util.esperarSegundos(5);
	}
	
	
	public void llenarDatosRecetaMedica(String descripcion) {
//		element(agregarNuevoDocumentoObject.txtDescipcion).click();
//		element(agregarNuevoDocumentoObject.txtDescipcion).sendKeys(descripcion);
//		((HidesKeyboard) appiumDriver()).hideKeyboard();
		looger.info("Iniciar llenar Datos Receta Médica");
		element(agregarNuevoDocumentoObject.btnSubirDocumento).click();
		
	}
	
	
	
}