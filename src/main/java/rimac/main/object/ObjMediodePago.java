package rimac.main.object;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

import java.util.List;

public class ObjMediodePago extends BaseDriver {

    private static ObjMediodePago  obj = null;

    private ObjMediodePago () {
    }

    public static ObjMediodePago getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjMediodePago();
        }
    }

    @AndroidFindBy(xpath = "//*[@text='No podemos encontrar tus tarjetas guardadas']")
    public WebElement lblNoPodemosEncontrar;

    @AndroidFindBy(id = "materialBtn")
    public WebElement btnAgregarTarjeta;

    @AndroidFindBy(xpath = "//*[@text= 'Mis tarjetas']")
    public WebElement lblMisTarjetas;

    @AndroidFindBy(xpath = "//*[ends-with(@resource-id,'ctnListCardRv')]/following-sibling::android.widget.TextView")
    public WebElement lnkAgregarNuevaTarjeta;

    public List<WebElement> opcTarjetaList(String numTarjeta) {
        String ultimosNumerosTarjeta=numTarjeta.substring(12,16);
        List<WebElement> we_opcTarjeta = appiumDriver().findElements(AppiumBy.xpath("//*[@text= '**** "+ultimosNumerosTarjeta+"']"));
        return  we_opcTarjeta;
    }

    public WebElement opcTarjeta(String numTarjeta) {
        String ultimosNumerosTarjeta=numTarjeta.substring(12,16);
        WebElement we_opcTarjeta = appiumDriver().findElement(AppiumBy.xpath("//*[@text= '**** "+ultimosNumerosTarjeta+"']"));
        return  we_opcTarjeta;
    }

    public List<WebElement> opcTarjetaSinSeguros(String numTarjeta) {
        String ultimosNumerosTarjeta=numTarjeta.substring(12,16);
        List<WebElement> we_opcTarjeta1 = appiumDriver().findElements(AppiumBy.xpath("//*[@text='Ningún seguro asociado']//parent::android.view.ViewGroup//preceding-sibling::android.widget.TextView[@text='**** "+ultimosNumerosTarjeta+"']"));
        return  we_opcTarjeta1;
    }

    public WebElement opcTarjetaSinSeguros2 (String numTarjeta) {
        String ultimosNumerosTarjeta=numTarjeta.substring(12,16);
        WebElement we_opcTarjeta1 = appiumDriver().findElement(AppiumBy.xpath("//*[@text='Ningún seguro asociado']//parent::android.view.ViewGroup//preceding-sibling::android.widget.TextView[@text='**** "+ultimosNumerosTarjeta+"']"));
        return  we_opcTarjeta1;
    }

    @AndroidFindBy(id = "card_option_trash")
    public WebElement btnEliminarTarjeta;

    @AndroidFindBy(id = "bottom_sheet_negative_button")
    public WebElement btnSiEliminar;

    @AndroidFindBy(id= "txtAddPaymentListCard")
    public WebElement btnAnadirNuevaTarjeta;

    @AndroidFindBy(xpath= "//android.widget.Button[@text='Añadir tarjeta']")
    public WebElement btnAnadirTarjeta;

    @AndroidFindBy(id= "rvPaymentListCard")
    public WebElement listTarjetas;

    @AndroidFindBy(id= "ctnListCardRv")
    public WebElement listTjetas;

    @AndroidFindBy(xpath= "(//*[ends-with(@resource-id,'rbPaymentCardSelected')])[1]")
    public WebElement rdbPrimeraTarjeta;

    @AndroidFindBy(xpath="//*[@text='Pagar']")
    public WebElement btnPagar;

    @AndroidFindBy(id="bodyEt")
    public WebElement txtCorreo;

    @AndroidFindBy(id="materialBtn")
    public WebElement btnContinuar;

}
