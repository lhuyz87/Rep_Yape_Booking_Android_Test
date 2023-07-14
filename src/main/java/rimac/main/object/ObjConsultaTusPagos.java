package rimac.main.object;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjConsultaTusPagos extends BaseDriver {

    private static ObjConsultaTusPagos  obj = null;

    private ObjConsultaTusPagos () {
    }

    public static ObjConsultaTusPagos getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjConsultaTusPagos();
        }
    }

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/downloadIcons")
    public WebElement btnDescargaHistorial;
////*[starts-with(@text, 'historial-pagos')]
    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement btnAbrir;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/downloadProgress")
    public WebElement btnDownloadProgress;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='']")
    public WebElement lblPdfHistorial;

    @AndroidFindBy(xpath = "(//*[@resource-id='com.rimac.rimac_surrogas.qa:id/amount'])[last()]")
    public WebElement lblMontoHistorial;

    public WebElement lblNumeroCuotaHistorial(String cuota){
        WebElement we_lblNumeroCuotaHistorial = appiumDriver().findElement(By.ByXPath.xpath("//*[@text='"+cuota+"']"));
        return we_lblNumeroCuotaHistorial;
    }
}
