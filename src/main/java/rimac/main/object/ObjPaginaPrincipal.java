package rimac.main.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.ObjPaginaPrincipal;
import rimac.main.util.BaseDriver;

public class ObjPaginaPrincipal extends BaseDriver{
	
	// singleton
	private static ObjPaginaPrincipal obj = null;

	private ObjPaginaPrincipal() {
	}

	public static ObjPaginaPrincipal getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjPaginaPrincipal();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	@AndroidFindBy(xpath = "//*[@text='Trámites']")
	public WebElement btnTramite;

	@AndroidFindBy(xpath = "//*[@text='Perfil']")
	public WebElement btnPerfil;

	@AndroidFindBy(xpath = "//*[@text='Tienda']")
	public WebElement btnTienda;

	//*[@index='3']
	//*[contains(text(),'Reembolso')]
	//*[@text='Reembolso de salud']//preceding::*[1]
	@AndroidFindBy(xpath = "//*[@text='Reembolso de salud']//ancestor::*[1]")
	public WebElement btnReembolsoSalud;
	@AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/button_see_all")
	public WebElement lnkVerTodas;

	@AndroidFindBy(xpath = "//*[@content-desc='Tus asistencias']")
	public WebElement lblTusAsistencias;

	@AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/bottom_nav_home")
	public WebElement btnHome;

	@AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/emergencyButton")
	public WebElement btnEmergencia;


	@AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/bottom_nav_insurance")
	public WebElement btnSeguros;
	
	@AndroidFindBy(xpath = "//*[@text='Buscador de salud']//ancestor::*[2]")
	public WebElement btnBuscadorClinica;

	public WebElement txtMontoReembolso(String monto) {
		WebElement we_MontoReembolso = appiumDriver().findElement(By.ByXPath.xpath("//*[@text='Gasto: S/ "+monto+"']"));
		return we_MontoReembolso;
	}
	@AndroidFindBy(xpath = "//*[@text='Conoce más']//ancestor::*[2]")
	public WebElement btnSoatHome;

	@AndroidFindBy(xpath = "//*[@text='Plan Vida Flexible']//following-sibling::android.widget.Button")
	public WebElement btnPlanVidaFlexibleHo;

}
