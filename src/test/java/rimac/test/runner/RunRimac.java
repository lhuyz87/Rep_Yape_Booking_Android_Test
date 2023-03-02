package rimac.test.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import rimac.main.util.UtilApp;
import rimac.test.util.ExcelUtilPropio;


@RunWith(RunPersonalizar.class)

//@CucumberOptions(features = "src/test/resources/features", tags =  "@AsistenciaVehicularAuxilioMecanico", glue = "rimac")
//@CucumberOptions(features = "src/test/resources/features", tags =  "@BuscadordeClinicasdesdeTramites", glue = "rimac")

public class RunRimac {
	
	@RunBefore
	public static void previo() {
		
		UtilApp.getInstancia().getProperties();
		ExcelUtilPropio.getInstancia().escribirFeatures();
				
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

		String myCustomProperty1 = variables.getProperty("appium.udid");
		String myCustomProperty2 = variables.getProperty("appium.xcodeOrgId");
		String myCustomProperty3 = variables.getProperty("appium.app");
		System.out.println(myCustomProperty1 +" - eeeooo - "+myCustomProperty2 + " - eeeooo2 - " + myCustomProperty3);
		
	}
	
}

