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
import rimac.main.util.PageObjectUtil2;
import rimac.main.util.UtilDef;
import rimac.main.util.VariablesAppNativa;
import rimac.main.object.LoginObject;
import rimac.main.object.ComencemosReembolsoSaludObject;


public class ComencemosReembolsoSaludScreen extends BaseScreen{

private long wdwTimeOut = 300L;
	
	protected ComencemosReembolsoSaludObject comencemosReembolsoSaludObject = ComencemosReembolsoSaludObject.getInstancia();

	// util
	public static Logger looger = Logger.getLogger(ComencemosReembolsoSaludScreen.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilDef util = new UtilDef();
	AppiumDriver driver;
	
	public void llenarDatosTramites(String prodContratante, String lugarAtencion, String fechaAtencion, String tipoCobert) {
		looger.info("Iniciar llenarDatosTramites");
		util.esperarElemento(3, comencemosReembolsoSaludObject.selProdContratante);
		element(comencemosReembolsoSaludObject.selProdContratante).click();
		System.out.println("Producto Contratante " + prodContratante);
		element(comencemosReembolsoSaludObject.productoContratante(appiumDriver(), prodContratante)).click();
		util.esperarElemento(5, comencemosReembolsoSaludObject.selLugarAtencion);
		element(comencemosReembolsoSaludObject.selLugarAtencion).click();
		element(comencemosReembolsoSaludObject.lugarAtencion(appiumDriver(), lugarAtencion)).click();
		util.esperarSegundos(1);
		element(comencemosReembolsoSaludObject.selFechaAtencion).click();
		element(comencemosReembolsoSaludObject.diaAtencion(appiumDriver(), fechaAtencion.substring(0,2))).click();
		element(comencemosReembolsoSaludObject.selAceptarDiaAtencion).click();
		util.esperarElemento(5, comencemosReembolsoSaludObject.selTipoCobertura);
		element(comencemosReembolsoSaludObject.selTipoCobertura).click();
		element(comencemosReembolsoSaludObject.tipoCobertura(appiumDriver(), tipoCobert)).click();
		appiumDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Continuar\").instance(0))"));

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
		util.esperarSegundos(1);
		element(comencemosReembolsoSaludObject.selFechaAtencion).click();
		element(comencemosReembolsoSaludObject.diaAtencion(appiumDriver(), fechaAtencion.substring(0,2))).click();
		element(comencemosReembolsoSaludObject.selAceptarDiaAtencion).click();
		util.esperarElemento(5, comencemosReembolsoSaludObject.selTipoCobertura);
		element(comencemosReembolsoSaludObject.selTipoCobertura).click();
		element(comencemosReembolsoSaludObject.tipoCobertura(appiumDriver(), tipoCobert)).click();
		appiumDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Continuar\").instance(0))"));

		element(comencemosReembolsoSaludObject.btnContinuar).click();
		
	}
	
}