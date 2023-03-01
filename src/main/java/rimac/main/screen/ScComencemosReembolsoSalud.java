package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

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
import rimac.main.object.ObjComencemosReembolsoSalud;


public class ScComencemosReembolsoSalud extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjComencemosReembolsoSalud comencemosReembolsoSaludObject = ObjComencemosReembolsoSalud.getInstancia();

	// util
	public static Logger looger = Logger.getLogger(ScComencemosReembolsoSalud.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilApp util = new UtilApp();
	AppiumDriver driver;
	
	public void llenarDatosTramitesSinBeneficiario(String prodContratante, String lugarAtencion, String fechaAtencion, String tipoCobert) {
		looger.info("Iniciar llenarDatosTramites");
		util.esperarElemento(3, comencemosReembolsoSaludObject.selProdContratante);
		element(comencemosReembolsoSaludObject.selProdContratante).click();
		System.out.println("Producto Contratante " + prodContratante);
		element(comencemosReembolsoSaludObject.productoContratante(appiumDriver(), prodContratante)).click();
		util.mobileSwipeScreenAndroidFinal();
		util.esperarElemento(5, comencemosReembolsoSaludObject.selLugarAtencion);
		element(comencemosReembolsoSaludObject.selLugarAtencion).click();
		element(comencemosReembolsoSaludObject.lugarAtencion(appiumDriver(), lugarAtencion)).click();
		util.mobileSwipeScreenAndroidFinal();
		util.esperarElemento(5, comencemosReembolsoSaludObject.selFechaAtencion);
		element(comencemosReembolsoSaludObject.selFechaAtencion).click();
		util.esperarActivoClick(3, comencemosReembolsoSaludObject.selAceptarDiaAtencion);
		element(comencemosReembolsoSaludObject.selAceptarDiaAtencion).click();
		int contador=0;
		while(element(comencemosReembolsoSaludObject.selTipoCobertura).isCurrentlyVisible()==false && contador<8){
			util.mobileSwipeScreenAndroidFinal();
		}
		util.esperarElemento(5, comencemosReembolsoSaludObject.selTipoCobertura);
		element(comencemosReembolsoSaludObject.selTipoCobertura).click();
		element(comencemosReembolsoSaludObject.tipoCobertura(appiumDriver(), tipoCobert)).click();
		util.mobileSwipeScreenAndroidFinal();

	}
	
	
	public void coberturaOdontologica(String tipoTratamiento) {
		
		element(comencemosReembolsoSaludObject.lstTipoTramiento).click();
		element(comencemosReembolsoSaludObject.getTratamiendo(appiumDriver(), tipoTratamiento)).click();
	}
	
	
	public void continuar() {
		element(comencemosReembolsoSaludObject.btnContinuar).click();
	}
	
	public void llenarDatosTramitesConBeneficiario(String prodContratante,String beneficiario,String lugarAtencion, String fechaAtencion, String tipoCobert) {
		looger.info("Iniciar llenarDatosTramites");
		util.esperarElemento(3, comencemosReembolsoSaludObject.selProdContratante);
		element(comencemosReembolsoSaludObject.selProdContratante).click();
		System.out.println("Producto Contratante " + prodContratante);
		element(comencemosReembolsoSaludObject.productoContratante(appiumDriver(), prodContratante)).click();
		util.esperarElemento(5, comencemosReembolsoSaludObject.selPaciente);
		element(comencemosReembolsoSaludObject.selPaciente).click();		
		element(comencemosReembolsoSaludObject.getPaciente(appiumDriver(), beneficiario)).click();
		util.esperarElemento(5, comencemosReembolsoSaludObject.selLugarAtencion);
		element(comencemosReembolsoSaludObject.selLugarAtencion).click();
		element(comencemosReembolsoSaludObject.lugarAtencion(appiumDriver(), lugarAtencion)).click();
		util.mobileSwipeScreenAndroidFinal();
		util.esperarElemento(3, comencemosReembolsoSaludObject.selFechaAtencion);
		element(comencemosReembolsoSaludObject.selFechaAtencion).click();
		element(comencemosReembolsoSaludObject.selAceptarDiaAtencion).click();
		int contador=0;
		while(element(comencemosReembolsoSaludObject.selTipoCobertura).isCurrentlyVisible()==false && contador<8){
			util.mobileSwipeScreenAndroidFinal();
		}
		util.esperarElemento(3, comencemosReembolsoSaludObject.selTipoCobertura);
		element(comencemosReembolsoSaludObject.selTipoCobertura).click();
		element(comencemosReembolsoSaludObject.tipoCobertura(appiumDriver(), tipoCobert)).click();
		util.mobileSwipeScreenAndroidFinal();
	}
	
}