package rimac.main.object;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ObjSoat {
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

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/btnText")
    public WebElement btnPagos;

    @AndroidFindBy(xpath= "//*[@text='Detalle de pago']")
    public WebElement msjDetPagos;

}
