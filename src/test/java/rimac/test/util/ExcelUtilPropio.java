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
import rimac.test.inout.LeerDD;


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

			switch (excelSplit[0]) {
				case "ConsultaSalud":
						data = LeerDD.getInstancia().leerDDConsultaSalud(hoja);
					break;
				case "ConsultaVehicularSoat":
						data = LeerDD.getInstancia().leerDDConsultaVehicularSoat(hoja);
					break;
				case "ConsultasVida":
						data = LeerDD.getInstancia().leerDDConsultasVida(hoja);
					break;
				case "Onboarding":
						data = LeerDD.getInstancia().leerDDOnboarding(hoja);
					break;
				case "CrossellRenovacion":
					data = LeerDD.getInstancia().leerDDCrossellRenovacion(hoja);
					break;
				case "Pagos":
					data = LeerDD.getInstancia().leerDDPagos(hoja);
					break;
				case "Perfil":
					data = LeerDD.getInstancia().leerDDPerfil(hoja);
					break;
				case "ServiciosSalud":
					data = LeerDD.getInstancia().leerDDServiciosSalud(hoja);
					break;
				case "ServiciosSoat":
					data = LeerDD.getInstancia().leerDDServiciosSoat(hoja);
					break;
				case "ServiciosVehiculares":
					data = LeerDD.getInstancia().leerDDServiciosVehiculares(hoja);
					break;
				case "TramitesSiniestros":
					data = LeerDD.getInstancia().leerDDTramitesSiniestros(hoja);
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
