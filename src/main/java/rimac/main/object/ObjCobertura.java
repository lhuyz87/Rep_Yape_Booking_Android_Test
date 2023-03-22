package rimac.main.object;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjCobertura extends BaseDriver {

    private static ObjCobertura obj = null;

    private ObjCobertura() {
    }

    public static ObjCobertura getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjCobertura();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/coverage_text_title")
    public WebElement lblConoceCobertura;
}
