package admin;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.ExcelUtility;
import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtility;

public class ChangeStatusOfAnOrderedProductTest {
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverUtility wUtil=new WebDriverUtility();
		JavaUtility jUtil=new JavaUtility();
		ExcelUtility eUtil=new ExcelUtility();
		FileUtility fUtil=new FileUtility();
		
		int rn=jUtil.getRandomNo();
		String browser=fUtil.readDataFromPropertyFile("browser");
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
		
		if(browser.equals("chrome"))
			driver=new ChromeDriver();
		else if(browser.equals("edge"))
			driver=new EdgeDriver();
		else if(browser.equals("firefox"))
			driver=new FirefoxDriver();
		else
			System.out.println("INVALID!!!!");
		System.out.println("Browser Launched");
			
		
		wUtil.maximizeWindow(driver);
		System.out.println("Window Maximized");
		wUtil.implicitWait(driver, 20);
		
		driver.get(adminUrl);
		System.out.println("Navigated to the admin url");
		driver.findElement(By.id("inputEmail")).sendKeys(adminUsername);
		driver.findElement(By.id("inputPassword")).sendKeys(adminPassword);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		System.out.println("Logged In");
		
		driver.findElement(By.xpath("//a[contains(text(),'Create Category')]")).click();
		driver.findElement(By.name("category")).sendKeys(category);
		driver.findElement(By.name("description")).sendKeys("Useful");
		driver.findElement(By.name("submit")).click();
		System.out.println("Category created");
		
		driver.findElement(By.xpath("//a[contains(text(),'Sub Category')]")).click();
		WebElement ctDropdown = driver.findElement(By.xpath("//select[@name=\"category\"]"));
		wUtil.selectFromADropDown(ctDropdown, category);
		driver.findElement(By.xpath("//input[@placeholder='Enter SubCategory Name']")).sendKeys(subCategory);
		driver.findElement(By.name("submit")).click();
		System.out.println("Sub-Category created");
		
		driver.findElement(By.xpath("//a[contains(text(),'Insert Product')]")).click();
		WebElement iCtDropdown = driver.findElement(By.xpath("//select[@name=\"category\"]"));
		wUtil.selectFromADropDown(iCtDropdown, category);
		WebElement iSctDropdown = driver.findElement(By.xpath("//select[@name=\"subcategory\"]"));
		wUtil.selectFromADropDown(iSctDropdown, subCategory);
		driver.findElement(By.name("productName")).sendKeys(productName);
		driver.findElement(By.name("productCompany")).sendKeys(productCompany);
		driver.findElement(By.name("productpricebd")).sendKeys(productPriceBD);
		driver.findElement(By.name("productprice")).sendKeys(productPriceAD);
		driver.findElement(By.name("productShippingcharge")).sendKeys(shippingCharge);
		WebElement availabilityDropdown = driver.findElement(By.xpath("//select[@name=\"productAvailability\"]"));
		wUtil.selectFromADropDown(availabilityDropdown, productAvailability);
		driver.findElement(By.id("productimage1")).sendKeys("D:\\Automatio\\com.e-commerce.EasyWhiz\\src\\test\\resources\\pictures\\pic1.png");
		driver.findElement(By.name("productimage2")).sendKeys("D:\\Automatio\\com.e-commerce.EasyWhiz\\src\\test\\resources\\pictures\\pic2.png");
		//driver.findElement(By.name("productimage3")).sendKeys(ue.select_Excel("image"));
		driver.findElement(By.name("submit")).click();
		System.out.println("Product created");
		driver.findElement(By.partialLinkText("Logout")).click();
		System.out.println("Admin logged out");
		
		driver.navigate().to(userUrl);
		System.out.println("Navigated to user url");
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(userEmail);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(userPassword);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		System.out.println("User logged in");
		driver.findElement(By.xpath("//input[@class='search-field']")).sendKeys(productName);
		driver.findElement(By.xpath("//button[@class='search-button']")).click();
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		wUtil.selectOKInAlertPopUp(driver);
		String parentId = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[text()='PROCCED TO CHEKOUT']")).click();
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//tr[last()]/td[last()]//a")).click();
		
		wUtil.switchToChildBorwser(driver, "Order Tracking Details");
		String orderStatus=driver.findElement(By.xpath("//b[text()='order Id:']/ancestor::tr/following-sibling::tr//td")).getText();
		String orderId=driver.findElement(By.xpath("//td[@class=\"fontkink\"]")).getText();
		System.out.println("Order Id: "+orderId);
		System.out.println("status: "+orderStatus);
		driver.close();
		
		driver.switchTo().window(parentId);
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("User logged out");
		
		driver.navigate().to(adminUrl);
		System.out.println("Navigated to the admin url");
		driver.findElement(By.id("inputEmail")).sendKeys(adminUsername);
		driver.findElement(By.id("inputPassword")).sendKeys(adminPassword);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		System.out.println("Admin Logged In");
		
		driver.findElement(By.xpath("//a[@href=\"#togglePages\"]")).click();
		driver.findElement(By.xpath("//a[@href=\"pending-orders.php\"]")).click();
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(productName);
		driver.findElement(By.xpath("//a[@title=\"Update order\"]")).click();
		String adminWindow = driver.getWindowHandle();
		
		wUtil.switchToChildBorwser(driver, "Update");
		wUtil.selectFromADropDown(driver.findElement(By.name("status")), "Delivered");
		driver.findElement(By.name("remark")).sendKeys("Enjoy");
		driver.findElement(By.name("submit2")).click();
		wUtil.selectOKInAlertPopUp(driver);
		
		String status = driver.findElement(By.xpath("//b[text()='Status:']/../..//td[@class=\"fontkink\"]")).getText();
		System.out.println("Status changed by admin to: "+status);
		driver.close();
		
		//driver.switchTo().window(adminWindow);
		wUtil.switchToChildBorwser(driver, adminWindow);
		driver.navigate().to(userUrl);
		System.out.println("Navigated to the user url");
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(userEmail);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(userPassword);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Order History")).click();
		driver.findElement(By.xpath("//a[contains(text(),'"+productName+"')]/ancestor::tr/descendant::a[@title=\"Track order\"]")).click();
		wUtil.switchToChildBorwser(driver, "Tracking");
		
		System.out.println(driver.getTitle());
		String updatedStatus = driver.findElement(By.xpath("//b[text()='Status:']/../..//td[@class=\"fontkink\"]")).getText();
		System.out.println("Status in User module: "+updatedStatus);
		if(updatedStatus.equals(status))
			System.out.println("Pass");
		else
			System.out.println("False");
		
		Thread.sleep(3000);
		driver.quit();

	}

}
