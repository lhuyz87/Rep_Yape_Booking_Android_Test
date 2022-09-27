package rimac.main.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.screen.AppLoginPage;
import rimac.main.screen.PaginaPrincipalScreen;
import rimac.main.screen.ReemDocCobertMedicaScreen;
import rimac.main.screen.TusTramitesScreen;
import rimac.main.screen.IniciarReembolsoSaludScreen;
import rimac.main.screen.ComencemosReembolsoSaludScreen;
import rimac.main.screen.ConfirmarDatosReembolsoSaludScreen;
import rimac.main.screen.DocRequeridosReembolsoSaludScreen;
import rimac.main.screen.RegistrarHuellaScreen;

public class ReembolsoDefinition {
	
	@Steps
	AppLoginPage appLoginPage;
	
	@Steps
	PaginaPrincipalScreen paginaPrincipalScreen;
	
	@Steps
	TusTramitesScreen tusTramitesScreen;
	
	@Steps
	IniciarReembolsoSaludScreen iniciarReembolsoSaludScreen;
	
	@Steps
	ComencemosReembolsoSaludScreen comencemosReembolsoSaludScreen;
	
	@Steps
	ConfirmarDatosReembolsoSaludScreen confirmarDatosReembolsoSaludScreen;
	
	@Steps
	DocRequeridosReembolsoSaludScreen docRequeridosReembolsoSaludScreen;
	
	@Steps
	RegistrarHuellaScreen registrarHuellaScreen;
	
	@Steps
	ReemDocCobertMedicaScreen reemDocCobertMedicaScreen;
	
	
	
	
	
	@Given("realiza el login con credenciales {string}, {string} y {string}")
	public void realiza_el_login_con_credenciales_y(String tipo, String id, String numero) {
	    // Write code here that turns the phrase above into concrete actions
		appLoginPage.login(id, numero);
	}

	@When("se ingresa a reembolso y se inicia el tramite")
	public void se_ingresa_a_reembolso_y_se_inicia_el_tramite() {
	    // Write code here that turns the phrase above into concrete actions
		registrarHuellaScreen.seleccionarOpcionRegistrarHuella("Por ahora no");
		paginaPrincipalScreen.seleccionarOpcionPrincipal("Tramites");
		tusTramitesScreen.seleccionarTramiteSalud("Reembolso de salud");
		iniciarReembolsoSaludScreen.seleccionarEmpezarReembolso();
	}

	@And("se registra los datos del reembolso {string} , {string}, {string} y {string}")
	public void se_registra_los_datos_del_reembolso_y(String prodContratante, String lugarAtencion, String fechaAtencion, String tipoCobert) {
	    // Write code here that turns the phrase above into concrete actions
		comencemosReembolsoSaludScreen.llenarDatosTramites(prodContratante, lugarAtencion, fechaAtencion, tipoCobert);
	}

	@And("registramos los datos del contacto: {string}, {string}  y direccion: {string}, {string}, {string} y {string}")
	public void registramos_los_datos_del_contacto_y_direccion_y(String mail, String telefono, String departamento, String provincia, String distrito , String direccion) {
	    // Write code here that turns the phrase above into concrete actions
		confirmarDatosReembolsoSaludScreen.llenarDatosDireccion(departamento, provincia, distrito, direccion);
	}

	@And("adjuntamos los documentos necesarios de la cobertura")
	public void adjuntamos_los_documentos_necesarios_de_la_cobertura() {
	    // Write code here that turns the phrase above into concrete actions
		docRequeridosReembolsoSaludScreen.continuarDocRequeridos();
		reemDocCobertMedicaScreen.AdjuntarFotoArchivo("AdjuntarArchivo");
	}

	@Then("podra validar la notificacion: Solicitud de reembolso recibida")
	public void podra_validar_la_notificacion_solicitud_de_reembolso_recibida() {
	    // Write code here that turns the phrase above into concrete actions
		
	}
	
	
	
	
	



}
