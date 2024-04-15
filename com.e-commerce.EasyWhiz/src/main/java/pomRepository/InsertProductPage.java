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
public class InsertProductPage {
	
	public InsertProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@name='category']")
	private WebElement categoryDropdown;
	
	@FindBy(xpath="//select[@name='subcategory']")
	private WebElement subCategoryDropdown;
	
	@FindBy(name="productName")
	private WebElement productNameTextfield;
	
	@FindBy(name="productCompany")
	private WebElement productCompanyTextfield;
	
	@FindBy(name="productprice")
	private WebElement productpriceADTextfield;
	
	@FindBy(name="productpricebd")
	private WebElement productPriceBDTextfield;
	
	@FindBy(name="productShippingcharge")
	private WebElement productShippingchargeTextfield;
	
	@FindBy(xpath="//select[@name='productAvailability']")
	private WebElement availabilityDropdown;
	
	@FindBy(id="productimage1")
	private WebElement chooseImg1button;
	
	@FindBy(name="productimage2")
	private WebElement chooseImg2button;
	
	@FindBy(name="submit")
	private WebElement insertButton;

	public WebElement getCategoryDropdown() {
		return categoryDropdown;
	}

	public WebElement getSubCategoryDropdown() {
		return subCategoryDropdown;
	}

	public WebElement getProductNameTextfield() {
		return productNameTextfield;
	}

	public WebElement getProductCompanyTextfield() {
		return productCompanyTextfield;
	}

	public WebElement getProductpriceADTextfield() {
		return productpriceADTextfield;
	}

	public WebElement getProductPriceBDTextfield() {
		return productPriceBDTextfield;
	}

	public WebElement getProductShippingchargeTextfield() {
		return productShippingchargeTextfield;
	}

	public WebElement getAvailabilityDropdown() {
		return availabilityDropdown;
	}

	public WebElement getChooseImg1button() {
		return chooseImg1button;
	}

	public WebElement getChooseImg2button() {
		return chooseImg2button;
	}

	public WebElement getInsertButton() {
		return insertButton;
	}
	
	/**
	 * inserts a product by entering all the mandatory fields
	 * @param wUtil
	 * @param category
	 * @param subCategory
	 * @param productName
	 * @param productCompany
	 * @param productPriceBD
	 * @param productPriceAD
	 * @param shippingCharge
	 * @param productAvailability
	 * @param pic1Path
	 * @param picSecondPath
	 */
	public void insertProduct(WebDriverUtility wUtil,String category,String subCategory,String productName,String productCompany,String productPriceBD,String productPriceAD,String shippingCharge,String productAvailability,String pic1Path,String picSecondPath)
	{
		wUtil.selectFromADropDown(categoryDropdown, category);
		wUtil.selectFromADropDown(subCategoryDropdown, subCategory);
		productNameTextfield.sendKeys(productName);
		productCompanyTextfield.sendKeys(productCompany);
		productPriceBDTextfield.sendKeys(productPriceBD);
		productpriceADTextfield.sendKeys(productPriceAD);
		productShippingchargeTextfield.sendKeys(shippingCharge);
		wUtil.selectFromADropDown(availabilityDropdown, productAvailability);
		chooseImg1button.sendKeys(pic1Path);
		chooseImg2button.sendKeys(picSecondPath);
		//driver.findElement(By.name("productimage3")).sendKeys(ue.select_Excel("image"));
		insertButton.click();
		System.out.println("Product Inserted");
	}


}
