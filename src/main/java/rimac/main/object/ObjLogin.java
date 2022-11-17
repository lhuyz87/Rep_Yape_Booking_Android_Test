package rimac.main.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.ObjLogin;
import rimac.main.util.BaseDriver;

public class ObjLogin extends BaseDriver{
	
	// singleton
	private static ObjLogin obj = null;

	private ObjLogin() {
	}

	public static ObjLogin getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjLogin();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	
	@AndroidFindBy(xpath = "//*[@text='Iniciar sesión']")
	public WebElement btnIngresarSesion;
	

    @AndroidFindBy(xpath = "//*[@text='Nº de documento']")
	public WebElement txtNumDocumento;
    

    @AndroidFindBy(xpath = "//*[@text='Contraseña']")
	public WebElement txtPassword;
    
	
	public WebElement diaAtencion(WebDriver webDriver, String dia) {
		By by = By.xpath("//*[@text='"+dia+"']");
		WebElement diaAtencion = webDriver.findElement(by);
		return diaAtencion;
	}
	
	
	
	//Antiguo:
	
	@AndroidFindBy(id = "com.rimac.rimac_surrogas:id/login_text_reset_password")
	public WebElement btnOlvideContra;
	
	
	//Nuevo
//	@AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/login_text_reset_password")
//	public WebElement btnOlvideContra;
	
	
}