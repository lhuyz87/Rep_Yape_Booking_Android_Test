package rimac.main.object;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import rimac.main.util.BaseDriver;

public class ObjPagos extends BaseDriver {

    private static ObjPagos obj = null;

    private ObjPagos() {
    }

    public static ObjPagos getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new ObjPagos();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @AndroidFindBy(id = "com.rimac.rimac_surrogas.qa:id/pmTextPaymentMethod")
    public WebElement lblMetodoPago;

    @AndroidFindBy(xpath = "//*[@text='Medios de pago']")
    public WebElement btnMediosPago;

    @AndroidFindBy(xpath= "//*[@text='Afiliar mi tarjeta']")
    public WebElement lnkAfiliarTarjeta;

    @AndroidFindBy(xpath= "//*[@text='Historial de pagos']")
    public WebElement btnHistorialPagos;
    @AndroidFindBy(xpath= "//*[@text='Pagar cuotas']")
    public WebElement btnPagarCuotas;

    @AndroidFindBy(xpath= "//*[@text='Cuotas a pagar']")
    public WebElement lblCuotasAPagar;

    @AndroidFindBy(xpath= "(//android.widget.CheckBox[@resource-id='com.rimac.rimac_surrogas.qa:id/rowPaymentQuoteCheck'])[1]")
    public WebElement chkCuota1;
    @AndroidFindBy(xpath= "//*[@text='Iniciar pago']")
    public WebElement btnIniciarPago;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/pcTextTitle")
    public WebElement titHemosRecibidosuPago;
    @AndroidFindBy(xpath= "//*[@text='Cuota pagada']")
    public WebElement btnCuotaPagada;

    @AndroidFindBy(xpath= "//*[@text='Entendido']")
    public WebElement btnEntendido;

    @AndroidFindBy(id= "com.rimac.rimac_surrogas.qa:id/btn_back")
    public WebElement tapRegresarSegVehicu;

    public WebElement titHemosRecibidosuPago2(String mensaje) {
        WebElement we_opcProblema = null;
        if(mensaje.equals("Seguro Vehicular")) {
            we_opcProblema = appiumDriver().findElement(AppiumBy.xpath("//*[@text='Seguro Vehicular']"));
        }
        return we_opcProblema;
    }

    @AndroidFindBy(xpath= "//*[@text='Ir al inicio']")
    public WebElement btnIrAInicio;

    @AndroidFindBy(xpath= "//*[@text='Estás afiliado a Débito Automático']")
    public WebElement titPagoAfiliado;



}
