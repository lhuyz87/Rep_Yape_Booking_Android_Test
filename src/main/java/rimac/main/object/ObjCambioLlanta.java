package rimac.main.object;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjCambioLlanta  extends BaseDriver {

    private static ObjCambioLlanta obj = null;

    private ObjCambioLlanta() {
    }

    public static ObjCambioLlanta getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjCambioLlanta();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @AndroidFindBy(xpath ="//android.view.ViewGroup[ends-with(@resource-id,'containerAnswerCase')][1]")
    public WebElement opcSiTengoRepuesto;
}
