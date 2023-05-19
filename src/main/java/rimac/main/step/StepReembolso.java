package rimac.main.step;

import java.util.List;
import java.util.Map;
import java.util.Random;

import com.openhtmltopdf.util.Util;

import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import rimac.main.screen.*;
//import rimac.main.screen.ScBeneficioPorDobleSeguro;
//import rimac.main.screen.ScCoberturaMedicinas;
//import rimac.main.screen.ScComentariosAdicionales;
//import rimac.main.screen.ScCompletaTusDatos;
//import rimac.main.screen.ScDocumentosRequeridos;
//import rimac.main.screen.ScEligeTuCuentaAbono;
//import rimac.main.screen.ScServiciosDeTuSeguro;
//import rimac.main.screen.ScComencemosTuReembolso;
//import rimac.main.screen.ScSolicitudRecibida;
//import rimac.main.screen.ScTusAsistencias;
import rimac.main.util.ConstantesDummy;


import rimac.main.screen.ScHome;
import rimac.main.screen.ScTusTramites;
import rimac.main.screen.ScAgregarNuevoDocumento;
import rimac.main.util.Variables;

public class StepReembolso {

	@Steps
	ScHome schome;
	@Steps
	ScTusTramites scTusTramites;
	@Steps
	ScIniciarReembolsoSalud scIniciarReembolsoSalud;
	@Steps
	ScComencemosReembolsoSalud scComencemosReembolsoSalud;
	@Steps
	ScConfirmarDatosReembolsoSalud scConfirmarDatosReembolsoSalud;
	@Steps
	ScDocRequeridosReembolsoSalud scDocRequeridosReembolsoSalud;
	@Steps
	ScReemDocCobertMedica scReemDocCobertMedica;
	@Steps
	ScAgregarNuevoDocumento scAgregarNuevoDocumento;
	@Steps
	ScCuentaDeAbono scCuentaDeAbono;
	@Steps
	ScSolicitudReembolsoRecibida scSolicitudReembolsoRecibida;
	@Steps
	ScConsultaReembolso scConsultaReembolso;
	@Steps
	ScTusSeguros scTusSeguros;
	@Steps
	ScTusAsistencias scTusAsistencias;

	@Steps
	ScServiciosTuSeguro scServiciosTuSeguro;
	@Steps
	ScAlertas scAlertas;

	StepReembolso() {
		Random randomObj = new Random();
		Variables objVariables = new Variables();
		objVariables.montoReembolso = String.valueOf(randomObj.ints(100, 999).findFirst().getAsInt());
	}
	public void selReembolsoSaludTramite() throws Exception {
		//schome.cerrarAlertas(15);
		//scAlertas.omitirAlertas(14);
		schome.seleccionarOpcionPrincipal("Tramites");
		scTusTramites.seleccionaReembolsoSalud();
	}

	public void seleccionar_ver_todas(){
		schome.seleccionaVerTodas();
	}

	public void ver_Detalle_Seguros(String seguro){
		schome.seleccionarOpcionPrincipal("Seguros");
		scTusSeguros.esperar_Tus_Seguros();
		scTusSeguros.ver_Detalle(seguro);
	}
	public void seleccionar_seguro_desde_tus_Servicios(){
		scServiciosTuSeguro.seleccionarServicio("Reembolso de salud");
	}
	public void selecciona_reembolso_de_salud_desde_asistencias() {
		scTusAsistencias.seleccionaProductoReembolsoSalud();

	}
	public void completaDatosReembolsoSinBeneficiario(DataTable datosReembolso) {
		List<Map<String, String>> user = datosReembolso.asMaps(String.class, String.class);

		String productoContratante = user.get(0).get("productoContratante");
		String lugarAtencion = user.get(0).get("lugarAtencion");
		String tipoCobertura = user.get(0).get("tipoCobertura");
		String tipoTratamiento = user.get(0).get("tipoTratamiento");
		
		if(tipoTratamiento == null) {
			scIniciarReembolsoSalud.seleccionarEmpezarReembolso();
			scComencemosReembolsoSalud.llenarDatosTramitesSinBeneficiario(productoContratante, lugarAtencion, lugarAtencion, tipoCobertura);
			scComencemosReembolsoSalud.continuar();
		}
	}

	public void registraDireccionContacto() {
		String departamento = ConstantesDummy.departamentoAncash;
		String provincia = ConstantesDummy.provinciaAncash;
		String distrito = ConstantesDummy.distritoAncash;
		String direccion = ConstantesDummy.direccionTest;
		
		scConfirmarDatosReembolsoSalud.llenarDatosDireccion(departamento, provincia, distrito, direccion);
		
		
	}
	
	public void iniciarRegistroDoc() {
		scDocRequeridosReembolsoSalud.continuarDocRequeridos();
	}

	public void registrarDocumentoPorCobert(String tipoCobertura) throws Exception {
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		String dispositivo = variables.getProperty("appium.deviceName");
		switch (tipoCobertura) {
			case "Medicinas":
			case "Atención ambulatoria":
				scReemDocCobertMedica.adjuntarFotoArchivo();
				if(dispositivo.equals("Huawei_P30_Lite_9_real_us")){
					scReemDocCobertMedica.tomarFotoHuawei();
				}else{
					scReemDocCobertMedica.subirArchivo();
				}
				scAgregarNuevoDocumento.seleccionarTipoDocuem(ConstantesDummy.tipoDocFactura);

				//scReemDocCobertMedica.omitirOCR();

				scAgregarNuevoDocumento.llenarDatosFactura(ConstantesDummy.serieDocumentoFactura, ConstantesDummy.nroDocumentoFactura, ConstantesDummy.monedaSoles, Variables.montoReembolso);
				scReemDocCobertMedica.adjuntarFotoArchivo();
				if(dispositivo.equals("Huawei_P30_Lite_9_real_us")){
					scReemDocCobertMedica.tomarFotoHuawei();
				}else{
					scReemDocCobertMedica.subirArchivo();
				}
				scAgregarNuevoDocumento.seleccionarTipoDocuem(ConstantesDummy.tipoDocRecetaMedica);
				scAgregarNuevoDocumento.llenarDatosRecetaMedica("Prueba");
			break;
							
		case "Odontología":
				scReemDocCobertMedica.subirComprobantes();
				if(dispositivo.equals("Huawei_P30_Lite_9_real_us")){
					scReemDocCobertMedica.tomarFotoHuawei();
				}else{
					scReemDocCobertMedica.subirArchivo();
				}
				scAgregarNuevoDocumento.seleccionarTipoDocuem(ConstantesDummy.tipoDocFactura);
			   //scReemDocCobertMedica.omitirOCR();
				scAgregarNuevoDocumento.llenarDatosFactura(ConstantesDummy.serieDocumentoFactura, ConstantesDummy.nroDocumentoFactura, ConstantesDummy.monedaSoles, Variables.montoReembolso);
			    scReemDocCobertMedica.subirDocumentos();
				if(dispositivo.equals("Huawei_P30_Lite_9_real_us")){
					scReemDocCobertMedica.tomarFotoHuawei();
				}else{
					scReemDocCobertMedica.subirArchivo();
				}
	//			scReemDocCobertMedica.continuar();
				break;

			case "Hospitalario":
				scReemDocCobertMedica.adjuntarFotoArchivo();
				if(dispositivo.equals("Huawei_P30_Lite_9_real_us")){
					scReemDocCobertMedica.tomarFotoHuawei();
				}else{
					scReemDocCobertMedica.subirArchivo();
				}
				scAgregarNuevoDocumento.seleccionarTipoDocuem(ConstantesDummy.tipoDocFactura);
				//scReemDocCobertMedica.omitirOCR();
				scAgregarNuevoDocumento.llenarDatosFactura(ConstantesDummy.serieDocumentoFactura, ConstantesDummy.nroDocumentoFactura, ConstantesDummy.monedaSoles, Variables.montoReembolso);
				scReemDocCobertMedica.adjuntarFotoArchivo();
				if(dispositivo.equals("Huawei_P30_Lite_9_real_us")){
					scReemDocCobertMedica.tomarFotoHuawei();
				}else{
					scReemDocCobertMedica.subirArchivo();
				}
				scAgregarNuevoDocumento.seleccionarTipoDocuem(ConstantesDummy.tipoOrdenMedica);
				scAgregarNuevoDocumento.llenarDatosRecetaMedica("Prueba");
				break;
		default:
			break;
		}
			
	}
	
	public void llenarDatosCuenta() throws Exception {
			
		   scReemDocCobertMedica.continuar();
		   scCuentaDeAbono.llenarDatosDeCuenta(ConstantesDummy.bancoInterbank, ConstantesDummy.tipoCuentaAhorrosInterbank, ConstantesDummy.monedaSoles, ConstantesDummy.nroCuentaAhorrosInterbank, ConstantesDummy.correo);
		   

	}
	
	public void ingresarComentariosAdicionales() throws Exception {
		scCuentaDeAbono.comentariosAdicionales("Comentario Prueba");
	}

	public String obtenerMensajeReembolso() {
		String mensajeMostrado = scSolicitudReembolsoRecibida.obtenerMensaje();
		return mensajeMostrado;
	}

	public void completaDatosReembolsoConBeneficiacio(String prodContrat, String paciente,String lugarAtencio,String fechaAtencio, String tipoCobert) {
		scIniciarReembolsoSalud.seleccionarEmpezarReembolso();
		scComencemosReembolsoSalud.llenarDatosTramitesConBeneficiario(prodContrat, paciente, lugarAtencio, "", tipoCobert);

	}

	
	public void ingreTipoTratami(String tipoTratam) {
		scComencemosReembolsoSalud.coberturaOdontologica(tipoTratam);
//		scComencemosReembolsoSalud.continuar();
	}
	
	
	public void continuPasoDos() {
		scComencemosReembolsoSalud.continuar();
	}



	public void selecSeguiReemSalud() throws Exception {
		//schome.cerrarAlertas(15);
		scAlertas.omitirAlertas(14);
		schome.seleccionarOpcionPrincipal("Tramites");
		scTusTramites.seleccionarSegui();
		
	}

	public String validarMontoReem(String monto) {
		
		String montoEncontrado = scConsultaReembolso.obtenerMonto(monto);
		return montoEncontrado;
	}

	public String obtener_monto_de_reembolsos_desde_inicio(String monto) {
		return schome.getMontoReembolso(monto);
	}

}
