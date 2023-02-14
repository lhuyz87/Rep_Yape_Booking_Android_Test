package rimac.main.object;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjSeguroVehicular extends BaseDriver {

    private static ObjSeguroVehicular obj = null;

    private ObjSeguroVehicular() {
    }

    public static ObjSeguroVehicular getInstancia() {
        instanciar();
        return obj;
    }
    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjSeguroVehicular();
        }
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    @AndroidFindBy(accessibility= "Póliza")
    public WebElement opcPoliza;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/policyTextDownload")
    public WebElement btnDescargarPoliza;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/pdf_content")
    public WebElement pdfPoliza;

}
