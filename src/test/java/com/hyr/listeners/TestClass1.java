package com.hyr.listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ITestListenerClass.class)
public class TestClass1 {
	
	@Test
	public void testMethod1()
	{
		System.out.println("i'm inside method1");
	}
	
	@Test
	public void testMethod2()
	{
		System.out.println("i'm inside method2");
		Assert.assertTrue(false);
	}

	
	@Test(timeOut=1000)
	public void testMethod3() throws InterruptedException
	{
		Thread.sleep(2000);
		System.out.println("i'm inside method3");
	}

	
	@Test(dependsOnMethods="testMethod3")
	public void testMethod4()
	{
		System.out.println("i'm inside method4");
	}


}
