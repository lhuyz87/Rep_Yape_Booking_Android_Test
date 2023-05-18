package rimac.main.object;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjPerfiladorSalud extends BaseDriver {

    private static ObjPerfiladorSalud obj = null;

    private ObjPerfiladorSalud() {
    }
    public static ObjPerfiladorSalud getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjPerfiladorSalud();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    @AndroidFindBy(xpath = "//*[@text='Empezar']")
    public WebElement opcSeguroTest;

    @AndroidFindBy(xpath = "//*[@text='Solo a mí']")
    public WebElement opcProteger;

    @AndroidFindBy(xpath = "//*[@text='Total']")
    public WebElement opcProteccion;

    @AndroidFindBy(xpath = "//*[@text='En una clínica']")
    public WebElement opcLugarAtencion;

    @AndroidFindBy(xpath = "//*[@text='Odontología']")
    public WebElement opcCobertura;

    @AndroidFindBy(xpath = "//*[@text='¡Lo quiero!']")
    public WebElement btnLoQuiero;

    @AndroidFindBy(xpath = "//*[@text='Finalizar']")
    public WebElement btnFinalizar;

    @AndroidFindBy(xpath = "//*[@text='Continuar']")
    public WebElement btnContinuar;

}
