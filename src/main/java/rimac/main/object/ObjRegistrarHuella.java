package rimac.main.object;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.ObjRegistrarHuella;
import rimac.main.util.BaseDriver;

public class ObjRegistrarHuella extends BaseDriver{
	
	// singleton
	private static ObjRegistrarHuella obj = null;

	private ObjRegistrarHuella() {
	}

	public static ObjRegistrarHuella getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjRegistrarHuella();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	@AndroidFindBy(xpath = "//*[@text='Por ahora no']")
	public WebElement btnPorAhoraNo;
	

	
	
}
