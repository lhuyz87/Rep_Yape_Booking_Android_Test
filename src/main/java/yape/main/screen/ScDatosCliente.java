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

import yape.main.object.ObjDatosCliente;
import yape.main.screen.ScDatosCliente;
import yape.main.util.BaseDriver;
import yape.main.util.MobileObjectUtil;
import yape.main.util.UtilApp;
import yape.main.util.VariablesAppNativa;

import static org.junit.Assert.assertFalse;

public class ScDatosCliente extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjDatosCliente objDatosCliente = ObjDatosCliente.getInstancia();

	
	
	public static Logger looger = Logger.getLogger(ScDatosCliente.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilApp util = new UtilApp();
	protected MobileObjectUtil mobil = MobileObjectUtil.getInstancia();
	AppiumDriver driver;
	


	public void ingresarDatos(String nombre, String apellido, String email, String direccion, String postal,
			String ciudad, String pais, String telefono) {
		
		String elementHierarchy = getDriver().getPageSource();
		
//		System.out.println(elementHierarchy);
		
		androidDriver().hideKeyboard();
		
		util.esperarElemento(3, objDatosCliente.txtNombre);
		element(objDatosCliente.txtNombre).click();;
		element(objDatosCliente.txtNombre).sendKeys(nombre);
		element(objDatosCliente.txtApellido).sendKeys(apellido);
//		element(objDatosCliente.txtMail).sendKeys(email);
		element(objDatosCliente.txtDireccion).sendKeys(direccion);
		element(objDatosCliente.txtCodigoPostal).sendKeys(postal);
		androidDriver().hideKeyboard();
		element(objDatosCliente.txtCiudad).sendKeys(ciudad);
		androidDriver().hideKeyboard();
		util.scroll();
		util.scroll();
//		element(objDatosCliente.txtPaisRegion).sendKeys(pais);
		androidDriver().hideKeyboard();
		element(objDatosCliente.txtTelefono).sendKeys(telefono);
		androidDriver().hideKeyboard();
		
	}



	public void seleccioarMotivoViaje(String motivo) {
		element(objDatosCliente.radBtnMotivoViaje(getDriver(), motivo)).click();
		
	}



	public void confirmarDatosFaltantes() {
		// TODO Auto-generated method stub
		element(objDatosCliente.btnSiguientePaso).click();
		
		
	}
}