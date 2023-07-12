package rimac.main.object;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjCuotasPagar extends BaseDriver {


    private static ObjCuotasPagar obj = null;

    private ObjCuotasPagar() {
    }

    public static ObjCuotasPagar getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjCuotasPagar();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @AndroidFindBy(xpath= "//*[@text='Cuotas a pagar']")
    public WebElement lblCuotasAPagar;
    @AndroidFindBy(xpath= "(//android.widget.CheckBox[@resource-id='com.rimac.rimac_surrogas.qa:id/rowPaymentQuoteCheck'])[1]")
    public WebElement chkCuota1;
    @AndroidFindBy(xpath = "//*[@resource-id= 'com.rimac.rimac_surrogas.qa:id/toolbarPayQuote']//following-sibling::android.widget.ImageButton")
    public WebElement btnVolver;
    @AndroidFindBy(xpath = "(//*[@resource-id= 'com.rimac.rimac_surrogas.qa:id/rowPaymentQuoteAmount'])[1]")
    public WebElement lblMontoCuota;
    @AndroidFindBy(xpath= "//*[@text='Iniciar pago']")
    public WebElement btnIniciarPago;

    @AndroidFindBy(xpath= "(//*[@resource-id='com.rimac.rimac_surrogas.qa:id/rowPaymentQuoteValue'])[1]")
    public WebElement lblNumeroCuotaPagar;
}