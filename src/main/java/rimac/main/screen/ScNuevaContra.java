package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.PushesFiles;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilDef;
import rimac.main.util.VariablesAppNativa;
import rimac.main.object.ObjNuevaContra;


public class ScNuevaContra extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjNuevaContra objNuevaContra = ObjNuevaContra.getInstancia();
	protected MobileObjectUtil pageObjectUtil2 = MobileObjectUtil.getInstancia();
	public static Logger looger = Logger.getLogger(ScNuevaContra.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilDef util = new UtilDef();
	AppiumDriver driver;

	

	public void ingresaNuevaContra() {
		
		int aux = (int)(1000 + (Math.random() * 30)); 
		
		System.out.println("Número Generado "  + aux );
	    util.esperarElemento(3, objNuevaContra.txtPasswor);
		element(objNuevaContra.txtPasswor).sendKeys("Rimac" + aux +".");
		element(objNuevaContra.txtPassworRep).sendKeys("Rimac" + aux +".");
		
		try {
			((HidesKeyboard) appiumDriver()).hideKeyboard();
		} catch (Exception e) {
			
		}
		
		element(objNuevaContra.btnCambiaContra).click();
		
	}
	
	public static int numeroAleatorioEnRango(int minimo, int maximo) {
	    // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
	    return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
	}
	
	
	
}