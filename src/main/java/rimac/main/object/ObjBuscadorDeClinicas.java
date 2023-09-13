package rimac.main.object;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.ObjBuscadorDeClinicas;
import rimac.main.util.BaseDriver;

public class ObjBuscadorDeClinicas extends BaseDriver{
	
	// singleton
	private static ObjBuscadorDeClinicas obj = null;

	private ObjBuscadorDeClinicas() {
	}

	public static ObjBuscadorDeClinicas getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjBuscadorDeClinicas();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	
	@AndroidFindBy(id = "edtSearch")
	public WebElement txtBuscarClinica;
	
	
	@AndroidFindBy(id = "text_clinic_name")
	public WebElement lblClinicaEncontra;


	public WebElement lblCopago() {
		WebElement we_opcProblema1 = appiumDriver().findElement(AppiumBy.xpath("//*[ends-with(@resource-id,'container')][1]/android.widget.TextView[1]"));
		return we_opcProblema1;
	}

	@AndroidFindBy(id = "text_step_title")
	public WebElement lblAntesdeComenzar;

	@AndroidFindBy(id = "input_patient")
	public WebElement cmbPaciente;

	@AndroidFindBy(xpath = "//*[ends-with(@resource-id,'bottom_sheet_group_insures')]/android.widget.RadioButton[1]")
	public WebElement rdbPaciente;

	@AndroidFindBy(id = "materialBtn")
	public WebElement btnContinuar;
	@AndroidFindBy(xpath ="//*[@text='Entendido']")
	public WebElement btnEntendidoLeerDoc;
}
