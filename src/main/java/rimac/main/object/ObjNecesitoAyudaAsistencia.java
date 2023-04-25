package rimac.main.object;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjNecesitoAyudaAsistencia extends BaseDriver {

    private static ObjNecesitoAyudaAsistencia obj = null;

    private ObjNecesitoAyudaAsistencia() {
    }

    public static ObjNecesitoAyudaAsistencia getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjNecesitoAyudaAsistencia();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/uiEditOption")
    public WebElement cmbEligeOpcion;

    public WebElement opcEligeOpcion(String opcion){
        WebElement we_opcEligeOpcion = appiumDriver().findElement(By.ByXPath.xpath("//*[@text='"+opcion+"']//following-sibling::android.widget.ImageView"));
        return we_opcEligeOpcion;
    }

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement btnContinuar;

    @AndroidFindBy(xpath= "//*[@text='Sí']//preceding-sibling::android.widget.ImageView")
    public WebElement btnSi;

    @AndroidFindBy(xpath = "//*[@text='No']//preceding-sibling::android.widget.ImageView")
    public WebElement btnNo;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement btnSolicitar;

    @AndroidFindBy(xpath = "//*[@text='Sí, por ejemplo la vía pública.']//following-sibling::android.widget.RadioButton")
    public WebElement btnSiViaPublica;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/sinisterTitle")
    public WebElement lblEnciendeLuces;

    @AndroidFindBy(xpath= "//*[@text='Asistencia sugerida']")
    public WebElement lblAsistenciSugerida;
}
