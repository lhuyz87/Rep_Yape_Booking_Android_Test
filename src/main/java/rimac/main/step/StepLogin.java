package rimac.main.step;

import io.cucumber.datatable.DataTable;
import java.util.Map;
import net.thucydides.core.annotations.Steps;
import java.util.List;
import rimac.main.screen.ScLogin;
import rimac.main.screen.ScNuevaContra;
import rimac.main.screen.ScValidaIdentid;
import rimac.main.screen.ScComoRecibCodVeri;
import rimac.main.screen.ScPregunDeVerifi;
import rimac.main.screen.ScTuContraCambiaConExito;
import rimac.main.util.UtilApp;

public class StepLogin {
	
	@Steps
	ScLogin scLogin;
	
	@Steps 
	ScValidaIdentid scValidaIdentid;
	
	@Steps 
	ScComoRecibCodVeri scComoRecibCodVeri;
	
	@Steps
	ScPregunDeVerifi scPregunDeVerifi;
	
	@Steps
	ScNuevaContra scNuevaContra;
	
	
	@Steps
	ScTuContraCambiaConExito scTuContraCambiaConExito;
	
	
	UtilApp utilApp = new UtilApp();
	
	
	public void realiza_el_login_con_credenciales(DataTable userCredentials) {
			List<Map<String, String>> user = userCredentials.asMaps(String.class, String.class);
			String tipoID = user.get(0).get("tipoID");
			String id = user.get(0).get("id");
			String password = user.get(0).get("password");
			
			scLogin.login(id, password);
	//		scAlertas.cerrarAlertas(20);
		}

	public void seleccOlvidaContra() {
		scLogin.seleccOlvidaContra();
		
	}

	public void ingresDocumen(String nroDocume) {
		scValidaIdentid.ingresDocumen(nroDocume);
		
	}

	public void seleccResponPregun() {
		scComoRecibCodVeri.seleccResponPregun();
		
	}

	public void seleccDatosdeSeguri(String fechaNacimi, String seguros) {
		scPregunDeVerifi.ingresaFechaNacimi(fechaNacimi);
		scPregunDeVerifi.seleccSeguros(seguros);
//		
	}

	public void ingresaNuevaContra() {
		scNuevaContra.ingresaNuevaContra();
		
	}

	public String obtenerTituloMensaje() {
		return scTuContraCambiaConExito.getTituloMensaje();
	}

	public String obtenerTituloMensajeActualizar() {
		// TODO Auto-generated method stub
		return scLogin.getMensajeActualizar();
	}

	public void saltarActualizacion() {
		// TODO Auto-generated method stub
		
		scLogin.seleccMasTarde();
		
	}

	public void validarIngresoCanalApp() {
		// TODO Auto-generated method stub
		scLogin.muestraLogin();
	}

	public boolean mostrarSoloActualizar() {
		// TODO Auto-generated method stub
		scLogin.muestraOpcionActualizar();
		return scLogin.noMostrarOpcionMasTarde();
	}

	public void activarRootModoDesarrollo(String host, String path, String body, String header, String complemento, String parameter) {
		// TODO Auto-generated method stub
		String response =utilApp.ejecutarServicioPost(host, path, body, header, complemento, null).toString();
		System.out.println("***"  + response);
	}

	public boolean validarNoIngresoConMensaje(String opcion) {
		return scLogin.noMuestraLogin();
		
	}
	
	
	
}

