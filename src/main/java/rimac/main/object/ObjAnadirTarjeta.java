package rimac.main.object;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjAnadirTarjeta extends BaseDriver {

    private static ObjAnadirTarjeta  obj = null;

    private ObjAnadirTarjeta () {
    }

    public static ObjAnadirTarjeta getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjAnadirTarjeta();
        }
    }

    @AndroidFindBy(xpath = "//*[ends-with(@resource-id,'editCfNumberCard')]//following-sibling::android.widget.EditText")
    public WebElement lblNumTarjeta;

    @AndroidFindBy(xpath = "//*[ends-with(@resource-id,'editCfNameHolder')]//following-sibling::android.widget.EditText")
    public WebElement lblNombre;

    @AndroidFindBy(xpath = "//*[ends-with(@resource-id,'editCfLastNameHolder')]//following-sibling::android.widget.EditText")
    public WebElement lblApellido;

    @AndroidFindBy(xpath = "//*[ends-with(@resource-id,'editCfDateCard')]//following-sibling::android.widget.EditText")
    public WebElement lblMMAA;

    @AndroidFindBy(xpath = "//*[ends-with(@resource-id,'editCfCvvCard')]//following-sibling::android.widget.EditText")
    public WebElement lblCVV;

    @AndroidFindBy(xpath = "//*[ends-with(@resource-id,'editCfEmailHolder')]//following-sibling::android.widget.EditText")
    public WebElement lblCorreo;

    @AndroidFindBy(id = "materialBtn")
    public WebElement btnAfiliarTarjeta;

    @AndroidFindBy(id = "cbCfSaveCard")
    public WebElement chkGuardarTarjeta;

    @AndroidFindBy(id = "materialBtn")
    public WebElement btnGuardarTarjetanew;

    @AndroidFindBy(id = "materialBtn")
    public WebElement btnPagarNew;
    @AndroidFindBy(id = "switchSw")
    public WebElement btnPagoAuto;

}
