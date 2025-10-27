package CustomListeners;

import org.testng.*;
import utils.PropertyReader;

public class TestNGListeners implements IInvokedMethodListener, ITestListener, IExecutionListener {
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult){
        if(method.isTestMethod()){
            System.out.println("Method: " + method.getTestMethod().getMethodName() + " is starting.");
        }
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult){
        if(method.isTestMethod()){
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
    }

    public void onExecutionFinish() {

        System.out.println("Execution Finished");
    }


}
