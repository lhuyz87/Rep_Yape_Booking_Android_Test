package rimac.main.object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.ObjPregunDeVerifi;
import rimac.main.util.BaseDriver;

public class ObjPregunDeVerifi extends BaseDriver{
	
	// singleton
	private static ObjPregunDeVerifi obj = null;

	private ObjPregunDeVerifi() {
	}

	public static ObjPregunDeVerifi getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjPregunDeVerifi();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	

	
	
	@AndroidFindBy(id = "com.rimac.rimac_surrogas:id/glyphIv")
	public WebElement btnCalend;
	
	@AndroidFindBy(id = "android:id/date_picker_header_year")
	public WebElement btnAnio;
	
	@AndroidFindBy(id = "com.rimac.rimac_surrogas:id/glyphIv")
	public WebElement btnMes;
	
	
	@AndroidFindBy(id = "android:id/button1")
	public WebElement btnAcepta;
	

	@AndroidFindBy(xpath = "//*[@resource-id='android:id/text1']")
	public List<WebElement> btnAnioNac;
	
	
	@AndroidFindBy(id = "android:id/prev")
	public WebElement btnMesPrevio;

	@AndroidFindBy(id = "android:id/next")
	public WebElement btnMesSig;
	
	@AndroidFindBy(id = "com.rimac.rimac_surrogas:id/materialBtn")
	public WebElement btnContinu;
	
	public WebElement selAnio(WebDriver webDriver, String anio) {
		By by = By.xpath("//*[@text='"+anio+"']");
		WebElement diaAtencion = webDriver.findElement(by);
		return diaAtencion;
	}
	
	
	public WebElement selDia(WebDriver webDriver, String dia) {
		By by = By.xpath("//*[@text='"+dia+"']");
		WebElement diaAtencion = webDriver.findElement(by);
		return diaAtencion;
	}

	public WebElement btnSeguroDomici(){
		WebElement we_SeguroDomici = appiumDriver().findElement(ByXPath.xpath("//*[@text='Domiciliario']//ancestor::*[1]"));
		return we_SeguroDomici;
	};
	
	public WebElement btnSeguroSaludEPS(){
		WebElement we_SeguroSaludEPS = appiumDriver().findElement(ByXPath.xpath("//*[@text='Salud / EPS']//ancestor::*[1]"));
		return we_SeguroSaludEPS;
	};
	
	public WebElement btnSeguroVehicu(){
		WebElement we_SeguroVehicu = appiumDriver().findElement(ByXPath.xpath("//*[@text='Vehicular']//ancestor::*[1]"));
		return we_SeguroVehicu;
	};
	
	public WebElement btnSeguroVida(){
		WebElement we_SeguroVida = appiumDriver().findElement(ByXPath.xpath("//*[@text='Vida']//ancestor::*[1]"));
		return we_SeguroVida;
	};
	
	public WebElement btnSeguroSOAT(){
		WebElement we_SeguroSOAT = appiumDriver().findElement(ByXPath.xpath("//*[@text='SOAT']//ancestor::*[1]"));
		return we_SeguroSOAT;
	};
	
	public WebElement btnSeguroOtros(){
		WebElement we_SeguroOtros = appiumDriver().findElement(ByXPath.xpath("//*[@text='Otros']//ancestor::*[1]"));
		return we_SeguroOtros;
	};
	
	

	
}
