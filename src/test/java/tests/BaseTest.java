package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public static AppiumDriver<IOSElement> driver;

    public AppiumDriver<IOSElement> getDriver() {
        return driver;
    }

    @BeforeSuite
    @Parameters({"platform", "deviceName", "udid"})
    public void setUpRealDevice(String platform, String deviceName, String udid) {
        DesiredCapabilities realCapabilities = new DesiredCapabilities();
        realCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platform);
        realCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        realCapabilities.setCapability(MobileCapabilityType.UDID, udid);
        realCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        realCapabilities.setCapability("bundleId", "com.apple.news");
        try {
            driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), realCapabilities);
        } catch(Exception e) {
            e.printStackTrace();
        }
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.launchApp();
    }

    @AfterMethod
    public void afterMethod() {
        driver.closeApp();
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
