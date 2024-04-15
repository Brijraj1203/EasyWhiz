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
public class SubCategoryPage {
	
	@FindBy(xpath="//select[@name='category']")
	private WebElement categoryDropdown;
	
	@FindBy(xpath="//input[@placeholder='Enter SubCategory Name']")
	private WebElement subCategoryTextfield;
	
	@FindBy(name="submit")
	private WebElement createButton;
	
	public SubCategoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getCategoryDropdown() {
		return categoryDropdown;
	}


	public WebElement getSubCategoryTextfield() {
		return subCategoryTextfield;
	}


	public WebElement getCreateButton() {
		return createButton;
	}
	
	/**
	 * creates a sub category by selecting a existing category from dropdown
	 * @param wUtil
	 * @param category
	 * @param subCategory
	 */
	public void createSubCategry(WebDriverUtility wUtil,String category,String subCategory)
	{
		wUtil.selectFromADropDown(categoryDropdown, category);
		//wUtil.javaScriptEnterValues(driver, subCategoryTextfield, subCategory);
		subCategoryTextfield.sendKeys(subCategory);
		createButton.click();
		System.out.println("Sub-Category created");
	}


	

}
