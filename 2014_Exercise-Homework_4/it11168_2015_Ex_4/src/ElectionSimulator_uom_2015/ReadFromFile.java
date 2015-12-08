package ElectionSimulator_uom_2015;


import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetDimension;

/**
 * Klash gia thn ylopoihsh twn vasikwn leitourgiwn sarwshs apo arxeia xlsx.
 * 
 * @author VAIRLIS CHARALAMPOS - it11168 UOM
 * 
 */
public class ReadFromFile {
	
	private final int correctFileRows = 6;
	private final int correctFileCells = 6;
	
	private XSSFWorkbook workbook;
	
	public ReadFromFile(){	
	}


	/**
	 * Methodos pou epistrefei 2d Array me strings.
	 * Ousiastika metatrepei to spreadsheet tou arxeiou pou dothike
	 * se enan 2d pinaka me ta stoixeia pou theloume.
	 * Xrhsimopoieitai sto deutero senario xrhshs.
	 * 
	 * @param String path
	 * @return String[][]
	 * @throws Exception
	 */
	public String[][] getResultsFromExcelFile(String path) throws Exception {
		
		String[][] resultsTable = new String[correctFileRows][correctFileCells];
		
		// arxikopoihsh twn stoixeiwn tou pinaka me to string "keno"
		for (int i=0; i<6; i++){
			for (int j=0; j<6; j++){
				resultsTable[i][j] = "keno";
			}
		}
		
		String message = "";
		boolean problemWithTheFile = false;
		FileInputStream ExcelToRead = null;
		
		try {
			ExcelToRead = new FileInputStream(path);
			workbook = new XSSFWorkbook(ExcelToRead);
			//DataFormatter formatter = new DataFormatter();
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();
			//Iterator<Row> rowIterator = sheet.iterator();
			
			CTSheetDimension dimension = sheet.getCTWorksheet().getDimension();
			String sheetDimensions = dimension.getRef();
			
			
			// prwtos elegxos - elegxos diastasewn tou dothentos ypologistikou fyllou
			if (!sheetDimensions.equals("A1:F6")){
				
				// metavliti me thn opoia vriskoume kapoio lathos sto arxeio
				// kai parakamptoume th sarwsh tou
				problemWithTheFile = true;
				/* an yparxei kapoio lathos stis diastaseis tou dothentos arxeiou h problemWithFile ginetai true
				 * kai etsi den mpainei kan sth diadikasia ths sarwshs (parse) tou arxeiou
				 * h methodos epistrefei ena 2d string array pou sth prwth grammh to prwto stoixeio einai 
				 * to string "keno" kai to deutero stoixeio einai to string message me to ti phge strava.
				 * an den yparxei lathos ston pinaka h diadikasia synexizetai kanonika
				 * opote h dataexchange elegxei to ti epetrepse o pinakas kai epistrefei ena string sto GUI
				 * 
				 */
				message = message +"Something bad happen while trying to read data from excel (.xlsx) file. \n"+
									"Reason: Wrong SpreadSheet Dimensions / Lathos diastaseis selidas Excel. \n" + 
									"Expected Dimensions [A1:F6] " +
									"Found Dimensions " + "[" + sheetDimensions + "] \n";
				// to mhnyma sfalmatos apothikeuetai sth prwth grammh sth deuterh sthlh 
				// tou 2d array
				resultsTable[0][1] = message; 
				
			}
			
			int i=0; 
			while (!problemWithTheFile && i<rows){
				XSSFRow row = sheet.getRow(i);
				int cells = 6;
				
				int j = 0;
				while (!problemWithTheFile && j<cells){
					
					XSSFCell cell = row.getCell(j);
					if (cell == null) {
						resultsTable[i][j] = "-";
					} else {
						String value = cellToString(cell, workbook);
						resultsTable[i][j] = value;
					}
					j++;
				}
				i++;
			}
			//aparaithth h entolh gia kleisimo tou input stream		
			ExcelToRead.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		
		// epistrofh pinaka 6x6 sto DataExchange object
		return resultsTable;	
	}
	
	
	/**
	 * Methodos me thn opoia sarwnetai kathe cell tou excel file kai epistrefetai se string.
	 *  
	 * @param XSSFCell cell
	 * @param XSSFWorkbook wb
	 * @return String px Donkeys or 123 (as String)
	 */
	public String cellToString (XSSFCell cell, XSSFWorkbook wb) {
		
		FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
		int typee = evaluator.evaluateInCell(cell).getCellType();
		String result ="";
		
		if (typee == XSSFCell.CELL_TYPE_BLANK){
			result = "";
		} else if (typee == XSSFCell.CELL_TYPE_STRING) {
			result = String.valueOf(cell);
		} else if (typee == XSSFCell.CELL_TYPE_NUMERIC){
			result = String.valueOf(cell.getNumericCellValue());
		} else {
			result = "";
		}	
		
		return result;
	}
	
	

	/**
	 * Methodos h opoia diavazei to arxeio eklogikos katalogos kai epistrefei mia lista me antikeimena typou Voter.
	 * Ousiastika sarwnei kathe grammh tou Eklogikou katalogou kai dhmiourgei kathe fora ena antikeimeno to opoio sto telos prosthetei se mia lista List<Voter>.
	 * @return List<Voter> Voters
	 */
	public List<Voter> getPermittedVotersFromExcelFile(){
		
		List<Voter> permittedUserList = new ArrayList<Voter>();
		FileInputStream ExcelFileToRead = null;
		
		try {
			
			ExcelFileToRead = new FileInputStream(new File("EKLOGIKOS_KATALOGOS.xlsx"));
			
			workbook = new XSSFWorkbook(ExcelFileToRead);
			DataFormatter formatter = new DataFormatter();
			
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			//XSSFRow row;
			//XSSFCell cell;
			//int num = sheet.getLastRowNum();
			Iterator<Row> rowIterator = sheet.iterator();
			
			while (rowIterator.hasNext()){
				
				Voter user = new Voter();
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				
				while (cellIterator.hasNext()){
					
					Cell cell = cellIterator.next();
					if (Cell.CELL_TYPE_STRING == cell.getCellType()){		
						user.setName(cell.getStringCellValue());
					}else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()){
						if (cell.getColumnIndex() == 1){
							user.setCode(formatter.formatCellValue(cell));				
						} else if (cell.getColumnIndex() == 2){
							user.setAfm(formatter.formatCellValue(cell));
						}
					}					
				}
				if (user.getAfm()==null ||user.getCode()==null || user.getName()==null){
				} else {
					permittedUserList.add(user);
				}
			}
			ExcelFileToRead.close();		
		}catch (Exception e){
			e.printStackTrace();
		} 
		
		return permittedUserList;		
	}
	
	
	/**
	 * Methodos h opoia sarwnei to arxeio Kommata kai epistrefei lista me String san onomata kommatwn.
	 * Xrhsimopoieitai kata thn ekkinhsh tou programmatos, mia fora kai meta de ksana xrhsimopoieitai gt to programma anakta auta ta onomata apo to .ser arxeio.
	 * @return List<String> onomata kommatwn apo arxeio
	 */
	public List<String> getPartiesFromFile(){
		
		List<String> politicalPartiesList = new ArrayList<>();
		FileInputStream ExcelFileToRead = null;
		
		try {
			ExcelFileToRead = new FileInputStream(new File("KOMMATA.xlsx"));
			workbook = new XSSFWorkbook(ExcelFileToRead);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			for (int i=1; i<5; i++){
				XSSFRow row = sheet.getRow(i);
				XSSFCell cell = row.getCell(0);
				if (Cell.CELL_TYPE_STRING == cell.getCellType()){
					politicalPartiesList.add(cell.getStringCellValue());
				}
			}
			ExcelFileToRead.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		return politicalPartiesList;
	}
	

}
