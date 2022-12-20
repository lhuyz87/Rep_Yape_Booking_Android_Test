package rimac.main.object;

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
	
	
	@AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/edtSearch")
	public WebElement txtBuscarClinica;
	
	
	@AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/text_clinic_name")
	public WebElement lblClinicaEncontra;
	
	@AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/text_price")
	public WebElement lblCopago;
	
	
   
	
	
}
