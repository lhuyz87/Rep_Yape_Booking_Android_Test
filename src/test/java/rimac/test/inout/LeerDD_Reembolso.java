package rimac.test.inout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;

import org.apache.poi.ss.usermodel.Sheet;

import rimac.main.util.Variables;
import rimac.test.util.*;


public class LeerDataDriven implements InOut {

	private ExcelUtilPropio excelUtilPropio = ExcelUtilPropio.getInstancia();
	private ExcelUtil excelUtil = new ExcelUtil();
	// singleton
	private static LeerDataDriven obj = null;

	private LeerDataDriven() {
	}

	public static LeerDataDriven getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new LeerDataDriven();
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
		if (rimac.main.util.Variables.UsarRemota.compareTo("SI") == 0) {
			// Codigo para manejo de archivo remoto
			NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(rimac.main.util.Variables.nombreDominio, rimac.main.util.Variables.userDominio,
					rimac.main.util.Variables.passDominio);
			System.out.println("*********** " + rimac.main.util.Variables.file_remota);
			try {
				dir = new SmbFile(rimac.main.util.Variables.file_remota, auth);
				file = new File(dir.getUncPath());
				System.out.println("*********** " + file.getAbsolutePath());

			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else {

			file = new File(rimac.main.util.Variables.file_local);

		}

		if (file.isFile()) {
			FileInputStream fileInputStream = new FileInputStream(file.getAbsoluteFile());
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			Sheet sheet = !hoja.isEmpty() ? workbook.getSheet(hoja) : workbook.getSheetAt(0);
			int ultimaFilaAfectada = sheet.getLastRowNum();
			int ultimaColumanaAfectada = sheet.getRow(0).getLastCellNum();
			rimac.main.util.Variables.numeroColumnas = ultimaColumanaAfectada;
			rimac.main.util.Variables.contador.add(hoja);
			for (int i = 1; i <= ultimaFilaAfectada; i++) {
				try {
					usar = sheet.getRow(i).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();

				} catch (Exception e) {
					// TODO: handle exception
				}
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
	public void escribirDD(List<String> listaString, String id) throws Exception {
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
}
