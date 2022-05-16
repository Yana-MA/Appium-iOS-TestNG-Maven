package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

@Getter
public class NavigationBar extends Page {

    private AppiumDriver driver;

    public NavigationBar(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @FindBy(name = "News+")
    private IOSElement news;

    @FindBy(name = "Search")
    private IOSElement search;

    public void clickNews() {
        news.click();
    }

    public NewsPage goToNews() {
        news.click();
        return new NewsPage(driver);
    }

    public void clickSearch() {
        search.click();
    }
}
