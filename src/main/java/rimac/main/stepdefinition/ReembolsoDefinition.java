package rimac.main.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.screen.AppLoginScreen;
import rimac.main.screen.ScHome;
import rimac.main.screen.ReemDocCobertMedicaScreen;
import rimac.main.screen.TusTramitesScreen;
import rimac.main.screen.IniciarReembolsoSaludScreen;
import rimac.main.screen.ComencemosReembolsoSaludScreen;
import rimac.main.screen.ConfirmarDatosReembolsoSaludScreen;
import rimac.main.screen.DocRequeridosReembolsoSaludScreen;
import rimac.main.screen.RegistrarHuellaScreen;
import rimac.main.screen.AgregarNuevoDocumentoScreen;
import rimac.main.screen.CuentaDeAbonoScreen;
import rimac.main.screen.SolicitudReembolsoRecibidaScreen;

public class ReembolsoDefinition {
	
	@Steps
	AppLoginScreen appLoginPage;
	
	@Steps
	ScHome paginaPrincipalScreen;
	
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
	
	@Steps
	AgregarNuevoDocumentoScreen agregarNuevoDocumentoScreen;
	
	@Steps
	CuentaDeAbonoScreen cuentaDeAbonoScreen;
	
	@Steps
	SolicitudReembolsoRecibidaScreen solicitudReembolsoRecibidaScreen;
	
	
	@Given("realiza el login con credenciales {string}, {string} y {string}")
	public void realiza_el_login_con_credenciales_y(String tipo, String id, String numero) {
	    // Write code here that turns the phrase above into concrete actions
		appLoginPage.login(id, numero);
	}

	@When("se ingresa a reembolso y se inicia el tramite")
	public void se_ingresa_a_reembolso_y_se_inicia_el_tramite() {
	    // Write code here that turns the phrase above into concrete actions
//		try {
//		registrarHuellaScreen.seleccionarOpcionRegistrarHuella("Por ahora no");
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
		
		paginaPrincipalScreen.cerrarAlertas(15);
		paginaPrincipalScreen.seleccionarOpcionPrincipal("Tramites");
		tusTramitesScreen.seleccionarTramiteSalud("Reembolso de salud");
		iniciarReembolsoSaludScreen.seleccionarEmpezarReembolso();
	}

	@And("se registra los datos del reembolso {string} , {string}, {string} y {string}")
	public void se_registra_los_datos_del_reembolso_y(String prodContratante, String lugarAtencion, String fechaAtencion, String tipoCobert) {
	    // Write code here that turns the phrase above into concrete actions
		comencemosReembolsoSaludScreen.llenarDatosTramites(prodContratante, lugarAtencion, fechaAtencion, tipoCobert);
		comencemosReembolsoSaludScreen.continuar();
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
		agregarNuevoDocumentoScreen.seleccionarTipoDocuem("Factura");
		agregarNuevoDocumentoScreen.llenarDatosFactura("1234", "1234567", "Soles (S/)", "1000");
		reemDocCobertMedicaScreen.AdjuntarFotoArchivo("AdjuntarArchivo");
		agregarNuevoDocumentoScreen.seleccionarTipoDocuem("Receta médica");
		agregarNuevoDocumentoScreen.llenarDatosRecetaMedica("Prueba");
	}

	@Then("podra validar la notificacion: Solicitud de reembolso recibida")
	public void podra_validar_la_notificacion_solicitud_de_reembolso_recibida() {
	    // Write code here that turns the phrase above into concrete actions
		reemDocCobertMedicaScreen.continuar();
		cuentaDeAbonoScreen.llenarDatosDeCuenta("Interbank", "Cuenta de ahorros", "Soles (S/)", "1234567891234", "aba@abc.com");
		cuentaDeAbonoScreen.comentariosAdicionales("Comentario Prueba");
		solicitudReembolsoRecibidaScreen.obtenerMensaje();
	}
	
	
	@When("se registra los datos del reembolso {string} ,{string}, {string}, {string} y {string}")
	public void se_registra_los_datos_del_reembolso_con_beneficiario(String prodContratante,String beneficiario, String lugarAtencion, String fechaAtencion, String tipoCobert) {
	    // Write code here that turns the phrase above into concrete actions
		comencemosReembolsoSaludScreen.llenarDatosTramitesConBeneficiario(prodContratante,beneficiario, lugarAtencion, fechaAtencion, tipoCobert);
		comencemosReembolsoSaludScreen.continuar();	
	}
	
	
	@When("se registra los datos del reembolso odontologico {string} ,{string}, {string}, {string}, {string} y {string}")
	public void se_registra_los_datos_del_reembolso_odontologico(String prodContratante, String beneficiario, String lugarAtencion, String fechaAtencion, String tipoCobert, String tipoTratamiento) {
	    // Write code here that turns the phrase above into concrete actions
		comencemosReembolsoSaludScreen.llenarDatosTramitesConBeneficiario(prodContratante,beneficiario, lugarAtencion, fechaAtencion, tipoCobert);
		comencemosReembolsoSaludScreen.coberturaOdontologica(tipoTratamiento);
		comencemosReembolsoSaludScreen.continuar();
	}
	
	
	@And("adjuntamos los documentos y comprobantes necesarios de la cobertura")
	public void adjuntamos_documento_comprobates() {
	    // Write code here that turns the phrase above into concrete actions
		docRequeridosReembolsoSaludScreen.continuarDocRequeridos();
		reemDocCobertMedicaScreen.subirComprobante("AdjuntarArchivo");
		agregarNuevoDocumentoScreen.seleccionarTipoDocuem("Factura");
		agregarNuevoDocumentoScreen.llenarDatosFactura("1234", "1234567", "Soles (S/)", "1000");
		reemDocCobertMedicaScreen.subirDocumento("AdjuntarArchivo");
		reemDocCobertMedicaScreen.continuar();
//		agregarNuevoDocumentoScreen.seleccionarTipoDocuem("Receta médica");
//		agregarNuevoDocumentoScreen.llenarDatosRecetaMedica("Prueba");
	}
	
	@When("desde el HOME seleccionar reembolso")
	public void desde_el_home_seleccionar_reembolso() {
	    // Write code here that turns the phrase above into concrete actions
		paginaPrincipalScreen.cerrarAlertas(1);
		paginaPrincipalScreen.seleccionarReembolso();
		iniciarReembolsoSaludScreen.seleccionarEmpezarReembolso();
	}

	
	
	
	
	
	
	



}
