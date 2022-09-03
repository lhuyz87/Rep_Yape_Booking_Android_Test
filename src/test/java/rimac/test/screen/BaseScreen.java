package rimac.test.screen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;

public class BaseScreen extends PageObject {

	public AndroidDriver androidDriver() {
        return (AndroidDriver)
                ((WebDriverFacade) getDriver()).getProxiedDriver();
    }
    
	public IOSDriver iosDriver() {
        return (IOSDriver)
                ((WebDriverFacade) getDriver()).getProxiedDriver();
    }
    
}
