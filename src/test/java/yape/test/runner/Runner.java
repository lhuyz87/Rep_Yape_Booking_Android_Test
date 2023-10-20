package yape.test.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import yape.main.util.UtilApp;
import yape.test.util.ExcelUtilPropio;


@RunWith(RunPersonalizar.class)

@CucumberOptions(features = "src/test/resources/features", tags =  "@ValidarRealizacionReserva", glue = "yape")
//@CucumberOptions(features = "src/test/resources/features", tags =  "@SucripcionDesdePerfil", glue = "rimac")

public class Runner {
	
	@RunBefore
	public static void previo() {
		
		UtilApp.getInstancia().getProperties();
//		ExcelUtilPropio.getInstancia().escribirFeatures();
//		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

	}
	
}

