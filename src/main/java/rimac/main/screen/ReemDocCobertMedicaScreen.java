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
import rimac.main.util.PageObjectUtil2;
import rimac.main.util.UtilDef;
import rimac.main.util.VariablesAppNativa;
import rimac.main.object.LoginObject;
import rimac.main.object.ReemDocCobertMedicaObject;
import rimac.main.object.AlertasObject;
import rimac.main.object.DirectorioObject;
import java.io.File;
import rimac.main.object.DocumentoComprobantesObject;


public class ReemDocCobertMedicaScreen extends BaseScreen{

private long wdwTimeOut = 300L;
	
	protected ReemDocCobertMedicaObject reemDocCobertMedicaObject = ReemDocCobertMedicaObject.getInstancia();
	protected AlertasObject alertasObject = AlertasObject.getInstancia();
	protected DirectorioObject directorioObject = DirectorioObject.getInstancia();
	protected DocumentoComprobantesObject documentoComprobantesObject = DocumentoComprobantesObject.getInstancia();
	// util
	public static Logger looger = Logger.getLogger(ReemDocCobertMedicaScreen.class.getName());
	
	int contador=0;
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilDef util = new UtilDef();
	AppiumDriver driver;
	
	
	public void AdjuntarFotoArchivo(String tipo) {
		
		util.esperarElemento(5, reemDocCobertMedicaObject.selFotosArchivos);
		element(reemDocCobertMedicaObject.selFotosArchivos).click();
		
		if(contador==0) {
			element(alertasObject.btnAppEnUso).click();	
			element(alertasObject.btnPermitir).click();	
			contador++;
		}

		if(tipo.compareTo("AdjuntarArchivo")==0) {
			element(reemDocCobertMedicaObject.selAdjuntarAtchivo).click();
			
			File fileAux = new File("src/test/resources/testResources/Prueba.pdf");
			System.out.println("++++"   + fileAux.getAbsolutePath());
			File fi = new File(fileAux.getAbsolutePath());
			String nombreArchivo = util.obtenerFechayHora()+"-"+fi.getName(); 
			try {
				((PushesFiles) appiumDriver()).pushFile("/storage/emulated/0/Download" + "/" +nombreArchivo , fi);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			util.esperarSegundos(2);
			element(directorioObject.nombreArchivo(appiumDriver(), nombreArchivo)).click();
//			util.esperarSegundos(5);
		
		}else {
			
		}
		
	}
	
	
	
public void subirComprobante(String tipo) {
		
		util.esperarElemento(5, documentoComprobantesObject.btnSubirComprobantes);
		element(documentoComprobantesObject.btnSubirComprobantes).click();
		
		try {
			element(alertasObject.btnAppEnUso).click();	
			element(alertasObject.btnPermitir).click();	
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		if(tipo.compareTo("AdjuntarArchivo")==0) {
			element(reemDocCobertMedicaObject.selAdjuntarAtchivo).click();
			
			File fileAux = new File("src/test/resources/testResources/Prueba.pdf");
			System.out.println("++++"   + fileAux.getAbsolutePath());
			File fi = new File(fileAux.getAbsolutePath());
			String nombreArchivo = util.obtenerFechayHora()+"-"+fi.getName(); 
			try {
				((PushesFiles) appiumDriver()).pushFile("/storage/emulated/0/Download" + "/" +nombreArchivo , fi);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			util.esperarSegundos(2);
			element(directorioObject.nombreArchivo(appiumDriver(), nombreArchivo)).click();
//			util.esperarSegundos(5);
		
		}
		
	}


public void subirDocumento(String tipo) {
	
	util.esperarElemento(5, documentoComprobantesObject.btnSubirDocumentos);
	element(documentoComprobantesObject.btnSubirDocumentos).click();
	
	try {
		element(alertasObject.btnAppEnUso).click();	
		element(alertasObject.btnPermitir).click();	
	} catch (Exception e) {
		System.err.println(e.getMessage());
	}

	if(tipo.compareTo("AdjuntarArchivo")==0) {
		element(reemDocCobertMedicaObject.selAdjuntarAtchivo).click();
		
		File fileAux = new File("src/test/resources/testResources/Prueba.pdf");
		System.out.println("++++"   + fileAux.getAbsolutePath());
		File fi = new File(fileAux.getAbsolutePath());
		String nombreArchivo = util.obtenerFechayHora()+"-"+fi.getName(); 
		try {
			((PushesFiles) appiumDriver()).pushFile("/storage/emulated/0/Download" + "/" +nombreArchivo , fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		util.esperarSegundos(1);
		element(directorioObject.nombreArchivo(appiumDriver(), nombreArchivo)).click();
		util.esperarSegundos(2);
	
	}else {
		
	}
	
}
	
	
	public void continuar() {
		
		util.esperarElemento(4, reemDocCobertMedicaObject.btnContinuar);
		element(reemDocCobertMedicaObject.btnContinuar).click();
		util.esperarSegundos(5);
	}
	
	
	
}