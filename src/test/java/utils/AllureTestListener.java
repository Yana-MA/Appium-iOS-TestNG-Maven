package utils;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import tests.BaseTest;

public class AllureTestListener extends BaseTest implements IInvokedMethodListener {

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult result) {
        Object testClass = result.getInstance();
        AppiumDriver driver = ((BaseTest) testClass).getDriver();
        if (result.getStatus() == ITestResult.FAILURE) {
            saveFailureScreenShot(driver);
        }
    }

    @Attachment(value ="screenshot", type = "image/png")
    public byte[] saveFailureScreenShot(AppiumDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
