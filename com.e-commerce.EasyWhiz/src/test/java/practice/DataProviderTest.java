package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import genericUtilities.IPathConstant;

public class DataProviderTest {
	@DataProvider
	public Object[][] adminLoginData()
	
	{
		Object [][] admin=new Object[2][2];
		admin[0][0]="admin";
		admin[0][1]="Test@123";
		
		admin[1][0]="admin";
		admin[1][1]="test@123";
		
		return admin;
	}
	
	@DataProvider
	public Object[][] loginData()
	
	{
		Object [][] login=new Object[2][3];
		login[0][0]="admin";
		login[0][1]="Test@123";
		login[0][2]="admin";
		
		login[1][0]="shopper@gmail.com";
		login[1][1]="password";
		login[1][2]="user";
		
		return login;
	}
	
	@DataProvider
	public Object[][] loginDataCrossBrowser()
	
	{
		Object [][] login=new Object[2][3];
		login[0][0]="admin";
		login[0][1]="Test@123";
		login[0][2]="chrome";
		
		login[1][0]="admin";
		login[1][1]="Test@123";
		login[1][2]="firefox";
		
		return login;
	}
	
	@DataProvider
	public Object[][] dataFromExcel() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DataProvider");
		int rowCount = sh.getLastRowNum();
		short cellCount = sh.getRow(0).getLastCellNum();
		
		Object[][] login=new Object[rowCount+1][cellCount];
		
		for(int i=0; i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				login[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return login;
		
	}

}
