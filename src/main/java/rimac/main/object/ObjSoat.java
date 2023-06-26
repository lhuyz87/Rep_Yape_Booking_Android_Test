package rimac.main.object;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjSoat extends BaseDriver {
    private static ObjSoat obj = null;

    private ObjSoat() {
    }

    public static ObjSoat getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjSoat();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @AndroidFindBy(xpath= "//*[@text='Detalle de pago']")
    public WebElement msjDetPagos2;


}
