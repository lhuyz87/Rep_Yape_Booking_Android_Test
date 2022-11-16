package rimac.app.bs;

import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;

import net.thucydides.core.environment.SystemEnvironmentVariables;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
//import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.appium.java_client.AppiumDriver;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserStackSerenityDriver implements DriverSource {

    public AppiumDriver newDriver() {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

        
        String buildName  = System.getenv("BROWSERSTACK_BUILD_NAME");
//      System.out.println("***********"  + System.getenv("BROWSERSTACK_USERNAME"));
      if (buildName == null) {
    	  buildName = (String) environmentVariables.getProperty("environment.single.build");
      }
        
        String username = System.getenv("BROWSERSTACK_USERNAME");
//        System.out.println("***********"  + System.getenv("BROWSERSTACK_USERNAME"));
        if (username == null) {
            username = (String) environmentVariables.getProperty("browserstack.user");
        }

        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        if (accessKey == null) {
            accessKey = (String) environmentVariables.getProperty("browserstack.key");
        }

//        String environment = System.getProperty("environment");
        String environment = System.getProperty("environment");
        environment="single";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
        System.out.println("***********"  + environment);

        Iterator it = environmentVariables.getKeys().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();

            if (key.equals("browserstack.user") || key.equals("browserstack.key")
                    || key.equals("browserstack.server")) {
                continue;
            } else if (key.startsWith("bstack_")) {
                if (key.contains("app")){
                    String appId = System.getenv("BROWSERSTACK_APP_ID");
                    if(appId == null){
                        appId = environmentVariables.getProperty(key);
                    }
                    capabilities.setCapability(key.replace("bstack_", ""),appId);
                } else
                    capabilities.setCapability(key.replace("bstack_", ""), environmentVariables.getProperty(key));
                	System.out.println("asdasd " + environmentVariables.getProperty(key));
                if (key.equals("bstack_browserstack.local")
                        && environmentVariables.getProperty(key).equalsIgnoreCase("true")) {
                	System.out.println("asdasd " + environmentVariables.getProperty(key));
                    System.setProperty("browserstack.local", "true");
                }
            } else if (environment != null && key.startsWith("environment." + environment)) {
                capabilities.setCapability(key.replace("environment." + environment + ".", ""),environmentVariables.getProperty(key));
                if (key.equals("environment." + environment + ".browserstack.local")
                        && environmentVariables.getProperty(key).equalsIgnoreCase("true")) {
                    System.setProperty("browserstack.local", "true");
                }
            }
        }
        System.out.println("capas " + capabilities.asMap());
        try {
        	System.out.println("Device " + capabilities.getCapability("device").toString());
            if(capabilities.getCapability("device").toString().contains("iP")){
                IOSDriver driver = new IOSDriver(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);
                System.out.println("Driver IOS "  + driver);
                return driver;
            }
            else{
                AndroidDriver driver = new AndroidDriver(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);
                System.out.println("Driver Android " + driver);
                return driver;
            }
        } catch (Exception e) {
            System.out.println("@@@\t"+e.getMessage() + "\n!!!\t" +e.getCause());
//            System.out.println(e);
            return null;
        }
    }

    public boolean takesScreenshots() {
        return true;
    }
}