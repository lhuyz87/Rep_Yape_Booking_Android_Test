package rimac.main.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.screen.ScLogin;
import rimac.main.screen.ScHome;
import rimac.main.screen.ScReemDocCobertMedica;
import rimac.main.screen.ScTusTramites;
import rimac.main.screen.ScIniciarReembolsoSalud;
import rimac.main.screen.ScComencemosReembolsoSalud;
import rimac.main.screen.ScConfirmarDatosReembolsoSalud;
import rimac.main.screen.ScDocRequeridosReembolsoSalud;
import rimac.main.screen.ScRegistrarHuella;
import rimac.main.screen.ScAgregarNuevoDocumento;
import rimac.main.screen.ScCuentaDeAbono;
import rimac.main.screen.ScSolicitudReembolsoRecibida;
import rimac.main.screen.ScServiciosTuSeguro;
import rimac.main.screen.ScTusSeguros;

public class ReembolsoDefinition3 {
	
	@Steps
	ScLogin appLoginPage;
	
	@Steps
	ScHome paginaPrincipalScreen;
	
	@Steps
	ScTusTramites tusTramitesScreen;
	
	@Steps
	ScIniciarReembolsoSalud iniciarReembolsoSaludScreen;
	
	@Steps
	ScComencemosReembolsoSalud comencemosReembolsoSaludScreen;
	
	@Steps
	ScConfirmarDatosReembolsoSalud confirmarDatosReembolsoSaludScreen;
	
	@Steps
	ScDocRequeridosReembolsoSalud docRequeridosReembolsoSaludScreen;
	
	@Steps
	ScRegistrarHuella registrarHuellaScreen;
	
	@Steps
	ScReemDocCobertMedica reemDocCobertMedicaScreen;
	
	@Steps
	ScAgregarNuevoDocumento agregarNuevoDocumentoScreen;
	
	@Steps
	ScCuentaDeAbono cuentaDeAbonoScreen;
	
	@Steps
	ScSolicitudReembolsoRecibida solicitudReembolsoRecibidaScreen;
	
	@Steps
	ScServiciosTuSeguro scServiciosTuSeguro;
	
	@Steps
	ScTusSeguros scTusSeguros;
	
	//---------------------------------
	
//	@Steps
//	StepReembolso stepReembolso;
//	
	
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
		comencemosReembolsoSaludScreen.llenarDatosTramitesSinBeneficiario(prodContratante, lugarAtencion, fechaAtencion, tipoCobert);
		comencemosReembolsoSaludScreen.continuar();
	}

	@And("registramos los datos del contacto: {string}, {string}  y direccion: {string}, {string}, {string} y {string}")
	public void registramos_los_datos_del_contacto_y_direccion_y(String mail, String telefono, String departamento, String provincia, String distrito , String direccion) {
	    // Write code here that turns the phrase above into concrete actions
		confirmarDatosReembolsoSaludScreen.llenarDatosDireccion(departamento, provincia, distrito, direccion);
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
	
	
	
	@When("desde el detalle del seguro seleccionar la opcion reembolso")
	public void desde_el_home_seleccionar_reembolso_detalle_seguro() {
	    // Write code here that turns the phrase above into concrete actions
		paginaPrincipalScreen.cerrarAlertas(1);
		paginaPrincipalScreen.seleccionarOpcionPrincipal("Seguros");
		scTusSeguros.seleccionarDetalleSeguro("");
		scServiciosTuSeguro.seleccionarServicio("Reembolso de salud");
		iniciarReembolsoSaludScreen.seleccionarEmpezarReembolso();
	}
	
	//-------------------------------------------------------------------------------------------------------------
	
//	@When("se ingresa a Reembolso de Salud desde Tramites y se inicia el tramite")
//	public void se_ingresa_a_reembolso_de_salud_desde_tramites_y_se_inicia_el_tramite() {
//		stepReembolso.selecciona_reembolso_de_salud_desde_tramites();
//		stepReembolso.acepta_haber_leido_todas_las_recomendaciones();
//	}


	
	
	
	
	
	
	



}
