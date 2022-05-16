package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class NewsPage {

    private AppiumDriver<IOSElement> driver;

    public NewsPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Getter
    @FindBy(xpath = "//*[contains(@label, 'New Titles')]")
    private IOSElement newTitles;

    @Getter
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='GET STARTED'])[2]")
    private IOSElement getStarted;

    @Getter
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[@name='Magazine Feed']")
    private IOSElement magazineFeed;

    public void isVisible() {
        newTitles.click();
    }

    public NewTitlesPage goToNewTitles() {
        newTitles.click();
        return new NewTitlesPage(driver);
    }

    public void scrollTillElement(String predicate) {
        HashMap<String, String> scrollObjects = new HashMap<>();
        scrollObjects.put("predicateString", predicate);
        scrollObjects.put("direction", "down");
        driver.executeScript("mobile: scroll", scrollObjects );
    }
}
