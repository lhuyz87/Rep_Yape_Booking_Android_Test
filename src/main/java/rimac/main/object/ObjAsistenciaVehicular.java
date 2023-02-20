package rimac.main.object;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

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

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/confirmCheckTerms")
    public WebElement chktermsAsistencia;
    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/phoneUpdateTitle")
    public WebElement titCelulardeContacto;
    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/onBoardingTitle")
    public WebElement titSolicitaAsistencia;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/inputName")
    public WebElement idtxtNombre;
    @AndroidFindBy(xpath= "//*[@resource-id='com.rimac.rimac_surrogas.qa:id/inputName']//following-sibling::android.widget.FrameLayout//following-sibling::android.widget.EditText")
    public WebElement txtNombre;
    @AndroidFindBy(xpath= "//*[@resource-id='com.rimac.rimac_surrogas.qa:id/inputPhone']//following-sibling::android.widget.FrameLayout//following-sibling::android.widget.EditText")
    public WebElement txtCelular;
    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement btnComenzar;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/plateTitle")
    public WebElement titTusVehiculosAfiliados;

    public WebElement btnVehiculo(String placa) {
        WebElement we_btnVehiculo = appiumDriver().findElement(AppiumBy.xpath("//*[@text='"+placa+"']"));
        return we_btnVehiculo;
    }
    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement btnContinuar;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/tvOmitir")
    public WebElement btnOmitir;
    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/sinisterTitle")
    public WebElement titQueNecesitas;

    public WebElement btnAsistencia(String asistencia) {
        WebElement we_opcProblema = appiumDriver().findElement(AppiumBy.xpath("//*[@text='"+asistencia+"']"));
        return we_opcProblema;
    }

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/additionalTitle")
    public WebElement tit_problemas;
    public WebElement opcProblema(String problema) {
        WebElement we_opcProblema = appiumDriver().findElement(AppiumBy.xpath("//*[@text='"+problema+"']"));
        return we_opcProblema;
    }
    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/confirmCheckTerms")
    public WebElement chk_terminos;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement btnConfirmarSolicitud;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/congratsTitle")
    public WebElement lblSolicitudEnviada;

    @AndroidFindBy(xpath = "//*[@text='En 5 minutos te escribiremos vía Whatsapp para confirmar el auxilio mecánico. Podrás darle seguimiento desde el Inicio.'")
    public WebElement msjConfirmacionAuxilioM;

    @AndroidFindBy(xpath = "//*[@text='En 5 minutos te escribiremos vía Whatsapp para confirmar el servicio de grúa. Podrás darle seguimiento desde la sección Inicio.']")
    public WebElement msjConfirmacionGrua;

    @AndroidFindBy(xpath = "//*[@text='Ya tienes un servicio en proceso']")
    public WebElement titYaTienesunServicio;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/materialBtn")
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

    @AndroidFindBy(xpath= "//*[@text='Sí, está en una zona de fácil acceso']")
    public WebElement opcEspaciofacilAcceso;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/additionalTitle")
    public WebElement titTuVehiculoZona;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/confirmTitle")
    public WebElement titConfirmacionAsistencia;

}
