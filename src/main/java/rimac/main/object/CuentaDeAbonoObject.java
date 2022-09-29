package rimac.main.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
//import net.thucydides.core.annotations.findby.By;
import rimac.main.object.CuentaDeAbonoObject;
import org.openqa.selenium.By;
import rimac.main.screen.BaseScreen;

public class CuentaDeAbonoObject extends BaseScreen{
	
	// singleton
	private static CuentaDeAbonoObject obj = null;

	private CuentaDeAbonoObject() {
	}

	public static CuentaDeAbonoObject getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new CuentaDeAbonoObject();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	@AndroidFindBy(xpath = "//*[@text='Entidad bancaria']")
	public WebElement lstEntidadBancaria;
	

	//Interbank, BBVA, Scotiabank, Scotiabank
	public WebElement getEntidadBancaria(WebDriver driver, String  entidad){
			By by = By.xpath("//*[@text='"+entidad+"']");
			WebElement elementoEntidad = driver.findElement(by);
			return elementoEntidad;
	}
	
	
	@AndroidFindBy(xpath = "//*[@text='Tipo de cuenta']")
	public WebElement lstTipoCuenta;
	

	//Cuenta de ahorros,Cuenta corriente,Cuenta maestra
	public WebElement getTipoCuenta(WebDriver driver, String  tipoCuenta){
			By by = By.xpath("//*[@text='"+tipoCuenta+"']");
			WebElement elementoTipoCuenta = driver.findElement(by);
			return elementoTipoCuenta;
	}
	

	@AndroidFindBy(xpath = "//*[@text='Tipo de moneda']")
	public WebElement lstTipoMoneda;
	

	//Soles (S/),Dólares ($)
	public WebElement getTipoMoneda(WebDriver driver, String  moneda){
			By by = By.xpath("//*[@text='"+moneda+"']");
			WebElement elementoMoneda = driver.findElement(by);
			return elementoMoneda;
	}
	
	@AndroidFindBy(xpath = "//*[@text='Número de cuenta']")
	public WebElement txtNumeroCuenta;
	
	@AndroidFindBy(xpath = "//*[@text='Correo electrónico']")
	public WebElement txtCorreo;
	
	
	
	@AndroidFindBy(xpath = "//*[@text='Continuar']")
	public WebElement btnContinuar;
	

	
	
	
}
