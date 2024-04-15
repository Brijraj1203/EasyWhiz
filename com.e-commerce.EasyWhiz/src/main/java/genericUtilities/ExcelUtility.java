package genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author Brijraj
 */
public class ExcelUtility {
	
	/**
	 * This method is used to read data from Excel sheet
	 * @author Brijraj
	 * @param shetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		String value = sh.getRow(rowNo).getCell(cellNo).getStringCellValue();
		wb.close();
		return value;
	}
	/**
	 * this method is used to write value in a cell of a existing excel sheet
	 * @author Brijraj 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName,int rowNo,int cellNo,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		sh.createRow(rowNo).createCell(cellNo).setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(IPathConstant.ExcelPath);
		wb.write(fos);
		wb.close();
	}
	/**
	 *this method is used to fetch number of rows in a sheet
	 * @author Brijraj
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getTotalRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		return sh.getLastRowNum();
	}
	
	/**
	 * this method converts a key value pair data in an excel sheet into a HashMap
	 * where key is common locator strategy of textfields and value is data to be passed in that textfield
	 * @param sheetName
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public HashMap<String, String> readMultipleData(String sheetName,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount=sh.getLastRowNum();
		
		HashMap<String, String> map=new HashMap<String, String>();
		for(int i=0;i<=rowCount;i++)
		{
			String key= sh.getRow(i).getCell(cellNo).getStringCellValue();
			String value= sh.getRow(i).getCell(cellNo+1).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}

}
