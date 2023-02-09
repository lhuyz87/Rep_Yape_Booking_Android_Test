package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import net.serenitybdd.core.Serenity;
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
import rimac.main.object.ObjAlertas;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilApp;
import rimac.main.util.VariablesAppNativa;
import rimac.main.object.ObjLogin;
import rimac.main.object.ObjTramites;

import static org.junit.Assert.assertFalse;


public class ScTusTramites extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjTramites tramitesObject = ObjTramites.getInstancia();
	protected ObjAlertas objAlertas = ObjAlertas.getInstancia();

	// util
	public static Logger looger = Logger.getLogger(ScTusTramites.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilApp util = new UtilApp();
	
	@SuppressWarnings("deprecation")
	public void seleccionarTramiteSalud(String tramite) {
		
		switch (tramite) {
		case "Atención médica virtual":
			
			break;
			
		case "Buscador de salud":
			looger.info("Buscar Opcion Buscador de salud");
			
			util.esperarElemento(10, tramitesObject.btnTodos);


			int contador=0;
			while(contador<5) {
				try {

					looger.info("Intenta para dar click " + contador);

					if (tramitesObject.btnBuscarClinica.isEnabled() == true) {
						element(tramitesObject.btnBuscarClinica).click();
						contador = 5;
						looger.info("Encuentra elemento");
					}
					util.mobileSwipeScreenAndroid();
					contador++;
				} catch (Exception e) {

					System.out.println("Mensaje " + e.getMessage());
					contador++;

				}
			}
			looger.info("Termina buscador de salud");
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

	public void seleccionarSegui() {
		// TODO Auto-generated method stub
		util.esperarElemento(3, tramitesObject.btnSeguimiento);
		util.esperarSegundos(1);
		element(tramitesObject.btnSeguimiento).click();
		util.esperarElemento(3, tramitesObject.btnSegReemSalud);
		element(tramitesObject.btnSegReemSalud).click();
		util.esperarSegundos(1);
		
	}

	public void seleccionaAsistenciaVehicular() {
		try {
			util.esperarElementoClick(5,tramitesObject.lblTramites);
			int contador=0;
			while(element(tramitesObject.btnAsisVehiculares).isCurrentlyVisible()==false && contador<7) {
				util.mobileSwipeScreenAndroid();
				contador++;
			}
			util.esperarElementoClick(2,tramitesObject.btnAsisVehiculares);
			Serenity.takeScreenshot();
			element(tramitesObject.btnAsisVehiculares).click();
			util.esperarSegundos(2);
			assertFalse(element(objAlertas.btnCerrarModal).isCurrentlyVisible());
		}
		catch (AssertionError e) {
			Serenity.takeScreenshot();
			throw new IllegalAccessError("Error en el aplicativo, Mensaje: Ocurrió un error inesperado");
		}
		catch(Exception e){
			Serenity.takeScreenshot();
		}

	}
	
}