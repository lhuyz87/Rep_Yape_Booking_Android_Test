package rimac.main.object;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjPagos extends BaseDriver {

    private static ObjPagos obj = null;

    private ObjPagos() {
    }

    public static ObjPagos getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjPagos();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/pmTextPaymentMethod")
    public WebElement lblMetodoPago;

    @AndroidFindBy(xpath = "//*[@text='Medios de pago']")
    public WebElement btnMediosPago;

    @AndroidFindBy(xpath= "//*[@text='Afiliar mi tarjeta']")
    public WebElement lnkAfiliarTarjeta;


}
