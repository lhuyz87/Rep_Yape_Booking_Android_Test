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

    @AndroidFindBy(id = "soatPurchaseHeaderTitle")
    public WebElement lblEligetuPlan;

    @AndroidFindBy(xpath = "//*[@text='Continuar']")
    public WebElement btnContinuar;

    @AndroidFindBy(accessibility = "No, gracias")
    public WebElement rdbNoAfiliar;

    @AndroidFindBy(id = "soatRenewalPrivacyPolicy")
    public WebElement rdbPoliticaPrivacidad;

    @AndroidFindBy(id = "soatRenewalCheckElectronicPolicy")
    public WebElement rdbEnvioPoliza;

    @AndroidFindBy(xpath = "//*[@text='Vial']")
    public WebElement btnVial;

    @AndroidFindBy(xpath = "//*[@text='Plus']")
    public WebElement btnPlus;

}
