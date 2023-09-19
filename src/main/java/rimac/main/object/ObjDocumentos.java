package rimac.main.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.ObjDocumentos;
import rimac.main.util.BaseDriver;

public class ObjDocumentos extends BaseDriver{
	
	// singleton
	private static ObjDocumentos obj = null;

	private ObjDocumentos() {
	}

	public static ObjDocumentos getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjDocumentos();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	
	@AndroidFindBy(xpath = "//*[@text='Factura']")
	public WebElement lblFactura;
	
	
	@AndroidFindBy(xpath = "//*[@text='Receta médica']")
	public WebElement lblRecetaMedica;
	
	public WebElement getTipoDocumento(WebDriver driver, String  tipoDocumento){
		By by = By.xpath("//*[@text='"+tipoDocumento+"']");
		WebElement elementoTipoDoc = driver.findElement(by);
		return elementoTipoDoc;
	}
	
}
