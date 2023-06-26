package rimac.main.screen;


import java.util.NoSuchElementException;
import java.util.logging.Logger;

import io.appium.java_client.MobileBy;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import io.appium.java_client.AppiumDriver;
import rimac.main.object.*;
import rimac.main.object.ObjMediodePago;
import rimac.main.object.ObjPaginaPrincipal;
import rimac.main.object.ObjPagos;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilApp;

import java.util.Timer;


public class ScTusSeguros extends BaseDriver{

	
	
	private long wdwTimeOut = 300L;
	protected ObjPaginaPrincipal objPaginaPrincipal=ObjPaginaPrincipal.getInstancia();
	protected ObjTusSeguros objTusSeguros = ObjTusSeguros.getInstancia();
	protected ObjMediodePago objMediodePago = ObjMediodePago.getInstancia();
	protected ObjPagos objPagos = ObjPagos.getInstancia();
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

	public void ver_detalle_seguro(String seguro){
		try {
			int contador = 0;
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
	public void ver_detalle_Vehicular(String seguro){
		try {
			int contador = 0;
			if(element(objTusSeguros.btnTodos).isCurrentlyVisible()){
				int xTodos=objTusSeguros.btnTodos.getLocation().getX();
				int yTodos=objTusSeguros.btnTodos.getLocation().getY();
				util.doSwipeCoordenadas(appiumDriver(), (xTodos+500), yTodos,xTodos,yTodos, 1000);
				if(element(objTusSeguros.btnVehicular).isCurrentlyVisible()){
					element(objTusSeguros.btnVehicular).click();
				}
			}
				while (element(objTusSeguros.opcSeguro(seguro)).isCurrentlyVisible() == false && contador < 8) {
					util.mobileSwipeScreenAndroid();
					contador++;
				}
			Serenity.takeScreenshot();
			element(objTusSeguros.opcSeguro(seguro)).click();
			if(element(objTusSeguros.btnEntendido).isCurrentlyVisible()){
				element(objTusSeguros.btnEntendido).click();
			}
		}catch(Exception e){
			Dimension dimension = appiumDriver().manage().window().getSize();
			Point start= new Point((int)(dimension.width*0.2), (int)(dimension.height*0.8));
			Point end= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.6));
			util.doSwipe(appiumDriver(), start, end, 500);
			element(objTusSeguros.opcSeguro(seguro)).click();
		}
	}

	public void ver_detalle_Vehicular_placa(String placa){
		try {
			int contador = 0;
			if(element(objTusSeguros.btnTodos).isCurrentlyVisible()){
				int xTodos=objTusSeguros.btnTodos.getLocation().getX();
				int yTodos=objTusSeguros.btnTodos.getLocation().getY();
				util.doSwipeCoordenadas(appiumDriver(), (xTodos+500), yTodos,xTodos,yTodos, 1000);
				if(element(objTusSeguros.btnVehicular).isCurrentlyVisible()){
					element(objTusSeguros.btnVehicular).click();
				}
			}
			Dimension dimension = appiumDriver().manage().window().getSize();
			Point start= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.5));
			Point end= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.2));

			int ybtnPerfil=objPaginaPrincipal.btnPerfil.getLocation().getY();
			while (contador < 8) {
				if(objTusSeguros.verDetalleXPlaca2(placa).size()!=0){
					break;
				}
				util.mobileSwipeScreenAndroid();
				contador++;
			}
			if ((ybtnPerfil-150) < objTusSeguros.verDetalleXPlaca(placa).getLocation().getY()) {
				util.doSwipe(appiumDriver(), start, end, 500);
			}
			Serenity.takeScreenshot();
			element(objTusSeguros.verDetalleXPlaca(placa)).click();
		}catch(NoSuchElementException e){
			throw new IllegalAccessError("No se encontró la placa del vehiculo");
		}
	}

	public void ver_detalle_Vida(String seguro){
		try {
			int contador = 0;
			if(element(objTusSeguros.btnTodos).isCurrentlyVisible()){
				int xTodos=objTusSeguros.btnTodos.getLocation().getX();
				int yTodos=objTusSeguros.btnTodos.getLocation().getY();
				util.doSwipeCoordenadas(appiumDriver(), (xTodos+500), yTodos,xTodos,yTodos, 1000);
				if(element(objTusSeguros.btnVida).isCurrentlyVisible()){
					element(objTusSeguros.btnVida).click();
				}
			}
			while (element(objTusSeguros.opcSeguro(seguro)).isCurrentlyVisible() == false && contador < 8) {
				util.mobileSwipeScreenAndroid();
				contador++;
			}
			Serenity.takeScreenshot();
			element(objTusSeguros.opcSeguro(seguro)).click();
		}catch(Exception e){
			Dimension dimension = appiumDriver().manage().window().getSize();
			Point start= new Point((int)(dimension.width*0.2), (int)(dimension.height*0.8));
			Point end= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.6));
			util.doSwipe(appiumDriver(), start, end, 500);
			element(objTusSeguros.opcSeguro(seguro)).click();
		}
	}

	public void ver_vetalle_Salud(String seguro){
		try {
			int contador = 0;
			if(element(objTusSeguros.btnTodos).isCurrentlyVisible()){
				int xTodos=objTusSeguros.btnTodos.getLocation().getX();
				int yTodos=objTusSeguros.btnTodos.getLocation().getY();
				util.doSwipeCoordenadas(appiumDriver(), (xTodos+500), yTodos,xTodos,yTodos, 1000);
				if(element(objTusSeguros.btnSalud).isCurrentlyVisible()){
					element(objTusSeguros.btnSalud).click();
				}
			}
			while (element(objTusSeguros.opcSeguro(seguro)).isCurrentlyVisible() == false && contador < 8) {
				util.mobileSwipeScreenAndroid();
				contador++;
			}
			Serenity.takeScreenshot();
			element(objTusSeguros.opcSeguro(seguro)).click();
		}catch(Exception e){
			Dimension dimension = appiumDriver().manage().window().getSize();
			Point start= new Point((int)(dimension.width*0.2), (int)(dimension.height*0.8));
			Point end= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.6));
			util.doSwipe(appiumDriver(), start, end, 500);
			element(objTusSeguros.opcSeguro(seguro)).click();
		}
	}

	public void ver_vetalle_Soat(String seguro){
		try {
			int contador = 0;
			if(element(objTusSeguros.btnTodos).isCurrentlyVisible()){
				int xTodos=objTusSeguros.btnTodos.getLocation().getX();
				int yTodos=objTusSeguros.btnTodos.getLocation().getY();
				util.doSwipeCoordenadas(appiumDriver(), (xTodos+500), yTodos,xTodos,yTodos, 1000);
				if(element(objTusSeguros.btnSOAT).isCurrentlyVisible()){
					element(objTusSeguros.btnSOAT).click();
				}
			}
			while (element(objTusSeguros.opcSeguro(seguro)).isCurrentlyVisible() == false && contador < 8) {
				util.mobileSwipeScreenAndroid();
				contador++;
			}
			Serenity.takeScreenshot();
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
			if(element(objTusSeguros.btnEntendido).isCurrentlyVisible()){
				element(objTusSeguros.btnEntendido).click();
				util.esperarElemento(10,objTusSeguros.btnPagos);
				element(objTusSeguros.btnPagos).click();
			}
			else{
			util.esperarElemento(10,objTusSeguros.btnPagos);
			element(objTusSeguros.btnPagos).click();
			}

		}catch(Exception e){
			throw new IllegalAccessError("Error para ingresar a pagos");
		}
	}
	public void seleccionar_Placa(String placa){
		int contador = 0;
		if(element(objTusSeguros.btnTodos).isCurrentlyVisible()){
			int xTodos=objTusSeguros.btnTodos.getLocation().getX();
			int yTodos=objTusSeguros.btnTodos.getLocation().getY();
			util.doSwipeCoordenadas(appiumDriver(), (xTodos+500), yTodos,xTodos,yTodos, 1000);
			if(element(objTusSeguros.btnVehicular).isCurrentlyVisible()){
				element(objTusSeguros.btnVehicular).click();
			}
		}
		Dimension dimension = appiumDriver().manage().window().getSize();
		Point start= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.5));
		Point end= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.2));

		int ybtnPerfil=objPaginaPrincipal.btnPerfil.getLocation().getY();
		while (contador < 8) {
			if(objTusSeguros.verDetalleXPlaca2(placa).size()!=0){
				break;
			}
			util.mobileSwipeScreenAndroid();
			contador++;
		}
		if ((ybtnPerfil-100) < objTusSeguros.verDetalleXPlaca(placa).getLocation().getY()) {
			util.doSwipe(appiumDriver(), start, end, 500);
		}
		Serenity.takeScreenshot();
		element(objTusSeguros.verDetalleXPlaca(placa)).click();
	}
	public void añadir_nueva_tarjeta() {
		Dimension dimension = appiumDriver().manage().window().getSize();
		Point start= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.8));
		Point end= new Point((int)(dimension.width*0.2), (int)(dimension.height*0.2));
		int contador=0;
		while(element(objMediodePago.btnAnadirNuevaTarjeta).isCurrentlyVisible()==false && contador<15) {
			util.doSwipe(appiumDriver(), start, end, 1000);
			contador++;
		}
		util.esperarElemento(5, objMediodePago.btnAnadirNuevaTarjeta);
		util.esperarSegundos(1);
		element(objMediodePago.btnAnadirNuevaTarjeta).click();
	}

	public void seleccionaSOAT() {
		try {
			util.esperarElemento(5, objTusSeguros.btnSOAT);
			element(objTusSeguros.btnSOAT).click();
			Serenity.takeScreenshot();
		}
		catch(org.openqa.selenium.NoSuchElementException ex) {
			System.out.println("Error cuando seleccionamos tapSOAT " + ex);
		}

	}
	public void verDetalle() {
		try {
			util.esperarElemento(5, objTusSeguros.btnVerDetallePlaca);
			element(objTusSeguros.btnVerDetallePlaca).click();
			Serenity.takeScreenshot();
		}
		catch(org.openqa.selenium.NoSuchElementException ex) {
			System.out.println("Error cuando seleccionamos  Ver detalle" + ex);
		}

	}
}