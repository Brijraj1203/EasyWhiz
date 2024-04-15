package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

/**
 * 
 * @author Brijraj
 */
public class SearchResultForUserPage {
	public SearchResultForUserPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='Add to cart']")
	private WebElement addToCartButton;
	
	public WebElement getAddToCartButton() {
		return addToCartButton;
	}
	
	/**
	 * clicks on add to cart button and handles alert popup
	 * @param wUtil
	 * @param driver
	 */
	public void addProductToCart(WebDriverUtility wUtil,WebDriver driver)
	{
		addToCartButton.click();
		wUtil.selectOKInAlertPopUp(driver);
	}
	

}
