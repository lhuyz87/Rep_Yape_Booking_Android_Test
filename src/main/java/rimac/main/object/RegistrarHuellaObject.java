package rimac.main.object;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.RegistrarHuellaObject;
import rimac.main.screen.BaseScreen;

public class RegistrarHuellaObject extends BaseScreen{
	
	// singleton
	private static RegistrarHuellaObject obj = null;

	private RegistrarHuellaObject() {
	}

	public static RegistrarHuellaObject getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new RegistrarHuellaObject();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	@AndroidFindBy(xpath = "//*[@text='Por ahora no']")
	public WebElement btnPorAhoraNo;
	

	
	
}
