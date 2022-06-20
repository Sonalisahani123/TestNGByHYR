package com.hyr.screenshots;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hyr.test.BaseTest;

public class ITestListenerClass extends BaseTest implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		captureScreenshot(result.getMethod().getMethodName()+ ".jpg");
		
	}

	
	
	
	
	

}
