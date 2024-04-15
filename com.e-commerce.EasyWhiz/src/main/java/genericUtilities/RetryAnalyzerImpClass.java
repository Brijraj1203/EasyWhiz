package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImpClass implements IRetryAnalyzer{
	int lowerCount=0;
	int upperCount=2;

	@Override
	public boolean retry(ITestResult result) {
		if(lowerCount<upperCount)
		{
			lowerCount++;
			return true;
		}
		return false;
	}

}
