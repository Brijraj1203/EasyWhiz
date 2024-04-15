package practice;

import org.testng.annotations.Test;

import genericUtilities.BaseClass;

public class Print extends BaseClass {

		@Test(groups="smoke")
		public void print1()
		{
			System.out.println("print 1");
		}
		@Test(groups="regression")
		public void print2()
		{
			System.out.println("print 2");
		}
		@Test
		public void print3()
		{
			System.out.println("print 3");
		}

	

}
