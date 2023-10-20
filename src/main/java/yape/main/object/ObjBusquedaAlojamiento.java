package yape.main.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import yape.main.object.ObjBusquedaAlojamiento;
import yape.main.util.BaseDriver;

public class ObjBusquedaAlojamiento extends BaseDriver{
	
	// singleton
	private static ObjBusquedaAlojamiento obj = null;

	private ObjBusquedaAlojamiento() {
	}

	public static ObjBusquedaAlojamiento getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjBusquedaAlojamiento();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	
	@AndroidFindBy(xpath = "//*[@text='Empezar a buscar']")
	public WebElement btnEmpezarBuscar;

	@AndroidFindBy(xpath = "//*[@text='Introduce tu destino']")
	public WebElement lblIngresarDestino;
	
	
	@AndroidFindBy(xpath = "//*[@text='Introduce destino']")
	public WebElement txtIngresarDestino;

	@AndroidFindBy(xpath = "//*[@id='facet_search_box_basic_field_label' and ./parent::*[@id='facet_search_box_accommodation_dates']]")
	public WebElement lblFechas;
	
	
	@AndroidFindBy(xpath = "//*[@content-desc='21 octubre 2023']")
	public WebElement auxiliar;
	
	public WebElement diaCalendario(WebDriver webDriver, String dia) {
		System.out.println("//*[@content-desc='"+dia+"']");
		By by = By.xpath("//*[@content-desc='"+dia+"']");
		WebElement diaAtencion = webDriver.findElement(by);
		return diaAtencion;
	}
	
	//*[@text='Cuzco'][1]
	//*[@text='Cuzco' and (./preceding-sibling::* | ./following-sibling::*)[@text='Ciudad de Cuzco, Perú']]
	
	public WebElement lblResultBusquedaDestino(WebDriver webDriver, String destino) {
		By by = By.xpath("//*[@text='"+destino+"']");
		WebElement resultDestino = webDriver.findElement(by);
	
		return resultDestino;
	}
	
	@AndroidFindBy(xpath = "//*[@text='Cuzco' and (./preceding-sibling::* | ./following-sibling::*)[@text='Ciudad de Cuzco, Perú']]")
	public WebElement lblResulBusqueda;

	@AndroidFindBy(xpath = "//*[@text='Seleccionar fechas']")
	public WebElement btnSeleccionarFecha;
	
	@AndroidFindBy(xpath = "//*[@text='1 habitación · 2 adultos · 0 niños']")
	public WebElement lblOcupantes;

//	com.booking:id/bui_input_stepper_buttons_block
	//*[@resource-id='com.booking:id/group_config_rooms_count']//*[@resource-id='com.booking:id/bui_input_stepper_value']
	//*[@resource-id='com.booking:id/bui_input_stepper_value']
	@AndroidFindBy(xpath = "//*[@resource-id='com.booking:id/group_config_rooms_count']//*[@resource-id='com.booking:id/bui_input_stepper_value']")
	public WebElement lblNumHabitaciones;
	
	@AndroidFindBy(xpath = "//*[@resource-id='com.booking:id/group_config_rooms_count']//*[@resource-id='com.booking:id/bui_input_stepper_remove_button']")
	public WebElement btnRemoverHabitacion;
	
	@AndroidFindBy(xpath = "//*[@resource-id='com.booking:id/group_config_rooms_count']//*[@resource-id='com.booking:id/bui_input_stepper_add_button']")
	public WebElement btnAgregarHabitacion;
	

	
	@AndroidFindBy(xpath = "//*[@resource-id='com.booking:id/group_config_adults_count']//*[@resource-id='com.booking:id/bui_input_stepper_value']")
	public WebElement lblNumAdultos;

	@AndroidFindBy(xpath = "//*[@resource-id='com.booking:id/group_config_adults_count']//*[@resource-id='com.booking:id/bui_input_stepper_remove_button']")
	public WebElement btnRemoverAdulto;
	
	@AndroidFindBy(xpath = "//*[@resource-id='com.booking:id/group_config_adults_count']//*[@resource-id='com.booking:id/bui_input_stepper_add_button']")
	public WebElement btnAgregarAdulto;
	
	
	@AndroidFindBy(xpath = "//*[@resource-id='com.booking:id/group_config_children_count']//*[@resource-id='com.booking:id/bui_input_stepper_value']")
	public WebElement lblNinos;
	
	@AndroidFindBy(xpath = "//*[@resource-id='com.booking:id/group_config_children_count]//*[@resource-id='com.booking:id/bui_input_stepper_remove_button']")
	public WebElement btnRemoverNino;
	
	@AndroidFindBy(xpath = "//*[@resource-id='com.booking:id/group_config_children_count']//*[@resource-id='com.booking:id/bui_input_stepper_add_button']")
	public WebElement btnAgregarNino;
	
	
	
	//*[@resource-id='com.booking:id/android.widget.EditText' and ./parent::*[@resource='com.booking:id/bstage1_contact_firstname_value']]
	
	@AndroidFindBy(xpath = "//*[@text='APLICAR']")
	public WebElement btnAplicarPersonas;
	
	
	@AndroidFindBy(xpath = "//*[@resource-id='android:id/numberpicker_input']")
	public WebElement btnSeleccionarEdad;
	
	
	@AndroidFindBy(xpath = "//*[@text='OK']")
	public WebElement btnConfirmarEdad;
	
	
	@AndroidFindBy(xpath = "//*[@text='APLICAR']")
	public WebElement btnAplicarHabitacionPersonas;
	
	
	@AndroidFindBy(xpath = "//*[@text='Buscar']")
	public WebElement btnBuscar;
	
	//*[contains(@text,'Palacio del Inka')]

	public WebElement lblHotel(WebDriver webDriver, String nombreHotel) {
		By by = By.xpath("//*[contains(@text,'"+nombreHotel+"')]");
		WebElement diaAtencion = webDriver.findElement(by);
		return diaAtencion;
	}
	
	
	@AndroidFindBy(xpath = "//*[@text='Elige habitación']")
	public WebElement btnSelHabitacion;
	
	
	@AndroidFindBy(xpath = "//*[@text='Reservar estas opciones']")
	public WebElement btnReservarOpcion;
	
	
	
	

}
