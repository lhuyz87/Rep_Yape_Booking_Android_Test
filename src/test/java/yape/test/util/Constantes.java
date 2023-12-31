package yape.test.util;

import yape.main.util.UtilDef;

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
    public static String dominioDP = yape.main.util.UtilDef.getInstancia().getVarEnvPro("dominioDP");
    public static String usuarioDP = yape.main.util.UtilDef.getInstancia().getVarEnvPro("usuarioDP");
    public static String passwordDP = UtilDef.getInstancia().getVarEnvPro("passwordDP");

    public static String correoDestino = UtilDef.getInstancia().getVarEnvPro("v_correoDestino");
    public static String correoRemitente = UtilDef.getInstancia().getVarEnvPro("v_correoRemitente");
    public static String passCorreoRemitente = UtilDef.getInstancia().getVarEnvPro("v_passCorreoRemitente");
    public static final String RutaLocal = "/home/adminqa/Documents/Auto/Android/";
    public static final String RutaRemota = "smb://01-045923.rimac.com.pe//DataPuebaAutomatizacion//Proy_CanalAPP_iOS//datapool//";
    public static final String fileData_01 = (UsarRemota.compareTo("NO")==0 ? RutaLocal+"Data.xlsx" : RutaRemota+"Data.xlsx");
    public static final String file_ConsultaSalud = (UsarRemota.compareTo("NO")==0 ? RutaLocal+"ConsultaSalud.xlsx" : RutaRemota+"ConsultaSalud.xlsx");
    public static final String file_ConsultaVehicularSoat = (UsarRemota.compareTo("NO")==0 ? RutaLocal+"ConsultaVehicularSoat.xlsx" : RutaRemota+"ConsultaVehicularSoat.xlsx");
    public static final String file_ConsultasVida = (UsarRemota.compareTo("NO")==0 ? RutaLocal+"ConsultasVida.xlsx" : RutaRemota+"ConsultasVida.xlsx");
    public static final String file_CrossellRenovacion = (UsarRemota.compareTo("NO")==0 ? RutaLocal+"CrossellRenovacion.xlsx" : RutaRemota+"CrossellRenovacion.xlsx");
    public static final String file_Onboarding = (UsarRemota.compareTo("NO")==0 ? RutaLocal+"Onboarding.xlsx" : RutaRemota+"Onboarding.xlsx");
    public static final String file_Pagos = (UsarRemota.compareTo("NO")==0 ? RutaLocal+"Pagos.xlsx" : RutaRemota+"Pagos.xlsx");
    public static final String file_Perfil = (UsarRemota.compareTo("NO")==0 ? RutaLocal+"Perfil.xlsx" : RutaRemota+"Perfil.xlsx");
    public static final String file_ServiciosSalud = (UsarRemota.compareTo("NO")==0 ? RutaLocal+"ServiciosSalud.xlsx" : RutaRemota+"ServiciosSalud.xlsx");
    public static final String file_ServiciosSoat = (UsarRemota.compareTo("NO")==0 ? RutaLocal+"ServiciosSoat.xlsx" : RutaRemota+"ServiciosSoat.xlsx");
    public static final String file_ServiciosVehiculares = (UsarRemota.compareTo("NO")==0 ? RutaLocal+"ServiciosVehiculares.xlsx" : RutaRemota+"ServiciosVehiculares.xlsx");
    public static final String file_TramitesSiniestros = (UsarRemota.compareTo("NO")==0 ? RutaLocal+"TramitesSiniestros.xlsx" : RutaRemota+"TramitesSiniestros.xlsx");
    public static final String file_VentaNueva = (UsarRemota.compareTo("NO")==0 ? RutaLocal+"VentaNueva.xlsx" : RutaRemota+"VentaNueva.xlsx");
    public static final String file_ServiciosVida = (UsarRemota.compareTo("NO")==0 ? RutaLocal+"ServiciosVida.xlsx" : RutaRemota+"ServiciosVida.xlsx");
}
