package by.teachmeskills.util.testng;

import by.teachmeskills.util.allure.AllureUtil;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;

@Log4j2
public class TestListener implements ITestListener {
    
    @Override
    public void onTestStart(ITestResult result) {
        log.info("======================================== STARTING TEST {} ========================================", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("======================================== FINISHED TEST {} Duration: {}s ========================================", result.getName(),
                          getExecutionTime(result));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("======================================== SKIPPING TEST {} ========================================", result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    private long getExecutionTime(ITestResult result) {
        return TimeUnit.MILLISECONDS.toSeconds(result.getEndMillis() - result.getStartMillis());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("======================================== FAILED TEST {} Duration: {}s ========================================", result.getName(),
                          getExecutionTime(result));
        takeScreenshot(result);
    }

    private byte[] takeScreenshot(ITestResult iTestResult) {
        ITestContext context = iTestResult.getTestContext();
        try {
            WebDriver driver = (WebDriver) context.getAttribute("driver");
            if (driver != null) {
                return AllureUtil.takeScreenshot(driver);
            } else {
                return new byte[]{};
            }
        } catch (NoSuchSessionException | IllegalStateException ex) {
            return new byte[]{};
        }
    }
}
