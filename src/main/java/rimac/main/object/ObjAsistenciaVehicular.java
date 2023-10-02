package rimac.main.object;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

import java.util.List;

public class ObjAsistenciaVehicular extends BaseDriver {

    private static ObjAsistenciaVehicular obj = null;

    public ObjAsistenciaVehicular() {
    }
    public static ObjAsistenciaVehicular getInstancia() {
        instanciar();
        return obj;
    }
    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjAsistenciaVehicular();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @AndroidFindBy(id= "confirmCheckTerms")
    public WebElement chktermsAsistencia;
    @AndroidFindBy(id= "phoneUpdateTitle")
    public WebElement titCelulardeContacto;
    @AndroidFindBy(id= "onBoardingTitle")
    public WebElement titSolicitaAsistencia;

    @AndroidFindBy(id= "inputName")
    public WebElement idtxtNombre;
    @AndroidFindBy(xpath= "//*[ends-with(@resource-id,'inputName')]//following-sibling::android.widget.FrameLayout//following-sibling::android.widget.EditText")
    public WebElement txtNombre;
    @AndroidFindBy(xpath= "//*[ends-with(@resource-id,'inputPhone')]//following-sibling::android.widget.FrameLayout//following-sibling::android.widget.EditText")
    public WebElement txtCelular;
    @AndroidFindBy(id= "materialBtn")
    public WebElement btnComenzar;

    @AndroidFindBy(id= "plateTitle")
    public WebElement titTusVehiculosAfiliados;

    @AndroidFindBy(xpath= "//*[ends-with(@resource-id,'platesRv')]/android.view.ViewGroup")
    public List<WebElement> listPlacas;

    public WebElement btnVehiculo(String placa) {
        WebElement we_btnVehiculo = appiumDriver().findElement(AppiumBy.xpath("//*[@text='"+placa+"']"));
        return we_btnVehiculo;
    }
    @AndroidFindBy(id= "materialBtn")
    public WebElement btnContinuar;

    @AndroidFindBy(xpath= "//*[@text='No, thanks']")
    public WebElement btnNoThanks;

    @AndroidFindBy(id= "tvOmitir")
    public WebElement btnOmitir;
    @AndroidFindBy(id= "sinisterTitle")
    public WebElement titQueNecesitas;

    public WebElement btnAsistencia(String asistencia) {
        WebElement we_opcProblema = null;
        if(asistencia.equals("Auxilio mecánico")) {
            we_opcProblema = appiumDriver().findElement(AppiumBy.xpath("//*[@text='Necesito auxilio mecánico']"));
        }
        if(asistencia.equals("Grúa")) {
            we_opcProblema = appiumDriver().findElement(AppiumBy.xpath("//*[@text='Necesito una grúa']"));
        }
        return we_opcProblema;
    }

    @AndroidFindBy(xpath = "//*[@text='Auxilio mecánico']")
    public WebElement btnAsistenciaAuxilio;

    @AndroidFindBy(xpath = "//*[@text='Grúa']")
    public WebElement btnAsistenciaGrua;

    @AndroidFindBy(xpath = "//*[@text='¿No sabes cuál elegir?']")
    public WebElement btnAyudameElegir;

    @AndroidFindBy(id = "additionalTitle")
    public WebElement tit_problemas;
    public WebElement opcProblema(String problema) {
        WebElement we_opcProblema = appiumDriver().findElement(AppiumBy.xpath("//*[@text='"+problema+"']"));
        return we_opcProblema;
    }
    @AndroidFindBy(id = "confirmCheckTerms")
    public WebElement chk_terminos;

    @AndroidFindBy(id = "materialBtn")
    public WebElement btnConfirmarSolicitud;

    @AndroidFindBy(id = "congratsTitle")
    public WebElement lblSolicitudEnviada;

    @AndroidFindBy(xpath = "//*[@text='Ya tienes un servicio en proceso']")
    public WebElement titYaTienesunServicio;

    @AndroidFindBy(id = "materialBtn")
    public WebElement btnIrAlInicio;


    public WebElement msjSolicitudAsistenciaHome(String asistencia, String placa) {
        WebElement we_SolicitudAsistenciaHome = null;
        String matriculaLetras=placa.substring(0,3);
        String matriculaNumeros=placa.substring(3,6);
        if(asistencia.equals("Auxilio mecánico")){
           we_SolicitudAsistenciaHome = appiumDriver().findElement(AppiumBy.xpath("//android.widget.TextView[@text='Solicitud de auxilio mecánico']//following-sibling::android.widget.TextView[@text='Placa: "+matriculaLetras+"-"+matriculaNumeros+"']"));
        }
        if(asistencia.equals("Grúa")){
            we_SolicitudAsistenciaHome = appiumDriver().findElement(AppiumBy.xpath("//android.widget.TextView[@text='Solicitud de grúa enviada']//following-sibling::android.widget.TextView[@text='Placa: "+matriculaLetras+"-"+matriculaNumeros+"']"));
        }
        return we_SolicitudAsistenciaHome;
    }

    @AndroidFindBy(xpath= "//*[@text='¿Qué te pareció la experiencia solicitando Auxilio mecánico?']")
    public WebElement mdlCalifaAuxilioMecanico;

    @AndroidFindBy(xpath= "//*[@text='Sí, por ejemplo la vía pública.']")
    public WebElement opcEspaciofacilAcceso;

    @AndroidFindBy(id= "additionalTitle")
    public WebElement titTuVehiculoZona;

    @AndroidFindBy(id= "confirmTitle")
    public WebElement titConfirmacionAsistencia;

}
