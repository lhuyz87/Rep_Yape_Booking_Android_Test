package rimac.main.object;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import rimac.main.util.BaseDriver;

public class ObjTuContraCambiaConExito extends BaseDriver{
	
	// singleton
	private static ObjTuContraCambiaConExito obj = null;

	private ObjTuContraCambiaConExito() {
	}

	public static ObjTuContraCambiaConExito getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjTuContraCambiaConExito();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	@AndroidFindBy(id = "com.rimac.rimac_surrogas:id/materialBtn")
	public WebElement btnIrInicio;
	
	@AndroidFindBy(id = "com.rimac.rimac_surrogas:id/forgetCongratulationTextTitle")
	public WebElement lblMensaj;
	
	
}
