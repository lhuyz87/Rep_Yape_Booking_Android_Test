package rimac.main.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.ObjDirectorio;
import rimac.main.util.BaseDriver;

public class ObjDirectorio extends BaseDriver{
	
	// singleton
	private static ObjDirectorio obj = null;

	private ObjDirectorio() {
	}

	public static ObjDirectorio getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjDirectorio();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	@AndroidFindBy(xpath = "//*[@text='Prueba.pdf']")
	public WebElement lblArchivo;
	
	public WebElement nombreArchivo(WebDriver webDriver, String nombre) {
//		By by = By.xpath("//[contains(text(),'Prueba')]");
		By by = By.xpath("//*[@text='"+nombre+"']");
		WebElement nombreArchivo = webDriver.findElement(by);
		System.out.println("Nombre Archivo :" + nombreArchivo.getText());
		return nombreArchivo;
	}
	
	public WebElement nombreArchivo2(WebDriver webDriver, String nombre) {
		By by = By.xpath("//[contains(text(),'"+nombre+"')]");
//		By by = By.xpath("//*[@text='"+nombre+"']");
		WebElement nombreArchivo = webDriver.findElement(by);
		System.out.println("***" + nombreArchivo.getText());
		return nombreArchivo;
	}
}
