package rimac.test.inout;

import java.io.*;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;

import rimac.main.util.Variables;
import rimac.test.util.*;


public class LeerDD implements InOut {


	// singleton
	private ExcelUtilPropio excelUtilPropio = ExcelUtilPropio.getInstancia();
	private ExcelUtil excelUtil = new ExcelUtil();
	// singleton
	private static LeerDD obj = null;

	private LeerDD() {
	}

	public static LeerDD getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new LeerDD();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	// singleton

	@Override
	public List<List<String>> leerDD(String hoja) throws Exception {
		List<List<String>> data = new ArrayList<List<String>>();
		List<String> reg = null;

		String usar = "";
		System.out.println("HOJAS " + hoja);
		SmbFile dir = null;
		File file = null;
		if (Constantes.UsarRemota.compareTo("SI") == 0) {
			// Codigo para manejo de archivo remoto
			NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(Constantes.dominioDP, Constantes.usuarioDP,
					Constantes.passwordDP);
			System.out.println("*********** " + Constantes.fileData_01);
			try {
				dir = new SmbFile(Constantes.fileData_01, auth);
				file = new File(dir.getUncPath());
				System.out.println("*********** " + file.getAbsolutePath());

			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else {
			file = new File(Constantes.fileData_01);
		}

		if (file.isFile()) {
			FileInputStream fileInputStream = new FileInputStream(file.getAbsoluteFile());
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			Sheet sheet = !hoja.isEmpty() ? workbook.getSheet(hoja) : workbook.getSheetAt(0);
			int ultimaFilaAfectada = sheet.getLastRowNum();
			int ultimaColumanaAfectada = sheet.getRow(0).getLastCellNum();
			Variables.numeroColumnas = ultimaColumanaAfectada;
			Variables.contador.add(hoja);
			for (int i = 1; i <= ultimaFilaAfectada; i++) {
				usar = sheet.getRow(i).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				reg = new ArrayList<String>();

				reg.add(String.valueOf(i));

				if (usar.toUpperCase().equals(Constantes.usar) || usar.compareToIgnoreCase("USAR") == 0) {

					System.out.println("ROW  " + i + "USAR:    " + usar);
					for (int j = 1; j < ultimaColumanaAfectada; j++) {
						reg.add(sheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
								.getStringCellValue());

					}
					Variables.contador.add("%" + i);
					data.add(reg);
				}

			}

			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
			workbook.close();
			fileOutputStream.close();
		}

		return data;
	}

	public List<List<String>> leerDDConsultaSalud(String hoja) throws Exception {
		List<List<String>> data = new ArrayList<List<String>>();
		List<String> reg = null;

		String usar = "";
		System.out.println("HOJAS " + hoja);
		SmbFile dir = null;
		File file = null;
		if (Constantes.UsarRemota.compareTo("SI") == 0) {
			// Codigo para manejo de archivo remoto
			NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(Constantes.dominioDP, Constantes.usuarioDP,
					Constantes.passwordDP);
			System.out.println("*********** " + Constantes.file_ConsultaSalud);
			try {
				dir = new SmbFile(Constantes.file_ConsultaSalud, auth);
				file = new File(dir.getUncPath());
				System.out.println("*********** " + file.getAbsolutePath());

			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else {
			file = new File(Constantes.file_ConsultaSalud);
		}

		if (file.isFile()) {
			FileInputStream fileInputStream = new FileInputStream(file.getAbsoluteFile());
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			Sheet sheet = !hoja.isEmpty() ? workbook.getSheet(hoja) : workbook.getSheetAt(0);
			int ultimaFilaAfectada = sheet.getLastRowNum();
			int ultimaColumanaAfectada = sheet.getRow(0).getLastCellNum();
			Variables.numeroColumnas = ultimaColumanaAfectada;
			Variables.contador.add(hoja);
			for (int i = 1; i <= ultimaFilaAfectada; i++) {
				usar = sheet.getRow(i).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				reg = new ArrayList<String>();

				reg.add(String.valueOf(i));

				if (usar.toUpperCase().equals(Constantes.usar) || usar.compareToIgnoreCase("USAR") == 0) {

					System.out.println("ROW  " + i + "USAR:    " + usar);
					for (int j = 1; j < ultimaColumanaAfectada; j++) {
						reg.add(sheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
								.getStringCellValue());

					}
					Variables.contador.add("%" + i);
					data.add(reg);
				}

			}

			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
			workbook.close();
			fileOutputStream.close();
		}

		return data;
	}

	public List<List<String>> leerDDConsultaVehicularSoat(String hoja) throws Exception {
		List<List<String>> data = new ArrayList<List<String>>();
		List<String> reg = null;

		String usar = "";
		System.out.println("HOJAS " + hoja);
		SmbFile dir = null;
		File file = null;
		if (Constantes.UsarRemota.compareTo("SI") == 0) {
			// Codigo para manejo de archivo remoto
			NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(Constantes.dominioDP, Constantes.usuarioDP,
					Constantes.passwordDP);
			System.out.println("*********** " + Constantes.file_ConsultaVehicularSoat);
			try {
				dir = new SmbFile(Constantes.file_ConsultaVehicularSoat, auth);
				file = new File(dir.getUncPath());
				System.out.println("*********** " + file.getAbsolutePath());

			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else {
			file = new File(Constantes.file_ConsultaVehicularSoat);
		}

		if (file.isFile()) {
			FileInputStream fileInputStream = new FileInputStream(file.getAbsoluteFile());
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			Sheet sheet = !hoja.isEmpty() ? workbook.getSheet(hoja) : workbook.getSheetAt(0);
			int ultimaFilaAfectada = sheet.getLastRowNum();
			int ultimaColumanaAfectada = sheet.getRow(0).getLastCellNum();
			Variables.numeroColumnas = ultimaColumanaAfectada;
			Variables.contador.add(hoja);
			for (int i = 1; i <= ultimaFilaAfectada; i++) {
				usar = sheet.getRow(i).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				reg = new ArrayList<String>();

				reg.add(String.valueOf(i));

				if (usar.toUpperCase().equals(Constantes.usar) || usar.compareToIgnoreCase("USAR") == 0) {

					System.out.println("ROW  " + i + "USAR:    " + usar);
					for (int j = 1; j < ultimaColumanaAfectada; j++) {
						reg.add(sheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
								.getStringCellValue());

					}
					Variables.contador.add("%" + i);
					data.add(reg);
				}

			}

			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
			workbook.close();
			fileOutputStream.close();
		}

		return data;
	}

	public List<List<String>> leerDDCrossellRenovacion(String hoja) throws Exception {
		List<List<String>> data = new ArrayList<List<String>>();
		List<String> reg = null;

		String usar = "";
		System.out.println("HOJAS " + hoja);
		SmbFile dir = null;
		File file = null;
		if (Constantes.UsarRemota.compareTo("SI") == 0) {
			// Codigo para manejo de archivo remoto
			NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(Constantes.dominioDP, Constantes.usuarioDP,
					Constantes.passwordDP);
			System.out.println("*********** " + Constantes.file_CrossellRenovacion);
			try {
				dir = new SmbFile(Constantes.file_CrossellRenovacion, auth);
				file = new File(dir.getUncPath());
				System.out.println("*********** " + file.getAbsolutePath());

			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else {
			file = new File(Constantes.file_CrossellRenovacion);
		}

		if (file.isFile()) {
			FileInputStream fileInputStream = new FileInputStream(file.getAbsoluteFile());
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			Sheet sheet = !hoja.isEmpty() ? workbook.getSheet(hoja) : workbook.getSheetAt(0);
			int ultimaFilaAfectada = sheet.getLastRowNum();
			int ultimaColumanaAfectada = sheet.getRow(0).getLastCellNum();
			Variables.numeroColumnas = ultimaColumanaAfectada;
			Variables.contador.add(hoja);
			for (int i = 1; i <= ultimaFilaAfectada; i++) {
				usar = sheet.getRow(i).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				reg = new ArrayList<String>();

				reg.add(String.valueOf(i));

				if (usar.toUpperCase().equals(Constantes.usar) || usar.compareToIgnoreCase("USAR") == 0) {

					System.out.println("ROW  " + i + "USAR:    " + usar);
					for (int j = 1; j < ultimaColumanaAfectada; j++) {
						reg.add(sheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
								.getStringCellValue());

					}
					Variables.contador.add("%" + i);
					data.add(reg);
				}

			}

			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
			workbook.close();
			fileOutputStream.close();
		}

		return data;
	}

	public List<List<String>> leerDDOnboarding(String hoja) throws Exception {
		List<List<String>> data = new ArrayList<List<String>>();
		List<String> reg = null;

		String usar = "";
		System.out.println("HOJAS " + hoja);
		SmbFile dir = null;
		File file = null;
		if (Constantes.UsarRemota.compareTo("SI") == 0) {
			// Codigo para manejo de archivo remoto
			NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(Constantes.dominioDP, Constantes.usuarioDP,
					Constantes.passwordDP);
			System.out.println("*********** " + Constantes.file_Onboarding);
			try {
				dir = new SmbFile(Constantes.file_Onboarding, auth);
				file = new File(dir.getUncPath());
				System.out.println("*********** " + file.getAbsolutePath());

			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else {
			file = new File(Constantes.file_Onboarding);
		}

		if (file.isFile()) {
			FileInputStream fileInputStream = new FileInputStream(file.getAbsoluteFile());
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			Sheet sheet = !hoja.isEmpty() ? workbook.getSheet(hoja) : workbook.getSheetAt(0);
			int ultimaFilaAfectada = sheet.getLastRowNum();
			int ultimaColumanaAfectada = sheet.getRow(0).getLastCellNum();
			Variables.numeroColumnas = ultimaColumanaAfectada;
			Variables.contador.add(hoja);
			for (int i = 1; i <= ultimaFilaAfectada; i++) {
				usar = sheet.getRow(i).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				reg = new ArrayList<String>();

				reg.add(String.valueOf(i));

				if (usar.toUpperCase().equals(Constantes.usar) || usar.compareToIgnoreCase("USAR") == 0) {

					System.out.println("ROW  " + i + "USAR:    " + usar);
					for (int j = 1; j < ultimaColumanaAfectada; j++) {
						reg.add(sheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
								.getStringCellValue());

					}
					Variables.contador.add("%" + i);
					data.add(reg);
				}

			}

			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
			workbook.close();
			fileOutputStream.close();
		}

		return data;
	}

	public List<List<String>> leerDDPagos(String hoja) throws Exception {
		List<List<String>> data = new ArrayList<List<String>>();
		List<String> reg = null;

		String usar = "";
		System.out.println("HOJAS " + hoja);
		SmbFile dir = null;
		File file = null;
		if (Constantes.UsarRemota.compareTo("SI") == 0) {
			// Codigo para manejo de archivo remoto
			NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(Constantes.dominioDP, Constantes.usuarioDP,
					Constantes.passwordDP);
			System.out.println("*********** " + Constantes.file_Pagos);
			try {
				dir = new SmbFile(Constantes.file_Pagos, auth);
				file = new File(dir.getUncPath());
				System.out.println("*********** " + file.getAbsolutePath());

			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else {
			file = new File(Constantes.file_Pagos);
		}

		if (file.isFile()) {
			FileInputStream fileInputStream = new FileInputStream(file.getAbsoluteFile());
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			Sheet sheet = !hoja.isEmpty() ? workbook.getSheet(hoja) : workbook.getSheetAt(0);
			int ultimaFilaAfectada = sheet.getLastRowNum();
			int ultimaColumanaAfectada = sheet.getRow(0).getLastCellNum();
			Variables.numeroColumnas = ultimaColumanaAfectada;
			Variables.contador.add(hoja);
			for (int i = 1; i <= ultimaFilaAfectada; i++) {
				usar = sheet.getRow(i).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				reg = new ArrayList<String>();

				reg.add(String.valueOf(i));

				if (usar.toUpperCase().equals(Constantes.usar) || usar.compareToIgnoreCase("USAR") == 0) {

					System.out.println("ROW  " + i + "USAR:    " + usar);
					for (int j = 1; j < ultimaColumanaAfectada; j++) {
						reg.add(sheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
								.getStringCellValue());

					}
					Variables.contador.add("%" + i);
					data.add(reg);
				}

			}

			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
			workbook.close();
			fileOutputStream.close();
		}

		return data;
	}
	public List<List<String>> leerDDConsultasVida(String hoja) throws Exception {
		List<List<String>> data = new ArrayList<List<String>>();
		List<String> reg = null;

		String usar = "";
		System.out.println("HOJAS " + hoja);
		SmbFile dir = null;
		File file = null;
		if (Constantes.UsarRemota.compareTo("SI") == 0) {
			// Codigo para manejo de archivo remoto
			NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(Constantes.dominioDP, Constantes.usuarioDP,
					Constantes.passwordDP);
			System.out.println("*********** " + Constantes.file_ConsultasVida);
			try {
				dir = new SmbFile(Constantes.file_ConsultasVida, auth);
				file = new File(dir.getUncPath());
				System.out.println("*********** " + file.getAbsolutePath());

			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else {
			file = new File(Constantes.file_ConsultasVida);
		}

		if (file.isFile()) {
			FileInputStream fileInputStream = new FileInputStream(file.getAbsoluteFile());
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			Sheet sheet = !hoja.isEmpty() ? workbook.getSheet(hoja) : workbook.getSheetAt(0);
			int ultimaFilaAfectada = sheet.getLastRowNum();
			int ultimaColumanaAfectada = sheet.getRow(0).getLastCellNum();
			Variables.numeroColumnas = ultimaColumanaAfectada;
			Variables.contador.add(hoja);
			for (int i = 1; i <= ultimaFilaAfectada; i++) {
				usar = sheet.getRow(i).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				reg = new ArrayList<String>();

				reg.add(String.valueOf(i));

				if (usar.toUpperCase().equals(Constantes.usar) || usar.compareToIgnoreCase("USAR") == 0) {

					System.out.println("ROW  " + i + "USAR:    " + usar);
					for (int j = 1; j < ultimaColumanaAfectada; j++) {
						reg.add(sheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
								.getStringCellValue());

					}
					Variables.contador.add("%" + i);
					data.add(reg);
				}

			}

			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
			workbook.close();
			fileOutputStream.close();
		}

		return data;
	}

	public List<List<String>> leerDDPerfil(String hoja) throws Exception {
		List<List<String>> data = new ArrayList<List<String>>();
		List<String> reg = null;

		String usar = "";
		System.out.println("HOJAS " + hoja);
		SmbFile dir = null;
		File file = null;
		if (Constantes.UsarRemota.compareTo("SI") == 0) {
			// Codigo para manejo de archivo remoto
			NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(Constantes.dominioDP, Constantes.usuarioDP,
					Constantes.passwordDP);
			System.out.println("*********** " + Constantes.file_Perfil);
			try {
				dir = new SmbFile(Constantes.file_Perfil, auth);
				file = new File(dir.getUncPath());
				System.out.println("*********** " + file.getAbsolutePath());

			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else {
			file = new File(Constantes.file_Perfil);
		}

		if (file.isFile()) {
			FileInputStream fileInputStream = new FileInputStream(file.getAbsoluteFile());
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			Sheet sheet = !hoja.isEmpty() ? workbook.getSheet(hoja) : workbook.getSheetAt(0);
			int ultimaFilaAfectada = sheet.getLastRowNum();
			int ultimaColumanaAfectada = sheet.getRow(0).getLastCellNum();
			Variables.numeroColumnas = ultimaColumanaAfectada;
			Variables.contador.add(hoja);
			for (int i = 1; i <= ultimaFilaAfectada; i++) {
				usar = sheet.getRow(i).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				reg = new ArrayList<String>();

				reg.add(String.valueOf(i));

				if (usar.toUpperCase().equals(Constantes.usar) || usar.compareToIgnoreCase("USAR") == 0) {

					System.out.println("ROW  " + i + "USAR:    " + usar);
					for (int j = 1; j < ultimaColumanaAfectada; j++) {
						reg.add(sheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
								.getStringCellValue());

					}
					Variables.contador.add("%" + i);
					data.add(reg);
				}

			}

			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
			workbook.close();
			fileOutputStream.close();
		}

		return data;
	}

	public List<List<String>> leerDDServiciosSalud(String hoja) throws Exception {
		List<List<String>> data = new ArrayList<List<String>>();
		List<String> reg = null;

		String usar = "";
		System.out.println("HOJAS " + hoja);
		SmbFile dir = null;
		File file = null;
		if (Constantes.UsarRemota.compareTo("SI") == 0) {
			// Codigo para manejo de archivo remoto
			NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(Constantes.dominioDP, Constantes.usuarioDP,
					Constantes.passwordDP);
			System.out.println("*********** " + Constantes.file_ServiciosSalud);
			try {
				dir = new SmbFile(Constantes.file_ServiciosSalud, auth);
				file = new File(dir.getUncPath());
				System.out.println("*********** " + file.getAbsolutePath());

			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else {
			file = new File(Constantes.file_ServiciosSalud);
		}

		if (file.isFile()) {
			FileInputStream fileInputStream = new FileInputStream(file.getAbsoluteFile());
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			Sheet sheet = !hoja.isEmpty() ? workbook.getSheet(hoja) : workbook.getSheetAt(0);
			int ultimaFilaAfectada = sheet.getLastRowNum();
			int ultimaColumanaAfectada = sheet.getRow(0).getLastCellNum();
			Variables.numeroColumnas = ultimaColumanaAfectada;
			Variables.contador.add(hoja);
			for (int i = 1; i <= ultimaFilaAfectada; i++) {
				usar = sheet.getRow(i).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				reg = new ArrayList<String>();

				reg.add(String.valueOf(i));

				if (usar.toUpperCase().equals(Constantes.usar) || usar.compareToIgnoreCase("USAR") == 0) {

					System.out.println("ROW  " + i + "USAR:    " + usar);
					for (int j = 1; j < ultimaColumanaAfectada; j++) {
						reg.add(sheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
								.getStringCellValue());

					}
					Variables.contador.add("%" + i);
					data.add(reg);
				}
			}
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
			workbook.close();
			fileOutputStream.close();
		}

		return data;
	}

	public List<List<String>> leerDDServiciosVehiculares(String hoja) throws Exception {
		List<List<String>> data = new ArrayList<List<String>>();
		List<String> reg = null;

		String usar = "";
		System.out.println("HOJAS " + hoja);
		SmbFile dir = null;
		File file = null;
		if (Constantes.UsarRemota.compareTo("SI") == 0) {
			// Codigo para manejo de archivo remoto
			NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(Constantes.dominioDP, Constantes.usuarioDP,
					Constantes.passwordDP);
			System.out.println("*********** " + Constantes.file_ServiciosVehiculares);
			try {
				dir = new SmbFile(Constantes.file_ServiciosVehiculares, auth);
				file = new File(dir.getUncPath());
				System.out.println("*********** " + file.getAbsolutePath());

			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else {
			file = new File(Constantes.file_ServiciosVehiculares);
		}

		if (file.isFile()) {
			FileInputStream fileInputStream = new FileInputStream(file.getAbsoluteFile());
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			Sheet sheet = !hoja.isEmpty() ? workbook.getSheet(hoja) : workbook.getSheetAt(0);
			int ultimaFilaAfectada = sheet.getLastRowNum();
			int ultimaColumanaAfectada = sheet.getRow(0).getLastCellNum();
			Variables.numeroColumnas = ultimaColumanaAfectada;
			Variables.contador.add(hoja);
			for (int i = 1; i <= ultimaFilaAfectada; i++) {
				usar = sheet.getRow(i).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				reg = new ArrayList<String>();

				reg.add(String.valueOf(i));

				if (usar.toUpperCase().equals(Constantes.usar) || usar.compareToIgnoreCase("USAR") == 0) {

					System.out.println("ROW  " + i + "USAR:    " + usar);
					for (int j = 1; j < ultimaColumanaAfectada; j++) {
						reg.add(sheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
								.getStringCellValue());

					}
					Variables.contador.add("%" + i);
					data.add(reg);
				}
			}
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
			workbook.close();
			fileOutputStream.close();
		}

		return data;
	}

	public List<List<String>> leerDDTramitesSiniestros(String hoja) throws Exception {
		List<List<String>> data = new ArrayList<List<String>>();
		List<String> reg = null;

		String usar = "";
		System.out.println("HOJAS " + hoja);
		SmbFile dir = null;
		File file = null;
		if (Constantes.UsarRemota.compareTo("SI") == 0) {
			// Codigo para manejo de archivo remoto
			NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(Constantes.dominioDP, Constantes.usuarioDP,
					Constantes.passwordDP);
			System.out.println("*********** " + Constantes.file_TramitesSiniestros);
			try {
				dir = new SmbFile(Constantes.file_TramitesSiniestros, auth);
				file = new File(dir.getUncPath());
				System.out.println("*********** " + file.getAbsolutePath());

			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else {
			file = new File(Constantes.file_TramitesSiniestros);
		}

		if (file.isFile()) {
			FileInputStream fileInputStream = new FileInputStream(file.getAbsoluteFile());
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			Sheet sheet = !hoja.isEmpty() ? workbook.getSheet(hoja) : workbook.getSheetAt(0);
			int ultimaFilaAfectada = sheet.getLastRowNum();
			int ultimaColumanaAfectada = sheet.getRow(0).getLastCellNum();
			Variables.numeroColumnas = ultimaColumanaAfectada;
			Variables.contador.add(hoja);
			for (int i = 1; i <= ultimaFilaAfectada; i++) {
				usar = sheet.getRow(i).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				reg = new ArrayList<String>();

				reg.add(String.valueOf(i));

				if (usar.toUpperCase().equals(Constantes.usar) || usar.compareToIgnoreCase("USAR") == 0) {

					System.out.println("ROW  " + i + "USAR:    " + usar);
					for (int j = 1; j < ultimaColumanaAfectada; j++) {
						reg.add(sheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
								.getStringCellValue());

					}
					Variables.contador.add("%" + i);
					data.add(reg);
				}
			}
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
			workbook.close();
			fileOutputStream.close();
		}

		return data;
	}

	public List<List<String>> leerDDServiciosSoat(String hoja) throws Exception {
		List<List<String>> data = new ArrayList<List<String>>();
		List<String> reg = null;

		String usar = "";
		System.out.println("HOJAS " + hoja);
		SmbFile dir = null;
		File file = null;
		if (Constantes.UsarRemota.compareTo("SI") == 0) {
			// Codigo para manejo de archivo remoto
			NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(Constantes.dominioDP, Constantes.usuarioDP,
					Constantes.passwordDP);
			System.out.println("*********** " + Constantes.file_ServiciosSoat);
			try {
				dir = new SmbFile(Constantes.file_ServiciosSoat, auth);
				file = new File(dir.getUncPath());
				System.out.println("*********** " + file.getAbsolutePath());

			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else {
			file = new File(Constantes.file_ServiciosSoat);
		}

		if (file.isFile()) {
			FileInputStream fileInputStream = new FileInputStream(file.getAbsoluteFile());
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			Sheet sheet = !hoja.isEmpty() ? workbook.getSheet(hoja) : workbook.getSheetAt(0);
			int ultimaFilaAfectada = sheet.getLastRowNum();
			int ultimaColumanaAfectada = sheet.getRow(0).getLastCellNum();
			Variables.numeroColumnas = ultimaColumanaAfectada;
			Variables.contador.add(hoja);
			for (int i = 1; i <= ultimaFilaAfectada; i++) {
				usar = sheet.getRow(i).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				reg = new ArrayList<String>();

				reg.add(String.valueOf(i));

				if (usar.toUpperCase().equals(Constantes.usar) || usar.compareToIgnoreCase("USAR") == 0) {

					System.out.println("ROW  " + i + "USAR:    " + usar);
					for (int j = 1; j < ultimaColumanaAfectada; j++) {
						reg.add(sheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
								.getStringCellValue());

					}
					Variables.contador.add("%" + i);
					data.add(reg);
				}

			}

			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
			workbook.close();
			fileOutputStream.close();
		}

		return data;
	}
	@Override
	public List<List<String>> leerUltimaFilaDD(String hoja) throws EncryptedDocumentException, IOException {
		List<List<String>> data = new ArrayList<List<String>>();
		List<String> reg = null;

		String usar = "";
		System.out.println("HOJAS " + hoja);
		SmbFile dir = null;
		File file = null;
		if (Constantes.UsarRemota.compareTo("SI") == 0) {
			// Codigo para manejo de archivo remoto
			NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(Constantes.dominioDP, Constantes.usuarioDP,
					Constantes.passwordDP);
			System.out.println("*********** " + Constantes.fileData_01);
			try {
				dir = new SmbFile(Constantes.fileData_01, auth);
				file = new File(dir.getUncPath());
				System.out.println("*********** " + file.getAbsolutePath());

			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else {
			file = new File(Constantes.fileData_01);
		}

		if (file.isFile()) {
			FileInputStream fileInputStream = new FileInputStream(file.getAbsoluteFile());
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			Sheet sheet = !hoja.isEmpty() ? workbook.getSheet(hoja) : workbook.getSheetAt(0);
			int ultimaFilaAfectada = sheet.getLastRowNum();
			int ultimaColumanaAfectada = sheet.getRow(0).getLastCellNum();
			Variables.numeroColumnas = ultimaColumanaAfectada;
			Variables.contador.add(hoja);

			if(ultimaFilaAfectada>=1) {
				usar = sheet.getRow(ultimaFilaAfectada).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				reg = new ArrayList<String>();

				reg.add(String.valueOf(ultimaFilaAfectada));

				if (usar.toUpperCase().equals(Constantes.usar)) {

					System.out.println("ROW  " + ultimaFilaAfectada + "USAR:    " + usar);
					for (int j = 1; j < ultimaColumanaAfectada; j++) {
						reg.add(sheet.getRow(ultimaFilaAfectada).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
								.getStringCellValue());

					}
					Variables.contador.add("%" + ultimaFilaAfectada);
					data.add(reg);
				}
			}

			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
			workbook.close();
			fileOutputStream.close();
		}

		return data;
	}

	@Override
	public void escribirDD(String string, String id) throws Exception {
	}

	@Override
	public void escribirNuevoDD(List<String> listaString, int dataDriven) throws Exception {
	}

	@Override
	public void escribirNuevoDD(String string, int dataDriven) throws Exception {
	}

	@Override
	public void escribirDD(List<String> listaString, String id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void escribirDD(List<String> listaString, int filaAEscribir) throws Exception {
		// TODO Auto-generated method stub

	}

	public void writeReembolsoinExcel(List<String> listaString) throws EncryptedDocumentException, FileNotFoundException, IOException {

		FileInputStream fileInputStream = new FileInputStream(new File(Constantes.fileData_01));
		Workbook libroExcel = WorkbookFactory.create(fileInputStream);
		Sheet hojaActual = libroExcel.getSheetAt(0);

		int nrofilaExistentes = hojaActual.getLastRowNum();

		for(int i=0; i<listaString.size();i++){
			System.out.println("Elemento "+listaString.get(i));
		}

		if(nrofilaExistentes>=5) {
			for(int i=1; i<=nrofilaExistentes; i++) {
				Row removingRow=hojaActual.getRow(hojaActual.getLastRowNum());
				if(removingRow!=null){
					hojaActual.removeRow(removingRow);
				}
			}
		}

		int nrofila = hojaActual.getLastRowNum()+1;

		hojaActual.createRow(nrofila).createCell(0, CellType.STRING).setCellValue("X");
		hojaActual.getRow(nrofila).createCell(1, CellType.STRING).setCellValue("DNI");
		hojaActual.getRow(nrofila).createCell(2, CellType.STRING).setCellValue(listaString.get(0));
		hojaActual.getRow(nrofila).createCell(3, CellType.STRING).setCellValue(listaString.get(1));
		hojaActual.getRow(nrofila).createCell(4, CellType.STRING).setCellValue(listaString.get(2));

		fileInputStream.close();
		FileOutputStream fileOutputStream = new FileOutputStream(Constantes.fileData_01);
		libroExcel.write(fileOutputStream);

		fileOutputStream.close();

	}

	@Override
	public void escribirDD(String string, int filaAEscribir) {
		// TODO Auto-generated method stub

	}
}
