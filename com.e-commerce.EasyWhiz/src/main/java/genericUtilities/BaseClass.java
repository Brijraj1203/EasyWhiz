package genericUtilities;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


public class BaseClass {
	public WebDriverUtility wUtil=new WebDriverUtility();
	public DatabaseUtility dUtil=new DatabaseUtility();
	public FileUtility fUtil=new FileUtility();
	
	public WebDriver driver;
	
	public static WebDriver sDriver;
	
	
	@BeforeSuite(alwaysRun = true)
	public void connectionDB() throws SQLException
	{
		dUtil.connectToDB();
		Reporter.log("--database connection achieved--",true);
	}
	
	
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void launchTheBrowser() throws IOException
	{
		String browser = fUtil.readDataFromPropertyFile("browser");
		if(browser.contentEquals("chrome"))
			driver=new ChromeDriver();
		else if(browser.equalsIgnoreCase("firefox"))
			driver=new FirefoxDriver();
		else if(browser.equalsIgnoreCase("edge"))
			driver=new EdgeDriver();
		else
			System.out.println("InVaLiD OpTiOn");
		
		sDriver=driver;
		
		wUtil.maximizeWindow(driver);
		Reporter.log("--browser launched and maximized--",true);
		wUtil.implicitWait(driver, 20);
		
	}
	
	@AfterClass(alwaysRun = true)
	public void closeTheBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
		Reporter.log("--browser closed--",true);
	}
	
	@AfterSuite(alwaysRun = true)
	public void closeDBConnection() throws SQLException
	{
		dUtil.closeConnection();
		Reporter.log("--database connection closed--",true);
	}

}
