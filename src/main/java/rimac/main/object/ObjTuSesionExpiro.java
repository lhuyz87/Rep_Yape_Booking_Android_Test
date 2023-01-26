package rimac.main.object;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjTuSesionExpiro extends BaseDriver {

    private static ObjTuSesionExpiro  obj = null;

    private ObjTuSesionExpiro () {
    }

    public static ObjTuSesionExpiro  getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjTuSesionExpiro ();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/dialog_text_title")
    public WebElement titTusesionExpiro;

   // @AndroidFindBy(xpath = "//*[@text='Tu sesión ha expirado']")
   // public WebElement titTusesionExpiro;

    @AndroidFindBy(xpath = "//*[@text='Estuviste inactivo por unos minutos. Por seguridad tu sesión expiró. Por favor, vuelve a iniciar sesión.']")
    public WebElement msjInactividad;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement btnEntendido;




}
