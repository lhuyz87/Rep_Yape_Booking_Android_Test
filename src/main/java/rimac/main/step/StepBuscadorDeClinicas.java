package rimac.main.step;

import net.thucydides.core.annotations.Steps;
import rimac.main.screen.ScBuscadorDeClinicas;
import rimac.main.screen.ScHome;
import rimac.main.screen.ScTusTramites;


public class StepBuscadorDeClinicas {

	@Steps
	ScHome scHome;
	@Steps
	ScTusTramites scTusTramites;
	@Steps
	ScBuscadorDeClinicas scBuscadorDeClinicas;
	
	public void selecciona_buscador_de_clinicas_desde_home() {
		scHome.cerrarAlertas(15);
		scHome.seleccionaBuscadorClinicas();
		
	}
	
	public void selecciona_buscador_de_clinicas_desde_tramites() {
		scHome.cerrarAlertas(15);
		scHome.seleccionarOpcionPrincipal("Tramites");;
		scTusTramites.seleccionarTramiteSalud("Buscador de salud");
	}
	
	public void buscar_clinica(String nomClinica) {
		scBuscadorDeClinicas.ingresarNombreClinica(nomClinica);
	}
	
	public String obtener_copago() {
		return scBuscadorDeClinicas.getCopago();
	}
	
	
}