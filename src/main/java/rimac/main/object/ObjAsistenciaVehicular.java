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

    @AndroidFindBy(xpath= "//*[@resource-id='com.rimac.rimac_surrogas.qa:id/inputName']/android.widget.FrameLayout/android.widget.EditText")
    public WebElement txtNombre;

    @AndroidFindBy(xpath= "//*[@resource-id='com.rimac.rimac_surrogas.qa:id/inputPhone']/android.widget.FrameLayout/android.widget.EditText")
    public WebElement txtCelular;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement btnComenzar;

    public WebElement btnVehiculo(String placa) {
        WebElement we_btnVehiculo = appiumDriver().findElement(AppiumBy.xpath("//*[@text='"+placa+"']"));
        return we_btnVehiculo;
    }
    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement btnContinuar;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/tvOmitir")
    public WebElement btnOmitir;
    @AndroidFindBy(xpath= "//*[@text='Auxilio mecánico']")
    public WebElement btnAuxilioMecanico;
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
    public WebElement msjSolicitudEnviada;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement btnIrAlInicio;


    public WebElement msjSolicitudAsistenciaHome(String placa) {
        String matriculaLetras=placa.substring(0,3);
        String matriculaNumeros=placa.substring(3,6);
        WebElement we_SolicitudAsistenciaHome = appiumDriver().findElement(AppiumBy.xpath("//android.widget.TextView[@text='Solicitud de auxilio mecánico']//following-sibling::android.widget.TextView[@text='Placa: "+matriculaLetras+"-"+matriculaNumeros+"']"));
        return we_SolicitudAsistenciaHome;
    }

    @AndroidFindBy(xpath= "//*[@text='¿Qué te pareció la experiencia solicitando Auxilio mecánico?']")
    public WebElement mdlCalifaAuxilioMecanico;

}
