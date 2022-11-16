package rimac.main.object;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.ObjTramites;
import rimac.main.util.BaseDriver;

public class ObjTramites extends BaseDriver{
	
	// singleton
	private static ObjTramites obj = null;

	private ObjTramites() {
	}

	public static ObjTramites getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjTramites();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	@AndroidFindBy(xpath = "//*[@text='Reembolso de salud']")
	public WebElement btnReembolsoSalud;
	

	@AndroidFindBy(xpath = "//*[@text='Todos']")
	public WebElement btnTodos;
	
	
	
}
