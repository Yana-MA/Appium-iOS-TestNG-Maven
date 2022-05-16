package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewTitlesPage extends Page {

    private AppiumDriver<IOSElement> driver;

    public NewTitlesPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Getter
//    @FindBy(name = "New Titles")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"New Titles\"")
    private IOSElement newTitles;

}
