package rimac.main.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import rimac.main.object.ObjReemDocCobertMedica;
import rimac.main.util.BaseDriver;

public class ObjReemDocCobertMedica extends BaseDriver{
	
	// singleton
	private static ObjReemDocCobertMedica obj = null;

	private ObjReemDocCobertMedica() {
	}

	public static ObjReemDocCobertMedica getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjReemDocCobertMedica();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	

	@AndroidFindBy(xpath = "//*[@text='Adjunta fotos o archivos']")
	public WebElement selFotosArchivos;
	
	@AndroidFindBy(xpath = "//*[@text='Adjuntar documento']")
	public WebElement selAdjuntarAtchivo;
	
	@AndroidFindBy(xpath = "//*[@text='Tomar una foto']")
	public WebElement selTomarFoto;

	@AndroidFindBy(xpath = "//*[@text='Continuar']")
	public WebElement btnContinuar;

	@AndroidFindBy(xpath = "//*[@text='Camera']")
	public WebElement opcCamara;

	/*@AndroidFindBy(xpath = "//*[@text='Cámara']")
	public WebElement btnCamara;*/

	@AndroidFindBy(id = "com.sec.android.app.camera:id/bottom_background")
	public WebElement btnCapturarSamsung;

	@AndroidFindBy(id = "com.huawei.camera:id/foot_black_background")
	public WebElement btnCapturarHuawei;

	@AndroidFindBy(id = "com.huawei.camera:id/done_button")
	public WebElement btnAceptarFoto;

	//com.rimac.rimac_surrogas.qa:id/uploadClose
	//com.huawei.camera:id/done_button
	//com.huawei.camera:id/head_black_background

//com.rimac.rimac_surrogas.qa:id/tbProgress
	//com.sec.android.app.camera:id/camera_preview
	//com.huawei.camera:id/foot_black_background
	//com.huawei.camera:id/foot_black_background

	@AndroidFindBy(id = "//*[@text='Ok']")
	public WebElement btnAceptar;
	
	

	
	
}
