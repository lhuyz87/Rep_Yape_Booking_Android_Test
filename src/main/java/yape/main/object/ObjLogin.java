package yape.main.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import yape.main.object.ObjLogin;
import yape.main.util.BaseDriver;

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
	
	@AndroidFindBy(xpath = "//*[@text='Inicia sesión con Google']")
	public WebElement btnIngresarGoogle;
	
	@AndroidFindBy(xpath = "//*[@text='ntwtxi']")
	public WebElement btnCorreo;



	
	
	
	
	

}
