package rimac.main.object;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjTusAsistencias extends BaseDriver {

    private static ObjTusAsistencias obj = null;

    private ObjTusAsistencias() {
    }

    public static ObjTusAsistencias getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjTusAsistencias();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @AndroidFindBy(xpath = "//*[@text='Reembolso de salud']")
    public WebElement btnReembolsoSalud;
}
