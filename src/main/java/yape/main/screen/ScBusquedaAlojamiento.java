package yape.main.screen;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import com.github.dockerjava.api.model.Driver;

//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.PushesFiles;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import yape.main.object.ObjBusquedaAlojamiento;
import yape.main.util.BaseDriver;
import yape.main.util.MobileObjectUtil;
import yape.main.util.UtilApp;
import yape.main.util.VariablesAppNativa;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

import static org.junit.Assert.assertFalse;


public class ScBusquedaAlojamiento extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjBusquedaAlojamiento objBusquedaAlojamiento = ObjBusquedaAlojamiento.getInstancia();

	
	
	public static Logger looger = Logger.getLogger(ScBusquedaAlojamiento.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilApp util = new UtilApp();
	AndroidDriver driver;

	public void selMensajeBienvenida() {
		// TODO Auto-generated method stub
		util.esperarActivoClick(1, objBusquedaAlojamiento.btnEmpezarBuscar);
		util.clickOn(objBusquedaAlojamiento.btnEmpezarBuscar);
	}


	public void ingresarDestino(String destino) {
		util.esperarActivoClick(1, objBusquedaAlojamiento.lblIngresarDestino);
		element(objBusquedaAlojamiento.lblIngresarDestino).click();
		element(objBusquedaAlojamiento.txtIngresarDestino).sendKeys(destino);
		util.esperarSegundos(2);
//		element(objBusquedaAlojamiento.lblResultBusquedaDestino(getDriver(), destino)).click();
		util.clickOn(objBusquedaAlojamiento.lblResulBusqueda);
		
	}


	public void ingresarFechas(String ida, String vuelta) {
		// TODO Auto-generated method stub
		

		util.esperarActivoClick(3, objBusquedaAlojamiento.diaCalendario(getDriver(), ida));
		util.clickOn(objBusquedaAlojamiento.diaCalendario(getDriver(), ida));
		util.esperarActivoClick(3, objBusquedaAlojamiento.diaCalendario(getDriver(), vuelta));
		util.clickOn(objBusquedaAlojamiento.diaCalendario(getDriver(), vuelta));
		util.esperarSegundos(2);
		element(objBusquedaAlojamiento.btnSeleccionarFecha).click();
		util.esperarSegundos(2);
		
	}


	public void ingresarHabitacion(String habitacion) {
		// TODO Auto-generated method stub
		int numHabitaciones = Integer.parseInt(habitacion);
		
		util.esperarElemento(3, objBusquedaAlojamiento.lblOcupantes);
		element(objBusquedaAlojamiento.lblOcupantes).click();
		util.esperarElemento(3, objBusquedaAlojamiento.lblNumHabitaciones);
		
		while(Integer.parseInt(objBusquedaAlojamiento.lblNumHabitaciones.getText())<numHabitaciones) {
			element(objBusquedaAlojamiento.btnAgregarHabitacion).click();
		}
		
	}


	public void ingresarAdultos(String adultos) {
		// TODO Auto-generated method stub
		int numAdultos = Integer.parseInt(adultos);
		util.esperarElemento(3, objBusquedaAlojamiento.lblNumAdultos);
		while(Integer.parseInt(objBusquedaAlojamiento.lblNumAdultos.getText())<numAdultos) {
			element(objBusquedaAlojamiento.btnAgregarAdulto).click();
		}
	}
	
	
	public void ingresarNinos(String ninos, String edad) {
		// TODO Auto-generated method stub
		int numNinos = Integer.parseInt(ninos);
		int numNinosMostrado=Integer.parseInt(objBusquedaAlojamiento.lblNinos.getText());
		util.esperarElemento(3, objBusquedaAlojamiento.lblNinos);
		while(numNinosMostrado<numNinos) {
			element(objBusquedaAlojamiento.btnAgregarNino).click();
			numNinosMostrado++;
			util.esperarElemento(3, objBusquedaAlojamiento.btnSeleccionarEdad);
//			for(int i=0; i<20;i++) {
//				System.out.println(objBusquedaAlojamiento.btnSeleccionarEdad.getText()  + " vs " + edad);
//				if(objBusquedaAlojamiento.btnSeleccionarEdad.getText().compareTo(edad)==0) {
//					break;
//				}
//				
////				util.scrollDown(getDriver());
////				util.scrollUno(getDriver(),"5 años");
//				
//			}
			
			while(objBusquedaAlojamiento.btnSeleccionarEdad.getText().compareTo(edad)!=0)
			{
				WebElement objetoDesplazable =  getDriver().findElement(By.xpath("//*[@resource-id='android:id/parentPanel']"));
				int startX =  objetoDesplazable.getLocation().getX()  + objetoDesplazable.getSize().getWidth()/2;
				int startY =  objetoDesplazable.getLocation().getY()  + objetoDesplazable.getSize().getHeight()*2/3;
				int endY =  objetoDesplazable.getLocation().getY()  + objetoDesplazable.getSize().getHeight()*1/3;
					
				TouchAction touchAction = new TouchAction(androidDriver());
				
				touchAction.press(PointOption.point(startX, startY))
		           .moveTo(PointOption.point(startX, endY))
		           .release()
		           .perform();
				
			}
			
			System.out.println("Se encuentra elemento");
			
			element(objBusquedaAlojamiento.btnConfirmarEdad).click();
			element(objBusquedaAlojamiento.btnAplicarPersonas).click();
//			util.esperarSegundos(18);
			
//			util.localizarElementoPorTexto(appiumDriver(), objBusquedaAlojamiento.btnSeleccionarEdad,edad);
		
		}
	}


	public void seleccionarBuscar() {
		// TODO Auto-generated method stub
		util.esperarElemento(3, objBusquedaAlojamiento.btnBuscar);
		element(objBusquedaAlojamiento.btnBuscar).click();
	}


	public void seleccionarHotel(String hotel) {
		// TODO Auto-generated method stub
		util.esperarElemento(3, objBusquedaAlojamiento.lblHotel(getDriver(), hotel));
		element(objBusquedaAlojamiento.lblHotel(getDriver(), hotel)).click();
	}


	public void confHabitacion() {
		// TODO Auto-generated method stub
		util.esperarElemento(3, objBusquedaAlojamiento.btnSelHabitacion);
		element(objBusquedaAlojamiento.btnSelHabitacion).click();
		element(objBusquedaAlojamiento.btnReservarOpcion).click();
		util.esperarSegundos(5);
	}
}