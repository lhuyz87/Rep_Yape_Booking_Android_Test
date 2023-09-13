package rimac.main.object;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.ObjConsultaReembolso;
import rimac.main.util.BaseDriver;

public class ObjConsultaReembolso extends BaseDriver{
	
	// singleton
	private static ObjConsultaReembolso obj = null;

	private ObjConsultaReembolso() {
	}

	public static ObjConsultaReembolso getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjConsultaReembolso();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	@AndroidFindBy(id = "tvFilters")
	public WebElement btnFiltro;
	
	@AndroidFindBy(xpath = "//*[@resource-id='refundSpendingPEN']")
	public List<WebElement> lblMontoReembolso;

}
