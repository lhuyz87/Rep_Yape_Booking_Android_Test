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

import io.appium.java_client.android.AndroidDriver;
//import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilApp;
import rimac.main.util.VariablesAppNativa;
import rimac.main.screen.ScBuscadorDeClinicas;
import rimac.main.object.ObjAlertas;
import rimac.main.object.ObjBuscadorDeClinicas;


import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Timer;
import java.util.TimerTask;

public class ScBuscadorDeClinicas extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjBuscadorDeClinicas objBuscadorDeClinicas = ObjBuscadorDeClinicas.getInstancia();
	protected ObjAlertas objAlertas = ObjAlertas.getInstancia();

	// util
	protected MobileObjectUtil mobileObjectUtil = MobileObjectUtil.getInstancia();
	public static Logger looger = Logger.getLogger(ScBuscadorDeClinicas.class.getName());
	UtilApp util = new UtilApp();
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}

	public void seleccionar_datos_para_continuar(){
		util.esperarElemento(10, objBuscadorDeClinicas.lblAntesdeComenzar);
		element(objBuscadorDeClinicas.cmbPaciente).click();
		element(objBuscadorDeClinicas.rdbPaciente).click();
		element(objBuscadorDeClinicas.btnContinuar).click();
	}
	public void ingresarNombreClinica(String nomClinica) {
		
		int contador=0;
		
		try {
			if(element(objAlertas.btnAppEnUso).isCurrentlyVisible()) {
				element(objAlertas.btnAppEnUso).click();
				System.out.println("Entra");
				util.esperarSegundos(1);
			
			}
		} catch (NoSuchElementException e) {
//			System.out.println("In catch block to handle no such element");
			e.printStackTrace();
		} 
				
		util.esperarActivoClick(10, objBuscadorDeClinicas.txtBuscarClinica);
		element(objBuscadorDeClinicas.txtBuscarClinica).sendKeys(nomClinica);
		Serenity.takeScreenshot();
		util.esperarActivoClick(10, objBuscadorDeClinicas.lblClinicaEncontra);
		element(objBuscadorDeClinicas.lblClinicaEncontra).click();
		

	}

	public boolean getCopago() {
		try {
			boolean solicitudExiste1;
			util.esperarActivoClick(10, objBuscadorDeClinicas.lblCopago());
			solicitudExiste1 = element(objBuscadorDeClinicas.lblCopago()).isCurrentlyVisible();
			System.out.println("se muestra el"+objBuscadorDeClinicas.lblCopago());
			return solicitudExiste1;
		} catch (Exception e) {
			throw new IllegalAccessError("Error no se puede validar el copago");
		} finally {
			Serenity.takeScreenshot();
		}

	}
	
}