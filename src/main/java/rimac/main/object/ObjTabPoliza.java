package rimac.main.object;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjTabPoliza extends BaseDriver {

    private static ObjTabPoliza obj = null;

    private ObjTabPoliza() {
    }

    public static ObjTabPoliza getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjTabPoliza();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @AndroidFindBy(id= "txtPoliceDomiciliary")
    public WebElement lblDetallePoliza;

    @AndroidFindBy(id= "policyTextDownload")
    public WebElement btnDescargarPoliza;

    @AndroidFindBy(id= "pdf_content")
    public WebElement pdfDocumento;

    @AndroidFindBy(id= "button")
    public WebElement btnEstadoCuenta;
}
