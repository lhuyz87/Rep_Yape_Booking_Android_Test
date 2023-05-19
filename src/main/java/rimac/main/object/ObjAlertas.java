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
	

	@AndroidFindBy(id ="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	public WebElement btnAppEnUso;
	
	@AndroidFindBy(xpath = "//*[@text='SOLO ESTA VEZ']")
	public WebElement btnSoloUnaVez;
	
	@AndroidFindBy(id ="com.android.permissioncontroller:id/permission_allow_button")
	public WebElement btnPermitir;
	
	@AndroidFindBy(id ="com.rimac.rimac_surrogas.qa:id/materialBtn")
	public WebElement btnRealizarInspeccion;
	
	@AndroidFindBy(id ="com.rimac.rimac_surrogas.qa:id/dialog_close")
	public WebElement btnCerrarRealizarInspeccion;
	
	@AndroidFindBy(id ="com.rimac.rimac_surrogas.qa:id/dialogClose")
	public WebElement btnCerrarVehicularVencer;
	
	
	@AndroidFindBy(id ="com.rimac.rimac_surrogas.qa:id/btn_not_yet")
	public WebElement btnEnteratePorAhoraNo;
	@AndroidFindBy(xpath ="//*[@text='Por ahora no']")
	public WebElement btnEnteratePorAhoraNo2;
	
	@AndroidFindBy(id ="com.rimac.rimac_surrogas.qa:id/registerTextNotYet")
	public WebElement btnHuellaPorAhoraNo;
	
	@AndroidFindBy(id ="com.rimac.rimac_surrogas.qa:id/dialog_btn_negative")
	public WebElement btnActualLuego;

	@AndroidFindBy(id ="com.rimac.rimac_surrogas.qa:id/materialBtn")
	public WebElement btnEntendidoError;

	@AndroidFindBy(xpath="//*[@text='Activa tu seguro vehicular hoy']//preceding-sibling::android.widget.ImageButton[@content-desc='Cerrar modal']")
	public WebElement btnCerrarModalInspeccion;

	@AndroidFindBy(xpath="//*[@text='Ocurrió un error']//preceding-sibling::android.widget.ImageButton[@content-desc='Cerrar modal']")
	public WebElement btnCerrarModalError;

	@AndroidFindBy(xpath ="//*[@text='Ya tienes un servicio en proceso']")
	public WebElement mdlServicioEnProceso;

	@AndroidFindBy(id ="com.rimac.rimac_surrogas.qa:id/imgCloseEmail")
	public WebElement btnCerrarEmail;
	@AndroidFindBy(id ="bottom_sheet_negative_button")
	public WebElement btnTalvezMasTarde;


}
