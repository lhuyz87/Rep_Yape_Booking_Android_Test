package rimac.test.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import rimac.main.util.UtilDef;

@RunWith(RunPersonalizar.class)

@CucumberOptions(features = "src/test/resources/features", tags =  "@Login" , glue = "rimac")

public class RunRimac {
	
	@RunBefore
	public static void previo() {
		
		System.out.println("ss");
		
		UtilDef.getInstancia().getProperties();
				
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

		String myCustomProperty1 = variables.getProperty("appium.udid");
		String myCustomProperty2 = variables.getProperty("appium.xcodeOrgId");
		System.out.println(myCustomProperty1 +" - eeeooo - "+myCustomProperty2);
		
	}
	
}