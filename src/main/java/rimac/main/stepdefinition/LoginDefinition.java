package rimac.main.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.screen.AppLoginScreen;

public class LoginDefinition {
	
	@Steps
	AppLoginScreen appLoginPage;
	
	@Given("inicio el app Mundo Rimac {string}, {string}")
	public void inicio_el_app_mundo_rimac(String dniUser, String passUser) {
		appLoginPage.login(dniUser, passUser);
	}
	
	@When("selecciono el producto {string}")
	public void selecciono_el_producto(String string) {

	}

}
