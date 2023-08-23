package rimac.test.definition;

import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.step.StepPlanVidaFlexible;

public class DefServicioVida {

    @Steps
    StepPlanVidaFlexible stepPlanVidaFlexible;

    @When("deseo conocer el detalle del estado de cuenta del {string} y del {string} ingresando desde Home")
    public void deseoConocerElDetalleDelEstadoDeCuentaDelYDelIngresandoDesdeHome(String anio, String mes) throws Exception {
        stepPlanVidaFlexible.desde_home_ver_detalle_vida_flexible();
        stepPlanVidaFlexible.ir_EstadoCuenta();
        stepPlanVidaFlexible.ingresarfecha(anio,mes);
        stepPlanVidaFlexible.descargar_estado_cuenta();
    }
}
