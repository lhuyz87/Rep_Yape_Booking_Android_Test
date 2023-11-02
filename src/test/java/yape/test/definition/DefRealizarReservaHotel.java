package yape.test.definition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import yape.main.step.StepBusquedaAlojamiento;
import yape.main.step.StepLogin;
import yape.main.step.StepRealizarPago;
import yape.test.util.UtilReport;
import yape.test.util.Variables;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
public class DefRealizarReservaHotel {
	
	@Steps
	StepLogin stepLogin;
	
	@Steps
	StepBusquedaAlojamiento stepBusquedaAlojamiento;
	
	
	@Steps
	StepRealizarPago stepRealizarPago;
	
	@Steps
	UtilReport utilReport;
	
	public static Logger looger = Logger.getLogger(DefRealizarReservaHotel.class.getName());

	@Given("realiza el login con cuenta google")
	public void realiza_el_login_con_cuenta_google() {
	    // Write code here that turns the phrase above into concrete actions
		stepLogin.realizarLogin("Google");
	}
	@Given("ingreso los datos de busqueda de alojamiento destino {string}, fecha de ida {string}, fecha de regreso {string}")
	public void ingreso_los_datos_de_busqueda_de_alojamiento_destino_fecha_de_ida_fecha_de_regreso(String destino, String ida, String vuelta) {
	    // Write code here that turns the phrase above into concrete actions
		stepBusquedaAlojamiento.ingresarDestinoFechas(destino,ida,vuelta);
	}
	@Given("ingreso la cantidad de habitación {string}, la cantidad de adultos {string} y la edad de niños  {string}")
	public void ingreso_la_cantidad_de_habitación_la_cantidad_de_adultos_y_la_edad_de_niños(String habitacion, String adultos, String ninos) {
	    // Write code here that turns the phrase above into concrete actions
		stepBusquedaAlojamiento.detalleHabitacion(habitacion,adultos,ninos);
	}
	@Given("realizamos la busqueda")
	public void realizamos_la_busqueda() {
	    // Write code here that turns the phrase above into concrete actions
		stepBusquedaAlojamiento.realizarBusqueda();
	}
	@Given("seleccionamos el hotel de preferencia {string}")
	public void seleccionamos_el_hotel_de_preferencia(String hotel) {
	    // Write code here that turns the phrase above into concrete actions
		stepBusquedaAlojamiento.selHotel(hotel);
	}
	@Given("confirmamos la elección de la habitación y la reserva")
	public void confirmamos_la_elección_de_la_habitación_y_la_reserva() {
	    // Write code here that turns the phrase above into concrete actions
	    stepBusquedaAlojamiento.confHabitacion();
	}
	@Given("ingresamos los datos del cliente:")
	public void ingresamos_los_datos_del_cliente(DataTable dataTable) {

		List<Map<String, String>> datosClientes = dataTable.asMaps(String.class, String.class);	     
		String nombre =datosClientes.get(0).get("Nombre");
		String apellido =datosClientes.get(0).get("Apellido");
		String email =datosClientes.get(0).get("e-mail");
		String direccion =datosClientes.get(0).get("Direccion");
		String postal =datosClientes.get(0).get("codigo Postal");
		String ciudad =datosClientes.get(0).get("Ciudad");
		String pais =datosClientes.get(0).get("Pais");
		String telefono =datosClientes.get(0).get("Telefono");
		String motivo =datosClientes.get(0).get("Motivo Viaje");
		
		stepBusquedaAlojamiento.registrarDatosCliente(nombre,apellido,email,direccion,postal,ciudad,pais,telefono,motivo);
		

	}
	@When("confirmar los datos de la reserva")
	public void confirmar_los_datos_de_la_reserva() {
	    // Write code here that turns the phrase above into concrete actions
	    stepBusquedaAlojamiento.resumenReserva();
	}
	@When("ingresar los datos de la tarjeta de crédito:")
	public void ingresar_los_datos_de_la_tarjeta_de_crédito(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> datosTarjeta = dataTable.asMaps(String.class, String.class);	

		String tarjeta =datosTarjeta.get(0).get("Numero de Tarjeta");
		String fechaVencimiento =datosTarjeta.get(0).get("Fecha de vencimiento");
		
		stepRealizarPago.datosPago(tarjeta,fechaVencimiento);
		
	}
	@When("validamos el monto total de la reserva sea correcto {string}")
	public void validamos_el_monto_total_de_la_reserva(String montoEsperado) {
	    // Write code here that turns the phrase above into concrete actions
		int montoMostrado = stepRealizarPago.obtenerMontos();
		
		utilReport.showStepMessage("Monto Esperado " + montoEsperado + "  Monto Mostrado " + montoMostrado);
		
		
		assertEquals(Integer.parseInt(montoEsperado), montoMostrado,1);
		
	}
	

	@When("confirmamos el pago de la reserva")
	public void confirmamos_el_pago_de_la_reserva() {
	    // Write code here that turns the phrase above into concrete actions
		stepRealizarPago.confirmarPagoReserva();
	}
	@Then("validamos que se muestre el mensaje {string}")
	public void validamos_que_se_muestre_el_mensaje(String mensajeEsperado) {
	    // Write code here that turns the phrase above into concrete actions
	    String mensajeObtenito="";
	    mensajeObtenito = stepRealizarPago.recibirConfirmacion();
	    utilReport.showStepMessage("Mensaje Esperado " + mensajeEsperado + "  Mensaje Mostrado " + mensajeObtenito);
	    Serenity.takeScreenshot();
	    assertEquals(mensajeEsperado, mensajeObtenito);
	}

	
}
