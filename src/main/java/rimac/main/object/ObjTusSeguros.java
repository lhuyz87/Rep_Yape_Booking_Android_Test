package rimac.main.object;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.ObjTusSeguros;
import rimac.main.util.BaseDriver;

public class ObjTusSeguros extends BaseDriver{
	
	// singleton
	private static ObjTusSeguros obj = null;

	private ObjTusSeguros() {
	}

	public static ObjTusSeguros getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjTusSeguros();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	@AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/btnText")
	public WebElement btnDetalleSeguro;

	public WebElement opcSeguro(String seguro) {
		WebElement we_opcSeguro = appiumDriver().findElement(AppiumBy.xpath("//*[@text='"+seguro+"'][1]//parent::android.widget.LinearLayout//following-sibling::android.widget.Button[@text='Ver detalle']"));
		return we_opcSeguro;
	}

	public WebElement tipoSeguro(String seguro) {
		WebElement we_tipoSeguro = appiumDriver().findElement(AppiumBy.xpath("//*[@text='"+seguro+"']"));
		return we_tipoSeguro;
	}

	@AndroidFindBy(xpath = "//*[@text='Tus seguros']")
	public WebElement lblTusSeguros;
	
}
