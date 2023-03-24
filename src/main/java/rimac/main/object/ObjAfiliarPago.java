package rimac.main.object;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjAfiliarPago extends BaseDriver {


    private static ObjAfiliarPago  obj = null;

    private ObjAfiliarPago () {
    }

    public static ObjAfiliarPago getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjAfiliarPago();
        }
    }
    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/txtTitlePaymentListCard")
    public WebElement lblAfiliarPago;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/textTitleGenericAffiliate")
    public WebElement lblTarjetaAfiliadaExito; //Tarjeta afiliada con éxito

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement btnIrPagos;
}
