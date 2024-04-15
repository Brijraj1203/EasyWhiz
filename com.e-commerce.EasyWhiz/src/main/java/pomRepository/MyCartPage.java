package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Brijraj
 */
public class MyCartPage {
	public MyCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='PROCCED TO CHEKOUT']")
	private WebElement proccedToChekoutButton;

	public WebElement getProccedToChekoutButton() {
		return proccedToChekoutButton;
	}
	
	public void clickOnProccedToChekoutButton()
	{
		proccedToChekoutButton.click();
	}

}
