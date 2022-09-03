package rimac.test.screen;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import net.serenitybdd.core.pages.PageObject;
import rimac.test.util.PageObjectUtil2;
import rimac.test.util.VariablesAppNativa;
import rimac.test.xpath.XPathLoginScreen;
import rimac.util.PageObjectUtil;

public class AppLoginPage extends PageObject{

private long wdwTimeOut = 300L;
	
	protected XPathLoginScreen xpathLoginScreen = XPathLoginScreen.getInstancia();

	// util
	protected PageObjectUtil2 pageObjectUtil2 = PageObjectUtil2.getInstancia();
	public static Logger looger = Logger.getLogger(AppLoginPage.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	public void login() {
		looger.info("aplicación iniciada");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		pageObjectUtil2.seleniumClick(getDriver(), xpathLoginScreen.btnIniciarSesion(VariablesAppNativa.platformName), 0);
//		pageObjectUtil2.seleniumClick(getDriver(), xpathLoginScreen.btnIniciarSesion(VariablesAppNativa.platformName), 0);
//		getDriver().findElement((By) By.className("XCUIElementTypeOther").findElement(getDriver().findElement(By.className(""))));
		
		List<WebElement> abc = getDriver().findElements(By.xpath("//XCUIElementTypeStaticText[@name='Iniciar sesión']"));
		System.out.println("nro de elementos: " + abc.size());
		abc.get(0).click();

		Dimension dimension = getDriver().manage().window().getSize();
		Point forTap = new Point((int)(dimension.width*0.5), (int)(dimension.height*0.65));
		pageObjectUtil2.doTap(getDriver(), forTap, 200); //with duration 200ms

		
		System.out.println("intenta tap");
		
		pageObjectUtil2.seleniumClick(getDriver(), xpathLoginScreen.txtUsername, 0);
		
	}
}