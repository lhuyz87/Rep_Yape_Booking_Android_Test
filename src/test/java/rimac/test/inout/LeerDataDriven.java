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

import rimac.test.util.ExcelUtilPropio;
import rimac.test.util.Variables;
import rimac.util.Constantes;
import rimac.util.ExcelUtil;
import rimac.util.Inout;

public class LeerDataDriven implements Inout {

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
		SmbFile dir=null;
		File file = null;
		if(Variables.UsarRemota.compareTo("SI")==0) {
		//Codigo para manejo de archivo remoto
    	NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(Variables.dominioDP, Variables.usuarioDP, Variables.passwordDP);
       	System.out.println("*********** " + Variables.file_remota);
    	try {
			dir = new SmbFile(Variables.file_remota, auth);
			file = new File(dir.getUncPath());
			System.out.println("*********** " + file.getAbsolutePath());
			
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
    	}else {
    		
    		file = new File(Variables.file_local);
			
		}

		if (file.isFile()) {
			FileInputStream fileInputStream = new FileInputStream(file.getAbsoluteFile());
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			Sheet sheet = !hoja.isEmpty() ? workbook.getSheet(hoja) : workbook.getSheetAt(0);
			int ultimaFilaAfectada = sheet.getLastRowNum();
			int ultimaColumanaAfectada= sheet.getRow(0).getLastCellNum();
			Variables.numeroColumnas =ultimaColumanaAfectada;
			for (int i = 0; i <= ultimaFilaAfectada; i++) {
				try{
				usar = sheet.getRow(i).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				}catch (Exception e) {
					// TODO: handle exception
				}
				reg = new ArrayList<String>();
				reg.add(String.valueOf(i));
				if (usar.toUpperCase().equals(Constantes.usar)||usar.compareToIgnoreCase("USAR")==0) {
					
//					System.out.println("ROW  " + i + "USAR:    " + usar);
					for(int j=1; j<ultimaColumanaAfectada;j++) {
//					System.out.println("columna  " + j);	

						reg.add(sheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());

				
					}
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
