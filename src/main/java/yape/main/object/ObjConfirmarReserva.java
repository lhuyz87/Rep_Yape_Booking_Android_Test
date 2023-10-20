package yape.main.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import yape.main.object.ObjConfirmarReserva;
import yape.main.util.BaseDriver;

public class ObjConfirmarReserva extends BaseDriver{
	
	// singleton
	private static ObjConfirmarReserva obj = null;

	private ObjConfirmarReserva() {
	}

	public static ObjConfirmarReserva getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjConfirmarReserva();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	@AndroidFindBy(xpath = "//*[@text='Confirmación de la reserva']")
	public WebElement lblReservaConfirmada;
	




	
	
	
	
	

}
