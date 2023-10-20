package yape.main.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import yape.main.object.ObjDatosPago;
import yape.main.util.BaseDriver;

public class ObjDatosPago extends BaseDriver{
	
	// singleton
	private static ObjDatosPago obj = null;

	private ObjDatosPago() {
	}

	public static ObjDatosPago getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjDatosPago();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	

	
	//*[contains(text(),'Palacio del Inka')]

	//*[@resource-id='com.booking:id/new_credit_card_number_edit']
	
	
	//*[@resource-id='com.booking:id/new_credit_card_number_edit']//*[@class='android.widget.EditText']
	@AndroidFindBy(xpath = "//*[@text='Número de la tarjeta']")
	public WebElement txtNumTarjeta;
	
	
	//*[@resource-id='com.booking:id/new_credit_card_expiry_date_edit']//*[@class='android.widget.EditText']
	@AndroidFindBy(xpath = "//*[@text='Fecha de caducidad']")
	public WebElement txtFechaCaducidad;
	
	//*[@resource-id='com.booking:id/informative_click_to_action_container']
	@AndroidFindBy(xpath = "//*[@resource-id='com.booking:id/informative_cta_view_price_container']//*[@resource-id='com.booking:id/title']")
	public WebElement lblMontoPagar;
	
	@AndroidFindBy(xpath = "//*[@text='Después de la reserva pagarás']/following-sibling::*[1]")
	public WebElement lblMontoTotalPagar;

	
	
	@AndroidFindBy(xpath = "//*[@text='Reservar ahora']")
	public WebElement btnReservarAhora;
	
}
