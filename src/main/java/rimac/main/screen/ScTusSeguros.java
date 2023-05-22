package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.By;
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
import rimac.main.util.UtilApp;
import rimac.main.util.VariablesAppNativa;
import rimac.main.object.ObjLogin;
import rimac.main.object.ObjPaginaPrincipal;
import rimac.main.screen.ScTusSeguros;
import rimac.main.object.ObjAlertas;
import rimac.main.object.ObjTusSeguros;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ScTusSeguros extends BaseDriver{

	
	
	private long wdwTimeOut = 300L;
	
	protected ObjTusSeguros objTusSeguros = ObjTusSeguros.getInstancia();
	
	// util
	protected MobileObjectUtil pageObjectUtil2 = MobileObjectUtil.getInstancia();
	public static Logger looger = Logger.getLogger(ScTusSeguros.class.getName());

	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilApp util = new UtilApp();
	AppiumDriver driver;
	static Timer timer;
	static int contador=0;
	
	
	public void seleccionarDetalleSeguro(String seguro) {
		
		util.esperarElemento(5, objTusSeguros.btnDetalleSeguro);
		util.esperarSegundos(1);
		element(objTusSeguros.btnDetalleSeguro).click();

	}

	public void esperar_Tus_Seguros(){
		util.esperarElemento(3, objTusSeguros.lblTusSeguros);
	}

	public void seleccionarVida(){
		element(objTusSeguros.btnVida).click();
	}

	public void ver_Detalle(String seguro){
		try {
			int contador = 0;
			int xTodos=objTusSeguros.btnTodos.getLocation().getX();
			int yTodos=objTusSeguros.btnTodos.getLocation().getY();
			util.doSwipeCoordenadas(appiumDriver(), (xTodos+500), yTodos,xTodos,yTodos, 1000);

			if(element(objTusSeguros.btnSOAT).isCurrentlyVisible()){
				element(objTusSeguros.btnSOAT).click();
			}
				while (element(objTusSeguros.opcSeguro(seguro)).isCurrentlyVisible() == false && contador < 8) {
					util.mobileSwipeScreenAndroid();
					contador++;
				}
			element(objTusSeguros.opcSeguro(seguro)).click();
		}catch(Exception e){
			Dimension dimension = appiumDriver().manage().window().getSize();
			Point start= new Point((int)(dimension.width*0.2), (int)(dimension.height*0.8));
			Point end= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.6));
			util.doSwipe(appiumDriver(), start, end, 500);
			element(objTusSeguros.opcSeguro(seguro)).click();
		}
	}

	public void irPagos(){
		try {
			util.esperarSegundos(2);
			Dimension dimension = appiumDriver().manage().window().getSize();
			Point start= new Point((int)(dimension.width*0.9), (int)(dimension.height*0.13));
			Point end= new Point((int)(dimension.width*0.1), (int)(dimension.height*0.13));
			util.doSwipe(appiumDriver(), start, end, 1000);
			util.esperarElemento(3,objTusSeguros.btnPagos);
			element(objTusSeguros.btnPagos).click();
		}catch(Exception e){
			throw new IllegalAccessError("Error para ingresar a pagos");
		}
	}
}