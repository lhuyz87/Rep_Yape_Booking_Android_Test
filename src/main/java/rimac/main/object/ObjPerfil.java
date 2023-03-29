package rimac.main.object;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjPerfil extends BaseDriver {

    private static ObjPerfil  obj = null;

    private ObjPerfil () {
    }

    public static ObjPerfil  getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjPerfil();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @AndroidFindBy(xpath = "//*[@text='Mis medios de pago']")
    public WebElement btnMediosPago;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/profile_text_about_me")
    public WebElement lblMiCuenta;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement btnCerrarSesion;

}
