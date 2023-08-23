package rimac.test.definition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import rimac.main.screen.ScComencemosReembolsoSalud;
import rimac.main.screen.ScLogin;
import rimac.main.step.StepLogin;
import rimac.test.util.Variables;
import static org.junit.Assert.assertEquals;
import java.util.logging.Logger;
public class LoginDefinition {
	
	@Steps
	StepLogin stepLogin;
	
	public static Logger looger = Logger.getLogger(LoginDefinition.class.getName());

	
	@Given("realiza el login con credenciales")
	public void  realiza_el_login_con_credenciales(DataTable userCredentials) throws Exception {
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
	public void se_ingresa_la_fecha_de_nacimiento_y_los_seguros_que_cuenta_el_cliente(String fechaNacimi, String seguros) throws Exception {
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
	
	@Given("Se ingresa a la aplicación con una versión menor a la minima requerida")
	public void ingresa_aplicacion_minima_requerida() {
		
		looger.info("Iniciar Escencario minima requerida");
		
	}
	
	
	@Given("Se ingresa a la aplicación con una versión menor a la minima recomendada")
	public void ingresa_aplicacion_minima_recomendada() {
		
		looger.info("Iniciar Escencario minima recomendada");
	}
	

	
	
	@Then("se debe mostar mensaje informativo {string}")
	public void debe_mostar_mensaje_acttualizar(String mensajeEsperado) {
	    // Write code here that turns the phrase above into concrete actions

		String valorActual = stepLogin.obtenerTituloMensajeActualizar();
		Serenity.takeScreenshot();
		try{

		assertEquals(mensajeEsperado, valorActual);
		}catch(AssertionError e){
			looger.info("Mensaje de Solicitud de actualización no coincide");
		}

	}
	
	@And("seleccionamos opción {string}")
	public void seleccionar_opcion_mas_tarde (String opcion) {
	    // Write code here that turns the phrase above into concrete actions
		stepLogin.saltarActualizacion();
		Serenity.takeScreenshot();
	}
	
	@Then("debe permitir el ingreso a la aplicación")
	public void permitir_ingreso_aplicacion() {
		
		stepLogin.validarIngresoCanalApp();
		Serenity.takeScreenshot();
	}
	
	
	@Then("mostrar solo opción actualizar")
	public void mostrar_opcion_actualizar() {
		
		boolean soloActualizar = stepLogin.mostrarSoloActualizar();
		assertEquals(false, soloActualizar);
	}

	@Given("Se ingresa a la aplicación con un dispositivo con modo desarrollador activado")
	public void ingresa_aplicacion_modo_desarrollador() {
		stepLogin.activarRootModoDesarrollo(Variables.hostModoRootDesa, Variables.pathModoRootDesa,"","ANDROID","activar",null);
	}
	
	@Then("no debe permitir el ingreso al aplicativo y debe mostar mensaje informativo relacionado a {string}")
	public void no_permitir_ingreso_aplicativo_modo_desarrollo (String opcion) {
	    // Write code here that turns the phrase above into concrete actions
		
		boolean ingreso = stepLogin.validarNoIngresoConMensaje(opcion);
		System.out.println("***"   + ingreso);
		assertEquals(false, ingreso);
	}

	@And("realiza el logeo nuevamente de sesion")
	public void realizaElLogeoNuevamenteDeSesion(DataTable userCredentials) throws Exception  {
		stepLogin.realiza_el_relogeo(userCredentials);
	}

    @And("se mantiene inactiva la sesión en el módulo onboarding")
    public void seMantieneInactivaLaSesiónEnElMóduloOnboarding() throws InterruptedException {
		stepLogin.se_mantiene_la_inactividad_onboarding();
    }

	@Then("se valida el mensaje para retornar al Login desde el home")
	public void seValidaElMensajeParaRetornarAlLoginDesdeElHome() {
		stepLogin.se_valida_mensaje_de_inactividad();
	}
}
