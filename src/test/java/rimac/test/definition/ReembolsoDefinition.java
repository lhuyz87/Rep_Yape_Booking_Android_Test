package rimac.test.definition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.screen.ScLogin;
import rimac.main.step.StepLogin;
import rimac.main.step.StepReembolso;
import rimac.main.util.Variables;
import rimac.test.inout.LeerDD_Reembolso;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReembolsoDefinition {
	
	
	@Steps
	StepReembolso stepReembolso;
	@Steps
	ScLogin appLoginPage;

	@Steps
	StepLogin stepLogin;


	private LeerDD_Reembolso excel = LeerDD_Reembolso.getInstancia();

	//-------------------------------------------------------------------------------------------------------------
	@Given("realiza el login con credenciales {string}, {string} y {string}")
	public void serealiza_el_login_con_credenciales_y(String tipo, String id, String numero) {
		// Write code here that turns the phrase above into concrete actions
		appLoginPage.login(id, numero);
	}
	@When("se ingresa a Reembolso de Salud desde Tramites y se inicia el tramite")
	public void se_ingresa_a_reembolso_de_salud_desde_tramites_y_se_inicia_el_tramite() throws Exception {
		stepReembolso.selReembolsoSaludTramite();
	}
	
	@And("se registra los datos del reembolso sin beneficiario con tipo de cobertura")
	public void se_registra_los_datos_del_reembolso_sin_beneficiario_con_tipo_de_cobertura(DataTable datosReembolso) {
		stepReembolso.completaDatosReembolsoSinBeneficiario(datosReembolso);	
	}
	
	@When("registra sus datos de contacto")
	public void registra_sus_datos_de_contacto() {
		stepReembolso.registraDireccionContacto();
	}
	
	
	@When("adjuntamos los documentos y comprobantes del reembolso con tipo de cobertura {string}")
	public void adjuntamos_los_documentos_y_comprobantes_del_reembolso_con_tipo_de_cobertura(String tipoCobertura) {
		
			stepReembolso.iniciarRegistroDoc();
			stepReembolso.registrarDocumentoPorCobert(tipoCobertura);
			stepReembolso.llenarDatosCuenta();
			stepReembolso.ingresarComentariosAdicionales();
				
	}
	
	
	@Then("debe aparecer el mensaje: {string}")
	public void debe_aparecer_el_mensaje(String valorEsperado) throws IOException {
		String valorActual = stepReembolso.obtenerMensajeReembolso();
		System.out.println("Monto: "+ Variables.montoReembolso);
		/*
		if(valorEsperado.compareTo(valorActual)==0) {
			System.out.println("Monto: "+ Variables.montoReembolso);
			Variables.listaStrings.add(Variables.montoReembolso);
			excel.writeReembolsoinExcel(Variables.listaStrings);
		}*/
		assertEquals(valorEsperado, valorActual);

	}

	
	
	@When("se registra los datos del reembolso con beneficiario con tipo de cobertura y tratamiento")
	public void se_registra_los_datos_del_reembolso_con_beneficiario_con_tipo_de_cobertura(DataTable datosReembolso) {

		List<Map<String, String>> user = datosReembolso.asMaps(String.class, String.class);

		String prodContrat = user.get(0).get("productoContratante");
		String paciente = user.get(0).get("paciente");
		String lugarAtencio = user.get(0).get("lugarAtencion");
		String tipoCoberta = user.get(0).get("tipoCobertura");
		String tipoTratami = user.get(0).get("tipoTratamiento");
		stepReembolso.completaDatosReembolsoConBeneficiacio(prodContrat,paciente, lugarAtencio,"", tipoCoberta);
		stepReembolso.ingreTipoTratami(tipoTratami);
		stepReembolso.continuPasoDos();
	}
	
	
	@And("adjuntamos los documentos necesarios de la cobertura")
	public void adjuntamos_los_documentos_necesarios_de_la_cobertura() {
	    // Write code here that turns the phrase above into concrete actions
		
		stepReembolso.iniciarRegistroDoc();
		stepReembolso.registrarDocumentoPorCobert("Medicinas");
		stepReembolso.llenarDatosCuenta();
		stepReembolso.ingresarComentariosAdicionales();
				
	}
	@When("se ingresa a Reembolso de Salud desde Home y se inicia el tramite")
	public void seIngresaAReembolsoDeSaludDesdeHomeYSeIniciaElTramite() {
		stepReembolso.seleccionar_ver_todas();
		stepReembolso.selecciona_reembolso_de_salud_desde_asistencias();
	}
	@When("se registra los datos del reembolso con beneficiario con tipo de cobertura")
		public void se_registra_los_datos_del_reembolso_con_beneficiario_con_tipo_de_cobertura_sin_tratamiento(DataTable datosReembolso) {
//		stepReembolso.completa_datos_reembolso_con_beneficiario_con_tipo_de_cobertura(datosReembolso);	

		List<Map<String, String>> user = datosReembolso.asMaps(String.class, String.class);

		String prodContrat = user.get(0).get("productoContratante");
		String paciente = user.get(0).get("paciente");
		String lugarAtencio = user.get(0).get("lugarAtencion");
		String tipoCoberta = user.get(0).get("tipoCobertura");
		
		stepReembolso.completaDatosReembolsoConBeneficiacio(prodContrat,paciente, lugarAtencio,"", tipoCoberta);
		stepReembolso.continuPasoDos();
	}
	

	@When("se ingresa al Seguimiento de Reembolso de Salud desde Tramites")
	public void ingresar_seguimiento_reembolso_salud_tramites() throws Exception {
	stepReembolso.selecSeguiReemSalud();
	}
	@When("se ingresa a Reembolso de Salud desde Seguros y se inicia el tramite {string}")
	public void seIngresaAReembolsoDeSaludDesdeSegurosYSeIniciaElTramite(String seguro) {

		stepReembolso.ver_Detalle_Seguros(seguro);
		stepReembolso.seleccionar_seguro_desde_tus_Servicios();
	}
	
	@Then("debe aparecer el monto {string} del reembolso solicitado")
	public void debe_aparecer_el_monto(String monto) {
		assertEquals(stepReembolso.validarMontoReem(monto), monto);
//		stepReembolso.validarMontoReem(monto);
	}


	@Then("debe aparecer el monto {string} del reembolso solicitado en Inicio")
	public void debeAparecerElMontoDelReembolsoSolicitadoEnInicio(String monto) {
		System.out.println(monto);
		String valorActual = stepReembolso.obtener_monto_de_reembolsos_desde_inicio(monto);
		assertEquals(monto, valorActual);
	}

	@And("debe aparecer el monto del reembolso solicitado")
	public void debeAparecerElMontoDelReembolsoSolicitado() {
		String monto =Variables.montoReembolso;
		System.out.println("MONTO"+monto);
		assertEquals(stepReembolso.validarMontoReem(monto), monto);
	}

	@And("se cierra la sesión del aplicativo")
	public void seCierraLaSesiónDelAplicativo() {
		stepLogin.cerrarSesion();
	}
	@And("debe aparecer el monto  del reembolso solicitado en Inicio")
	public void debeAparecerElMontoDelReembolsoSolicitadoEnInicio() {
		String monto=Variables.montoReembolso;
		String valorActual = stepReembolso.obtener_monto_de_reembolsos_desde_inicio(monto);
		assertEquals(monto, valorActual);
	}


}
