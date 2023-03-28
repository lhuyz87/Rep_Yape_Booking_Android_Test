package rimac.main.object;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjPagoTarjeta extends BaseDriver {

    private static ObjPagoTarjeta obj = null;

    private ObjPagoTarjeta() {
    }

    public static ObjPagoTarjeta getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjPagoTarjeta();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/txtAddPaymentListCard")
    public WebElement btnAgregaTarjeta;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/account_verify_edit_document")
    public WebElement lblDni;

    @AndroidFindBy(xpath = "//*[@resource-id= 'com.rimac.rimac_surrogas.qa:id/puTextInputEmail']//following-sibling::android.widget.EditText")
    public WebElement lblCorreo;

    @AndroidFindBy(xpath = "//*[@resource-id= 'com.rimac.rimac_surrogas.qa:id/puTextInputPhone']//following-sibling::android.widget.EditText")
    public WebElement lblCelular;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/button")
    public WebElement btnContinuar;

    @AndroidFindBy(xpath = "//*[@resource-id= 'com.rimac.rimac_surrogas.qa:id/inputCardNumber']//following-sibling::android.widget.EditText")
    public WebElement lblTarjeta;

    @AndroidFindBy(xpath = "//*[@resource-id= 'com.rimac.rimac_surrogas.qa:id/inputCardFirstName']//following-sibling::android.widget.EditText")
    public WebElement lblNombre;

    @AndroidFindBy(xpath = "//*[@resource-id= 'com.rimac.rimac_surrogas.qa:id/inputCardLastName']//following-sibling::android.widget.EditText")
    public WebElement lblApellido;

    @AndroidFindBy(xpath = "//*[@resource-id= 'com.rimac.rimac_surrogas.qa:id/inputCardDate']//following-sibling::android.widget.EditText")
    public WebElement lblMesAnio;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/button")
    public WebElement btnPagar;

    @AndroidFindBy(xpath = "//*[@resource-id= 'com.rimac.rimac_surrogas.qa:id/inputCvv']//following-sibling::android.widget.EditText")
    public WebElement lblCvv;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/txtTitlePaymentListCard")
    public WebElement lblPagaInstante;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/congratsTitle")
    public WebElement lblCompraSoatExito; //¡Listo! Estamos por enviar tu SOAT

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/button")
    public WebElement btnFinalizar;

}
