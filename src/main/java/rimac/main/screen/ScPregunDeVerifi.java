package rimac.main.screen;


import java.util.List;
import java.util.logging.Logger;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By.ByXPath;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.Serenity;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilApp;
import rimac.main.object.ObjPregunDeVerifi;

public class ScPregunDeVerifi extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjPregunDeVerifi objPregunDeVerifi = ObjPregunDeVerifi.getInstancia();

	// util
	protected MobileObjectUtil pageObjectUtil2 = MobileObjectUtil.getInstancia();

	public static Logger looger = Logger.getLogger(ScPregunDeVerifi.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilApp util = new UtilApp();
	AppiumDriver driver;


	public void ingresaFechaNacimi(String fechaNacimi) {
		int ancla=0;
		int intento=10;
		boolean buscaAnio=false;
		util.esperarSegundos(2);
		util.esperarActivoClick(5, objPregunDeVerifi.btnCalend);
		element(objPregunDeVerifi.btnCalend).click();
		String dia= fechaNacimi.split("/")[0];
		String mes= fechaNacimi.split("/")[1];
		String anio= fechaNacimi.split("/")[2];
	
		System.out.println("Fecha " + dia+mes+anio);
		
		element(objPregunDeVerifi.btnAnio).click();
		
		while(ancla==0||intento<=15) {
			
			buscaAnio = util.buscarTextoLista(objPregunDeVerifi.btnAnioNac, anio);
			if(buscaAnio==true) {
				System.out.println("Se encontro elemento  ");
				break;
			}else {
				util.scrollUp(driver);
			}
			
			
			intento++;
		}
		
	String xpathMonth = "//*[@resource-id='android:id/month_view']//descendant::android.view.View";
		List<WebElement> elementos = driver.findElements(ByXPath.xpath(xpathMonth));
		for(int i=0; i< elementos.size(); i++) {
	}
	
		String mesActual = elementos.get(0).getAttribute("content-desc").split(" ")[1];
		System.out.println("Mes Actual " + mesActual);
		
		
		String mesNumeroActual=util.numeroMes(mesActual);
		
		int cantMesDif= Integer.parseInt(mes)-Integer.parseInt(mesNumeroActual);
		System.out.println("Meses diferencia "  + cantMesDif);

//		05 -  11 = -06
		
		if(cantMesDif==0) {
			element(objPregunDeVerifi.selDia(driver, ""+Integer.parseInt(dia))).click();
		}
		
		if(cantMesDif<0) {
			for(int i=0; i<cantMesDif*-1; i++) {
				element(objPregunDeVerifi.btnMesPrevio).click();
			}
			element(objPregunDeVerifi.selDia(driver, ""+Integer.parseInt(dia))).click();
		}
		
		if(cantMesDif>0) {
			for(int i=0; i<cantMesDif; i++) {
				element(objPregunDeVerifi.btnMesPrevio).click();
			}
			element(objPregunDeVerifi.selDia(driver, ""+Integer.parseInt(dia))).click();
		}
	
		
		element(objPregunDeVerifi.btnAcepta).click();
		
		util.esperarSegundos(3);
		
	
		
		
		
//		for(int i=0; i< objPregunDeVerifi.btnAnioNac.size();i++) {
//			
//			System.out.println("Años  " + objPregunDeVerifi.btnAnioNac.get(i).getText());
//		}
		

		
		Serenity.takeScreenshot();
		
	}


	public void seleccSeguros(String seguros) {

		String[] seguro = seguros.split(",");
		util.scroll();
		for (String v_seguro : seguro) {
			
			switch (v_seguro.trim()) {

			    case "Domiciliario":
			    	element(objPregunDeVerifi.btnSeguroDomici()).click();
			    	continue;
			    case "Salud / EPS":
			    	element(objPregunDeVerifi.btnSeguroSaludEPS()).click();
			    	continue;
			    case "Vehicular":
			    	element(objPregunDeVerifi.btnSeguroVehicu()).click();
			    	continue;
			    case "Vida":
			    	element(objPregunDeVerifi.btnSeguroVida()).click();
			    	continue;
			    case "SOAT":
			    	element(objPregunDeVerifi.btnSeguroSOAT()).click();
			    	util.esperarSegundos(5);
			    	continue;
	
			    default:
			    	element(objPregunDeVerifi.btnSeguroOtros()).click();
			    	continue;
	
			}
		}
		Serenity.takeScreenshot();
		element(objPregunDeVerifi.btnContinu).click();
		
	}
	
	
	
}