package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.NavigationBar;
import pages.NewsPage;
import pages.SearchPage;
import utils.AllureTestListener;

import static org.testng.Assert.assertTrue;

@Listeners({ AllureTestListener.class })
public class Tests extends BaseTest {

    @Test
    public void search() {
        NavigationBar navBar = new NavigationBar(driver);
        SearchPage searchPage = new SearchPage(driver);

        navBar.clickSearch();
        searchPage.inputSearchText("alphasense1");
        driver.getKeyboard().pressKey(Keys.ENTER);
        assertTrue(searchPage.getSearchUnavailableMessage().contains("Search Unavailable"));
    }

    @Test
    public void scrollToTheLastCategory() {
        NavigationBar navBar = new NavigationBar(driver);
        NewsPage newsPage = new NewsPage(driver);

        navBar.clickNews();

        new WebDriverWait( driver, 3 )
                .until( ExpectedConditions.visibilityOf(newsPage.getMagazineFeed()));
        new WebDriverWait( driver, 5 )
                .until( ExpectedConditions.visibilityOf(newsPage.getGetStarted()));

        newsPage.scrollTillElement("label == `New Titles`");
        String title = newsPage.goToNewTitles().getNewTitles().getText();

        Assert.assertEquals("New Titles", title);
    }

    @Test
    public void testThatAlwaysFails() {
        NavigationBar navBar = new NavigationBar(driver);
        SearchPage searchPage = new SearchPage(driver);

        navBar.clickSearch();
        searchPage.inputSearchText("shouldFail");

        Assert.assertEquals("CancelButton", searchPage.getCancel());
    }
}
