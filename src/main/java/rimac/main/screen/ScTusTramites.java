package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.poi.ss.formula.ThreeDEval;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;

import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PushesFiles;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.pages.PageObject;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilDef;
import rimac.main.util.VariablesAppNativa;
import rimac.main.object.ObjLogin;
import rimac.main.object.ObjTramites;


public class ScTusTramites extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjTramites tramitesObject = ObjTramites.getInstancia();

	// util
	public static Logger looger = Logger.getLogger(ScTusTramites.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilDef util = new UtilDef();
	
	@SuppressWarnings("deprecation")
	public void seleccionarTramiteSalud(String tramite) {
		
		switch (tramite) {
		case "Atención médica virtual":
			
			break;
			
		case "Buscador de clínicas":
			looger.info("Buecar Opcion Buscador de clinicas");
			
			util.esperarElemento(10, tramitesObject.btnTodos);

			element(tramitesObject.btnBuscarClinica).click();
			looger.info("Termina buscador de clínica");
			break;
			
		case "Médico a domicilio":
			
			break;
			
		case "Reembolso de salud":
			looger.info("Iniciar Reembolso de salud");
			util.esperarElemento(10, tramitesObject.btnTodos);;

			int contadorini=0;	
			while(contadorini<5) {
				try {
					
					looger.info("Intenta para dar click "  + contadorini);
					util.mobileSwipeScreenAndroid();
					if(tramitesObject.btnReembolsoSalud.isEnabled()==true) {
						element(tramitesObject.btnReembolsoSalud).click();
						contadorini=5;
						looger.info("Encuentra elemento");
					}
					
					contadorini++;
				 }catch (Exception e) {
					 
					 System.out.println("Mensaje " + e.getMessage());
					 contadorini++;
					 
				}
//			
				
//			element(tramitesObject.btnReembolsoSalud).click();
			}
				looger.info("Termina Reembolso de salud");
			break;
		case "Programa Cuídate":
			
			break;
			
		case "Chequeo preventivo":
			
			break;
			
		case "Extensión de receta":
			
			break;

		default:
			break;
		}
		
	}
	
}