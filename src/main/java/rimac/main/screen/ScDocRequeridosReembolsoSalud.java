package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PushesFiles;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.pages.PageObject;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilApp;
import rimac.main.util.VariablesAppNativa;
import rimac.main.object.ObjLogin;
import rimac.main.object.ObjDocRequeridosReembolsoSalud;


public class ScDocRequeridosReembolsoSalud extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjDocRequeridosReembolsoSalud objDocRequeridosReembolsoSalud = ObjDocRequeridosReembolsoSalud.getInstancia();

	// util
	public static Logger looger = Logger.getLogger(ScDocRequeridosReembolsoSalud.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilApp util = new UtilApp();
	AppiumDriver driver;

	public void continuarDocRequeridos() {

		looger.info("Inicia los documentos Requeridos");
		util.esperarSegundos(3);
		try {
			util.esperarElementoClick(3, objDocRequeridosReembolsoSalud.btnContinuar);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

		looger.info("Se muestra boton Continuar");
		util.esperarSegundos(3);
		element(objDocRequeridosReembolsoSalud.btnContinuar).click();
//		try {
//			Thread.sleep(8000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	public void ingresar_factura() throws Exception {
		int contador=0;
		while(element(objDocRequeridosReembolsoSalud.btnCargarFactura).isCurrentlyVisible()==false && contador<5){
			util.mobileSwipeScreenAndroid();
			contador++;
		}
		element(objDocRequeridosReembolsoSalud.btnCargarFactura).click();
		util.esperarElementoVisible(5, objDocRequeridosReembolsoSalud.btnEntendidoComprobantes);
		element(objDocRequeridosReembolsoSalud.btnEntendidoComprobantes).click();
	}

	public void ingresar_receta() throws Exception {
		int contador=0;
		while(element(objDocRequeridosReembolsoSalud.btnCargarReceta).isCurrentlyVisible()==false && contador<5){
			util.mobileSwipeScreenAndroid();
			contador++;
		}
		element(objDocRequeridosReembolsoSalud.btnCargarReceta).click();
		util.esperarElementoVisible(5, objDocRequeridosReembolsoSalud.btnEntendidoSustenta);
		element(objDocRequeridosReembolsoSalud.btnEntendidoSustenta).click();
	}

	public void ingresar_solicitud_reemb_odontologico() throws Exception {
		int contador=0;
		while(element(objDocRequeridosReembolsoSalud.btnCargarReembOdon).isCurrentlyVisible()==false && contador<7){
			util.mobileSwipeScreenAndroid();
			contador++;
		}
		element(objDocRequeridosReembolsoSalud.btnCargarReembOdon).click();
		util.esperarElementoVisible(5, objDocRequeridosReembolsoSalud.btnEntendidoSustenta);
		element(objDocRequeridosReembolsoSalud.btnEntendidoSustenta).click();
	}

	public void ingresar_orden_medica() throws Exception {
		int contador=0;
		while(element(objDocRequeridosReembolsoSalud.btnOrdenMedica).isCurrentlyVisible()==false && contador<7){
			util.mobileSwipeScreenAndroid();
			contador++;
		}
		element(objDocRequeridosReembolsoSalud.btnOrdenMedica).click();
		util.esperarElementoVisible(5, objDocRequeridosReembolsoSalud.btnEntendidoSustenta);
		element(objDocRequeridosReembolsoSalud.btnEntendidoSustenta).click();
	}
	
}