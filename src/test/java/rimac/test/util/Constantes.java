package rimac.test.util;

import rimac.main.util.UtilDef;

public class Constantes {


    //	// data driven y otros archivos
    public static final String usar = "X";
    private static final String res = "src/test/resources/dataDriven/";
    public static final String rutaPlantillas = res + "0_plantillas/";
    public static final String ruta = res + System.getProperty("user.name") + "/";
    //
//	// features
    public static final String UsarRemota = "NO";
    public static final String featRuta = "src/test/resources/features/";
    public static final String featLlave = "###DATOS###@";
    public static String dominioDP = rimac.main.util.UtilDef.getInstancia().getVarEnvPro("dominioDP");
    public static String usuarioDP = rimac.main.util.UtilDef.getInstancia().getVarEnvPro("usuarioDP");
    public static String passwordDP = UtilDef.getInstancia().getVarEnvPro("passwordDP");

    public static String correoDestino = UtilDef.getInstancia().getVarEnvPro("v_correoDestino");
    public static String correoRemitente = UtilDef.getInstancia().getVarEnvPro("v_correoRemitente");
    public static String passCorreoRemitente = UtilDef.getInstancia().getVarEnvPro("v_passCorreoRemitente");
    //public static final String RutaLocal = "/Users/christianmaurysolis/Documents/Documentos/";
    public static final String RutaLocal = "/home/adminqa/Documents/Auto/Android/";
    //public static final String RutaLocal = "/home/adminqa/Documents/data-Android-test-Cloud-v1/";
    //public static final String RutaLocal = "/home/adminqa/Documents/data-Android-test-Cloud-v1/";
    public static final String RutaRemota = "smb://01-045923.rimac.com.pe//DataPuebaAutomatizacion//Proy_CanalAPP_iOS//datapool//";
    public static final String fileData_01 = (UsarRemota.compareTo("NO")==0 ? RutaLocal+"Data.xlsx" : RutaRemota+"Data.xlsx");


}
