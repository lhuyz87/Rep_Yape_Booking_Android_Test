package rimac.test.util;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;

import com.ibm.icu.impl.InvalidFormatException;

import jcifs.smb.NtlmPasswordAuthentication;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class UtilDef {
	
	@Steps
	private Variables variables;
	
	ExcelUtil excelUtil = new ExcelUtil();
	
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
	/*
	public String verificarruta() {
		ExcelUtil excelUtil = new ExcelUtil();
		String ruta="";
		
		if(variables.UsarRemota.compareTo("SI")==0) {
	    	ruta= variables.file_remota;
	    	NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(variables.dominioDP, variables.usuarioDP, variables.passwordDP);
	    	ruta=excelUtil.absolutPath(auth,ruta);
	       	}else {
	       		ruta=variables.file_local;		    	
	    	 }
		return ruta;	
	}

	public String[] verificarRutaOrigenDestino() {
		ExcelUtil excelUtil = new ExcelUtil();
		String rutaOrigen="";
		String rutaDestino="";
		String[] rutas= new String[2];
		
		if(variables.UsarRemota.compareTo("SI")==0) {
			rutaOrigen= variables.rutaRemotaPlantilla;
			rutaDestino= variables.RutaRemota;
	    	NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(variables.dominioDP, variables.usuarioDP, variables.passwordDP);
	    	rutaOrigen=excelUtil.absolutPath(auth,rutaOrigen);
	    	rutaDestino=excelUtil.absolutPath(auth,rutaDestino);
	    	rutas[0]=rutaOrigen;
	    	rutas[1]=rutaDestino;
	       	}else {
	       		rutaOrigen=variables.rutaLocalPlantilla;	
	       		rutaDestino= variables.RutaLocal;
		    rutas[0]=rutaOrigen;
		    rutas[1]=rutaDestino;
	    	 }
		return rutas;	
	}*/
	
	public static double roundToDecimals(double d, int c)  
	{   
	      int temp = (int)(d * Math.pow(10 , c));  
	      return ((double)temp)/Math.pow(10 , c);  
	}
	
	public static double redondearDosDecimales(double valor) {
		double numValor = 0.0;
		numValor=(double)Math.round(valor * 100d) / 100d;
		return numValor;
	} 
	
	public double calcularCuotaEsperado(String plan, String primaAhorro, double primaCotizacion){
		double resultado = 0;
		double primaAhor = Double.parseDouble(primaAhorro);
		if(plan.compareTo("23774")==0) {
			resultado=(((primaCotizacion-(primaCotizacion/12))+primaAhor)/1);
		}else if(plan.compareTo("23775")==0) {
			resultado=(((primaCotizacion)+primaAhor)/2);
		}else if(plan.compareTo("23776")==0) {
			resultado=(((primaCotizacion)+primaAhor)/12);
		}else if(plan.compareTo("23777")==0) {
			resultado=(((primaCotizacion)+primaAhor)/4);
		}
		return resultado;
	}
	
/*
	public void crearArchivoReporte() throws IOException{
		String rutas[] = verificarRutaOrigenDestino();
		String ruta = rutas[1] + variables.DataPrueba;
		
		File file = new File(rutas[1] +"\\" + variables.DataPrueba);
		System.out.println(rutas[1] +"\\" + variables.DataPrueba);
		// File (or directory) with new name
		File file2 = new File(rutas[1] + "\\" + "Ejec-"+obtenerFechayHora().replace(":", "")+ ".xlsx");
//		TimeZone.getTimeZone("user.timezone")
		if (file2.exists())
		   throw new java.io.IOException("file exists");

		// Rename file (or directory)
		boolean success = file.renameTo(file2);

		if (!success) {
		   // File was not successfully renamed
		}
		
		
	}*/
	

	
	public String obtenerFechayHora() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
        LocalDateTime today = LocalDateTime.now();     //Today

        String fecha =today.format(dtf);           
        System.out.println(" horaaaa"  + fecha);
        return fecha;          
    }
	
	public String getVarEnvPro(String variable) {
		
		String varEnvPro="";
		
		if(System.getProperty("varFlag")!=null) {
			varEnvPro=System.getProperty(variable);
			}else {
			varEnvPro=System.getenv(variable);
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
			}catch (Exception e) {
				System.out.println("Mensaje " + e.getMessage());
			}
			
	}
	
	

}
