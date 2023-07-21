package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;

import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PushesFiles;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.pages.PageObject;
import rimac.main.object.*;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilApp;
import rimac.main.util.VariablesAppNativa;
import rimac.main.screen.ScHome;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ScHome extends BaseDriver{

	
	
	private long wdwTimeOut = 300L;
	
	protected ObjPaginaPrincipal objectPrincipal = ObjPaginaPrincipal.getInstancia();
	protected ObjRegistrarHuella registrarHuellaObject = ObjRegistrarHuella.getInstancia();
	protected ObjAlertas alertasObject = ObjAlertas.getInstancia();
	protected ObjTienda objTienda = ObjTienda.getInstancia();
	// util
	protected MobileObjectUtil pageObjectUtil2 = MobileObjectUtil.getInstancia();
	public static Logger looger = Logger.getLogger(ScHome.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilApp util = new UtilApp();
	AppiumDriver driver;
	static Timer timer;
	static int contador=0;
	
	public void seleccionarOpcionPrincipal(String opcion) {
		looger.info("aplicación iniciada");
			
		
		switch (opcion) {
		case "Home":
			
			break;
			
		case "Seguros":
			util.esperarElemento(10, objectPrincipal.btnSeguros);
			element(objectPrincipal.btnSeguros).click();
			break;
			
		case "Tramites":
			util.esperarElemento(10, objectPrincipal.btnTramite);
			element(objectPrincipal.btnTramite).click();
			break;
		
		case "Tienda":
			util.esperarElemento(10, objectPrincipal.btnTienda);
			element(objectPrincipal.btnTienda).click();
			break;
			
		case "Perfil":
			util.esperarElemento(10, objectPrincipal.btnTramite);
			element(objectPrincipal.btnPerfil).click();
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
		util.esperarElemento(7, objectPrincipal.btnEmergencia);
		int contador=0;
		try {
			while(element(objectPrincipal.btnBuscadorClinica).isCurrentlyVisible()==false && contador<5){
				util.mobileSwipeScreenAndroid();
			}
			element(objectPrincipal.btnBuscadorClinica).click();
			System.out.println("Se encontro elemento  ");
		} catch (Exception e) {
			// TODO: handle exception
			util.scrollDown(appiumDriver());
		}
	}

	public void seleccionaVerTodas() {

		Dimension dimension = appiumDriver().manage().window().getSize();
		Point start= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.8));
		Point end= new Point((int)(dimension.width*0.5),(0));
		util.doSwipe(appiumDriver(), start, end, 1000);
		element(objectPrincipal.lnkVerTodas).click();
		util.esperarSegundos(3);
		//util.esperarElemento(8,objectPrincipal.lblTusAsistencias);
	}

	public String getMontoReembolso(String monto) {

		String montoReembolso = "";

		try {
			Dimension dimension = appiumDriver().manage().window().getSize();
			Point start= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.9));
			Point end= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.3));
			util.doSwipe(appiumDriver(), start, end, 1000); //with duration 1s
			util.esperarElemento(15, objectPrincipal.txtMontoReembolso(monto));
			montoReembolso = element(objectPrincipal.txtMontoReembolso(monto)).isVisible() == true ? monto: "no existe";
		}catch(NoSuchElementException ex) {
			montoReembolso = "no existe";
		}

		Serenity.takeScreenshot();
		return montoReembolso;


	}
	public void seleccionaSoatDosMinutos() {
		try {
			int contador = 0;
			while(element(objectPrincipal.btnSoatHome).isCurrentlyVisible()==false && contador<5){
				util.mobileSwipeScreenAndroidFinal();
				contador ++;
			}
			int ybtnPerfil=objectPrincipal.btnPerfil.getLocation().getY();
			if ((ybtnPerfil-150) < objectPrincipal.btnSoatHome.getLocation().getY()) {
				util.mobileSwipeScreenAndroid();
			}
			element(objectPrincipal.btnSoatHome).click();
		} catch (Exception e) {
			util.scrollDown(appiumDriver());
		}

	}
	public void seleccionaSegurosHome() {
		pageObjectUtil2.tapElement(appiumDriver(),objectPrincipal.btnPlanVidaFlexibleHo);
		util.esperarSegundos(3);
	}
}