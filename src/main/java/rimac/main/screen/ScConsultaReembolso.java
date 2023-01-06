package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PushesFiles;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import rimac.main.object.ObjComentariosAdicionales;
import rimac.main.object.ObjConsultaReembolso;
import rimac.main.object.ObjCuentaDeAbono;
import rimac.main.object.ObjSolicitudReembolsoRecibida;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilApp;
import rimac.main.util.VariablesAppNativa;



public class ScConsultaReembolso extends BaseDriver{

private long wdwTimeOut = 300L;
	


protected ObjConsultaReembolso objConsultaReembolso  = ObjConsultaReembolso.getInstancia();

	
	// util
	public static Logger looger = Logger.getLogger(ScConsultaReembolso.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilApp util = new UtilApp();
	AppiumDriver driver;

	public String obtenerMonto(String monto) {
	
		util.esperarElemento(3, objConsultaReembolso.btnFiltro);
		String montoEncontrado= "";
		String fechaReembol = "19/12/2022";
		int aux=0;
		while(aux<10) {
			
			try {
				
				for(int i =0; i< objConsultaReembolso.lblMontoReembolso.size();i++) {
					System.out.println("Aux "  + aux   +" Monto "  +i+" :  " + objConsultaReembolso.lblMontoReembolso.get(i).getText());
					System.out.println("Aux "  + aux   +" Fecha "  +i+" :  " + objConsultaReembolso.lblFechaReembolso.get(i).getText().substring(0,2));
					System.out.println(objConsultaReembolso.lblFechaReembolso.get(i).getText().substring(0,2) + "-vs-"  +  fechaReembol.substring(0,2) );
					if(Integer.parseInt(objConsultaReembolso.lblFechaReembolso.get(i).getText().substring(0,2))<Integer.parseInt(fechaReembol.substring(0,2))){
						aux=10;
						Serenity.takeScreenshot();
						break;
					}
					System.out.println(objConsultaReembolso.lblMontoReembolso.get(i).getText()+ "-vs-"  +  monto);
					if(objConsultaReembolso.lblMontoReembolso.get(i).getText().trim().compareToIgnoreCase(monto)==0){
						Serenity.takeScreenshot();
						montoEncontrado=objConsultaReembolso.lblMontoReembolso.get(i).getText().trim();
						aux=10;
						break;
				}

			}
				
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			

			util.mobileSwipeScreenAndroid();
			System.out.println("Auxiliar " +aux);
			aux++;
		
		
	}
		
		return montoEncontrado;
	
	}
	
	
	
}