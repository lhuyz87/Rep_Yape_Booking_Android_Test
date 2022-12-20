package rimac.main.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

import org.openqa.selenium.By;
import rimac.main.object.ObjConfirmarDatosReembolsoSalud;
import rimac.main.util.BaseDriver;

public class ObjConfirmarDatosReembolsoSalud extends BaseDriver{
	
	// singleton
	private static ObjConfirmarDatosReembolsoSalud obj = null;

	private ObjConfirmarDatosReembolsoSalud() {
	}

	public static ObjConfirmarDatosReembolsoSalud getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjConfirmarDatosReembolsoSalud();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	
	
	@AndroidFindBy(xpath = "//*[@text='DNI del titular']")
	public WebElement lblDni;
	//*[@text='Dirección']/following :: *[3]
	//*[@class='android.widget.FrameLayout' and ./parent::*[@id='uiEditDepartment'] and ./*[@text]]
//	@AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and ./parent::*[./parent::*[@id='uiEditDepartment']]]") 
	
	
	
	@AndroidFindBy(id ="com.rimac.rimac_surrogas.qa:id/uiEditDepartment")
	public WebElement selDepartamento;
	
	
	public WebElement getDepartamento(WebDriver webDriver) {
		By by = By.xpath("//*[@class='android.widget.EditText' and ./parent::*[./parent::*[@id='uiEditDepartment']]]");
		WebElement elementDepar = webDriver.findElement(by);
		return elementDepar;
	}

	@AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/uiEditProvince")
	public WebElement selProvincia;
	
	@AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/uiEditDistrict")
	public WebElement selDistrito;
	
	

//	@AndroidFindBy(id = "com.rimac.rimac_surrogas:id/uiEditDistrict")
//	public WebElement selDireccion;
//	
	
	
	
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
	
	
	@AndroidFindBy(xpath = "//*[@text='Departamento']")
	public WebElement txtDepartamento;
	
	
}
