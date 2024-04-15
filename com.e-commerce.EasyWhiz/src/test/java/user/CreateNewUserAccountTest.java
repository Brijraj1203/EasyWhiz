package user;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelUtility;
import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtility;
import pomRepository.UserAuthenticationPage;
import pomRepository.UserHomePage;

@Listeners(genericUtilities.ListenerImpClass.class)
public class CreateNewUserAccountTest extends BaseClass{
	
	@Test(retryAnalyzer = genericUtilities.RetryAnalyzerImpClass.class, priority=-1)
	public void createNewUserAccountTest() throws IOException, InterruptedException {
		WebDriverUtility wUtil=new WebDriverUtility();
		JavaUtility jUtil=new JavaUtility();
		ExcelUtility eUtil=new ExcelUtility();
		FileUtility fUtil=new FileUtility();
	
		int rn=jUtil.getRandomNo();
		String userUrl=fUtil.readDataFromPropertyFile("userUrl");
		String fullName=eUtil.readDataFromExcel("CreateAccount", 1, 0)+rn;
		String emailAdd=eUtil.readDataFromExcel("CreateAccount", 1, 1)+rn+"@gmail.com";
		String contactNo=eUtil.readDataFromExcel("CreateAccount", 1, 2);
		String password=eUtil.readDataFromExcel("CreateAccount", 1, 3);
		String cPassword=eUtil.readDataFromExcel("CreateAccount", 1, 4);

		
		
		
		
		driver.get(userUrl);
		System.out.println("--navigated to the url--");
		
		UserHomePage userHomePage=new UserHomePage(driver);
		UserAuthenticationPage userAuthPage=new UserAuthenticationPage(driver);
		
		userHomePage.clickOnLoginLink();
		
		userAuthPage.createAccount(fullName, emailAdd, contactNo, password, cPassword);
		
		
		System.out.println("Alert message: "+wUtil.getTextFromAlertPopUp(driver));
		wUtil.selectOKInAlertPopUp(driver);
		System.out.println("--alert handled--");
		Assert.fail();
		
		userAuthPage.userLogin(emailAdd, password);
		
		userHomePage.clickOnLogoutButton();

		//complted

		//Thank you
		

	}
	

}
