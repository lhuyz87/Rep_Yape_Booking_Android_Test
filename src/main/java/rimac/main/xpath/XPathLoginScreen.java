package rimac.main.xpath;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import rimac.main.xpath.XPathLoginScreen;

public class XPathLoginScreen {
	
	// singleton
	private static XPathLoginScreen obj = null;

	private XPathLoginScreen() {
	}

	public static XPathLoginScreen getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new XPathLoginScreen();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	//XCUIElementTypeButton[contains(@text, 'Iniciar sesión')]
	//XCUIElementTypeStaticText[@name='193930 Copy 1']/following-sibling::XCUIElementTypeButton
	//*[@class='UIAButton' and (./preceding-sibling::* | ./following-sibling::*)[@class='UIAView' and ./*[./*[@text='Iniciar sesión']]] and ./*[@class='UIAStaticText']]
	//*[@class='UIAView' and ./*[@class='UIAView' and ./*[@class='UIAView' and ./*[@class='UIAView'] and ./*[@class='UIAButton']]]]
	public final String btnIniciarSesion ="//*[@text='Iniciar sesión']";
	public final String txtUsername = "//*[@name='test-Username']";
	public final String txtPassword = "//*[@name='test-Password']";
	public final String btnLogin = "//*[@name='test-LOGINxxx']";
	
	public final String btnIniciarSesion(String platformName) {
		System.out.println("La plataforma es: "+platformName);
		if(platformName.compareTo("IOS")==0)
			return "sx";
		else
			return "com.rimac.rimac_surrogas:id/materialBtn";
	}
	
	public final String txtNroDocumento(String platformName) {
		if(platformName.compareTo("IOS")==0)
			return "//XCUIElementTypeTextField[@name='Nº de documento']";
		else
			return "com.rimac.rimac_surrogas:id/materialBtn";
	}
	
	
}
