package practice;

import org.testng.annotations.Test;

import genericUtilities.BaseClass;

public class Sample extends BaseClass{
	@Test(groups="regression")
	public void sample1()
	{
		System.out.println("Sample 1");
	}
	
	@Test
	public void sample2()
	{
		System.out.println("Sample 2");
	}
	
	@Test(groups="smoke")
	public void sample3()
	{
		System.out.println("Sample 3");
	}

}
