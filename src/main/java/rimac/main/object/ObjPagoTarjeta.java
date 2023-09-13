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

    @AndroidFindBy(id = "txtAddPaymentListCard")
    public WebElement btnAgregaTarjeta;

    @AndroidFindBy(id = "account_verify_edit_document")
    public WebElement lblDni;

    @AndroidFindBy(xpath = "//*[@resource-id= 'puTextInputEmail']//following-sibling::android.widget.EditText")
    public WebElement lblCorreo;

    @AndroidFindBy(xpath = "//*[@resource-id= 'puTextInputPhone']//following-sibling::android.widget.EditText")
    public WebElement lblCelular;

    @AndroidFindBy(id = "button")
    public WebElement btnContinuar;

    @AndroidFindBy(id = "materialBtn")
    public WebElement btnPagar;

    @AndroidFindBy(xpath = "//*[@resource-id= 'inputCvv']//following-sibling::android.widget.EditText")
    public WebElement lblCvv;

    @AndroidFindBy(id = "txtTitlePaymentListCard")
    public WebElement lblPagaInstante;

    @AndroidFindBy(id = "congratsTitle")
    public WebElement lblCompraSoatExito; //¡Listo! Estamos por enviar tu SOAT

    @AndroidFindBy(id = "materialBtn")
    public WebElement btnFinalizar;

}
