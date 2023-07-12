package rimac.main.step;

import net.thucydides.core.annotations.Steps;
import rimac.main.screen.ScPagos;
import rimac.main.screen.ScTusSeguros;

public class StepHistorialPagos {

    @Steps
    ScTusSeguros scTusSeguros;

    @Steps
    ScPagos scPagos;

    public void iraPagarCuotas() throws Exception {
        scTusSeguros.irPagos();
        scPagos.iraPagarCuotas();
    }

    public boolean validarCronograma() throws Exception {
       return scPagos.validarCronograma();
    }
}
