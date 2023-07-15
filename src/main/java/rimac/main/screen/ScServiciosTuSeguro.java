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
import rimac.main.util.UtilApp;
import rimac.main.util.VariablesAppNativa;
import rimac.main.object.ObjLogin;
import rimac.main.object.ObjPaginaPrincipal;
import rimac.main.screen.ScServiciosTuSeguro;
import rimac.main.object.ObjAlertas;
import rimac.main.object.ObjServicioTuSeguro;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ScServiciosTuSeguro extends BaseDriver{

	
	
	private long wdwTimeOut = 300L;
	
	protected ObjServicioTuSeguro objServicioTuSeguro = ObjServicioTuSeguro.getInstancia();
	
	// util
	protected MobileObjectUtil pageObjectUtil2 = MobileObjectUtil.getInstancia();
	public static Logger looger = Logger.getLogger(ScServiciosTuSeguro.class.getName());
	
	
	public static void main(String[] args) {
		
	}
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilApp util = new UtilApp();
	public void seleccionarServicioReembolso() {
		looger.info("Inicia selección del seguro");
			int contador=0;
			while(element(objServicioTuSeguro.btnReembolsoSalud).isCurrentlyVisible()==false && contador<5){
				util.mobileSwipeScreenAndroid();
			}
			util.esperarElemento(5, objServicioTuSeguro.btnReembolsoSalud);
			element(objServicioTuSeguro.btnReembolsoSalud).click();
	}
	
	
	
}