package admin;

import java.io.IOException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelUtility;
import genericUtilities.FileUtility;
import genericUtilities.IPathConstant;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtility;
import pomRepository.AdminHomePage;
import pomRepository.AdminLoginPage;
import pomRepository.CategoryPage;
import pomRepository.InsertProductPage;
import pomRepository.MyAccountPage;
import pomRepository.MyCartPage;
import pomRepository.OrderHistoryPage;
import pomRepository.PaymentMethodPage;
import pomRepository.PendingOrdersPage;
import pomRepository.SearchResultForUserPage;
import pomRepository.SubCategoryPage;
import pomRepository.UserAuthenticationPage;
import pomRepository.UserHomePage;

public class ChangeStatusOfOrderedProductTest extends BaseClass{
	@Test(retryAnalyzer = genericUtilities.RetryAnalyzerImpClass.class)
	public void changeStatusOfOrderedProductTest() throws IOException, InterruptedException {
		WebDriverUtility wUtil=new WebDriverUtility();
		JavaUtility jUtil=new JavaUtility();
		ExcelUtility eUtil=new ExcelUtility();
		FileUtility fUtil=new FileUtility();
		
		int rn = jUtil.getRandomNo();

		String adminUrl=fUtil.readDataFromPropertyFile("adminUrl");
		String adminUsername=fUtil.readDataFromPropertyFile("adminUserName");
		String adminPassword=fUtil.readDataFromPropertyFile("adminPassword");
		String userUrl=fUtil.readDataFromPropertyFile("userUrl");
		String userEmail=fUtil.readDataFromPropertyFile("userEmail");
		String userPassword=fUtil.readDataFromPropertyFile("userPassword");
		String category=eUtil.readDataFromExcel("InsertProduct", 1, 0)+rn;
		String subCategory=eUtil.readDataFromExcel("InsertProduct", 1, 1)+rn;
		String productName=eUtil.readDataFromExcel("InsertProduct", 1, 2)+rn;
		String productCompany=eUtil.readDataFromExcel("InsertProduct", 1, 3);
		String productPriceBD=eUtil.readDataFromExcel("InsertProduct", 1, 4);
		String productPriceAD=eUtil.readDataFromExcel("InsertProduct", 1, 5);
		String shippingCharge=eUtil.readDataFromExcel("InsertProduct", 1, 6);
		String productAvailability=eUtil.readDataFromExcel("InsertProduct", 1, 7);
		
		driver.get(adminUrl);
		System.out.println("--navigated to the admin url");
		
		AdminLoginPage adminLoginPage=new AdminLoginPage(driver);
		AdminHomePage adminHomePage=new AdminHomePage(driver);
		CategoryPage categoryPage=new CategoryPage(driver);
		SubCategoryPage subCategoryPage=new SubCategoryPage(driver);
		InsertProductPage insertProductPage=new InsertProductPage(driver);
		SearchResultForUserPage searchPageUser=new SearchResultForUserPage(driver);
		MyCartPage cartPage=new MyCartPage(driver);
		PaymentMethodPage paymentPage=new PaymentMethodPage(driver);
		OrderHistoryPage orderHisPage=new OrderHistoryPage(driver);
		
		adminLoginPage.loginToAppAsAdmin(adminUsername, adminPassword);
		
		adminHomePage.clickOnCreateCategoryLink();
		
		categoryPage.createCategory(category);
		
		adminHomePage.clickOnSubCategoryLink();
		//System.out.println(subCategory);
		subCategoryPage.createSubCategry(wUtil, category, subCategory);
		
		String pic1Path=IPathConstant.Pic1Path;
		String pic2Path=IPathConstant.Pic2Path;
		adminHomePage.clickOnInsertProductLink();
		insertProductPage.insertProduct(wUtil, category, subCategory, productName, productCompany, productPriceBD, productPriceAD, shippingCharge, productAvailability, pic1Path, pic2Path);
		
		adminHomePage.clickOnLogoutLink();
		System.out.println("Admin logged out");
		
		driver.navigate().to(userUrl);
		System.out.println("Navigated to user url");
		UserHomePage userHomePage=new UserHomePage(driver);
		UserAuthenticationPage userAuthPage=new UserAuthenticationPage(driver);
		
		userHomePage.clickOnLoginLink();
		
		userAuthPage.userLogin(userEmail, userPassword);
		System.out.println("User logged in");
		userHomePage.searchForProduct(productName);
		searchPageUser.addProductToCart(wUtil, driver);
		
		cartPage.clickOnProccedToChekoutButton();
		paymentPage.clickOnSubmitButton();
		
		
		orderHisPage.fetchTrackingDetails(driver,wUtil);
		
		userHomePage.clickOnLogoutButton();
		
		driver.navigate().to(adminUrl);
		System.out.println("Navigated to admin url");
		adminLoginPage.loginToAppAsAdmin(adminUsername, adminPassword);
		
		adminHomePage.clickOnPendingOrdersLink();
		PendingOrdersPage pndOrdPage=new PendingOrdersPage(driver);
		String statusChangeTo = pndOrdPage.searchProductAndChangeStatusToDelivered(productName, driver, wUtil);
		
		adminHomePage.clickOnLogoutLink();
		
		driver.navigate().to(userUrl);
		System.out.println("Navigated to user url");
		
		userHomePage.clickOnLoginLink();
		
		userAuthPage.userLogin(userEmail, userPassword);
		System.out.println("User logged in");
		userHomePage.clickOnMyAccountLink();
		
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.clickOnOrderHistoryLink();
		
		String status2 = orderHisPage.fetchStatusOfAProduct(driver, wUtil, productName);
		
		if(statusChangeTo.equals(status2))
			Reporter.log("Pass: Status change Verified",true);
		else
			Reporter.log("Fail",true);
		
		userHomePage.clickOnLogoutButton();


	}

}
