package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.Dimension;
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
import rimac.main.object.ObjPaginaPrincipal;
import rimac.main.screen.ScHome;
import rimac.main.object.ObjAlertas;
import rimac.main.object.ObjRegistrarHuella;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ScHome extends BaseDriver{

	
	
	private long wdwTimeOut = 300L;
	
	protected ObjPaginaPrincipal objectPrincipal = ObjPaginaPrincipal.getInstancia();
	protected ObjRegistrarHuella registrarHuellaObject = ObjRegistrarHuella.getInstancia();
	protected ObjAlertas alertasObject = ObjAlertas.getInstancia();
	
	// util
	protected MobileObjectUtil pageObjectUtil2 = MobileObjectUtil.getInstancia();
	public static Logger looger = Logger.getLogger(ScHome.class.getName());
	
	
	public static void main(String[] args) {
		
	}
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilDef util = new UtilDef();
	AppiumDriver driver;
	static Timer timer;
	static int contador=0;
	
	public void seleccionarOpcionPrincipal(String opcion) {
		looger.info("aplicación iniciada");
			
		
		switch (opcion) {
		case "Home":
			
			break;
			
		case "Seguros":
			util.esperarSegundos(8);
			util.esperarElemento(10, objectPrincipal.btnSeguros);
			util.esperarSegundos(3);
			element(objectPrincipal.btnSeguros).click();
			break;
			
		case "Tramites":
			
			util.esperarSegundos(8);
			util.esperarElemento(10, objectPrincipal.btnTramite);
			element(objectPrincipal.btnTramite).click();
			break;
		
		case "Tienda":
			
			break;
			
		case "Perfil":
			
			break;

		default:
			break;
		}
		
	}
	

	 TimerTask alertas = new TimerTask() {

		@Override
		public void run() {
			
			try {
				element(alertasObject.btnHuellaPorAhoraNo).click();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			try {
				element(alertasObject.btnCerrarRealizarInspeccion).click();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				element(alertasObject.btnCerrarVehicularVencer).click();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			try {
				element(alertasObject.btnEnteratePorAhoraNo).click();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		
			try {
				element(alertasObject.btnHuellaPorAhoraNo).click();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			contador++;
			System.out.println("Timer " + contador);
	        	if(contador==1000)
	        		timer.cancel();
		}
		 
	 };
	 
	public void cerrarAlertas(int seconds) {
			
			timer = new Timer();
	        System.out.println("Se inicia el JOB de cerrar alertas");
	        timer.scheduleAtFixedRate(alertas,new Date(),500);
			
	}
	
	public void seleccionarReembolso() {
		
		util.esperarElemento(5, objectPrincipal.btnHome);
		util.esperarSegundos(3);
		 System.out.println("Entraaaa");
//		util.localizarElementoScroll(appiumDriver(), objectPrincipalScreen.btnReembolsoSalud);
		
		
		while(element(objectPrincipal.btnReembolsoSalud).isCurrentlyVisible()==false) {
			Dimension dimension = appiumDriver().manage().window().getSize();
			//arrastrar hacia arriba, como deslizando la app para ver más contenido
			Point start= new Point((int)(dimension.width*0.2), (int)(dimension.height*0.8));
			Point end= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.2)); 
			pageObjectUtil2.doSwipe(appiumDriver(), start, end, 1000); //with duration 1s
		}
//		Actions action = new Actions(driver);
//		action.moveToElement(objectPrincipalScreen.btnReembolsoSalud).click().perform();
		
		pageObjectUtil2.tapElement(appiumDriver(),objectPrincipal.btnReembolsoSalud);
		
//		element(objectPrincipalScreen.btnReembolsoSalud).click();
		
	}

	public void seleccionaBuscadorClinicas() {
		// TODO Auto-generated method stub
		//
		util.esperarSegundos(8);
		util.esperarElemento(5, objectPrincipal.btnHome);
		util.esperarSegundos(6);
		int intentos=0;
		while(intentos<=5) {
			
		try {
			element(objectPrincipal.btnBuscadorClinica).click();
			System.out.println("Se encontro elemento  ");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No encontro elemento  "  + intentos);
			util.scrollDown(appiumDriver());
		}	
			
//		if(objectPrincipal.btnBuscadorClinica.isEnabled()==true) {
//				System.out.println("Se encontro elemento  ");
//				break;
//			}else {
//				System.out.println("No encontro elemento  "  + intentos);
//				util.scrollDown(appiumDriver());
//			}
			intentos++;
		}
		
		
//		appiumDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Buscador de clínicas\").instance(0))"));
//		element(objectPrincipal.btnBuscadorClinica).click();
	}
	
	
}