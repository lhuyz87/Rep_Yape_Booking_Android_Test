package rimac.main.object;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjCommons extends BaseDriver {
    private static ObjCommons obj = null;

    private ObjCommons() {
    }

    public static ObjCommons getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjCommons();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }



    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/csatImageClose")
    public WebElement btnCerrarmodal;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/csatTitle")
    public WebElement btnCalificaApp;




}