package rimac.main.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

import org.openqa.selenium.By;
import rimac.main.object.ConfirmarDatosReembolsoSaludObject;
import rimac.main.screen.BaseScreen;

public class ConfirmarDatosReembolsoSaludObject extends BaseScreen{
	
	// singleton
	private static ConfirmarDatosReembolsoSaludObject obj = null;

	private ConfirmarDatosReembolsoSaludObject() {
	}

	public static ConfirmarDatosReembolsoSaludObject getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ConfirmarDatosReembolsoSaludObject();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	
	
	@AndroidFindBy(xpath = "//*[@text='DNI del titular']")
	public WebElement lblDni;
	
	//*[@class='android.widget.EditText' and ./parent::*[./parent::*[@id='uiEditDepartment']]]
//	@AndroidFindBy(xpath = "//*[@text='Departamento']")
	@AndroidFindBy(xpath = "//*[@id='uiEditDepartment']")
	public WebElement selDepartamento;
	
	
//	@AndroidFindBy(xpath = "//*[@text='Provincia']")
	@AndroidFindBy(xpath = "//*[@id='uiEditProvince']")
	public WebElement selProvincia;
	
	@AndroidFindBy(xpath = "//*[@id='uiEditDistrict']")
	public WebElement selDistrito;
	
	
//	@AndroidFindBy(xpath = "//*[@id='uiEditAddress']")
	@AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and ./parent::*[./parent::*[@id='uiEditAddress']]]")
	public WebElement selDireccion;
	
	public WebElement departamento(WebDriver webDriver, String departamento) {
		By by = By.xpath("//*[@text='"+departamento+"']");
		WebElement diaAtencion = webDriver.findElement(by);
		return diaAtencion;
	}
	
	public WebElement provincia(WebDriver webDriver, String provincia) {
		By by = By.xpath("//*[@text='"+provincia+"']");
		WebElement diaAtencion = webDriver.findElement(by);
		return diaAtencion;
	}
	
	public WebElement distrito(WebDriver webDriver, String distrito) {
		By by = By.xpath("//*[@text='"+distrito+"']");
		WebElement diaAtencion = webDriver.findElement(by);
		return diaAtencion;
	}
	
	public WebElement direccion() {
		List<WebElement> links = appiumDriver().findElements(By.xpath("//*[@text='Dirección']"));
		
		return links.get(1);
	}
	
	
		
	@AndroidFindBy(xpath = "//*[@text='Continuar']")
	public WebElement btnContinuar;
	
	

	
	
}
