package rimac.main.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import rimac.main.object.DocRequeridosReembolsoSaludObject;
import rimac.main.screen.BaseScreen;

public class DocRequeridosReembolsoSaludObject extends BaseScreen{
	
	// singleton
	private static DocRequeridosReembolsoSaludObject obj = null;

	private DocRequeridosReembolsoSaludObject() {
	}

	public static DocRequeridosReembolsoSaludObject getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new DocRequeridosReembolsoSaludObject();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	

	@AndroidFindBy(xpath = "//*[@text='Continuar']")
	public WebElement btnContinuar;
	
	

	
	
}
