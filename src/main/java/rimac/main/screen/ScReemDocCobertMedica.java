package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Logger;

import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PushesFiles;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.requirements.reports.FileSystemRequirmentsOutcomeFactory;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilApp;
import rimac.main.util.VariablesAppNativa;
import rimac.main.object.ObjLogin;
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
	
	
	public void AdjuntarFotoArchivo(String tipo) {
		
		util.esperarElemento(5, reemDocCobertMedicaObject.selFotosArchivos);
		element(reemDocCobertMedicaObject.selFotosArchivos).click();
		
//		if(contador==0) {
//			try {
//				element(alertasObject.btnAppEnUso).click();
//				contador++;
//			}catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//			
//			try {
//				element(alertasObject.btnPermitir).click();	
//			}catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//				
//			contador++;
			
//		}

		if(tipo.compareTo("AdjuntarArchivo")==0) {
			/*File documentsDir = new File("/storage/emulated/0/Documents");
			String documentsPath = documentsDir.getAbsolutePath();
			System.out.println("ruta obtenida "+documentsPath);
			///sdcard/Download
			///storage/emulated/0/Documents*/


			File fileAux = new File("src/test/resources/testResources/Prueba.pdf");
			System.out.println("++++"   + fileAux.getAbsolutePath());
			File fi = new File(fileAux.getAbsolutePath());
//			String nombreArchivo = util.obtenerFechayHora()+"-"+fi.getName(); 
			String nombreArchivo = fi.getName(); 
			try {
				((PushesFiles) appiumDriver()).pushFile("/storage/emulated/0/Download" + "/" +nombreArchivo , fi);
				System.out.println("Nommbre de archivo a adjuntar :"   + "/storage/emulated/0/Download" + "/" +nombreArchivo);
//				((PushesFiles) appiumDriver()).pushFile("/storage/emulated/0/Download" + "/" , fi);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			
			
			element(reemDocCobertMedicaObject.selAdjuntarAtchivo).click();
			
			util.esperarElemento(5, directorioObject.nombreArchivo(appiumDriver(), nombreArchivo));
			util.esperarSegundos(2);
			element(directorioObject.nombreArchivo(appiumDriver(), nombreArchivo)).click();
//			element(directorioObject.nombreArchivo2(appiumDriver(), "Prueba")).click();
			util.esperarSegundos(3);
		}
	}
	
	
public void subirComprobante(String tipo) {
		
		util.esperarElemento(5, documentoComprobantesObject.btnSubirComprobantes);
		element(documentoComprobantesObject.btnSubirComprobantes).click();
		
//		try {
//			element(alertasObject.btnAppEnUso).click();	
//			element(alertasObject.btnPermitir).click();	
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//		}
		
		if(tipo.compareTo("AdjuntarArchivo")==0) {
			
			
			File fileAux = new File("src/test/resources/testResources/Prueba.pdf");
//			System.out.println("++++"   + fileAux.getAbsolutePath());
			File fi = new File(fileAux.getAbsolutePath());
//			String nombreArchivo = util.obtenerFechayHora()+"-"+fi.getName(); 
			String nombreArchivo = fi.getName(); 
			try {
				((PushesFiles) appiumDriver()).pushFile("/storage/emulated/0/Download" + "/" +nombreArchivo , fi);
				System.out.println("Nommbre de archivo a adjuntar :"   + "/storage/emulated/0/Download" + "/" +nombreArchivo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			
			
			element(reemDocCobertMedicaObject.selAdjuntarAtchivo).click();
			
			util.esperarElemento(5, directorioObject.nombreArchivo(appiumDriver(), nombreArchivo));
			element(directorioObject.nombreArchivo(appiumDriver(), nombreArchivo)).click();
//			util.esperarSegundos(5);
		
		}
		
	}


public void subirDocumento(String tipo) {

	util.esperarElementoVisible(8,documentoComprobantesObject.btnSubirDocumentos);
	element(documentoComprobantesObject.btnSubirDocumentos).click();
	
//	try {
//		element(alertasObject.btnAppEnUso).click();	
//		element(alertasObject.btnPermitir).click();	
//	} catch (Exception e) {
//		System.err.println(e.getMessage());
//	}

	if(tipo.compareTo("AdjuntarArchivo")==0) {
		
		
		File fileAux = new File("src/test/resources/testResources/Prueba.pdf");
		System.out.println("++++"   + fileAux.getAbsolutePath());
		File fi = new File(fileAux.getAbsolutePath());
//		String nombreArchivo = util.obtenerFechayHora()+"-"+fi.getName(); 
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
		
	
	}else {
		
	}
	
}
	
	
	public void continuar() {
		util.esperarActivoClick(4, reemDocCobertMedicaObject.btnContinuar);
		element(reemDocCobertMedicaObject.btnContinuar).click();
		util.esperarSegundos(5);
	}
	
	
	
}