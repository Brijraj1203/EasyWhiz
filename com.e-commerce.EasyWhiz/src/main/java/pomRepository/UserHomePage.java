package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Brijraj
 */
public class UserHomePage {
	
	public UserHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Login")
	private WebElement loginLink;
	
	@FindBy(xpath="//input[@class='search-field']")
	private WebElement searchField;
	
	@FindBy(xpath="//button[@class='search-button']")
	private WebElement searchButton;
	
	@FindBy(linkText="Logout")
	private WebElement logoutLink;
	
	@FindBy(linkText="My Account")
	private WebElement myAccountLink;
	
	

	public WebElement getMyAccountLink() {
		return myAccountLink;
	}


	public WebElement getLoginLink() {
		return loginLink;
	}
	
	
	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public void clickOnMyAccountLink()
	{
		myAccountLink.click();
	}
	
	public void clickOnLoginLink()
	{
		loginLink.click();
	}
	
	/**
	 * searches for a given product and clicks  on search button
	 * @param productName
	 */
	public void searchForProduct(String productName)
	{
		searchField.sendKeys(productName);
		searchButton.click();
	}
	
	public void clickOnLogoutButton()
	{
		logoutLink.click();
		System.out.println("logged out");
	}

}
