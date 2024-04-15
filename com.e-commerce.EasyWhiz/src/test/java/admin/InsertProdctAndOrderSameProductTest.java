package admin;

import java.io.IOException;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelUtility;
import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtility;
import pomRepository.AdminHomePage;
import pomRepository.AdminLoginPage;
import pomRepository.CategoryPage;
import pomRepository.InsertProductPage;
import pomRepository.MyCartPage;
import pomRepository.OrderHistoryPage;
import pomRepository.PaymentMethodPage;
import pomRepository.SearchResultForUserPage;
import pomRepository.SubCategoryPage;
import pomRepository.UserAuthenticationPage;
import pomRepository.UserHomePage;

public class InsertProdctAndOrderSameProductTest extends BaseClass{
	@Test
	public void insertProdctAndOrderSameProductTest() throws IOException, InterruptedException {
//		ChromeOptions opt=new ChromeOptions();
//		opt.addArguments("--headless");
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
		
		String pic1Path="D:\\Automatio\\com.e-commerce.EasyWhiz\\src\\test\\resources\\pictures\\pic1.png";
		String picSecondPath="D:\\Automatio\\com.e-commerce.EasyWhiz\\src\\test\\resources\\pictures\\pic2.png";
		adminHomePage.clickOnInsertProductLink();
		insertProductPage.insertProduct(wUtil, category, subCategory, productName, productCompany, productPriceBD, productPriceAD, shippingCharge, productAvailability, pic1Path, picSecondPath);
		
		adminHomePage.clickOnLogoutLink();
		System.out.println("Admin logged out");
		
		driver.navigate().to(userUrl);
		System.out.println("--navigated to user url");
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
		
		

	}

}
