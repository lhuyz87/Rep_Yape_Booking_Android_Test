package rimac.main.definition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.screen.ScLogin;
import rimac.main.step.StepLogin;
import static org.junit.Assert.assertEquals;
public class LoginDefinition {
	
	@Steps
	ScLogin appLoginPage;
	
	@Steps
	StepLogin stepLogin;
	
	@Given("inicio el app Mundo Rimac {string}, {string}")
	public void inicio_el_app_mundo_rimac(String dniUser, String passUser) {
		appLoginPage.login(dniUser, passUser);
	}
	
//	@When("selecciono el producto {string}")
//	public void selecciono_el_producto(String string) {
//
//	}
	
	@Given("realiza el login con credenciales")
	public void realiza_el_login_con_credenciales(DataTable userCredentials) {
		stepLogin.realiza_el_login_con_credenciales(userCredentials);
		
	}
	
	
	@Given("se selecciona la opción ¿Olvidaste tu contraseña?")
	public void se_selecciona_la_opción_olvidaste_tu_contraseña() {
	    // Write code here that turns the phrase above into concrete actions
		stepLogin.seleccOlvidaContra();
	}
	@Given("se ingresa el tipo y número de documento: {string}, {string}")
	public void se_ingresa_el_tipo_y_número_de_documento(String tipo, String id) {
	    // Write code here that turns the phrase above into concrete actions
		stepLogin.ingresDocumen(id);
	}
	@When("se selecciona la opción Responder Preguntas")
	public void se_selecciona_la_opción_responder_preguntas() {
	    // Write code here that turns the phrase above into concrete actions
		stepLogin.seleccResponPregun();
	}
	@When("se ingresa la fecha de nacimiento {string} y los seguros {string} que cuenta el cliente")
	public void se_ingresa_la_fecha_de_nacimiento_y_los_seguros_que_cuenta_el_cliente(String fechaNacimi, String seguros) {
	    // Write code here that turns the phrase above into concrete actions
		stepLogin.seleccDatosdeSeguri(fechaNacimi, seguros);
	}
	@Then("debe permitir el ingreso de una nueva contraseña")
	public void debe_permitir_el_ingreso_de_una_nueva_contraseña() {
	    // Write code here that turns the phrase above into concrete actions
		stepLogin.ingresaNuevaContra();
	}
	@Then("debe de aparecer el mensaje de {string}")
	public void debe_de_aparecer_el_mensaje_de(String valorEspera) {
	    // Write code here that turns the phrase above into concrete actions
		String valorActual = stepLogin.obtenerTituloMensaje();
		assertEquals(valorEspera, valorActual);
	}

}
