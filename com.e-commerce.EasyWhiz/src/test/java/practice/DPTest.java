package practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import pomRepository.AdminLoginPage;
import pomRepository.UserAuthenticationPage;
import pomRepository.UserHomePage;

public class DPTest {
	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "dataFromExcel")
	public void excelTest(String usrname,String pwd)
	{
		System.out.println(usrname+"-----"+pwd);
	}
	
	
	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "adminLoginData",enabled=false)
	public void loginAdmin(String username,String password)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
		AdminLoginPage adLogPage=new AdminLoginPage(driver);
		adLogPage.loginToAppAsAdmin(username, password);
	}
	
	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "loginData",enabled =false)
	public void login(String username,String password,String x)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		if(x.equals("admin"))
		{
			driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
			AdminLoginPage adLogPage=new AdminLoginPage(driver);
			adLogPage.loginToAppAsAdmin(username, password);
		}
		else
		{
			driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/");
			UserHomePage uHomPage=new UserHomePage(driver);
			uHomPage.clickOnLoginLink();
			UserAuthenticationPage uAuthPage=new UserAuthenticationPage(driver);
			uAuthPage.userLogin(username, password);
		}
		
	}
	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "loginDataCrossBrowser",enabled = false)
	public void loginAdminCrossBr(String username,String password,String browser) throws InterruptedException
	{
		WebDriver driver=null;
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
		AdminLoginPage adLogPage=new AdminLoginPage(driver);
		adLogPage.loginToAppAsAdmin(username, password);
		Thread.sleep(3000);
		driver.quit();
	}

}
