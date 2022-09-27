package rimac.main.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import rimac.main.object.IniciarReembolsoSaludObject;
import rimac.main.screen.BaseScreen;

public class IniciarReembolsoSaludObject extends BaseScreen{
	
	// singleton
	private static IniciarReembolsoSaludObject obj = null;

	private IniciarReembolsoSaludObject() {
	}

	public static IniciarReembolsoSaludObject getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new IniciarReembolsoSaludObject();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	
	@AndroidFindBy(xpath = "//[contains(text(),'Antes de iniciar')]")
	public WebElement lblIniciarReembolso;
	
	
	@AndroidFindBy(xpath = "//*[@text='Empezar reembolso']")
	public WebElement btnEmpezarReembolso;
	
	
	@AndroidFindBy(xpath = "//*[@text='Descargar']")
	public WebElement btnDescargarRequisitos;
	
	
	
	
}
