package rimac.main.object;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

import java.util.List;

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

    @AndroidFindBy(id= "onBoardingTitle")
    public WebElement titSolicitaChoferR;

    @AndroidFindBy(id= "confirmCheckTerms")
    public WebElement chktermsChoferR;

    @AndroidFindBy(id= "materialBtn")
    public WebElement btnChoferR;

    @AndroidFindBy(id= "phoneUpdateTitle")
    public WebElement titCelulardeContacto;

    @AndroidFindBy(id= "inputName")
    public WebElement idtxtNombre;
    @AndroidFindBy(xpath= "//*[@resource-id='inputName']//following-sibling::android.widget.FrameLayout//following-sibling::android.widget.EditText")
    public WebElement txtNombre;
    @AndroidFindBy(xpath= "//*[@resource-id='inputPhone']//following-sibling::android.widget.FrameLayout//following-sibling::android.widget.EditText")
    public WebElement txtCelular;
    @AndroidFindBy(xpath= "//*[@resource-id='inputEmail']//following-sibling::android.widget.FrameLayout//following-sibling::android.widget.EditText")
    public WebElement txtCorreo;
    @AndroidFindBy(id= "materialBtn")
    public WebElement btnComenzar;
    @AndroidFindBy(id= "plateTitle")
    public WebElement titTusVehiculosAfiliados;

    public WebElement btnVehiculo(String placa) {
        WebElement we_btnVehiculo = appiumDriver().findElement(AppiumBy.xpath("//*[@text='"+placa+"']"));
        return we_btnVehiculo;
    }
    @AndroidFindBy(id="addressMapInputDestiny")
    public WebElement txtPuntoDestino;

    @AndroidFindBy(id="addressMapInput")
    public WebElement txtPuntoPartida;
    @AndroidFindBy(xpath = "//*[@text='Chofer de reemplazo']")
    public WebElement opcChoferReemplazo;
    @AndroidFindBy(id= "selectionText")
    public WebElement opcSelecPuntoMapa;
    @AndroidFindBy(id= "addressConfirm")
    public WebElement opcConfirmarPuntoMapa;

    @AndroidFindBy(id= "materialBtn")
    public WebElement opcContSelecPuntoMapa;

    @AndroidFindBy(id= "inputDatePicker")
    public WebElement selecFecha;

    @AndroidFindBy(id= "buttonConfirm")
    public WebElement btnAceptarFecha;

    @AndroidFindBy(id= "inputTimePicker")
    public WebElement selecHora;
    @AndroidFindBy(id= "buttonConfirm")
    public WebElement btnConfirmarHora;
    @AndroidFindBy(id= "materialBtn")
    public WebElement btnConfirmarFechaHora;
    @AndroidFindBy(id= "lblTitle")
    public WebElement titRequisitosServicios;

    @AndroidFindBy(xpath= "//*[@text='Revisión técnica']")
    public WebElement chcBoxRevisionTecnica;

    @AndroidFindBy(id= "materialBtn")
    public WebElement btnContinuarRevtec;

    @AndroidFindBy(id= "lblTitle")
    public WebElement titConfirmarChofer;

    @AndroidFindBy(id= "materialBtn")
    public WebElement btnConfirmarChofer;

    public WebElement msjSolicitudChoferHome(String placa) {

        String matriculaLetras=placa.substring(0,3);
        String matriculaNumeros=placa.substring(3,6);

        WebElement soli_choferhome = appiumDriver().findElement(AppiumBy.xpath("//*[@text='Solicitud Chofer de reemplazo']//following-sibling::android.widget.TextView[@text='"+matriculaLetras+"-"+matriculaNumeros+"']"));
        return soli_choferhome;
    }
    public List<WebElement> msjSolicitudChoferHomeExist(String placa) {

        String matriculaLetras=placa.substring(0,3);
        String matriculaNumeros=placa.substring(3,6);

        List<WebElement> soli_choferhome = appiumDriver().findElements(AppiumBy.xpath("//*[@text='Solicitud Chofer de reemplazo']//following-sibling::android.widget.TextView[@text='"+matriculaLetras+"-"+matriculaNumeros+"']"));
        return soli_choferhome;
    }
    @AndroidFindBy(id= "materialBtn")
    public WebElement btnIrInicio;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Inicio']")
    public WebElement opcHome;

    @AndroidFindBy(xpath= "//*[@text='Hemos recibido tu solicitud']")
    public WebElement titChoferReemplazo;

    @AndroidFindBy(id = "csatImageClose")
    public WebElement btnCerrarmodal;

    @AndroidFindBy(id = "assistanceCancelButton")
    public WebElement btnCancelarChofer;

    @AndroidFindBy(id = "bottom_sheet_negative_button")
    public WebElement btnSiCancelar;

    @AndroidFindBy(id = "received_request_title")
    public WebElement lblSolicitudCancelada;

    @AndroidFindBy(id = "backBtn")
    public WebElement btnRegresar;

}
