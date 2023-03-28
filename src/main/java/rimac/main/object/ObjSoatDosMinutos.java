package rimac.main.object;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

import java.util.List;

public class ObjSoatDosMinutos extends BaseDriver {

    private static ObjSoatDosMinutos obj = null;

    private ObjSoatDosMinutos() {
    }

    public static ObjSoatDosMinutos getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjSoatDosMinutos();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }


    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/soatPurchaseHeaderTitle")
    public WebElement lblTitle;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/inputPlate")
    public List<WebElement> inputPlaca;

    public WebElement inputPlaca(String index) {
        WebElement we_inputPlaca = appiumDriver().findElement(AppiumBy.xpath("//*[@resource-id= 'com.rimac.rimac_surrogas.qa:id/inputPlate']/android.widget.EditText["+index+"]"));
        return we_inputPlaca;
    }

}
