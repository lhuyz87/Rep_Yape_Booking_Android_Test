package rimac.test.util;
import rimac.util.GeneralUtil;
public class Variables {

	// CB
	public static final String cbUser = "";
	public static final String cbPass = "";



	

	
	
	public static String hostModoRootDesa="https://apitest.rimac.com";
	public static String pathModoRootDesa="/app-nativa/mock/v1/tampering";
	
	
	
	
	
	//Variables
	// data driven y otros archivos
	public static int numeroColumnas = 0;
	
	public static final String usar = "X";
	public static final String res = "src/test/resources/dataDriven/Plantilla/";
	public static final String rutaLocalPlantilla = "src/test/resources/dataDriven/Plantilla/";
	public static final String rutaRemotaPlantilla = "smb://172.26.40.37//DataPuebaAutomatizacion//Proy_APIVIDA//datapool//Plantilla//";
	public static final String rutaPlantillas = res + "DataPrueba.xlsx";
	public static final String ruta = res + System.getProperty("user.name") + "/";

	
	// data driven y local
	
	public static final String RutaLocal ="src/test/resources/dataDriven/";
	
	// data driven y otros archivos

	public static final String RutaRemota = "smb://172.26.40.37//DataPuebaAutomatizacion//Proy_APIVIDA//datapool//";
	public static final String DataPrueba =  "DataPrueba.xlsx";
	public static final String UsarRemota="NO";
	
	
	
	//Data de prueba
	public static final String file_remota = RutaRemota + DataPrueba;
	//Data de prueba local
	public static final String file_local = RutaLocal + DataPrueba;
	
	
	public static final String dominioDP =GeneralUtil.getInstancia().getVarEnvPro("dominioDP"); 
	public static final String usuarioDP = GeneralUtil.getInstancia().getVarEnvPro("usuarioDP");  
	public static final String passwordDP = GeneralUtil.getInstancia().getVarEnvPro("passwordDP"); 

	
	
}

