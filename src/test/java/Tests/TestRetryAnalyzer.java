package Tests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestRetryAnalyzer implements IRetryAnalyzer {
    int counter = 1;
    int retryMaxLimit = 1;
 dfsdfsd
    public boolean retry(ITestResult result) {
        if (counter < retryMaxLimit) {
            counter++;
            return true;
        }
        return false;
    }
}
