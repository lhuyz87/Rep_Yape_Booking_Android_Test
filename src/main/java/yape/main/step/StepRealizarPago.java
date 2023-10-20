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

public class StepRealizarPago {
	
	@Steps
	ScPagos scPagos;
	
	@Steps
	ScConfirmarReserva scConfirmarReserva;
	


	public static Logger looger = Logger.getLogger(ScLogin.class.getName());
	
	UtilApp utilApp = new UtilApp();
	@Step()
	public void datosPago(String tarjeta, String fechaVencimiento) {
		// TODO Auto-generated method stub
		
		scPagos.IngresarDatosTarjeta(tarjeta,fechaVencimiento);
		
	}
	public int obtenerMontos() {
		// TODO Auto-generated method stub
		int montoTotal= scPagos.obtenerMontoTotal();
		return montoTotal;
	}
	public void confirmarPagoReserva() {
		scPagos.confirmarPago();
		
	}
	public String recibirConfirmacion() {
		// TODO Auto-generated method stub
		
		String mensaje = scConfirmarReserva.obtnerMensajeConfirmacion();
		return mensaje;
	}
	
	
	
	
}

