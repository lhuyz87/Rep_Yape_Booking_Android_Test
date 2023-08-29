package rimac.main.object;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjChoferReemplazo extends BaseDriver {

private static ObjChoferReemplazo obj = null;

public ObjChoferReemplazo(){}

    public static ObjChoferReemplazo getInstancia() {
        instanciar();
        return obj;
    }
    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjChoferReemplazo();
        }
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/onBoardingTitle")
    public WebElement titSolicitaChoferR;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/confirmCheckTerms")
    public WebElement chktermsChoferR;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement btnChoferR;


    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/phoneUpdateTitle")
    public WebElement titCelulardeContacto;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/inputName")
    public WebElement idtxtNombre;
    @AndroidFindBy(xpath= "//*[@resource-id='com.rimac.rimac_surrogas.qa:id/inputName']//following-sibling::android.widget.FrameLayout//following-sibling::android.widget.EditText")
    public WebElement txtNombre;
    @AndroidFindBy(xpath= "//*[@resource-id='com.rimac.rimac_surrogas.qa:id/inputPhone']//following-sibling::android.widget.FrameLayout//following-sibling::android.widget.EditText")
    public WebElement txtCelular;
    @AndroidFindBy(xpath= "//*[@resource-id='com.rimac.rimac_surrogas.qa:id/inputEmail']//following-sibling::android.widget.FrameLayout//following-sibling::android.widget.EditText")
    public WebElement txtCorreo;
    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement btnComenzar;


    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/plateTitle")
    public WebElement titTusVehiculosAfiliados;

    public WebElement btnVehiculo(String placa) {
        WebElement we_btnVehiculo = appiumDriver().findElement(AppiumBy.xpath("//*[@text='"+placa+"']"));
        return we_btnVehiculo;
    }
    @AndroidFindBy(xpath="//*[@text='Punto de destino']")
    public WebElement txtPuntoDestino;

    @AndroidFindBy(xpath = "//*[@text='Chofer de reemplazo']")
    public WebElement opcChoferReemplazo;
    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/selectionText")
    public WebElement opcSelecPuntoMapa;
    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/addressConfirm")
    public WebElement opcConfirmarPuntoMapa;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement opcContSelecPuntoMapa;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/inputDatePicker")
    public WebElement selecFecha;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/buttonConfirm")
    public WebElement btnAceptarFecha;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/inputTimePicker")
    public WebElement selecHora;
    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/buttonConfirm")
    public WebElement btnConfirmarHora;
    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement btnConfirmarFechaHora;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/lblTitle")
    public WebElement titRequisitosServicios;

    @AndroidFindBy(xpath= "//*[@text='Revisión técnica']")
    public WebElement chcBoxRevisionTecnica;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement btnContinuarRevtec;


    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/lblTitle")
    public WebElement titConfirmarChofer;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement btnConfirmarChofer;

    public WebElement msjSolicitudChoferHome(String placa) {

        String matriculaLetras=placa.substring(0,3);
        String matriculaNumeros=placa.substring(3,6);

        WebElement soli_choferhome = appiumDriver().findElement(AppiumBy.xpath("//*[@text='Solicitud Chofer de reemplazo']//following-sibling::android.widget.TextView[@text='Placa: "+matriculaLetras+"-"+matriculaNumeros+"']"));
        return soli_choferhome;
    }
    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement btnIrInicio;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Inicio']")
    public WebElement opcHome;

    @AndroidFindBy(xpath= "//*[@text='Hemos recibido tu solicitud']")
    public WebElement titChoferReemplazo;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/csatImageClose")
    public WebElement btnCerrarmodal;

}
