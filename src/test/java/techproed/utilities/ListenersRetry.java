package techproed.utilities;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class ListenersRetry implements IRetryAnalyzer {
    //This class will let the test classes to run failed tet case again automatically
//We have to connect this class with the test class
    private int retryCount = 0;
    private static final int maxRetryCount = 3;
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
