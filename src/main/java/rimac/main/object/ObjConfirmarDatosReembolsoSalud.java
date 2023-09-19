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

	@AndroidFindBy(id ="personalDataTitle")
	public WebElement lblDataTitle;

	@AndroidFindBy(id ="uiEditDepartment")
	public WebElement selDepartamento;

	@AndroidFindBy(id = "uiEditProvince")
	public WebElement selProvincia;
	
	@AndroidFindBy(id = "uiEditDistrict")
	public WebElement selDistrito;

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

	@AndroidFindBy(xpath = "//*[ends-with(@resource-id,'uiEditEmail')]//following-sibling::android.widget.EditText")
	public WebElement txtCorreo;

	@AndroidFindBy(xpath = "//*[ends-with(@resource-id,'uiEditCellphoneNumber')]//following-sibling::android.widget.EditText")
	public WebElement txtCelular;
	
	@AndroidFindBy(xpath = "//*[@text='Departamento']")
	public WebElement txtDepartamento;
	
	
}
