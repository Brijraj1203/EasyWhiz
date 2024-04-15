package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Brijraj
 */
public class CategoryPage {
	
	@FindBy(name="category")
	private WebElement categoryTextfield;
	
	@FindBy(name="description")
	private WebElement descriptionTextfield;
	
	@FindBy(name="submit")
	private WebElement createButton;
	
	public CategoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCategoryTextfield() {
		return categoryTextfield;
	}

	public WebElement getDescriptionTextfield() {
		return descriptionTextfield;
	}

	public WebElement getCreateButton() {
		return createButton;
	}
	
	/**
	 * creates category by taking category name as parameter
	 * @param category
	 */
	public void createCategory(String category)
	{
		categoryTextfield.sendKeys(category);
		descriptionTextfield.sendKeys("Useful");
		createButton.click();
		System.out.println("Category created");
	}
	

}
