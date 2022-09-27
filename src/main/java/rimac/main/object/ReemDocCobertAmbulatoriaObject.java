package rimac.main.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import rimac.main.object.ReemDocCobertAmbulatoriaObject;
import rimac.main.screen.BaseScreen;

public class ReemDocCobertAmbulatoriaObject extends BaseScreen{
	
	// singleton
	private static ReemDocCobertAmbulatoriaObject obj = null;

	private ReemDocCobertAmbulatoriaObject() {
	}

	public static ReemDocCobertAmbulatoriaObject getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ReemDocCobertAmbulatoriaObject();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	

	@AndroidFindBy(xpath = "//*[@text='Adjunta fotos o archivos']")
	public WebElement selFotosArchivos;
	
	@AndroidFindBy(xpath = "//*[@text='Adjuntar documento']")
	public WebElement selAdjuntarAtchivo;
	
	@AndroidFindBy(xpath = "//*[@text='Tomar una foto']")
	public WebElement selTomarFoto;
	
	

	
	
}
