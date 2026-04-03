package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.MainPage;
import pages.SearchResultsPage;
import utils.RandomUtils;


public class MainPageTests extends TestBase {
    MainPage mainPage = new MainPage();
    CartPage cartPage = new CartPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();
    String query, email;


    @Test
    @DisplayName("Тест поиска")
    public void searchTest() {
        query = RandomUtils.getRandomBeer();
        mainPage.openPage()
                .hideAllBanners()
                .searchQuery(query);
        searchResultsPage.checkSearchQuery(query);
    }

    @Test
    @DisplayName("Тест подписки на рассылку")
    public void subscribeByEmailTest() {
        email = RandomUtils.getRandomEmail();
        mainPage.openPage()
                .hideAllBanners()
                .subcribetonewsletter(email)
                .checkSubscriptionResult();
    }

}
