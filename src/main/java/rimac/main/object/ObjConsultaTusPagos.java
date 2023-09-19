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

    @AndroidFindBy(id = "downloadIcons")
    public WebElement btnDescargaHistorial;

    @AndroidFindBy(id = "materialBtn")
    public WebElement btnAbrir;

    @AndroidFindBy(xpath = "(//*[ends-with(@resource-id,'amount')])[last()]")
    public WebElement lblMontoHistorial;

    @AndroidFindBy(xpath = "(//*[@text='Documents']")
    public WebElement btnDocuments;
    @AndroidFindBy(xpath = "(//*[@text='historial']")
    public WebElement lblHistorialPdf;

    public WebElement lblNumeroCuotaHistorial(String cuota){
        WebElement we_lblNumeroCuotaHistorial = appiumDriver().findElement(By.ByXPath.xpath("//*[@text='"+cuota+"']"));
        return we_lblNumeroCuotaHistorial;
    }
}
