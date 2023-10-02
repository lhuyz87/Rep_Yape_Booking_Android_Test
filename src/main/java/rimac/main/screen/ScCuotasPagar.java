package rimac.main.screen;

import rimac.main.object.ObjCuotasPagar;
import rimac.main.object.ObjPagos;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilApp;
import rimac.main.util.Variables;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScCuotasPagar extends BaseDriver {

    private long wdwTimeOut = 300L;

    protected UtilApp util = UtilApp.getInstancia();
    protected ObjPagos objPagos=ObjPagos.getInstancia();

    public void consultaUltimoPago() throws Exception {
        String mesCapturado="";
        String anioCapturado="";
        String mesPendientePago="";
        util.esperarElementoVisible(5,objPagos.lblCuotasAPagar);
        if(element(objPagos.lblFechaVenc1).isCurrentlyVisible()){
            mesPendientePago=element(objPagos.lblFechaVenc1).getText();
        }else{
            mesPendientePago=element(objPagos.lblFechaVenc2).getText();
        }
        Pattern pattern = Pattern.compile("\\d{2}/(\\d{2})/(\\d{4})");
        Matcher matcher = pattern.matcher(mesPendientePago);
        if (matcher.find()) {
            mesCapturado= matcher.group(1);
            anioCapturado = matcher.group(2);
        }
        String[] listaMes = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        if(mesCapturado.equals("01")){
            mesCapturado="13";
            anioCapturado=String.valueOf(Integer.parseInt(anioCapturado)-1);
        }
        String mesPagado = listaMes[Integer.parseInt(mesCapturado) - 2];
        String anioPagado=anioCapturado;
        String fechaPagada= mesPagado+" "+anioPagado;
        Variables.cuotaPorPagar=fechaPagada;
        element(objPagos.btnRetroceder).click();
    }
}
