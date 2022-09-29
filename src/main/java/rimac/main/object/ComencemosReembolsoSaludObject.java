package rimac.main.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import rimac.main.object.ComencemosReembolsoSaludObject;
import rimac.main.screen.BaseScreen;

public class ComencemosReembolsoSaludObject extends BaseScreen{
	
	// singleton
	private static ComencemosReembolsoSaludObject obj = null;

	private ComencemosReembolsoSaludObject() {
	}

	public static ComencemosReembolsoSaludObject getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ComencemosReembolsoSaludObject();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	

	@AndroidFindBy(xpath = "//*[@text='Producto y contratante']")
	public WebElement selProdContratante;
	
	
	@AndroidFindBy(xpath = "//*[@text='Lugar de atención']")
	public WebElement selLugarAtencion;
	
	@AndroidFindBy(xpath = "//*[@text='Fecha de atención']")
	public WebElement selFechaAtencion;
	
	@AndroidFindBy(xpath = "//*[@text='Paciente']")
	public WebElement selPaciente;
	
	
	public WebElement diaAtencion(WebDriver webDriver, String dia) {
		By by = By.xpath("//*[@text='"+dia+"']");
		WebElement diaAtencion = webDriver.findElement(by);
		return diaAtencion;
	}
	
	public WebElement productoContratante(WebDriver webDriver, String prodContra) {
		By by = By.xpath("//*[@text='"+prodContra+"']");
		WebElement diaAtencion = webDriver.findElement(by);
		return diaAtencion;
	}
	
	public WebElement lugarAtencion(WebDriver webDriver, String lugar) {
		By by = By.xpath("//*[@text='"+lugar+"']");
		WebElement diaAtencion = webDriver.findElement(by);
		return diaAtencion;
	}
	
	public WebElement tipoCobertura(WebDriver webDriver, String cobertura) {
		By by = By.xpath("//*[@text='"+cobertura+"']");
		WebElement diaAtencion = webDriver.findElement(by);
		return diaAtencion;
	}
	
	public WebElement getPaciente(WebDriver webDriver, String paciente) {
		By by = By.xpath("//*[@text='"+paciente+"']");
		WebElement elementPaciente = webDriver.findElement(by);
		return elementPaciente;
	}
	
	
	@AndroidFindBy(xpath = "//*[@text='ACEPTAR']")
	public WebElement selAceptarDiaAtencion;
	
		
	@AndroidFindBy(xpath = "//*[@text='Tipo de cobertura']")
	public WebElement selTipoCobertura;
	
		
	@AndroidFindBy(xpath = "//*[@text='Continuar']")
	public WebElement btnContinuar;
	
	

	
	
}