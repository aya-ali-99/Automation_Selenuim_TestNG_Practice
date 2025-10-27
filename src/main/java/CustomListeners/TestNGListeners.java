package CustomListeners;

import drivers.WebDriverFactory;
import org.testng.*;
import utils.AllureUtils;
import utils.PropertyReader;
import utils.ScreenShotUtils;

public class TestNGListeners implements IInvokedMethodListener, ITestListener, IExecutionListener {
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult){
        if(method.isTestMethod()){
            System.out.println("Method: " + method.getTestMethod().getMethodName() + " is starting.");
        }
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult){
        if(method.isTestMethod()){
            ScreenShotUtils.takeScreenShot(WebDriverFactory.get(), testResult.getName());
            System.out.println("Method: " + method.getTestMethod().getMethodName() + " has finished." );
        }
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " Passed");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " Failed");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " Skipped");
    }

    public void onExecutionStart() {

        System.out.println("Execution Started");
        PropertyReader.loadProperties();
        AllureUtils.cleanAllureResults();
    }

    public void onExecutionFinish() {
        AllureUtils.setAllureEnvironmentInfo();
        System.out.println("Execution Finished");
    }


}
