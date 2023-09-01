package rimac.main.screen;
import io.appium.java_client.HidesKeyboard;
import rimac.main.object.ObjPerfiladorVehi;
import rimac.main.util.BaseDriver;
import rimac.main.util.UtilApp;


public class ScPerfiladorVehicular extends BaseDriver {

    UtilApp util=UtilApp.getInstancia();
    ObjPerfiladorVehi objPerfiladorVehi= ObjPerfiladorVehi.getInstancia();
    public void ingresarPlacaVeh(String placa1, String placa2, String placa3, String placa4, String placa5, String placa6) throws Exception{
        util.esperarElementoVisible(10,objPerfiladorVehi.lblIngrPlaca);
        ((HidesKeyboard) appiumDriver()).hideKeyboard();
        element(objPerfiladorVehi.inputPlaca("1")).sendKeys(placa1);
        element(objPerfiladorVehi.inputPlaca("2")).sendKeys(placa2);
        element(objPerfiladorVehi.inputPlaca("3")).sendKeys(placa3);
        element(objPerfiladorVehi.inputPlaca("5")).sendKeys(placa4);
        element(objPerfiladorVehi.inputPlaca("6")).sendKeys(placa5);
        element(objPerfiladorVehi.inputPlaca("7")).sendKeys(placa6);
    }
    public void datosVeh() throws Exception {
        try {
            util.mobileSwipeScreenAndroidFinal();
            util.esperarElementoVisible(5,objPerfiladorVehi.btnContinuar);
            element(objPerfiladorVehi.btnContinuar).click();
            util.esperarElementoVisible(5,objPerfiladorVehi.btnProVehi);
            element(objPerfiladorVehi.btnProVehi).click();
            element(objPerfiladorVehi.btnContinuar).click();
            util.esperarElementoVisible(5,objPerfiladorVehi.btnAsistencia);
            element(objPerfiladorVehi.btnAsistencia).click();
            element(objPerfiladorVehi.btnContinuar).click();
            util.esperarElementoVisible(5,objPerfiladorVehi.btnTiempoUso);
            element(objPerfiladorVehi.btnTiempoUso).click();
            element(objPerfiladorVehi.btnContinuar).click();
            util.esperarElementoVisible(5,objPerfiladorVehi.btnPagoMes);
            element(objPerfiladorVehi.btnPagoMes).click();
            element(objPerfiladorVehi.btnVerResultado).click();

        }catch(Exception e){
            throw new IllegalAccessError("Error al ingresar datos del vehiculo");
        }


    }


    public void verPlanVehi() throws Exception {
        util.esperarElementoVisible(5,objPerfiladorVehi.btnLoQuiero);
        element(objPerfiladorVehi.btnLoQuiero).click();
        util.esperarElementoVisible(5,objPerfiladorVehi.btnContinuar);
        element(objPerfiladorVehi.btnContinuar).click();
        util.esperarElementoVisible(10,objPerfiladorVehi.btnFinalizar);
        element(objPerfiladorVehi.btnFinalizar).click();

    }
}
