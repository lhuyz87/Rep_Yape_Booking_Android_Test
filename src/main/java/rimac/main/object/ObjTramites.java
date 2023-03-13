package rimac.main.object;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.ObjTramites;
import rimac.main.util.BaseDriver;

public class ObjTramites extends BaseDriver{
	
	// singleton
	private static ObjTramites obj = null;

	private ObjTramites() {
	}

	public static ObjTramites getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjTramites();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	@AndroidFindBy(xpath = "//*[@text='Reembolso de salud']//parent::android.view.ViewGroup//following-sibling::android.widget.ImageView")
	public WebElement btnReembolsoSalud;

	@AndroidFindBy(xpath = "//*[@text='Reembolso de salud']")
	public WebElement opcReembolsoSalud;

	@AndroidFindBy(xpath = "//*[@text='Todos']")
	public WebElement btnTodos;
	
	
	@AndroidFindBy(xpath = "//*[@text='Buscador de salud']")
	public WebElement btnBuscarClinica;
	
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Seguimiento\"]")
	public WebElement btnSeguimiento;
	
		
	@AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/cardIconTitle")
	public WebElement btnSegReemSalud;

	@AndroidFindBy(xpath = "//*[@text='Asistencias vehiculares']//parent::android.view.ViewGroup//following-sibling::android.widget.ImageView")
	public WebElement btnAsisVehiculares;

	@AndroidFindBy(xpath = "//*[@text='Asistencias vehiculares']")
	public WebElement opcAsisVehiculares;

	@AndroidFindBy(xpath = "//*[@text='Vehicular']")
	public WebElement opcVehicular;

	@AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/processTitle")
	public WebElement lblTramites;
}
