package rimac.main.util;

//import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
//import rimac.util.GeneralUtil;

public class VariablesAppNativa {
	
	static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
	
	public static final String platformName = variables.getProperty("appium.platformName");
//	public static final String dniUser = GeneralUtil.getInstancia().getVarEnvPro("dniUser");
//	public static final String passUser = GeneralUtil.getInstancia().getVarEnvPro("passUser");

}
