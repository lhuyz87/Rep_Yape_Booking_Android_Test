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
import rimac.main.util.PageObjectUtil2;
import rimac.main.util.UtilDef;
import rimac.main.util.VariablesAppNativa;
import rimac.main.object.LoginObject;
import rimac.main.object.PaginaPrincipalObject;
import rimac.main.screen.ScHome;
import rimac.main.object.AlertasObject;
import rimac.main.object.RegistrarHuellaObject;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ScHome extends BaseScreen{

	
	
	private long wdwTimeOut = 300L;
	
	protected PaginaPrincipalObject objectPrincipalScreen = PaginaPrincipalObject.getInstancia();
	protected RegistrarHuellaObject registrarHuellaObject = RegistrarHuellaObject.getInstancia();
	protected AlertasObject alertasObject = AlertasObject.getInstancia();
	
	// util
	protected PageObjectUtil2 pageObjectUtil2 = PageObjectUtil2.getInstancia();
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
		util.esperarElemento(10, objectPrincipalScreen.btnTramite);
		
		
		switch (opcion) {
		case "Home":
			
			break;
			
		case "Seguros":
			
			break;
			
		case "Tramites":
			util.esperarElemento(5, objectPrincipalScreen.btnTramite);
			util.esperarSegundos(3);
			element(objectPrincipalScreen.btnTramite).click();
		
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
	        timer.scheduleAtFixedRate(alertas,new Date(),1000);
			
	}
	
	public void seleccionarReembolso() {
		
		util.esperarElemento(5, objectPrincipalScreen.btnHome);
		util.esperarSegundos(3);
		 System.out.println("Entraaaa");
//		util.localizarElementoScroll(appiumDriver(), objectPrincipalScreen.btnReembolsoSalud);
		
		
		while(element(objectPrincipalScreen.btnReembolsoSalud).isCurrentlyVisible()==false) {
			Dimension dimension = appiumDriver().manage().window().getSize();
			//arrastrar hacia arriba, como deslizando la app para ver más contenido
			Point start= new Point((int)(dimension.width*0.2), (int)(dimension.height*0.8));
			Point end= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.2)); 
			pageObjectUtil2.doSwipe(appiumDriver(), start, end, 1000); //with duration 1s
		}
//		Actions action = new Actions(driver);
//		action.moveToElement(objectPrincipalScreen.btnReembolsoSalud).click().perform();
		
		pageObjectUtil2.tapElement(appiumDriver(),objectPrincipalScreen.btnReembolsoSalud);
		
//		element(objectPrincipalScreen.btnReembolsoSalud).click();
		
	}
	
	
}