package rimac.main.object;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjActualizaDatos extends BaseDriver {

    private static ObjActualizaDatos obj = null;

    private ObjActualizaDatos() {
    }

    public static ObjActualizaDatos getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjActualizaDatos();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @AndroidFindBy(id = "updateDataTitle")
    public WebElement lblActualizaDatos;

    @AndroidFindBy(xpath = "//*[ends-with(@resource-id,'inputPhone')]//following-sibling::android.widget.FrameLayout//following-sibling::android.widget.EditText")
    public WebElement txtCelular;

    @AndroidFindBy(xpath = "//*[ends-with(@resource-id,'inputEmail')]//following-sibling::android.widget.FrameLayout//following-sibling::android.widget.EditText")
    public WebElement txtCorreo;

    @AndroidFindBy(id = "materialBtn")
    public WebElement btnContinuar;
}
