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

    @AndroidFindBy(xpath = "//*[@resource-id= 'com.rimac.rimac_surrogas.qa:id/editCfNumberCard']//following-sibling::android.widget.EditText")
    public WebElement lblNumTarjeta;

    @AndroidFindBy(xpath = "//*[@resource-id= 'com.rimac.rimac_surrogas.qa:id/editCfNameHolder']//following-sibling::android.widget.EditText")
    public WebElement lblNombre;

    @AndroidFindBy(xpath = "//*[@resource-id= 'com.rimac.rimac_surrogas.qa:id/editCfLastNameHolder']//following-sibling::android.widget.EditText")
    public WebElement lblApellido;

    @AndroidFindBy(xpath = "//*[@resource-id= 'com.rimac.rimac_surrogas.qa:id/editCfDateCard']//following-sibling::android.widget.EditText")
    public WebElement lblMMAA;

    @AndroidFindBy(xpath = "//*[@resource-id= 'com.rimac.rimac_surrogas.qa:id/editCfCvvCard']//following-sibling::android.widget.EditText")
    public WebElement lblCVV;

    @AndroidFindBy(xpath = "//*[@resource-id= 'com.rimac.rimac_surrogas.qa:id/editCfEmailHolder']//following-sibling::android.widget.EditText")
    public WebElement lblCorreo;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement btnAfiliarTarjeta;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/paymentCardFrontLayout")
    public WebElement imgTarjeta;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/button")
    public WebElement btnPagar;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/cbCfSaveCard")
    public WebElement btnGuardarTarjetanew;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement btnPagarNew;
    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/switchSw")
    public WebElement btnPagoAuto;



}
