package pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

/**
 * 
 * @author Brijraj
 */
public class PendingOrdersPage {
	public PendingOrdersPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement searchTextfield;
	
	@FindBy(xpath="//a[@title='Update order']")
	private WebElement updateOrderButton;

	public WebElement getSearchTextfield() {
		return searchTextfield;
	}

	public WebElement getUpdateOrderButton() {
		return updateOrderButton;
	}
	
	/**
	 * searches for a given product and changes its status to delivered
	 * @param productName
	 * @param driver
	 * @param wUtil
	 * @return
	 */
	public String searchProductAndChangeStatusToDelivered(String productName,WebDriver driver,WebDriverUtility wUtil)
	
	{
		searchTextfield.sendKeys(productName);
		updateOrderButton.click();
		String adminWindow = driver.getWindowHandle();
		
		wUtil.switchToChildBorwser(driver, "Update");
		wUtil.selectFromADropDown(driver.findElement(By.name("status")), "Delivered");
		driver.findElement(By.name("remark")).sendKeys("Enjoy");
		driver.findElement(By.name("submit2")).click();
		wUtil.selectOKInAlertPopUp(driver);
		
		String status = driver.findElement(By.xpath("//b[text()='Status:']/../..//td[@class=\"fontkink\"]")).getText();
		System.out.println("Status changed by admin to: "+status);
		driver.close();
		wUtil.switchToChildBorwser(driver, adminWindow);
		return status;
	}
	

}
