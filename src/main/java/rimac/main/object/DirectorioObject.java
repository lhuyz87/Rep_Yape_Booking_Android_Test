package rimac.main.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.DirectorioObject;
import rimac.main.screen.BaseScreen;

public class DirectorioObject extends BaseScreen{
	
	// singleton
	private static DirectorioObject obj = null;

	private DirectorioObject() {
	}

	public static DirectorioObject getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new DirectorioObject();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	@AndroidFindBy(xpath = "//*[@text='Prueba.pdf']")
	public WebElement lblArchivo;
	
	public WebElement nombreArchivo(WebDriver webDriver, String nombre) {
		By by = By.xpath("//*[@text='"+nombre+"']");
		WebElement nombreArchivo = webDriver.findElement(by);
		System.out.println("***" + nombreArchivo.getText());
		return nombreArchivo;
	}
}
