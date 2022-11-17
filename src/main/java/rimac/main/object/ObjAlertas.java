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
	
	@AndroidFindBy(id ="com.rimac.rimac_surrogas:id/materialBtn")
	public WebElement btnRealizarInspeccion;
	
	@AndroidFindBy(id ="com.rimac.rimac_surrogas:id/dialog_close")
	public WebElement btnCerrarRealizarInspeccion;
	
	@AndroidFindBy(id ="com.rimac.rimac_surrogas:id/dialogClose")
	public WebElement btnCerrarVehicularVencer;
	
	
	@AndroidFindBy(id ="com.rimac.rimac_surrogas:id/btn_not_yet")
	public WebElement btnEnteratePorAhoraNo;
	
	@AndroidFindBy(id ="com.rimac.rimac_surrogas:id/registerTextNotYet")
	public WebElement btnHuellaPorAhoraNo;
	
	@AndroidFindBy(id ="com.rimac.rimac_surrogas:id/dialog_btn_negative")
	public WebElement btnActualLuego;
	
	
	
	
	

	
	
	
	
}