package practice;

import org.testng.annotations.Test;

import genericUtilities.BaseClass;

public class Demo extends BaseClass{
	@Test(groups = "smoke")
	public void demo1()
	{
		System.out.println("Demo 1");
	}
	
	@Test
	public void demo2()
	{
		System.out.println("Demo 2");
	}
	
	@Test(groups = "regression")
	public void demo3()
	{
		System.out.println("Demo 3");
	}

}
