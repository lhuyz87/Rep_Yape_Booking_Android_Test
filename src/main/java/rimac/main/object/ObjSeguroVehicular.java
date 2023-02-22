package rimac.main.object;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjSeguroVehicular extends BaseDriver {

    private static ObjSeguroVehicular obj = null;

    private ObjSeguroVehicular() {
    }

    public static ObjSeguroVehicular getInstancia() {
        instanciar();
        return obj;
    }
    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjSeguroVehicular();
        }
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    @AndroidFindBy(accessibility= "Póliza")
    public WebElement opcPoliza;

    @AndroidFindBy(xpath= "//*[@resource-id='android:id/pickers']/android.widget.NumberPicker[2]/android.widget.EditText")
    public WebElement fechaAnio;

    @AndroidFindBy(xpath= "//*[@resource-id='android:id/pickers']/android.widget.NumberPicker[1]/android.widget.EditText")
    public WebElement fechaMes;
    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/editDateAccountStatus")
    public WebElement btnModificarFecha;
    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/btnCalendarAccept")
    public WebElement btnAceptarFecha;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/button")
    public WebElement btnDescargar;


}
