package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    private AppiumDriver<IOSElement> driver;

    public SearchPage(AppiumDriver<IOSElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//XCUIElementTypeSearchField[@name=\"Channels, Topics, & Stories\"]")
    private IOSElement searchField;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Cancel']")
    private IOSElement cancel;

    @FindBy(xpath = "//*[contains(@label, 'Unavailable')]")
    private IOSElement searchUnavailableMessage;

    public void inputSearchText(String text) {
        searchField.sendKeys(text);
    }

    public String getCancel() {
        return cancel.getText();
    }

    public String getSearchUnavailableMessage() {
        return searchUnavailableMessage.getText();
    }
}
