package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Brijraj
 */
public class MyAccountPage {
	public MyAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Shipping / Billing Address")
	private WebElement addressLink;
	
	@FindBy(linkText="Order History")
	private WebElement orderHistoryLink;
	
	@FindBy(linkText = "Payment Pending Order")
	private WebElement pendingOrderLink;
	
	

	public WebElement getAddressLink() {
		return addressLink;
	}

	public WebElement getPendingOrderLink() {
		return pendingOrderLink;
	}

	public WebElement getOrderHistoryLink() {
		return orderHistoryLink;
	}
	
	public void clickOnOrderHistoryLink()
	{
		orderHistoryLink.click();
	}
	
	public void clickOnPendingOrderLink()
	{
		pendingOrderLink.click();
	}
	
	public void clickOnAddressLink()
	{
		addressLink.click();
	}

}
