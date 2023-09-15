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
import rimac.main.object.*;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilApp;
import rimac.main.util.VariablesAppNativa;

import static org.junit.Assert.assertFalse;


public class ScTusTramites extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjTramites tramitesObject = ObjTramites.getInstancia();
	protected ObjCommons objCommons = ObjCommons.getInstancia();
	protected ObjChoferReemplazo objChoferReemplazo = ObjChoferReemplazo.getInstancia();

	// util
	public static Logger looger = Logger.getLogger(ScTusTramites.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilApp util = new UtilApp();



	public void seleccionaReembolso() {
		try {
			Dimension dimension = appiumDriver().manage().window().getSize();
			Point start= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.5));
			Point end= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.2));
			util.esperarElementoClick(5,tramitesObject.lblTramites);
			int contador=0;
			while(element(tramitesObject.btnReembolsoSalud).isCurrentlyVisible()==false && contador<15) {
				util.doSwipe(appiumDriver(), start, end, 1000);
				contador++;
			}
			util.esperarElementoClick(5,tramitesObject.opcReembolsoSalud);
			Serenity.takeScreenshot();
			element(tramitesObject.btnReembolsoSalud).click();
			util.esperarSegundos(2);
		}
		catch (Exception e) {
			Serenity.takeScreenshot();
			throw new IllegalAccessError("Error en el aplicativo, para igresar a Reembolso");
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

	public void seleccionaReembolsoSalud() {
		Dimension dimension = appiumDriver().manage().window().getSize();
		Point start= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.5));
		Point end= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.2));
		util.esperarSegundos(2);
		util.esperarElementoClick(5,tramitesObject.lblTramites);
		if(element(objCommons.btnTodos).isCurrentlyVisible()){
			int xTodos=objCommons.btnTodos.getLocation().getX();
			int yTodos=objCommons.btnTodos.getLocation().getY();
			util.doSwipeCoordenadas(appiumDriver(), (xTodos+500), yTodos,xTodos,yTodos, 1000);
			if(element(tramitesObject.opcSalud).isCurrentlyVisible()){
				element(tramitesObject.opcSalud).click();
			}
		}
		int contador=0;
		while(element(tramitesObject.btnReembolsoSalud).isCurrentlyVisible()==false && contador<8) {
			util.doSwipe(appiumDriver(), start, end, 500);
			contador++;
		}
		if (dimension.height*0.8< tramitesObject.btnReembolsoSalud.getLocation().getY()) {
			util.doSwipe(appiumDriver(), start, end, 500);
		}
		Serenity.takeScreenshot();
		element(tramitesObject.btnReembolsoSalud).click();
		util.esperarSegundos(2);
	}

	public void seleccionaBuscadordeSalud() {
		Dimension dimension = appiumDriver().manage().window().getSize();
		Point start= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.5));
		Point end= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.2));
		util.esperarSegundos(2);
		util.esperarElementoClick(5,tramitesObject.lblTramites);
		if(element(objCommons.btnTodos).isCurrentlyVisible()) {
			int xTodos = objCommons.btnTodos.getLocation().getX();
			int yTodos = objCommons.btnTodos.getLocation().getY();
			util.doSwipeCoordenadas(appiumDriver(), (xTodos + 500), yTodos, xTodos, yTodos, 1000);
			if (element(tramitesObject.opcSalud).isCurrentlyVisible()) {
				element(tramitesObject.opcSalud).click();
			}
		}
		int contador=0;
		while(element(tramitesObject.btnBuscarClinica).isCurrentlyVisible()==false && contador<15) {
			util.doSwipe(appiumDriver(), start, end, 500);
			if(element(tramitesObject.btnBuscarClinica).isCurrentlyVisible()){
				break;
			}
			contador++;
		}
		Serenity.takeScreenshot();
		if (dimension.height*0.8 < tramitesObject.btnBuscarClinica.getLocation().getY()) {
			util.doSwipe(appiumDriver(), start, end, 500);
		}
		element(tramitesObject.btnBuscarClinica).click();
		util.esperarSegundos(2);
	}

	public void seleccionaAsistenciaVehicular() {
		Dimension dimension = appiumDriver().manage().window().getSize();
		Point start= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.5));
		Point end= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.2));
		util.esperarSegundos(2);
		util.esperarElementoClick(5,tramitesObject.lblTramites);
		if(element(objCommons.btnTodos).isCurrentlyVisible()) {
			int xTodos = objCommons.btnTodos.getLocation().getX();
			int yTodos = objCommons.btnTodos.getLocation().getY();
			util.doSwipeCoordenadas(appiumDriver(), (xTodos + 500), yTodos, xTodos, yTodos, 1000);
			if (element(tramitesObject.opcVehicular).isCurrentlyVisible()) {
				element(tramitesObject.opcVehicular).click();
			}
		}
		int contador=0;
		while(element(tramitesObject.btnAsisVehiculares).isCurrentlyVisible()==false && contador<8) {
			util.doSwipe(appiumDriver(), start, end, 500);
			if(element(tramitesObject.btnAsisVehiculares).isCurrentlyVisible()){
				break;
			}
			contador++;
		}
		if (dimension.height*0.8 < tramitesObject.btnAsisVehiculares.getLocation().getY()) {
			util.doSwipe(appiumDriver(), start, end, 500);
		}
		Serenity.takeScreenshot();
		element(tramitesObject.btnAsisVehiculares).click();
		util.esperarSegundos(2);
	}

	public void seleccionaChoferReemplazo() {
		Dimension dimension = appiumDriver().manage().window().getSize();
		Point start= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.8));
		Point end= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.5));
		util.esperarSegundos(2);
		util.esperarElementoClick(5,tramitesObject.lblTramites);
		if (element(tramitesObject.opcVehicular).isCurrentlyVisible()) {
			element(tramitesObject.opcVehicular).click();
		}
		int contador=0;
		while(element(objChoferReemplazo.opcChoferReemplazo).isCurrentlyVisible()==false && contador<15) {
			util.doSwipe(appiumDriver(), start, end, 500);
			if(element(objChoferReemplazo.opcChoferReemplazo).isCurrentlyVisible()){
				break;
			}
			contador++;
		}
		if (dimension.height*0.8 < objChoferReemplazo.opcChoferReemplazo.getLocation().getY()) {
			util.doSwipe(appiumDriver(), start, end, 500);
		}
		Serenity.takeScreenshot();
		element(objChoferReemplazo.opcChoferReemplazo).click();
		util.esperarSegundos(1);
	}

	public void seleccionaDescuentoAsistencias() {
		Dimension dimension = appiumDriver().manage().window().getSize();
		Point start= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.5));
		Point end= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.2));
		util.esperarSegundos(2);
		util.esperarElementoClick(5,tramitesObject.lblTramites);
		if(element(objCommons.btnTodos).isCurrentlyVisible()) {
			int xTodos = objCommons.btnTodos.getLocation().getX();
			int yTodos = objCommons.btnTodos.getLocation().getY();
			util.doSwipeCoordenadas(appiumDriver(), (xTodos + 500), yTodos, xTodos, yTodos, 1000);
			if (element(tramitesObject.opcVehicular).isCurrentlyVisible()) {
				element(tramitesObject.opcVehicular).click();
			}
		}
		int contador=0;
		while(element(tramitesObject.btnDescuentoAsistencias).isCurrentlyVisible()==false && contador<8) {
			util.doSwipe(appiumDriver(), start, end, 500);
			if(element(tramitesObject.btnDescuentoAsistencias).isCurrentlyVisible()){
				break;
			}
			contador++;
		}
		if (dimension.height*0.8 < tramitesObject.btnDescuentoAsistencias.getLocation().getY()) {
			util.doSwipe(appiumDriver(), start, end, 500);
		}
		Serenity.takeScreenshot();
		element(tramitesObject.btnDescuentoAsistencias).click();
	}
	
}