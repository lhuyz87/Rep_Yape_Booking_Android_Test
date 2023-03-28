package rimac.main.object;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjEligeTuPlan extends BaseDriver {

    private static ObjEligeTuPlan obj = null;

    private ObjEligeTuPlan() {
    }

    public static ObjEligeTuPlan getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjEligeTuPlan();
        }
    }

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/soatPurchaseHeaderTitle")
    public WebElement lblEligetuPlan;

    @AndroidFindBy(xpath = "//*[@text='Continuar']")
    public WebElement btnContinuar;

    @AndroidFindBy(accessibility = "No, gracias")
    public WebElement rdbNoAfiliar;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/soatRenewalPrivacyPolicy")
    public WebElement rdbPoliticaPrivacidad;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/soatRenewalCheckElectronicPolicy")
    public WebElement rdbEnvioPoliza;


}
