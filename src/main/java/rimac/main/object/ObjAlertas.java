package rimac.main.object;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.ObjAlertas;
import rimac.main.util.BaseDriver;

public class ObjAlertas extends BaseDriver{
	
	// singleton
	private static ObjAlertas obj = null;

	private ObjAlertas() {
	}

	public static ObjAlertas getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjAlertas();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	

	@AndroidFindBy(id ="permission_allow_foreground_only_button")
	public WebElement btnAppEnUso;

	@AndroidFindBy(id ="btn_not_yet")
	public WebElement btnEnteratePorAhoraNo;
	
	@AndroidFindBy(id ="registerTextNotYet")
	public WebElement btnHuellaPorAhoraNo;
	@AndroidFindBy(id ="dialog_btn_negative")
	public WebElement btnActualLuego;
	@AndroidFindBy(id ="materialBtn")
	public WebElement btnEntendidoError;

	@AndroidFindBy(xpath="//*[@text='Activa tu seguro vehicular hoy']//preceding-sibling::android.widget.ImageButton[@content-desc='Cerrar modal']")
	public WebElement btnCerrarModalInspeccion;

	@AndroidFindBy(xpath="//*[@text='Ocurrió un error']//preceding-sibling::android.widget.ImageButton[@content-desc='Cerrar modal']")
	public WebElement btnCerrarModalError;

	@AndroidFindBy(xpath="//*[@text='Estar Bien']//preceding-sibling::android.widget.ImageButton[ends-with(@resource-id,'dialog_close')]")
	public WebElement btnCerrarModalEstarBien;

	@AndroidFindBy(xpath ="//*[@text='Ya tienes un servicio en proceso']")
	public WebElement mdlServicioEnProceso;

	@AndroidFindBy(id ="imgCloseEmail")
	public WebElement btnCerrarEmail;
	@AndroidFindBy(id ="bottom_sheet_negative_button")
	public WebElement btnTalvezMasTarde;


}
