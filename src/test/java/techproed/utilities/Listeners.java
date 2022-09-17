package techproed.utilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners implements ITestListener {
//    ITestListener is an interface. We use it for customizing testng framework
//    onStart, onFinish, onTestStart, onTestSkipped, onTestSuccess, onTestFailure
//    These method named must be exactly the same, otherwise Listeners will not listen a method with a different name

    public void onStart(ITestContext arg){
        System.out.println("onStart - Execute once BEFORE all tests = > "+arg.getName());
    }
    public void onFinish(ITestContext arg){
        System.out.println("onFinish - Execute once AFTER all tests = > "+arg.getName());
    }
    public void onTestStart(ITestResult arg0){
        System.out.println("onTestStart - Execute before EACH @Test = > "+arg0.getName());
    }
    public void onTestSuccess(ITestResult arg0){
        System.out.println("onTestSuccess - Execute AFTER EACH PASSED @Test = > "+arg0.getName());
    }
    public void onTestSkipped(ITestResult arg0){
        System.out.println("onTestSkipped - Execute AFTER EACH SKIPPED @Test = > "+arg0.getName());
    }
    public void onTestFailure(ITestResult arg0){

        System.out.println("onTestFailure - Execute AFTER EACH FAILED @Test = > "+arg0.getName());
        try {
            ReusableMethods.getScreenshot(arg0.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Driver.closeDriver();
    }
}
