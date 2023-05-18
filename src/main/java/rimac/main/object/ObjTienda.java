package rimac.main.object;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjTienda extends BaseDriver {

    private static ObjTienda obj = null;

    private ObjTienda() {
    }

    public static ObjTienda getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjTienda();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/tvDescription")
    public WebElement lblDescripcion;

    @AndroidFindBy(xpath = "//*[@text='SOAT en 2 minutos']")
    public WebElement btnSoatDosminutos;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement btnConoceMas;

    @AndroidFindBy(xpath = "//*[@text='Seguros de Salud']")
    public WebElement btnSegSalud;

    @AndroidFindBy(xpath = "//*[@text='Salud']")
    public WebElement btnSalud;

    @AndroidFindBy(xpath = "//*[@text='Descubre el seguro ideal para ti con este test']")
    public WebElement opcSeguroTest;

    @AndroidFindBy(xpath = "//*[@text='Seguros Vehiculares']")
    public WebElement btnSeguroVehi;

}
