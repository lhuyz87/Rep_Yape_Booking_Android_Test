package rimac.main.step;

import java.util.List;
import java.util.Map;
import java.util.Random;

import com.openhtmltopdf.util.Util;

import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Step;
import rimac.main.screen.ScAgregarNuevoDocumento;
//import rimac.main.screen.ScBeneficioPorDobleSeguro;
//import rimac.main.screen.ScCoberturaMedicinas;
//import rimac.main.screen.ScComentariosAdicionales;
//import rimac.main.screen.ScCompletaTusDatos;
import rimac.main.screen.ScConfirmarDatosReembolsoSalud;
import rimac.main.screen.ScConsultaReembolso;
//import rimac.main.screen.ScDocumentosRequeridos;
//import rimac.main.screen.ScEligeTuCuentaAbono;
import rimac.main.screen.ScHome;
import rimac.main.screen.ScIniciarReembolsoSalud;
//import rimac.main.screen.ScServiciosDeTuSeguro;
//import rimac.main.screen.ScComencemosTuReembolso;
//import rimac.main.screen.ScSolicitudRecibida;
//import rimac.main.screen.ScTusAsistencias;
import rimac.main.screen.ScTusSeguros;
import rimac.main.screen.ScTusTramites;
import rimac.main.util.ConstantesDummy;


import rimac.main.screen.ScHome;
import rimac.main.screen.ScTusTramites;
import rimac.main.screen.ScComencemosReembolsoSalud;
import rimac.main.screen.ScDocRequeridosReembolsoSalud;
import rimac.main.screen.ScReemDocCobertMedica;
import rimac.main.screen.ScAgregarNuevoDocumento;
import rimac.main.screen.ScCuentaDeAbono;
import rimac.main.screen.ScSolicitudReembolsoRecibida;
import rimac.main.util.Variables;

public class StepReembolso {

	@Steps
	ScHome scHome;
	@Steps
	ScTusSeguros scTusSeguros;
//	@Steps
//	ScTusAsistencias scTusAsistencias;
//	@Steps
//	ScServiciosDeTuSeguro scServiciosDeTuSeguro;
//	@Steps
//	ScComencemosTuReembolso scComencemosTuReembolso;
//	@Steps
//	ScBeneficioPorDobleSeguro scBeneficioPorDobleSeguros;
//	@Steps
//	ScCompletaTusDatos scCompletaTusDatos;
//	@Steps
//	ScDocumentosRequeridos scDocumentosRequeridos;
//	@Steps
//	ScCoberturaMedicinas scCoberturaMedicinas;
//
//	@Steps
//	ScEligeTuCuentaAbono scEligeTuCuentaAbono;
//	@Steps
//	ScComentariosAdicionales scComentariosAdicionales;
//	@Steps
//	ScSolicitudRecibida scSolicitudRecibida;
	
	//-------------------
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

	StepReembolso() {
		Random randomObj = new Random();
		Variables objVariables = new Variables();
		objVariables.montoReembolso = String.valueOf(randomObj.ints(100, 999).findFirst().getAsInt());
	}
	public void selReembolsoSaludTramite() {
		schome.cerrarAlertas(15);
		schome.seleccionarOpcionPrincipal("Tramites");
		scTusTramites.seleccionarTramiteSalud("Reembolso de salud");
		scIniciarReembolsoSalud.seleccionarEmpezarReembolso();
	}



	public void completaDatosReembolsoSinBeneficiario(DataTable datosReembolso) {
		List<Map<String, String>> user = datosReembolso.asMaps(String.class, String.class);

		String productoContratante = user.get(0).get("productoContratante");
		String lugarAtencion = user.get(0).get("lugarAtencion");
		String tipoCobertura = user.get(0).get("tipoCobertura");
		String tipoTratamiento = user.get(0).get("tipoTratamiento");
		
		if(tipoTratamiento == null) {
			scComencemosReembolsoSalud.llenarDatosTramitesSinBeneficiario(productoContratante, lugarAtencion, lugarAtencion, tipoCobertura);
			scComencemosReembolsoSalud.continuar();
		}else {
			
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


	public void registrarDocumentoPorCobert(String tipoCobertura) {

		switch (tipoCobertura) {
		case "Medicinas":
			
			System.out.println("Entra a medicinas");
			scReemDocCobertMedica.AdjuntarFotoArchivo("AdjuntarArchivo");
			scAgregarNuevoDocumento.seleccionarTipoDocuem(ConstantesDummy.tipoDocFactura);
			scAgregarNuevoDocumento.llenarDatosFactura(ConstantesDummy.serieDocumentoFactura, ConstantesDummy.nroDocumentoFactura, ConstantesDummy.monedaSoles, Variables.montoReembolso);
			scReemDocCobertMedica.AdjuntarFotoArchivo("AdjuntarArchivo");
			scAgregarNuevoDocumento.seleccionarTipoDocuem(ConstantesDummy.tipoDocRecetaMedica);
			scAgregarNuevoDocumento.llenarDatosRecetaMedica("Prueba");
			break;
							
		case "Odontología":
			System.out.println("Entra a Odontologia");
			
			scReemDocCobertMedica.subirComprobante("AdjuntarArchivo");
			scAgregarNuevoDocumento.seleccionarTipoDocuem(ConstantesDummy.tipoDocFactura);
			scAgregarNuevoDocumento.llenarDatosFactura(ConstantesDummy.serieDocumentoFactura, ConstantesDummy.nroDocumentoFactura, ConstantesDummy.monedaSoles, ConstantesDummy.monto);
			scReemDocCobertMedica.subirDocumento("AdjuntarArchivo");
//			scReemDocCobertMedica.continuar();
			break;

		default:
			break;
		}
			
	}
	
	public void llenarDatosCuenta() {
			
		   scReemDocCobertMedica.continuar();
		   scCuentaDeAbono.llenarDatosDeCuenta(ConstantesDummy.bancoInterbank, ConstantesDummy.tipoCuentaAhorrosInterbank, ConstantesDummy.monedaSoles, ConstantesDummy.nroCuentaAhorrosInterbank, ConstantesDummy.correo);
		   

	}
	
	public void ingresarComentariosAdicionales() {
		scCuentaDeAbono.comentariosAdicionales("Comentario Prueba");
	}

	public String obtenerMensajeReembolso() {
		String mensajeMostrado = scSolicitudReembolsoRecibida.obtenerMensaje();
		return mensajeMostrado;
	}

	public void completaDatosReembolsoConBeneficiacio(String prodContrat, String paciente,String lugarAtencio,String fechaAtencio, String tipoCobert) {
		
		scComencemosReembolsoSalud.llenarDatosTramitesConBeneficiario(prodContrat, paciente, lugarAtencio, "", tipoCobert);

	}
	
	
	public void ingreTipoTratami(String tipoTratam) {
		scComencemosReembolsoSalud.coberturaOdontologica(tipoTratam);
//		scComencemosReembolsoSalud.continuar();
	}
	
	
	public void continuPasoDos() {
		scComencemosReembolsoSalud.continuar();
	}



	public void selecSeguiReemSalud() {
		schome.cerrarAlertas(15);
		schome.seleccionarOpcionPrincipal("Tramites");
		scTusTramites.seleccionarSegui();
		
	}



	public String validarMontoReem(String monto) {
		
		String montoEncontrado = scConsultaReembolso.obtenerMonto(monto);
		
		
		return montoEncontrado;
	}
	


}
