package rimac.test.util;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import net.thucydides.core.annotations.Steps;
import rimac.test.inout.LeerDD_Reembolso;


public class ExcelUtilPropio extends ExcelUtil {
	
	@Steps
	private Variables variables;

	// singleton
	private static ExcelUtilPropio obj = null;
	public static Object copiarPlantillas;
	UtilDef util = new UtilDef();
	ExcelUtil excelUtil = new ExcelUtil();

	private ExcelUtilPropio() {
	}

	public static ExcelUtilPropio getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ExcelUtilPropio();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	// singleton


	public List<List<String>> excelToList(String excel, String hoja, String vez) {
		List<List<String>> data = new ArrayList<List<String>>();
//		System.out.println("excel: " + excel + "-hoja: " + hoja + " VEZ: " + vez  );
		try {
			String[] excelSplit = excel.split("\\|");
			// int v = Integer.parseInt(vez);

//			System.out.println(" valor 1: " + excelSplit[0] + " valor 2: " + excelSplit[1] + " LONGITUD: " + excelSplit.length  );

			switch (excelSplit[0]) {
				case "Data":
						data = LeerDD_Reembolso.getInstancia().leerDD(hoja);
					break;
				default:
					break;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}

		return data;
	}
	
	public String generarPlaca() {
		String placa="";
		
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 3;
		Random random = new Random();

		String PlacaString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString().toUpperCase();
		int PlacaNumerica = ThreadLocalRandom.current().nextInt(100, 999 + 1);
		placa=PlacaString.concat(""+PlacaNumerica);

		return placa;
	}
	
		/*
	public void copiarPlantillas() {
		System.out.println("Entrando a Copiar Plantilla...");
		String rutas[] = util.verificarRutaOrigenDestino();
		File file = new File(rutas[0]);
		String[] archivos = file.list();
		
		// verificar si existe directorio
		File rutaDestino = new File(rutas[1]);

		if (!rutaDestino.exists()) {
			System.out.println("creando directorio local para los data driven");
			rutaDestino.mkdir();
		}
		System.out.println("*********"   + archivos.length);
		System.out.println("********* Origen "   + rutas[0]);
		System.out.println("********* Destino "   + rutas[1]);
		
		if(variables.UsarRemota.compareTo("SI")==0) {
			rutas[0]=rutas[0]+"/";
			rutas[1]=rutas[1]+"/";
		}
		
		for (int i = 0; i < archivos.length; i++) {
			System.out.println(archivos[i]);
			copiarArchivo(archivos[i], rutas[0], rutas[1]);
		
		}
	}*/

	private void copiarArchivo(String archivo, String rutaOrigen, String rutaDestino) {
		Path origenPath = FileSystems.getDefault().getPath(rutaOrigen + archivo);
		Path destinoPath = FileSystems.getDefault().getPath(rutaDestino + archivo);

		try {
			Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}

	
	
	
	
}
