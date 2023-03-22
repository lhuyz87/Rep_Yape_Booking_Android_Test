package rimac.main.screen;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import rimac.main.object.ObjAnadirTarjeta;
import rimac.main.object.ObjMediodePago;
import rimac.main.object.ObjPerfil;
import rimac.main.util.BaseDriver;
import rimac.main.util.UtilApp;

public class ScMediosDePago extends BaseDriver {

    protected ObjAnadirTarjeta objAnadirTarjeta = ObjAnadirTarjeta.getInstancia();
    protected ObjPerfil objPerfil = ObjPerfil.getInstancia();
    protected ObjMediodePago objMediodePago = ObjMediodePago.getInstancia();

    protected UtilApp util = UtilApp.getInstancia();

    public void eliminarTarjeta(String numTarjeta){
        int contador = 0;
        boolean condicion1 = objMediodePago.opcTarjetaList(numTarjeta).size() != 0;
        boolean condicion2 = element(objMediodePago.lblMisTarjetas).isCurrentlyVisible();
        boolean condicion3 = element(objMediodePago.btnAgregarTarjeta).isCurrentlyVisible();
        //Si la tarjeta existe en el listado, borrar la tarjeta
        if (condicion1) {
            while (element(objMediodePago.opcTarjeta(numTarjeta)).isCurrentlyVisible() == false && contador < 5) {
                util.mobileSwipeScreenAndroid();
            }
            Serenity.takeScreenshot();
            element((WebElement) objMediodePago.opcTarjeta(numTarjeta)).click();
            element(objMediodePago.btnEliminarTarjeta).click();
            element(objMediodePago.btnSiEliminar).click();
            Serenity.takeScreenshot();
        }
        while(contador<10){
            if(condicion2){
                break;
            }
            if(condicion3){
                break;
            }
            util.esperarSegundos(1);
            contador++;
        }
    }
    public void agregarTarjeta(String numTarjeta, String nombre, String apellido, StringBuilder mmaa, String cvv, String correo) {
        try {
            boolean condicion1 = objMediodePago.opcTarjetaList(numTarjeta).size()== 0;
            if(condicion1){
                int contador = 0;
                if (element(objMediodePago.btnAgregarTarjeta).isCurrentlyVisible()) {
                    element(objMediodePago.btnAgregarTarjeta).click();
                    Serenity.takeScreenshot();
                }
                if (element(objMediodePago.lblMisTarjetas).isCurrentlyVisible()) {
                    while(element(objMediodePago.lnkAgregarNuevaTarjeta).isCurrentlyVisible()==false && contador<5){
                        util.mobileSwipeScreenAndroid();
                        contador++;
                    }
                    util.esperarSegundos(3);
                    Serenity.takeScreenshot();
                    element(objMediodePago.lnkAgregarNuevaTarjeta).click();
                }
                util.esperarElemento(3, objAnadirTarjeta.imgTarjeta);
                element(objAnadirTarjeta.lblNumTarjeta).sendKeys(numTarjeta);
                element(objAnadirTarjeta.lblNombre).sendKeys(nombre);
                element(objAnadirTarjeta.lblApellido).sendKeys(apellido);
                util.pressEnter(androidDriver());
                element(objAnadirTarjeta.lblMMAA).sendKeys(mmaa);
                element(objAnadirTarjeta.lblCVV).sendKeys(cvv);
                util.pressEnter(androidDriver());
                element(objAnadirTarjeta.lblCorreo).sendKeys(correo);
                util.pressEnter(androidDriver());
                util.esperarElementoVisible(5, objAnadirTarjeta.btnGuardarTarjeta);
                Serenity.takeScreenshot();
                element(objAnadirTarjeta.btnGuardarTarjeta).click();
                util.esperarElementoVisible(15, objMediodePago.lblMisTarjetas);
                util.esperarSegundos(8);
            }
        }
        catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("Error para ingresar los datos de la tarjeta");
        }

    }

    public boolean existeTarjeta(String numTarjeta){
        boolean tarjetaExiste=false;
        try{
            Serenity.takeScreenshot();
            util.esperarElementoVisible(9,objMediodePago.opcTarjeta(numTarjeta));
            tarjetaExiste = objMediodePago.opcTarjetaList(numTarjeta).size() != 0;

        }catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("No existe tarjeta dentro de Mis Tarjetas");
        }
        return tarjetaExiste;
    }

    public String validarEliminarTarjeta(){
        String mensajeExiste="";
        try{
            util.esperarElementoVisible(5,objMediodePago.lblTarjetaEliminadaExito);
            mensajeExiste = element(objMediodePago.lblTarjetaEliminadaExito).getText();
        }catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("No se muestra el mensaje Tarjeta Eliminada");
        }
        return mensajeExiste;
    }


}
