package yape.main.screen;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.html5.Location;
import com.github.dockerjava.api.model.Driver;

//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.PushesFiles;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import yape.main.object.ObjDatosPago;
import yape.main.object.ObjLogin;
import yape.main.screen.ScPagos;
import yape.main.util.BaseDriver;
import yape.main.util.MobileObjectUtil;
import yape.main.util.UtilApp;
import yape.main.util.VariablesAppNativa;

import static org.junit.Assert.assertFalse;

public class ScPagos extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjDatosPago objDatosPago = ObjDatosPago.getInstancia();

	
	
	public static Logger looger = Logger.getLogger(ScPagos.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilApp util = new UtilApp();
	protected MobileObjectUtil mobil = MobileObjectUtil.getInstancia();
	AppiumDriver driver;


	public void IngresarDatosTarjeta(String tarjeta, String fechaVencimiento) {
		// TODO Auto-generated method stub
		util.esperarElemento(3, objDatosPago.txtNumTarjeta);
		element(objDatosPago.txtNumTarjeta).sendKeys(tarjeta);
		element(objDatosPago.txtFechaCaducidad).click();
		element(objDatosPago.txtFechaCaducidad).sendKeys(fechaVencimiento);
		
		util.scroll();
		
//		System.out.println(objDatosPago.lblMontoPagar.getText());
	}


	public int obtenerMontoTotal() {
		// TODO Auto-generated method stub
		int monto=0;
		String aux="";
		util.esperarElemento(2, objDatosPago.lblMontoPagar);
		aux = objDatosPago.lblMontoPagar.getText().substring(3,objDatosPago.lblMontoPagar.getText().length());
		aux = aux.replace(".", "");
		System.out.println(aux);
		monto = Integer.parseInt(aux);
		return monto;
	}


	public void confirmarPago() {
		// TODO Auto-generated method stub
		
		util.esperarElemento(3, objDatosPago.btnReservarAhora);
		element(objDatosPago.btnReservarAhora).click();
	}
}