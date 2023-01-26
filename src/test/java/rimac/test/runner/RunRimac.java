package rimac.test.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
//import net.thucydides.core.environment.SystemEnvironmentVariables;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import rimac.main.util.UtilApp;


@RunWith(RunPersonalizar.class)

//@CucumberOptions(features = "src/test/resources/features", tags =  "@AsistenciaVehicularAuxilioMecanico", glue = "rimac")
//@CucumberOptions(features = "src/test/resources/features", tags =  "@TiempoInactividadModulo", glue = "rimac")

public class RunRimac {
	
	@RunBefore
	public static void previo() {
		
		System.out.println("ss");
		
		UtilApp.getInstancia().getProperties();
				
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

		String myCustomProperty1 = variables.getProperty("appium.udid");
		String myCustomProperty2 = variables.getProperty("appium.xcodeOrgId");
		System.out.println(myCustomProperty1 +" - eeeooo - "+myCustomProperty2);
		
	}
	
}

