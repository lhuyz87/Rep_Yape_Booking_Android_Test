package rimac.main.object;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjActivaTuSeguro extends BaseDriver {

    private static ObjActivaTuSeguro obj = null;

    private ObjActivaTuSeguro() {
    }

    public static ObjActivaTuSeguro getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjActivaTuSeguro();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @AndroidFindBy(id = "dialog_close")
    public WebElement btnCerrarModal;

    @AndroidFindBy(id = "dialog_text_title")
    public WebElement titActivatuSeguro;

}
