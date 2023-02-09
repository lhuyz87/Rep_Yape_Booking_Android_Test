package rimac.main.util;

import java.util.ArrayList;
import java.util.List;

public class Variables {


	public static int numeroColumnas = 0;
	public static String montoReembolso = "";
	public static List<String> contador=new ArrayList<String>();
	public static List<String> listaStrings = new ArrayList<String>();

	public static final String nombreDominio = UtilDef.getInstancia().getVarEnvPro("nombreDominio");
	public static final String userDominio = UtilDef.getInstancia().getVarEnvPro("userDominio");
	public static final String passDominio = UtilDef.getInstancia().getVarEnvPro("passDominio");

	public static final String UsarRemota = "NO";

	// CB
	public static final String cbUser = "";
	public static final String cbPass = "";

	// data driven y otros archivos
	private static final String res = "src/test/resources/dataDriven/";
	private static final String ruta = res + System.getProperty("user.name") + "/";

	// vida ley activos
	public static final String file_01 = ruta + "DataPrueba.xlsx";
	public static final String h01 = "01-RegistrarAtencion";
	
	public static String tag="";


	public static final String RutaLocal ="src/test/resources/dataDriven/";
	public static final String RutaRemota = "/Users/christianmaurysolis/git/CanalApp-auto-iOS-test-v1/src/test/resources/dataDriven/Plantilla/";
	public static final String DataPrueba = "DataPrueba.xlsx";

	public static final String file_remota = RutaRemota + DataPrueba;
	//Data de prueba local
	public static final String file_local = RutaLocal + DataPrueba;



	
//	public String v_codProyectoSquad = "";
//	public String v_codEscenario = "";
//	public String v_codCasoPrueba = "";
//	public Gson gson = new Gson();
//	public JsonObject v_jsonDatosGenerados1 = gson.fromJson("{}", JsonObject.class);
//	public JsonObject v_jsonDatosGenerados2 = gson.fromJson("{}", JsonObject.class);
//	public JsonObject v_jsonDatosGenerados3 = gson.fromJson("{}", JsonObject.class);
//	public JsonObject v_jsonDatosGenerados4 = gson.fromJson("{}", JsonObject.class);
//	public JsonObject v_jsonDatosGenerados5 = gson.fromJson("{}", JsonObject.class);
//	
//	public static String v_estadoTC = "";
}

