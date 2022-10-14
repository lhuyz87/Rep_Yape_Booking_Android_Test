
package rimac.main.util;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableList;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import rimac.main.util.PageObjectUtil2;

import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

public class PageObjectUtil2 {

	// singleton
	private static PageObjectUtil2 obj = null;
	private long wdwTimeOut = 5L;

	private PageObjectUtil2() {
	}

	private final static PointerInput FINGER = new PointerInput(TOUCH, "finger");

    public static void doSwipe(AppiumDriver driver, Point start, Point end, int duration) {
        Sequence swipe = new Sequence(FINGER, 1)
                .addAction(FINGER.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY()))
                .addAction(FINGER.createPointerDown(LEFT.asArg()))
                .addAction(FINGER.createPointerMove(ofMillis(duration), viewport(), end.getX(), end.getY()))
                .addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));
    }

    public void doTap(WebDriver webDriver, Point point, int duration) {
        Sequence tap = new Sequence(FINGER, 1)
                .addAction(FINGER.createPointerMove(ofMillis(0), viewport(), point.getX(), point.getY()))
                .addAction(FINGER.createPointerDown(LEFT.asArg()))
                .addAction(new Pause(FINGER, ofMillis(duration)))
                .addAction(FINGER.createPointerUp(LEFT.asArg()));
        ((RemoteWebDriver) webDriver).perform(Arrays.asList(tap));
    }
    
    
    public void tapElement(AppiumDriver webDriver, WebElement el) {
    	System.out.println("Entra tap element");
	    Rectangle elRect = el.getRect();
	    Point point = new Point(
	        elRect.x + (int)(elRect.getWidth() / 2.0),
	        elRect.y + (int)(elRect.getHeight() / 2.0)
	    );
	    tapAtPoint(webDriver, point);
	}
    
    public void tapAtPoint(AppiumDriver webDriver, Point point) {
//	    AppiumDriver<MobileElement> d = getDriver();  // assuming here a getDriver method
	    PointerInput input = new PointerInput(Kind.TOUCH, "finger1");
	    Sequence tap = new Sequence(input, 0);
	    tap.addAction(input.createPointerMove(Duration.ZERO, Origin.viewport(), point.x, point.y));
	    tap.addAction(input.createPointerDown(MouseButton.LEFT.asArg()));
	    tap.addAction(new Pause(input, Duration.ofMillis(200)));
	    tap.addAction(input.createPointerUp(MouseButton.LEFT.asArg()));
	    webDriver.perform(ImmutableList.of(tap));
	}
    
    
	public void seleniumMobileClick(AndroidDriver androidDriver, final String xpath, int pos){
        By by = MobileBy.id(xpath);
        List<WebElement> lista = androidDriver.findElements(by);

		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);

			if (we.isDisplayed()) {
				we.click();
				sleep(1.5);
			}
		}
    }
	
	public void seleniumMobileiOSClick(IOSDriver iosDriver, final String xpath, int pos){
        By by = MobileBy.id(xpath);
        List<WebElement> lista = iosDriver.findElements(by);

		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);

			if (we.isDisplayed()) {
				we.click();
				sleep(1.5);
			}
		}
    }
	
	public static PageObjectUtil2 getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new PageObjectUtil2();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public void seleniumClick(AppiumDriver webDriver, final String xpath, int pos) {
		By by = AppiumBy.xpath(xpath);
		List<WebElement> lista = webDriver.findElements(by);

		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);

			if (we.isDisplayed()) {
				we.click();
				sleep(1.5);
			}
		}
	}

	public String seleniumGetText(WebDriver webDriver, final String xpath, int pos) {
		By by = By.xpath(xpath);
		List<WebElement> lista = webDriver.findElements(by);
		String texto ="";
		int count=1;
		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);
			do {
				texto = we.getText();
				sleep(1.5);
				count++;
			}while(texto.isEmpty() || count==10);			
		}
		return texto;
	}

	public void seleniumWrite(WebDriver webDriver, final String path, int pos, String valor) {
		By by = By.xpath(path);
		List<WebElement> lista = webDriver.findElements(by);

		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);

			if (we.isDisplayed()) {
				we.click();
				sleep(0.25);
				we.clear();
				we.sendKeys(valor);

				sleep(1);
			}
		}
	}
	
	
	public void seleniumTypeESCKey(WebDriver webDriver, final String path, int pos) {
		By by = By.xpath(path);
		List<WebElement> lista = webDriver.findElements(by);

		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);

			if (we.isDisplayed()) {
				try {
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_ESCAPE);
					robot.keyRelease(KeyEvent.VK_ESCAPE);

				} catch (Exception ex) {
					System.out.println(ex.getMessage());
					ex.printStackTrace();
				}
			}
		}
	}
	
	public void seleniumSelectCombo(WebDriver webDriver, final String path, int pos, String valor) {
		By by = By.xpath(path);
		List<WebElement> lista = webDriver.findElements(by);

		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);

			if (we.isDisplayed()) {
				we.click();			
				Select select=new Select(we);
				select.selectByVisibleText(valor);
				sleep(1);
			}
		}
	}
	
	public WebElement seleniumGetWebElement(WebDriver webDriver, final String xpath, int pos) {
		By by = By.xpath(xpath);
		List<WebElement> lista = webDriver.findElements(by);

		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);
			return we;
		}else
			return null;
	}

	
	public void seleniumScrolltoElementJScript(WebDriver webDriver, final String xpath, int pos) {
		By by = By.xpath(xpath);
		List<WebElement> lista = webDriver.findElements(by);
		
		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);
			JavascriptExecutor jse1 = (JavascriptExecutor) webDriver;
			jse1.executeScript("arguments[0].scrollIntoView(false); arguments[0].scrollIntoView({block: 'center'});", we);
			sleep(1);
		}
	}
	
	
	public void sleep(double seg) {
		long miliseg = (new Double(seg * 1000)).longValue();

		try {
			// System.out.println("sleep:\t\t" + seg + " seg... <--> " + miliseg +
			// "miliseg...");
			Thread.sleep(miliseg);
		} catch (InterruptedException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}


}
