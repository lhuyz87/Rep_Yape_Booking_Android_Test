package rimac.main.screen;

import java.util.logging.Logger;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import rimac.main.util.PageObjectUtil2;
import rimac.main.util.VariablesAppNativa;
import rimac.main.xpath.XPathLoginScreen;
import rimac.main.screen.AppLoginPage;

public class AppLoginPage extends BaseScreen{

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
		Dimension dimension = appiumDriver().manage().window().getSize();
		Point forTap = new Point((int)(dimension.width*0.5), (int)(dimension.height*0.65));
		pageObjectUtil2.doTap(appiumDriver(), forTap, 200); //with duration 200ms
		
		pageObjectUtil2.seleniumClick(appiumDriver(), xpathLoginScreen.txtNroDocumento(VariablesAppNativa.platformName), 0);
		pageObjectUtil2.seleniumWrite(appiumDriver(), xpathLoginScreen.txtNroDocumento(VariablesAppNativa.platformName), 0, "88888888");
		
		
	}
}