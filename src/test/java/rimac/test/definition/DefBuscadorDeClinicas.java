package rimac.test.definition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.step.StepLogin;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import rimac.main.step.StepBuscadorDeClinicas;



public class DefBuscadorDeClinicas {
	
	@Steps 
	StepBuscadorDeClinicas stepBuscadorDeClinicas;

	@When("selecciona la opción Búsqueda de clínicas desde Home y se inicia el tramite")
	public void selecciona_la_opción_búsqueda_de_clínicas_desde_home_y_se_inicia_el_tramite() throws Exception {
		stepBuscadorDeClinicas.selecciona_buscador_de_clinicas_desde_home();
	}

	@When("selecciona la opción Búsqueda de clínicas desde menu Tramites y se inicia el tramite")
	public void selecciona_la_opción_búsqueda_de_clínicas_desde_menu_tramites_y_se_inicia_el_tramite() throws Exception {
		stepBuscadorDeClinicas.selecciona_buscador_de_clinicas_desde_tramites();
	}

	@When("al filtrar la clínica {string}")
	public void al_filtrar_la_clínica(String nomClinica) {
		stepBuscadorDeClinicas.buscar_clinica(nomClinica);
	}
	
	@Then("al seleccionarla debe mostrar su monto de copago {string}")
	public void al_seleccionarla_debe_mostrar_su_monto_de_copago(String copagoEsperado) {
		String valorActual = stepBuscadorDeClinicas.obtener_copago();
		assertEquals(copagoEsperado,valorActual);
	}

}