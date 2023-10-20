package yape.main.step;

import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.Map;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import java.util.List;
import java.util.logging.Logger;

import yape.main.screen.*;
import yape.main.util.UtilApp;
import yape.main.util.Variables;

public class StepBusquedaAlojamiento {
	

	
	@Steps
	ScBusquedaAlojamiento scBusquedaAlojamiento;
	
	@Steps
	ScDatosCliente scDatosCliente;

	
	@Steps
	ScResumenReserva scResumenReserva;

	public static Logger looger = Logger.getLogger(ScLogin.class.getName());
	
	UtilApp utilApp = new UtilApp();

	@Step()
	public void ingresarDestinoFechas(String destino, String ida, String vuelta) {
		// TODO Auto-generated method stub
		scBusquedaAlojamiento.ingresarDestino(destino);
		scBusquedaAlojamiento.ingresarFechas(ida,vuelta);
	}
	@Step()
	public void detalleHabitacion(String habitacion, String adultos, String ninos) {
		// TODO Auto-generated method stub
		scBusquedaAlojamiento.ingresarHabitacion(habitacion);
		scBusquedaAlojamiento.ingresarAdultos(adultos);
		scBusquedaAlojamiento.ingresarNinos(ninos.split("-")[0],ninos.split("-")[1]);
	}
	@Step()
	public void realizarBusqueda() {
		// TODO Auto-generated method stub
		scBusquedaAlojamiento.seleccionarBuscar();
	}
	@Step()
	public void selHotel(String hotel) {
		// TODO Auto-generated method stub
		scBusquedaAlojamiento.seleccionarHotel(hotel);
	}


	@Step()
	public void confHabitacion() {
		// TODO Auto-generated method stub
		scBusquedaAlojamiento.confHabitacion();
	}
	@Step()
	public void registrarDatosCliente(String nombre, String apellido, String email, String direccion, String postal,
			String ciudad, String pais, String telefono, String motivo) {
		// TODO Auto-generated method stub
		scDatosCliente.ingresarDatos(nombre,apellido,email,direccion,postal,ciudad,pais,telefono);
		scDatosCliente.seleccioarMotivoViaje(motivo);
		scDatosCliente.confirmarDatosFaltantes();
	}
	@Step()
	public void resumenReserva() {
		// TODO Auto-generated method stub
		scResumenReserva.confirmarReserva();
	}
	
	
	
	
	
}

