package yape.main.step;

import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.Map;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import java.util.List;
import java.util.logging.Logger;

import yape.main.screen.*;
import yape.main.util.UtilApp;
import yape.main.util.Variables;

public class StepLogin {
	
	@Steps
	ScLogin scLogin;
	
	@Steps
	ScBusquedaAlojamiento scBusquedaAlojamiento;
	


	public static Logger looger = Logger.getLogger(ScLogin.class.getName());
	
	UtilApp utilApp = new UtilApp();
	
	@Step()
	public void realizarLogin(String tipoLogin) {

		if(tipoLogin.compareTo("Google")==0) {
			scLogin.ingresarCuentaGoogle();
		}
		
		
		scBusquedaAlojamiento.selMensajeBienvenida();
			
		}
	
	
}

