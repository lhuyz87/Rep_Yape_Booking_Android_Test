package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PushesFiles;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import rimac.main.object.ObjComentariosAdicionales;
import rimac.main.object.ObjConsultaReembolso;
import rimac.main.object.ObjCuentaDeAbono;
import rimac.main.object.ObjSolicitudReembolsoRecibida;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilApp;
import rimac.main.util.VariablesAppNativa;



public class ScConsultaReembolso extends BaseDriver {

	private long wdwTimeOut = 300L;


	protected ObjConsultaReembolso objConsultaReembolso = ObjConsultaReembolso.getInstancia();


	// util
	public static Logger looger = Logger.getLogger(ScConsultaReembolso.class.getName());

	public long getWdwTimeOut() {
		return wdwTimeOut;
	}

	UtilApp util = new UtilApp();
	AppiumDriver driver;

	public String obtenerMonto(String monto) {

		util.esperarElemento(3, objConsultaReembolso.btnFiltro);
		String montoEncontrado = "";
		String montoObtenido = "";
		int aux = 0;
		while (aux < 10) {
			for (int i = 0; i < objConsultaReembolso.lblMontoReembolso.size(); i++) {
				montoObtenido = (objConsultaReembolso.lblMontoReembolso.get(i).getText());
				montoEncontrado = montoObtenido.substring(3, montoObtenido.length() - 3);
				if (montoEncontrado.equals(monto)) {
					Serenity.takeScreenshot();
					aux = 10;
					break;
				}
			}
			util.mobileSwipeScreenAndroid();
			aux++;
		}
		return montoEncontrado;
	}

}
