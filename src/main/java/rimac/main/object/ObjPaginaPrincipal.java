package rimac.main.object;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.ObjPaginaPrincipal;
import rimac.main.util.BaseDriver;

public class ObjPaginaPrincipal extends BaseDriver{
	
	// singleton
	private static ObjPaginaPrincipal obj = null;

	private ObjPaginaPrincipal() {
	}

	public static ObjPaginaPrincipal getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjPaginaPrincipal();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	@AndroidFindBy(xpath = "//*[@text='Trámites']")
	public WebElement btnTramite;
	
	//*[@index='3']
	//*[contains(text(),'Reembolso')]
	//*[@text='Reembolso de salud']//preceding::*[1]
	@AndroidFindBy(xpath = "//*[@text='Reembolso de salud']//ancestor::*[1]")
	public WebElement btnReembolsoSalud;

	
	@AndroidFindBy(id = "com.rimac.rimac_surrogas:id/bottom_nav_home")
	public WebElement btnHome;
	
	
	@AndroidFindBy(id = "com.rimac.rimac_surrogas:id/bottom_nav_insurance")
	public WebElement btnSeguros;
	
		

	
}
