package pomRepository;
/**
 * 
 * @author Brijraj
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	@FindBy(partialLinkText="Logout")
	private WebElement logoutLink;
	
	@FindBy(partialLinkText="User Login Log")
	private WebElement userLoginLogLink;
	
	@FindBy(xpath="//a[@href='#togglePages']")
	private WebElement orderManagementExpansionButton;
	
	@FindBy(partialLinkText="Create Category")
	private WebElement createCategoryLink;
	
	@FindBy(partialLinkText="Sub Category")
	private WebElement subCategoryLink;
	
	@FindBy(partialLinkText="Insert Product")
	private WebElement insertProductLink;
	
	@FindBy(partialLinkText="Manage Products")
	private WebElement manageProductsLink;
	
	@FindBy(partialLinkText="Manage users")
	private WebElement manageUsersLink;
	
	@FindBy(xpath="//a[@href='todays-orders.php']")
	private WebElement todaysOrdersLink;
	
	@FindBy(xpath="//a[@href='pending-orders.php']")
	private WebElement pendingOrdersLink;
	
	@FindBy(xpath="//a[@href='delivered-orders.php']")
	private WebElement deliveredOrdersLink;
	
	public AdminHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getUserLoginLogLink() {
		return userLoginLogLink;
	}

	public WebElement getOrderManagementExpansionButton() {
		return orderManagementExpansionButton;
	}

	public WebElement getCreateCategoryLink() {
		return createCategoryLink;
	}

	public WebElement getSubCategoryLink() {
		return subCategoryLink;
	}

	public WebElement getInsertProductLink() {
		return insertProductLink;
	}

	public WebElement getManageProductsLink() {
		return manageProductsLink;
	}

	public WebElement getManageUsersLink() {
		return manageUsersLink;
	}

	public WebElement getTodaysOrdersLink() {
		return todaysOrdersLink;
	}

	public WebElement getPendingOrdersLink() {
		return pendingOrdersLink;
	}

	public WebElement getDeliveredOrdersLink() {
		return deliveredOrdersLink;
	}
	
	public void clickOnLogoutLink()
	{
		logoutLink.click();
	}
	
	public void clickOnCreateCategoryLink()
	{
		createCategoryLink.click();
	}
	public void clickOnSubCategoryLink()
	{
		subCategoryLink.click();
	}
	
	public void clickOnInsertProductLink()
	{
		insertProductLink.click();
	}
	public void clickOnManageUsersLink()
	{
		manageUsersLink.click();
	}
	public void clickOnManageProductsLink()
	{
		manageProductsLink.click();
	}
	
	/**
	 * expands order management toggle and clicks on todays order link
	 */
	public void clickOnTodaysOrdersLink()
	{
		orderManagementExpansionButton.click();
		todaysOrdersLink.click();
	}
	
	/**
	 * expands order management toggle and clicks on pending order link
	 */
	public void clickOnPendingOrdersLink()
	{
		orderManagementExpansionButton.click();
		pendingOrdersLink.click();
	}
	
	/**
	 * expands order management toggle and clicks on delivered order link
	 */
	public void clickOnDeliveredOrdersLink()
	{
		orderManagementExpansionButton.click();
		deliveredOrdersLink.click();
	}

}
