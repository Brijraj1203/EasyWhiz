package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * contains both signup and login
 * @author Brijraj
 */
public class UserAuthenticationPage {
	@FindBy(id="fullname")
	private WebElement fullnameTextfield;
	
	@FindBy(id="email")
	private WebElement emailCreateAccoutTextfield;
	
	@FindBy(id="contactno")
	private WebElement contactNoTextfield;
	
	@FindBy(id="password")
	private WebElement passwordTextfield;
	
	@FindBy(id="confirmpassword")
	private WebElement confirmpasswordTextfield;
	
	@FindBy(xpath="//button[text()='Sign Up']")
	private WebElement signUpButton;
	
	@FindBy(id="exampleInputEmail1")
	private WebElement loginEmailTextfield;
	
	@FindBy(id="exampleInputPassword1")
	private WebElement loginPassword1Textfield;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement loginButton;
	
	public UserAuthenticationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getFullnameTextfield() {
		return fullnameTextfield;
	}

	public WebElement getEmailCreateAccoutTextfield() {
		return emailCreateAccoutTextfield;
	}

	public WebElement getContactNoTextfield() {
		return contactNoTextfield;
	}

	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}

	public WebElement getConfirmpasswordTextfield() {
		return confirmpasswordTextfield;
	}

	public WebElement getSignUpButton() {
		return signUpButton;
	}

	public WebElement getLoginEmailTextfield() {
		return loginEmailTextfield;
	}

	public WebElement getLoginPassword1Textfield() {
		return loginPassword1Textfield;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	/**
	 * creates an user account by filling all the details
	 * @param fullName
	 * @param emailAdd
	 * @param contactNo
	 * @param password
	 * @param cPassword
	 */
	public void createAccount(String fullName, String emailAdd, String contactNo, String password, String cPassword)
	{
		fullnameTextfield.sendKeys(fullName);
		emailCreateAccoutTextfield.sendKeys(emailAdd);
		contactNoTextfield.sendKeys(contactNo);
		passwordTextfield.sendKeys(password);
		confirmpasswordTextfield.sendKeys(cPassword);
		signUpButton.click();
	}
	
	/**
	 * login for an already registered user
	 * @param emailAdd
	 * @param password
	 */
	public void userLogin(String emailAdd,String password)
	{
		loginEmailTextfield.sendKeys(emailAdd);
		loginPassword1Textfield.sendKeys(password);
		loginButton.click();
		System.out.println("logged in");
	}

}
