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


public class ReemDocCobertMedicaScreen extends BaseScreen{

private long wdwTimeOut = 300L;
	
	protected ReemDocCobertMedicaObject reemDocCobertMedicaObject = ReemDocCobertMedicaObject.getInstancia();
	protected AlertasObject alertasObject = AlertasObject.getInstancia();
	protected DirectorioObject directorioObject = DirectorioObject.getInstancia();
	// util
	public static Logger looger = Logger.getLogger(ReemDocCobertMedicaScreen.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilDef util = new UtilDef();
	AppiumDriver driver;
	
	
	public void AdjuntarFotoArchivo(String tipo) {
		
		util.esperarElemento(5, reemDocCobertMedicaObject.selFotosArchivos);
		element(reemDocCobertMedicaObject.selFotosArchivos).click();
		element(alertasObject.btnAppEnUso).click();	
		element(alertasObject.btnPermitir).click();	
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
			
//			element(directorioObject.lblArchivo).click();
			element(directorioObject.nombreArchivo(appiumDriver(), nombreArchivo)).click();
			util.esperarSegundos(5);
		
		}else {
			
		}
		
	}
	
	
	
}