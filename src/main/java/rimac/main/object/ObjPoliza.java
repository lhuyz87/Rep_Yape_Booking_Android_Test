package rimac.main.object;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjPoliza extends BaseDriver {


    private static ObjPoliza obj = null;

    private ObjPoliza() {
    }

    public static ObjPoliza getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjPoliza();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Póliza']")
    public WebElement btnPoliza;

    @AndroidFindBy(id = "policyTextPlate")
    public WebElement numeroPoliza;

    @AndroidFindBy(xpath = "//*[@text='Entendido']")
    public WebElement btnEntendido;
}
