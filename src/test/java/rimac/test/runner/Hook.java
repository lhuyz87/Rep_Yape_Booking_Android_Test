package rimac.test.runner;

import io.cucumber.java.After;
import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.steps.StepEventBus;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import rimac.main.util.BaseDriver;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Hook extends BaseDriver {
    static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

   @After
    public void tearDown() throws InvalidKeyException, NoSuchAlgorithmException {

        String v_environment = variables.getProperty("environment");
        System.out.println(v_environment);

        if (!v_environment.contains("local")) {
            TestOutcome outcome = StepEventBus.getEventBus().getBaseStepListener().getCurrentTestOutcome();
            System.out.println("SauceOnDemandSessionID="+appiumDriver().getSessionId().toString()+ " job-name="+outcome.getCompleteName());
            if(outcome.isSuccess()) {
                appiumDriver().executeScript("sauce:job-result=passed");
            }else {
//				sendEmail(outcome);
                appiumDriver().executeScript("sauce:job-result=failed");
            }
        }
    }
}
