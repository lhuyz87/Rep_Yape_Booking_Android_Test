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

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement btnAgregarTarjeta;

    @AndroidFindBy(xpath = "//*[@text= 'Mis tarjetas']")
    public WebElement lblMisTarjetas;

    @AndroidFindBy(xpath = "//*[@resource-id= 'com.rimac.rimac_surrogas.qa:id/ctnListCardRv']/following-sibling::android.widget.TextView")
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
    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/card_option_trash")
    public WebElement btnEliminarTarjeta;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/bottom_sheet_negative_button")
    public WebElement btnSiEliminar;


    @AndroidFindBy(xpath = "//*[@resource-id= 'com.rimac.rimac_surrogas.qa:id/toolbarMethodPay']//following-sibling::android.widget.ImageButton")
    public WebElement btnVolver;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/alertMessage")
    public WebElement lblalert;

    @AndroidFindBy(xpath= "//*[@text='Tarjeta guardada con éxito.']")
    public WebElement lblTarjetaGuardadaExito;

    @AndroidFindBy(xpath= "//*[@text='La tarjeta fue eliminada con éxito.']")
    public WebElement lblTarjetaEliminadaExito;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/txtAddPaymentListCard")
    public WebElement btnAnadirNuevaTarjeta;

    @AndroidFindBy(xpath= "//android.widget.Button[@text='Añadir tarjeta']")
    public WebElement btnAnadirTarjeta;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/rvPaymentListCard")
    public WebElement listTarjetas;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/ctnListCardRv")
    public WebElement listTjetas;

    @AndroidFindBy(xpath= "(//*[@resource-id='com.rimac.rimac_surrogas.qa:id/rbPaymentCardSelected'])[1]")
    public WebElement rdbPrimeraTarjeta;

    @AndroidFindBy(xpath="//*[@text='Pagar']")
    public WebElement btnPagar;

    @AndroidFindBy(id="com.rimac.rimac_surrogas.qa:id/bodyEt")
    public WebElement txtCorreo;

    @AndroidFindBy(id="com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement btnContinuar;

}
