package rimac.main.object;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.ObjValidaIdentid;
import rimac.main.util.BaseDriver;

public class ObjValidaIdentid extends BaseDriver{
	
	// singleton
	private static ObjValidaIdentid obj = null;

	private ObjValidaIdentid() {
	}

	public static ObjValidaIdentid getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjValidaIdentid();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	
	
	@AndroidFindBy(id = "com.rimac.rimac_surrogas:id/dropdownEditText")
	public WebElement nroDocume;
	

	@AndroidFindBy(id = "com.rimac.rimac_surrogas:id/dropdownAutoCompleteText")
	public WebElement btnTipoDoc;
	
	@AndroidFindBy(id = "com.rimac.rimac_surrogas:id/materialBtn")
	public WebElement btnContinu;	

	
}
