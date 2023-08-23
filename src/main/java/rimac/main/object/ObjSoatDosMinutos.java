package rimac.main.object;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

import java.util.List;

public class ObjSoatDosMinutos extends BaseDriver {

    private static ObjSoatDosMinutos obj = null;

    private ObjSoatDosMinutos() {
    }

    public static ObjSoatDosMinutos getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjSoatDosMinutos();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }


    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/soatPurchaseHeaderTitle")
    public WebElement lblTitle;

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/inputPlate")
    public List<WebElement> inputPlaca;

    public WebElement inputPlaca(String index) {
        WebElement we_inputPlaca = appiumDriver().findElement(AppiumBy.xpath("//*[@resource-id= 'com.rimac.rimac_surrogas.qa:id/inputPlate']/android.widget.EditText["+index+"]"));
        return we_inputPlaca;
    }

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/inputVehicleUse")
    public WebElement cmbTipoUso;

    public WebElement opcTipoUso(String tipo) {
        WebElement we_tipoUso = appiumDriver().findElement(AppiumBy.xpath("//*[@text='"+tipo+"']"));
        return we_tipoUso;
    }
    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/inputTypeVehicle")
    public WebElement cmbTipoVehiculo;
    public WebElement opcVehiculo(String vehiculo) {
        WebElement we_Vehiculo = appiumDriver().findElement(AppiumBy.xpath("//*[@text='"+vehiculo+"']"));
        return we_Vehiculo;
    }
    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/inputVehicleBrand")
    public WebElement cmbMarca;
    public WebElement opcMarca(String marca) {
        WebElement we_Marca = appiumDriver().findElement(AppiumBy.xpath("//*[@text='"+marca+"']"));
        return we_Marca;
    }
    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/inputVehicleModel")
    public WebElement cmbModelo;

    public WebElement opcModelo(String modelo) {
        WebElement we_Modelo = appiumDriver().findElement(AppiumBy.xpath("//*[@text='"+modelo+"']"));
        return we_Modelo;
    }
    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/inputYear")
    public WebElement txtAnio;
    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/inputSerie")
    public WebElement txtSerie;
    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/inputSeatNumber")
    public WebElement txtNumAsientos;
    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/materialBtn")
    public WebElement btnContinuar;

}
