package rimac.main.object;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import rimac.main.util.BaseDriver;

public class ObjNuevaContra extends BaseDriver{
	
	// singleton
	private static ObjNuevaContra obj = null;

	private ObjNuevaContra() {
	}

	public static ObjNuevaContra getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjNuevaContra();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	@AndroidFindBy(xpath = "//*[@resource-id='com.rimac.rimac_surrogas:id/forgetPasswordEditPassword']/child::*[1]/child::*[1]/child::*[1]/child::*[1]/child::*[1]")
	public WebElement txtPasswor;
	
	@AndroidFindBy(xpath = "//*[@resource-id='com.rimac.rimac_surrogas:id/forgetPasswordEditPasswordRepeat']/child::*[1]/child::*[1]/child::*[1]/child::*[1]/child::*[1]")
	public WebElement txtPassworRep;
	
	@AndroidFindBy(id = "com.rimac.rimac_surrogas:id/materialBtn")
	public WebElement btnCambiaContra;
	
}
