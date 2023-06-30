package rimac.main.step;

import net.thucydides.core.annotations.Steps;
import rimac.main.screen.ScAlertas;
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

	@Steps
	ScAlertas scAlertas;


	public void selecciona_buscador_de_clinicas_desde_home() throws Exception {
		//scHome.cerrarAlertas(15);
		scAlertas.omitirAlertas(7);
		scHome.seleccionaBuscadorClinicas();
	}
	
	public void selecciona_buscador_de_clinicas_desde_tramites() throws Exception {
		//scHome.cerrarAlertas(15);
		scAlertas.omitirAlertas(7);
		scHome.seleccionarOpcionPrincipal("Tramites");;
		scTusTramites.seleccionaBuscadordeSalud();

	}
	
	public void buscar_clinica(String nomClinica) {
		scBuscadorDeClinicas.seleccionar_datos_para_continuar();
		scBuscadorDeClinicas.ingresarNombreClinica(nomClinica);
	}
	
	public boolean obtener_copago() {
		return scBuscadorDeClinicas.getCopago();
	}
	
	
}