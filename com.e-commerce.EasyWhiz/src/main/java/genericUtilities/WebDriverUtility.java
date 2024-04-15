package genericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * this class contains methods used in selenium webdriver
 * @author Brijraj
 */
public class WebDriverUtility {
	/**
	 * this method maximizes the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * this method waits for element to be located on a web page for maximum time in seconds(sec)
	 * @param driver
	 * @param sec
	 */
	public void implicitWait(WebDriver driver,int sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	/**
	 *this method waits for the element to be clickable 
	 * @param driver
	 * @param elementToClick
	 * @param sec
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement elementToClick,int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(elementToClick));
	}
	
	/**
	 * this method selects an option from dropdown by visible text
	 * @param dropdown
	 * @param option
	 */
	public void selectFromADropDown(WebElement dropdown,String option)
	{
		Select select=new Select(dropdown);
		select.selectByVisibleText(option);
	}
	
	/**
	 * this method selects an option from dropdown by value
	 * @param value
	 * @param dropdown
	 */
	public void selectFromADropDown(String value,WebElement dropdown)
	{
		Select select=new Select(dropdown);
		select.selectByValue(value);
	}
	
	/**
	 * this method fetches all the options present in a dropdown
	 * @param dropdown
	 */
	public void getAllOptionsFromADropDown(WebElement dropdown)
	{
		Select select=new Select(dropdown);
		List<WebElement> options = select.getOptions();
		for(WebElement option:options)
		{
			System.out.println(option.getText());
		}
	}
	
	/**
	 * this method selects an option from dropdown by index value
	 * @param dropdown
	 * @param index
	 */
	public void selectFromADropDown(WebElement dropdown,int index)
	{
		Select select=new Select(dropdown);
		select.selectByIndex(index);
	}
	
	/**
	 * this method clicks on a n element using java script executor
	 * @param driver
	 * @param element
	 */
	public void javaScriptClick(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	/**
	 * this method passes value in a textfield using javascriptExecutor
	 * @param driver
	 * @param element
	 * @param value
	 */
	public void javaScriptEnterValues(WebDriver driver,WebElement element,String value)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='"+value+"'", element);
	}
	
	/**
	 * this method is used to scroll till an element,pass trueFalse value as "true" if u want the element to be at the top of screen otherwise "false"
	 * @param driver
	 * @param element
	 * @param trueFalse
	 */
	public void javaScriptScrollToAnElement(WebDriver driver,WebElement element,String trueFalse)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView("+trueFalse+")", element);
	}
	
	/**
	 * this method scrolls till the end of the page 
	 * @param driver
	 * @param element
	 */
	public void javaScriptScrollToBottom(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	/**
	 * this method scrolls till top of the page
	 * @param driver
	 */
	public void javaScriptScrollToTop(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	
	/***
	 * this method scrolls till desired x and y value,for scrolling only downwards give x=0
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void javaScriptScrollTillAPoint(WebDriver driver,int x,int y)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	/**
	 * this method takes screenshot of the web page
	 * @param driver
	 * @param element
	 * @return 
	 * @return 
	 * @throws IOException 
	 */
	public static String takeAScreenShot(WebDriver driver,String screenshotName) throws IOException
	{
		JavaUtility jUtil=new JavaUtility();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("./screenshots/"+screenshotName+"_"+jUtil.getSystemDateInFormat()+".png");
		
		FileHandler.copy(src, dst);

		return dst.getAbsolutePath();
	}
	
	/**
	 * performs mouse hover action on an element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOnAnElement(WebDriver driver, WebElement element)
	{
		new Actions(driver).moveToElement(element).perform();
	}
	
	/**
	 * performs click action on an element
	 * @param driver
	 * @param element
	 */
	public void clickOnAnElement(WebDriver driver, WebElement element)
	{
		new Actions(driver).click(element).perform();
	}
	
	/**
	 * performs right click action on an element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnAnElement(WebDriver driver, WebElement element)
	{
		new Actions(driver).contextClick(element).perform();
	}
	
	/**
	 * performs double click action on an element
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnAnElement(WebDriver driver, WebElement element)
	{
		new Actions(driver).doubleClick(element).perform();
	}
	
	/**
	 * performs send keys action on a text field
	 * @param driver
	 * @param element
	 * @param charSeq
	 */
	public void sendKeysInTextfield(WebDriver driver, WebElement element,String charSeq)
	{
		new Actions(driver).sendKeys(element,charSeq).perform();
	}
	
	/**
	 * clicks ok on an alert popup
	 * @param driver
	 */
	public void selectOKInAlertPopUp(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/*
	 * clicks on cancel button in an alert popup
	 */
	public void selectCancelInAlertPopUp(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/*
	 * fetches text from an alert popup
	 */
	public String getTextFromAlertPopUp(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * sends value in the text field of an alert
	 * @param driver
	 * @param value
	 */
	public void sendValuesInTextfieldOfAlertPopUp(WebDriver driver, String value)
	{
		driver.switchTo().alert().sendKeys(value);;
	}
	
	/**
	 * switches control to a window by providing title of that window
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToChildBorwser(WebDriver driver,String partialWindowTitle)
	{
		Set<String> allIds = driver.getWindowHandles();
		for(String id:allIds)
		{
			driver.switchTo().window(id);
			String currentWindowTitle = driver.getTitle();
			if(currentWindowTitle.contains(partialWindowTitle))
				break;
		}
	}
	
	
	public void switchToFrame(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public Robot robotObj() throws AWTException
	{
		Robot r=new Robot();
		return r;
	}
	
	public void robotKeyPressEnter() throws AWTException
	{
		robotObj().keyPress(KeyEvent.VK_ENTER);
	}
	public void robotKeyReleaseEnter() throws AWTException
	{
		robotObj().keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void robotKeyPressTab() throws AWTException
	{
		robotObj().keyPress(KeyEvent.VK_TAB);
	}
	public void robotKeyReleaseTab() throws AWTException
	{
		robotObj().keyRelease(KeyEvent.VK_TAB);
	}
	
	

}
