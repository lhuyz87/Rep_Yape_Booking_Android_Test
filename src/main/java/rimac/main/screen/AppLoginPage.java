package rimac.main.screen;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rimac.main.util.PageObjectUtil2;
import rimac.main.util.UtilDef;
import rimac.main.util.VariablesAppNativa;
import rimac.main.object.ObjectLoginScreen;
import rimac.main.screen.AppLoginPage;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class AppLoginPage extends BaseScreen{

private long wdwTimeOut = 300L;
	
	protected ObjectLoginScreen xpathLoginScreen = ObjectLoginScreen.getInstancia();

	// util
	protected PageObjectUtil2 pageObjectUtil2 = PageObjectUtil2.getInstancia();
	public static Logger looger = Logger.getLogger(AppLoginPage.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilDef util = new UtilDef();
	
	@AndroidFindBy(xpath = "//*[@text='Iniciar sesión']")
	WebElement btnIngresarSesion;
	
	@AndroidFindBy(xpath = "//*[@text='Nº de documento']")
	WebElement txtNumDocumento;
	
	@AndroidFindBy(xpath = "//*[@text='Contraseña']")
	WebElement txtPassword;
	
	@AndroidFindBy(xpath = "//*[@text='Iniciar sesión']")
	WebElement btnAceptarCredenciales;
	
	public void login3() {
			looger.info("aplicación iniciada");
		
			waitForCondition().until(
		            ExpectedConditions.elementToBeClickable(appiumDriver().findElement(By.xpath("//*[@text='Iniciar sesión']")))
		    );	
	
		pageObjectUtil2.seleniumClick(appiumDriver(), "//*[@text='Iniciar sesión']",0);
		
		waitForCondition().until(
	            ExpectedConditions.elementToBeClickable(appiumDriver().findElement(By.xpath("//*[@id='dropdownEditText']")))
	    );
		pageObjectUtil2.seleniumWrite(appiumDriver(), "//*[@id='dropdownEditText']", 0, "44147610");
//		pageObjectUtil2.seleniumWrite(appiumDriver(), xpathLoginScreen.txtPass(VariablesAppNativa.platformName), 0, VariablesAppNativa.passUser);
//		pageObjectUtil2.seleniumClick(appiumDriver(), xpathLoginScreen.btnDone(VariablesAppNativa.platformName), 0);
//		pageObjectUtil2.seleniumClick(appiumDriver(), xpathLoginScreen.btnIniciarSesion(VariablesAppNativa.platformName), 0);
//		
//		pageObjectUtil2.seleniumClick(appiumDriver(), xpathFaceID.btnPorAhoraNo(VariablesAppNativa.platformName), 0);
//		
//		pageObjectUtil2.seleniumClick(appiumDriver(), xpathNotificaciones.btnAceptar(VariablesAppNativa.platformName), 0);
	}
		
	
	public void login() {
		looger.info("aplicación iniciada");
		util.esperarElemento(10, btnIngresarSesion);
		element(btnIngresarSesion).click();
		element(txtNumDocumento).click();
		element(txtNumDocumento).sendKeys("76243722");
		element(txtPassword).click();
		element(txtPassword).sendKeys("Rimac2021");
		element(btnAceptarCredenciales).click();

		
	}
}