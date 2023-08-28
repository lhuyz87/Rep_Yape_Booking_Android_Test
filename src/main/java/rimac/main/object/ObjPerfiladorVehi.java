package rimac.main.object;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjPerfiladorVehi extends BaseDriver {
    private static ObjPerfiladorVehi obj = null;

    private ObjPerfiladorVehi() {
    }
    public static ObjPerfiladorVehi getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjPerfiladorVehi();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @AndroidFindBy(xpath = "//*[@text='Empezar']")
    public WebElement opcSeguroTest;

    @AndroidFindBy(xpath = "//*[@text='Continuar']")
    public WebElement btnContinuar;

    public WebElement inputPlaca(String index) {
        WebElement we_inputPlaca = appiumDriver().findElement(AppiumBy.xpath("//*[@resource-id= 'com.rimac.rimac_surrogas.qa:id/inputPlate']/android.widget.EditText["+index+"]"));
        return we_inputPlaca;
    }

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/uiTxtTitle")
    public WebElement lblIngrPlaca;

    @AndroidFindBy(xpath = "//*[@text='Básica']")
    public WebElement btnProVehi;

    @AndroidFindBy(xpath = "//*[@text='Asistencias vehiculares']")
    public WebElement btnAsistencia;

    @AndroidFindBy(xpath = "//*[@text='Uso diario']")
    public WebElement btnTiempoUso;

    @AndroidFindBy(xpath = "//*[@text='Desde $26']")
    public WebElement btnPagoMes;

    @AndroidFindBy(xpath = "//*[@text='Ver resultado']")
    public WebElement btnVerResultado;

    @AndroidFindBy(xpath = "//*[@text='¡Lo quiero!']")
    public WebElement btnLoQuiero;

    @AndroidFindBy(xpath = "//*[@text='Finalizar']")
    public WebElement btnFinalizar;

}
