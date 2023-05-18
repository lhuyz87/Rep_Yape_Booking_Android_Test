package rimac.main.screen;

import rimac.main.object.ObjPerfiladorSalud;
import rimac.main.util.BaseDriver;
import rimac.main.util.UtilApp;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class ScPerfiladorSalud extends BaseDriver {
    UtilApp util=UtilApp.getInstancia();
    ObjPerfiladorSalud objPerfiladorSalud= ObjPerfiladorSalud.getInstancia();
    public void opc_Test() throws Exception {
        util.esperarElementoVisible(5,objPerfiladorSalud.opcSeguroTest);
        element(objPerfiladorSalud.opcSeguroTest).click();
    }

    public void opc_Preguntas() throws Exception {
        util.mobileSwipeScreenAndroidFinal();
        element(objPerfiladorSalud.opcProteger).click();
        util.esperarElementoVisible(5,objPerfiladorSalud.btnContinuar);
        element(objPerfiladorSalud.btnContinuar).click();
        util.esperarElementoVisible(5,objPerfiladorSalud.opcProteccion);
        element(objPerfiladorSalud.opcProteccion).click();
        util.esperarElementoVisible(5,objPerfiladorSalud.btnContinuar);
        element(objPerfiladorSalud.btnContinuar).click();
        util.esperarElementoVisible(5,objPerfiladorSalud.opcLugarAtencion);
        element(objPerfiladorSalud.opcLugarAtencion).click();
        util.esperarElementoVisible(5,objPerfiladorSalud.btnContinuar);
        element(objPerfiladorSalud.btnContinuar).click();
        util.esperarElementoVisible(5,objPerfiladorSalud.opcCobertura);
        element(objPerfiladorSalud.opcCobertura).click();
        util.esperarElementoVisible(5,objPerfiladorSalud.btnContinuar);
        element(objPerfiladorSalud.btnContinuar).click();

    }

    public void opc_Recomendada() throws Exception {

        util.esperarElementoVisible(5,objPerfiladorSalud.btnLoQuiero);
        element(objPerfiladorSalud.btnLoQuiero).click();

        util.esperarElementoVisible(5,objPerfiladorSalud.btnFinalizar);
        element(objPerfiladorSalud.btnFinalizar).click();


    }
}
