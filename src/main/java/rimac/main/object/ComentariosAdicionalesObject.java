package rimac.main.object;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.ComentariosAdicionalesObject;
import rimac.main.screen.BaseScreen;

public class ComentariosAdicionalesObject extends BaseScreen{
	
	// singleton
	private static ComentariosAdicionalesObject obj = null;

	private ComentariosAdicionalesObject() {
	}

	public static ComentariosAdicionalesObject getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ComentariosAdicionalesObject();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	@AndroidFindBy(xpath = "//*[@id='commentInput']")
	public WebElement txtDescripcion;
	
	@AndroidFindBy(xpath = "//*[@text='Enviar solicitud']")
	public WebElement btnEnviarSolicitud;
	
	
	
}
