package techproed.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;

public class Listeners implements ITestListener {

//    ITestListener is an interface. We use it for customizing testng framework
//    onStart, onFinish, onTestStart, onTestSkipped, onTestSuccess, onTestFailure

    public void onStart(ITestContext arg){
        System.out.println("onStart - Execute once BEFORE all tests = >"+arg.getName());
    }
    public void onFinish(ITestContext arg){
        System.out.println("onFinish - Execute once AFTER all tests = >"+arg.getName());
    }
    public void onTestStart(ITestContext arg){
        System.out.println("onTestStart - Execute  before EACH @Tests = >"+arg.getName());
    }
    public void onTestFailure(ITestContext arg){
        System.out.println("onTestFailure - Execute  AFTER EACH PASSED @Tests = >"+arg.getName());
    }
    public void onSkipped(ITestContext arg){
        System.out.println("onSkipped - Execute AFTER EACH PASSED SKIPPED @Tests = >"+arg.getName());
    }
    public void onSuccess(ITestContext arg){
        System.out.println("onSuccess - Execute AFTER EACH FAILED @Tests = >"+arg.getName());
    }


}
