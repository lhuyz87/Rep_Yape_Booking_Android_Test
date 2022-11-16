package rimac.main.object;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.ObjTusSeguros;
import rimac.main.util.BaseDriver;

public class ObjTusSeguros extends BaseDriver{
	
	// singleton
	private static ObjTusSeguros obj = null;

	private ObjTusSeguros() {
	}

	public static ObjTusSeguros getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjTusSeguros();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	
	
	@AndroidFindBy(id = "com.rimac.rimac_surrogas:id/btnText")
	public WebElement btnDetalleSeguro;
	
}
