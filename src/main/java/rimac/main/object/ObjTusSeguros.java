package rimac.main.object;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.ObjTusSeguros;
import rimac.main.util.BaseDriver;

import java.util.List;

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
		WebElement we_opcSeguro = appiumDriver().findElement(AppiumBy.xpath("(//*[@text='"+seguro+"']//parent::android.widget.LinearLayout//following-sibling::android.widget.Button[@text='Ver detalle'])[1]"));
		return we_opcSeguro;
	}

	public WebElement tipoSeguro(String seguro) {
		WebElement we_tipoSeguro = appiumDriver().findElement(AppiumBy.xpath("//*[@text='"+seguro+"']"));
		return we_tipoSeguro;
	}

	@AndroidFindBy(xpath = "//*[@text='Tus seguros']")
	public WebElement lblTusSeguros;

	@AndroidFindBy(xpath = "//android.widget.CompoundButton[@text='Todos']")
	public WebElement btnTodos;

	@AndroidFindBy(xpath = "//android.widget.CompoundButton[@text='SOAT']")
	public WebElement btnSOAT;

	@AndroidFindBy(xpath = "//android.widget.CompoundButton[@text='Vehicular']")
	public WebElement btnVehicular;

	@AndroidFindBy(xpath = "//*[@text='Entendido']")
	public WebElement btnEntendido;
	@AndroidFindBy(xpath = "//android.widget.CompoundButton[@text='Salud']")
	public WebElement btnSalud;
	@AndroidFindBy(xpath = "//android.widget.CompoundButton[@text='Vida']")
	public WebElement btnVida;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Pagos\"]")
	public WebElement btnPagos;

	@AndroidFindBy(xpath = "//*[@text='Seguro Vehicular']")
	public WebElement titSeguroVehicular;

	public WebElement btnPlacaSeg2(String placa) {
		WebElement we_tnPlacaSeg = appiumDriver().findElement(AppiumBy.xpath("//*[@text='Placa: "+placa+"']"));
		return we_tnPlacaSeg;
	}

	public WebElement btnPlacaSeg(String placa) {

		String matriculaLetras=placa.substring(0,3);
		String matriculaNumeros=placa.substring(3,6);

		WebElement we_tnPlacaSeg = appiumDriver().findElement(AppiumBy.xpath("//*[@text='Placa: "+matriculaLetras+"-"+matriculaNumeros+"']"));
		return we_tnPlacaSeg;
	}

	@AndroidFindBy(xpath = "//*[@text='Ver detalle']")
	public WebElement btnVerDetallePlaca;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Retroceder\"]")
	public WebElement tbSeguroVehicular;

	public WebElement verDetalleXPlaca(String placa) {
		WebElement  we_tnPlacaSeg = appiumDriver().findElement(AppiumBy.xpath("(//*[@text='Placa: "+placa+"']//parent::*//following-sibling::*)[3]"));
		return we_tnPlacaSeg;
	}
	public List<WebElement> verDetalleXPlaca2(String placa) {
		List<WebElement>  we_tnPlacaSeg = appiumDriver().findElements(AppiumBy.xpath("(//*[@text='Placa: "+placa+"']//parent::*//following-sibling::*)[3]"));
		return we_tnPlacaSeg;
	}
}
