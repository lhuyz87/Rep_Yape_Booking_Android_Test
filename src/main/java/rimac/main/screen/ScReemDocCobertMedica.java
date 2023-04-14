package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Logger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PushesFiles;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import rimac.main.util.BaseDriver;
import rimac.main.util.UtilApp;
import rimac.main.object.ObjReemDocCobertMedica;
import rimac.main.object.ObjAlertas;
import rimac.main.object.ObjDirectorio;
import java.io.File;
import rimac.main.object.ObjDocumentoComprobantes;



public class ScReemDocCobertMedica extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjReemDocCobertMedica reemDocCobertMedicaObject = ObjReemDocCobertMedica.getInstancia();
	protected ObjAlertas alertasObject = ObjAlertas.getInstancia();
	protected ObjDirectorio directorioObject = ObjDirectorio.getInstancia();
	protected ObjDocumentoComprobantes documentoComprobantesObject = ObjDocumentoComprobantes.getInstancia();
	// util
	public static Logger looger = Logger.getLogger(ScReemDocCobertMedica.class.getName());
	
	int contador=0;
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilApp util = new UtilApp();
	AppiumDriver driver;
	
	public void adjuntarFotoArchivo(){
		util.esperarElemento(5, reemDocCobertMedicaObject.selFotosArchivos);
		element(reemDocCobertMedicaObject.selFotosArchivos).click();
	}

	public void subirComprobantes(){
		util.esperarElemento(5, documentoComprobantesObject.btnSubirComprobantes);
		element(documentoComprobantesObject.btnSubirComprobantes).click();
	}

	public void subirDocumentos(){
		util.esperarElementoVisible(8,documentoComprobantesObject.btnSubirDocumentos);
		element(documentoComprobantesObject.btnSubirDocumentos).click();
	}

	public void tomarFotoHuawei(){
		element(reemDocCobertMedicaObject.selTomarFoto).click();
		element(reemDocCobertMedicaObject.opcCamara).click();
		util.esperarSegundos(3);
		androidDriver().pressKey(new KeyEvent(AndroidKey.CAMERA));
		util.esperarSegundos(1);
		element(reemDocCobertMedicaObject.btnAceptarFoto).click();
		util.esperarSegundos(1);
	}

	public void subirArchivo() {

		File fileAux = new File("src/test/resources/testResources/Prueba.pdf");
		File fi = new File(fileAux.getAbsolutePath());
		String nombreArchivo = fi.getName();
		try {
			((PushesFiles) appiumDriver()).pushFile("/storage/emulated/0/Download" + "/" +nombreArchivo , fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		element(reemDocCobertMedicaObject.selAdjuntarAtchivo).click();

		util.esperarElemento(5, directorioObject.nombreArchivo(appiumDriver(), nombreArchivo));
		util.esperarSegundos(2);
		element(directorioObject.nombreArchivo(appiumDriver(), nombreArchivo)).click();
		util.esperarSegundos(2);
	
		}
	
	
	public void continuar() {
		util.esperarActivoClick(4, reemDocCobertMedicaObject.btnContinuar);
		element(reemDocCobertMedicaObject.btnContinuar).click();
		util.esperarSegundos(5);
	}
	
	
	
}