package rimac.main.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
//import net.thucydides.core.annotations.findby.By;
import rimac.main.object.ObjCuentaDeAbono;
import rimac.main.util.BaseDriver;

import java.util.List;

import org.openqa.selenium.By;

public class ObjCuentaDeAbono extends BaseDriver{
	
	// singleton
	private static ObjCuentaDeAbono obj = null;

	private ObjCuentaDeAbono() {
	}

	public static ObjCuentaDeAbono getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjCuentaDeAbono();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	@AndroidFindBy(id = "uiEditBankEntity")
	public WebElement lstEntidadBancaria;

	public WebElement getEntidadBancaria(WebDriver driver, String  entidad){
			try {
				By by = By.xpath("//*[@text='"+entidad+"']");
				WebElement elementoEntidad = driver.findElement(by);
				return elementoEntidad;
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			return null;

	}

	
	@AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/uiEditAccountType")
	public WebElement lstTipoCuenta;

	public WebElement getTipoCuenta(WebDriver driver, String  tipoCuenta){
			By by = By.xpath("//*[@text='"+tipoCuenta+"']");
			WebElement elementoTipoCuenta = driver.findElement(by);
			return elementoTipoCuenta;
	}

	@AndroidFindBy(id = "uiEditCurrencyType")
	public WebElement lstTipoMoneda;

	public WebElement getTipoMoneda(WebDriver driver, String  moneda){
			By by = By.xpath("//*[@text='"+moneda+"']");
			WebElement elementoMoneda = driver.findElement(by);
			return elementoMoneda;
	}
	
	@AndroidFindBy(xpath = "//*[@text='Número de cuenta']")
	public WebElement txtNumeroCuenta;
	
	@AndroidFindBy(xpath = "//*[@text='Entidad bancaria']")
	public WebElement txtEntBancaria;
	
	
	public WebElement elemententBancaria() {
		List<WebElement> elementEntBancaria = appiumDriver().findElements(By.xpath("//*[@text='Entidad bancaria']"));
		
		return elementEntBancaria.get(1);
	}

	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"createAccountEditEmail\"]")
	public WebElement txtCorreo;

	@AndroidFindBy(xpath = "//*[@text='Continuar']")
	public WebElement btnContinuar;
}
