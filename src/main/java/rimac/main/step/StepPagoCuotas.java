package rimac.main.step;

import net.thucydides.core.annotations.Steps;
import rimac.main.screen.*;
import rimac.main.util.ConstantesDummy;
import rimac.main.util.Variables;

public class StepPagoCuotas {

    @Steps
    ScHome scHome;
    @Steps
    ScSoat scSoat;
    @Steps
    ScTusSeguros scTusSeguros;
    @Steps
    ScMediosDePago scMediosDePago;
    @Steps
    ScPagos scPagos;
    @Steps
    ScConsultaTusPagos scConsultaTusPagos;

    public void verDetalleSeguroVehicular(String placa){
        scHome.seleccionarOpcionPrincipal("Seguros");
        scTusSeguros.esperar_Tus_Seguros();
        scTusSeguros.ver_detalle_Vehicular_placa(placa);
    }

    public void pagarCuotas() throws Exception {
        scTusSeguros.irPagos();
        scPagos.iraPagarCuotas();
        Variables.cuotaPorPagar= scPagos.obtenerNumeroCuota();
        Variables.montoCuotaPagos= scPagos.obtenerMontoCuota();
        scPagos.seleccionarCuota();

    }

    public void pagarConTarjetaAsociada() throws Exception {
        scMediosDePago.pagarTarjetaAsociada();
    }

    public void pagarSinTarjetaAsociada(String numTarjeta, String cvv, String fecha) throws Exception {
        String nombre = ConstantesDummy.nombre;
        String apellido = ConstantesDummy.apellido;
        String correo = ConstantesDummy.correo;
        StringBuilder mmaa = new StringBuilder(fecha.substring(0,2));
        mmaa.append(fecha.substring(3,5));
        scMediosDePago.añadir_tarjeta();
        scMediosDePago.ingresarDatosTarjeta(numTarjeta, nombre,apellido,mmaa,cvv,correo);
        scMediosDePago.pagar();
    }
    public boolean obtiene_mensaje_confirmacion() {
        return scPagos.obtener_mensaje_confirmacion();
    }

    public void selecciona_HistorialPago() {
        scPagos.irHistorialPagos();
    }
    public void obtenerMontoHistorial(){
        String cuota= Variables.cuotaPorPagar;
        Variables.montoCuotaHistorial= scConsultaTusPagos.obtenerUltimoMonto(cuota);
    }

    public void iraSegurosDesdePerfil() {
        scHome.seleccionarOpcionPrincipal("Seguros");

    }
    public void iraSoatDesdeSeguros() {
        scTusSeguros.seleccionaSOAT();
    }

    public void verDetalleSoat() {
        scTusSeguros.verDetalle();
    }

    public void mostrarDetallePago() {
        scSoat.iraPagos();
    }

    public boolean obtiene_mensaje_detallePago() {
        return scSoat.obtener_mensaje_detallePago();
    }
}
