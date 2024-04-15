package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClassTest {
	@Test
	public void test1()
	{
		System.out.println("Test Script 1");
	}
	
	@BeforeClass
	public void bc()
	{
		System.out.println("Before class---->launch the browser and navigate to the url");
	}
	@BeforeMethod
	public void bm()
	{
		System.out.println("Before Method----->login");
	}
	@BeforeSuite
	public void bs()
	{
		System.out.println("Before Suite--->database connection");
	}
	@AfterSuite
	public void as()
	{
		System.out.println("After Suite--->database connection closed");
	}
	@AfterClass
	public void ac()
	{
		System.out.println("After class---->close the browser");
	}
	@AfterMethod
	public void am()
	{
		System.out.println("Afetr Method--->Logout");
	}
	@Test
	public void test2()
	{
		System.out.println("Test Script 2");
	}

}
