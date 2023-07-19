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

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/updateDataTitle")
    public WebElement lblActualizaDatos;

    @AndroidFindBy(xpath = "//*[@resource-id='com.rimac.rimac_surrogas.qa:id/inputPhone']//following-sibling::android.widget.FrameLayout//following-sibling::android.widget.EditText")
    public WebElement txtCelular;

    @AndroidFindBy(xpath = "//*[@resource-id='com.rimac.rimac_surrogas.qa:id/inputEmail']//following-sibling::android.widget.FrameLayout//following-sibling::android.widget.EditText")
    public WebElement txtCorreo;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement btnContinuar;
}
