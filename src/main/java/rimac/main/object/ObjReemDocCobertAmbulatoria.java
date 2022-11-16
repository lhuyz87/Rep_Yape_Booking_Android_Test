package rimac.main.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import rimac.main.object.ObjReemDocCobertAmbulatoria;
import rimac.main.util.BaseDriver;

public class ObjReemDocCobertAmbulatoria extends BaseDriver{
	
	// singleton
	private static ObjReemDocCobertAmbulatoria obj = null;

	private ObjReemDocCobertAmbulatoria() {
	}

	public static ObjReemDocCobertAmbulatoria getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjReemDocCobertAmbulatoria();
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
