package rimac.main.object;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.TramitesObject;
import rimac.main.screen.BaseScreen;

public class TramitesObject extends BaseScreen{
	
	// singleton
	private static TramitesObject obj = null;

	private TramitesObject() {
	}

	public static TramitesObject getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new TramitesObject();
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
