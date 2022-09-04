package rimac.main.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.screen.AppLoginPage;

public class LoginDefinition {
	
	@Steps
	AppLoginPage appLoginPage;
	
	@Given("inicio el app Mundo Rimac")
	public void inicio_el_app_mundo_rimac() {
		appLoginPage.login();
	}
	@When("selecciono el producto {string}")
	public void selecciono_el_producto(String string) {

	}

}
