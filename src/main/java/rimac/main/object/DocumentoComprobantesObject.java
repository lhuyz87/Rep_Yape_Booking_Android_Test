package rimac.main.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
//import net.thucydides.core.annotations.findby.By;
import rimac.main.object.DocumentoComprobantesObject;
import org.openqa.selenium.By;
import rimac.main.screen.BaseScreen;

public class DocumentoComprobantesObject extends BaseScreen{
	
	// singleton
	private static DocumentoComprobantesObject obj = null;

	private DocumentoComprobantesObject() {
	}

	public static DocumentoComprobantesObject getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new DocumentoComprobantesObject();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	@AndroidFindBy(xpath = "//*[@text='Tipo de documento']")
	public WebElement lstTipoDocumento;
	
	@AndroidFindBy(xpath = "//*[@text='Subir documento']")
	public WebElement btnSubirDocumento;	
	
	@AndroidFindBy(id = "com.rimac.rimac_surrogas:id/documentVoucherUploadTitle")
	public WebElement btnSubirComprobantes;
	
	
	@AndroidFindBy(id = "com.rimac.rimac_surrogas:id/documentUploadTitle")
	public WebElement btnSubirDocumentos;
	
	
	@AndroidFindBy(xpath = "//*[@text='Continuar']")
	public WebElement btnContinuar;	
	
	
	@AndroidFindBy(xpath = "//*[@text='Serie de documento']")
	public WebElement txtSerieDocumento;
	
	@AndroidFindBy(xpath = "//*[@text='Número de documento']")
	public WebElement txtNroDocumento;
	
	
	@AndroidFindBy(xpath = "//*[@text='Moneda']")
	public WebElement lstMoneda;
	
	public WebElement getMoneda(WebDriver driver, String  Moneda){
			By by = By.xpath("//*[@text='"+Moneda+"']");
			WebElement elementMoneda = driver.findElement(by);
			return elementMoneda;
	}
	
	@AndroidFindBy(xpath = "//*[@text='Monto']")
	public WebElement txtMonto;
	
	
	@AndroidFindBy(xpath = "//*[@text='Fecha de emisión del documento']")
	public WebElement lstFechaEmision;
	
	@AndroidFindBy(xpath = "//*[@text='ACEPTAR']")
	public WebElement btnAceptar;
	
	
	
	//Receta Médica
	
	@AndroidFindBy(xpath = "//*[@id='commentInput']")
	public WebElement txtDescipcion;
	
	
	
}
