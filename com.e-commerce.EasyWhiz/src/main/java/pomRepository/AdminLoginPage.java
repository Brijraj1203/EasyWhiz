package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Brijraj
 */
public class AdminLoginPage {
	@FindBy(id="inputEmail")
	private WebElement userNameTextfield;
	
	@FindBy(id="inputPassword")
	private WebElement passwordTextfield;
	
	@FindBy(name="submit")
	private WebElement loginButton;
	
	@FindBy(xpath="//span[@style='color:red;']")
	private WebElement logoutSuccesfulMsg;
	
	public WebElement getLogoutSuccesfulMsg() {
		return logoutSuccesfulMsg;
	}

	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameTextfield() {
		return userNameTextfield;
	}

	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	/**
	 * login to application as admin by providing user name,password and click on login button
	 * @param userName
	 * @param password
	 */
	public void loginToAppAsAdmin(String userName, String password)
	{
		userNameTextfield.sendKeys(userName);
		passwordTextfield.sendKeys(password);
		loginButton.click();
	}

}
