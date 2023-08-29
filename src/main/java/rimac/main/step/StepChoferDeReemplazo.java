package rimac.main.step;

import net.thucydides.core.annotations.Steps;
import rimac.main.screen.ScAlertas;
import rimac.main.screen.ScChoferDeReemplazo;
import rimac.main.screen.ScHome;
import rimac.main.screen.ScTusTramites;
import rimac.main.util.ConstantesDummy;

public class StepChoferDeReemplazo {

    @Steps
    ScHome scHome;
    @Steps
    ScTusTramites scTusTramites;
    @Steps
    ScChoferDeReemplazo scChoferDeReemplazo;
    @Steps
    ScAlertas scAlertas;

    public void se_ingresa_a_chofer_reemplazo_desde_tramites() throws Exception {

        scHome.seleccionarOpcionPrincipal("Tramites");
        scTusTramites.seleccionaChoferReemplazo();

    }

    public void chkTerminosAsistencia() throws InterruptedException {

        scChoferDeReemplazo.terminosCondicionesChoferDeReemplazo();
    }

    public void se_ingresa_Datos_de_contacto(){
        String nombre = ConstantesDummy.nombre;
        String correo = ConstantesDummy.correo;
        String celular = ConstantesDummy.celular;
        scChoferDeReemplazo.ingresar_Datos_de_Contacto(nombre,celular,correo);

    }
    public void seleccionarVehiculo(String placa){
        scChoferDeReemplazo.seleccionar_Vehiculo(placa);

    }

    public void buscar_destino(){
        scChoferDeReemplazo.buscardestino();
                   }
    public void ingresar_fecha() throws InterruptedException {
        scChoferDeReemplazo.seleccionfecha();
    }

    public void ingresar_hora() throws InterruptedException {
        scChoferDeReemplazo.seleccionhora();
    }

    public void ingresar_requisitos() throws InterruptedException {
        scChoferDeReemplazo.seleccionRequisitos();
    }
    public void confirmar_chofer() throws InterruptedException {
        scChoferDeReemplazo.seleccionConfirmar();
    }

    public void retornarInicio() throws Exception {
        scChoferDeReemplazo.irAlInicio();
        scHome.seleccionarOpcionPrincipal("Home");
        scAlertas.omitirAlertas(7);
    }

    public boolean se_valida_solicitud_chofer(String placa) {
        return scChoferDeReemplazo.validacion_solicitud_chofer(placa);
    }

}
