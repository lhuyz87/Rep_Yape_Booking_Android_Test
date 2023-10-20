package yape.main.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import yape.main.object.ObjDatosCliente;
import yape.main.util.BaseDriver;

public class ObjDatosCliente extends BaseDriver{
	
	// singleton
	private static ObjDatosCliente obj = null;

	private ObjDatosCliente() {
	}

	public static ObjDatosCliente getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjDatosCliente();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	

	
	//*[contains(text(),'Palacio del Inka')]

	//*[@class='android.widget.EditText' and ./parent::*[@id='bstage1_contact_firstname_value']]"
	//*[@class='android.widget.EditText' and @name='nombre1']

	@AndroidFindBy(xpath = "//*[@resource-id='com.booking:id/bstage1_contact_firstname_value']//*[@class='android.widget.EditText']")
	public WebElement txtNombre;
	
	//*[@resource-id='com.booking:id/bstage1_contact_lastname_value']//*[@class='android.widget.EditText']
	@AndroidFindBy(xpath = "//*[@resource-id='com.booking:id/bstage1_contact_lastname_value']//*[@class='android.widget.EditText']")
	public WebElement txtApellido;
	
	//*[@resource-id='com.booking:id/bstage1_contact_email_value']//*[@class='android.widget.EditText']
	@AndroidFindBy(xpath = "//*[@resource-id='com.booking:id/bstage1_contact_email_value']//*[@class='android.widget.EditText']")
	public WebElement txtMail;
	
	//*[@resource-id='com.booking:id/bstage1_contact_address_value']//*[@class='android.widget.EditText']
	@AndroidFindBy(xpath = "//*[@resource-id='com.booking:id/bstage1_contact_address_value']//*[@class='android.widget.EditText']")
	public WebElement txtDireccion;
	
	//*[@resource-id='com.booking:id/bstage1_contact_zipcode_value']//*[@class='android.widget.EditText']
	@AndroidFindBy(xpath = "//*[@resource-id='com.booking:id/bstage1_contact_zipcode_value']//*[@class='android.widget.EditText']")
	public WebElement txtCodigoPostal;
	
	//*[@resource-id='com.booking:id/bstage1_contact_city_value']//*[@class='android.widget.EditText']
	
	@AndroidFindBy(xpath = "//*[@resource-id='com.booking:id/bstage1_contact_city_value']//*[@class='android.widget.EditText']")
	public WebElement txtCiudad;
	
	//*[@resource-id='com.booking:id/bstage1_contact_country_value']//*[@class='android.widget.EditText']
	@AndroidFindBy(xpath = "//*[@resource-id='com.booking:id/bstage1_contact_country_value']//*[@class='android.widget.EditText']")
	public WebElement txtPaisRegion;
	
	//*[@resource-id='com.booking:id/bstage1_contact_firstname_value']//*[@class='android.widget.EditText']
	@AndroidFindBy(xpath = "//*[@resource-id='com.booking:id/bstage1_contact_telephone_value']//*[@class='android.widget.EditText']")
	public WebElement txtTelefono;
	
	
	public WebElement radBtnMotivoViaje(WebDriver webDriver, String motivoViaje) {
		By by = By.xpath("//*[@text='"+motivoViaje+"']");
		WebElement diaAtencion = webDriver.findElement(by);
		return diaAtencion;
	}
	
	@AndroidFindBy(xpath = "//*[@text='Siguiente paso']")
	public WebElement btnSiguientePaso;
	
	@AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and ./parent::*[@id='bstage1_contact_firstname_value']]")
	public WebElement btnAgregarDatos;

}
