package rimac.main.util;

import java.util.Properties;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;

import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import rimac.main.screen.BaseScreen;
import rimac.main.util.UtilDef;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;

public class UtilDef  extends BaseScreen{

	public static Properties p;
	private static UtilDef obj = null;

	public static UtilDef getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new UtilDef();
		}
	}

	/**
	 * Este método es invocado por Jenkins automáticamente (en caso esté publicado)
	 * @param variable
	 * @return
	 */
	public String getVarEnvPro(String variable) {
		String varEnvPro = "";
		if (System.getProperty("varFlag") != null) {
			varEnvPro = System.getProperty(variable);//desde el properties
		} else {
			varEnvPro = System.getenv(variable); //desde el Vault
		}
		return varEnvPro;
	}

	public void getProperties() {
		try {
			p = new Properties();
			p.load(new FileReader(new File("src/test/resources/secrets.properties")));
			for (String name : p.stringPropertyNames()) {
				String value = p.getProperty(name);
				System.setProperty(name, value);
//		        System.out.println(name +" : " + value);
			}
		} catch (Exception e) {
			System.out.println("Mensaje " + e.getMessage());
		}
	}

	public boolean verificarPDFdescargado(String nom_Documento, int totalTimeoutInMillis) throws InterruptedException  {
		boolean flag = false;
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		String pathDescarga = variables.getProperty("chrome_preferences.download.default_directory");
		System.out.println("Ruta referencia: "+pathDescarga);
		String nom_ArchivoDescargado = "";

		/**
		 * Se añade totalTimeoutInMillis, 
		 * representa al tiempo en milisegundos para esperar q termine de descargar y luego poder traer el último archivo
		 */

		Thread.sleep(totalTimeoutInMillis);

		nom_ArchivoDescargado = getNombreUltimoArchivoDescargado(pathDescarga, "pdf", nom_Documento);
		String file_with_location = pathDescarga + nom_ArchivoDescargado;
		System.out.println("nom_ArchivoDescargado: " + nom_ArchivoDescargado);
		System.out.println("file_with_location: " + file_with_location);
		
		File file = new File(file_with_location);
		flag = file.exists();
		System.out.println(flag);
		if (flag)
			System.out.println(" SÍ SE LOGRÓ DESCARGAR EL ARCHIVO: "+ nom_ArchivoDescargado);
		else
			System.out.println(" NO SE LOGRÓ DESCARGAR");
			
		return flag;
		
	}
	
	public String getNombreUltimoArchivoDescargado(String filePath, String extension, String nom_Documento) throws InterruptedException {
		File dir = new File(filePath);
		FileFilter fileFilter = new WildcardFileFilter("*." + extension);
		String nombreDocumentoDescargado = "";
		
		for (File files : dir.listFiles(fileFilter)) {
			if(files.getName().contains(nom_Documento)) {
				nombreDocumentoDescargado = files.getName();
				break;
			}
	    }

		return nombreDocumentoDescargado;
	}
	
	public void esperarElemento(int intentos, WebElement elemento) {
		int contador=0;
		while(element(elemento).isEnabled()==false) {
			contador++;
			if(element(elemento).isEnabled()==true||contador==intentos) {
				System.out.println("Se encuentra elemento");			
				break;
			}else
				System.out.println("contador: " + contador);
				
		}
	}
}
