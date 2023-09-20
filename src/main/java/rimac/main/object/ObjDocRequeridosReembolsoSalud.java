package rimac.main.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import rimac.main.object.ObjDocRequeridosReembolsoSalud;
import rimac.main.util.BaseDriver;

public class ObjDocRequeridosReembolsoSalud extends BaseDriver{
	
	// singleton
	private static ObjDocRequeridosReembolsoSalud obj = null;

	private ObjDocRequeridosReembolsoSalud() {
	}

	public static ObjDocRequeridosReembolsoSalud getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjDocRequeridosReembolsoSalud();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	@AndroidFindBy(xpath = "//*[@text='Continuar']")
	public WebElement btnContinuar;

	@AndroidFindBy(id = "documentInfoTitle")
	public WebElement lblCargaDocumentos;

	@AndroidFindBy(id = "rowRefundDocumentsTitle")
	public WebElement btnCargarFactura;

	@AndroidFindBy(xpath = "//*[@text='Receta médica']")
	public WebElement btnCargarReceta;

	@AndroidFindBy(xpath = "//*[@text='Comprobantes de pago']//following-sibling::android.view.ViewGroup")
	public WebElement btnEntendidoComprobantes;

	@AndroidFindBy(xpath = "//*[@text='Documentos sustentatorios']//following-sibling::android.view.ViewGroup")
	public WebElement btnEntendidoSustenta;

	@AndroidFindBy(xpath = "//*[@text='Solicitud de reembolso odontológico']")
	public WebElement btnCargarReembOdon;

	@AndroidFindBy(xpath = "//*[@text='Orden médica']")
	public WebElement btnOrdenMedica;

}
