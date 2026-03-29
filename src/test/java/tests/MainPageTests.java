package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import utils.RandomUtils;

public class MainPageTests extends TestBase {
    MainPage mainPage = new MainPage();
    String query, email;

    @Test
    @DisplayName("Search test")
    public void searchTest() {
        query = RandomUtils.getRandomBeer();
        mainPage.openPage()
                .hideAllBanners()
                .searchQuery(query)
                .checkSearchQuery(query);
    }

    @Test
    @DisplayName("Subscription test")
    public void subscribeByEmailTest() {
        email = RandomUtils.getRandomEmail();
        mainPage.openPage()
                .hideAllBanners()
                .subcribetonewsletter(email)
                .checkSubscriptionResult();
    }

    @Test
    @DisplayName("Adding Product to cart test")
    public void addProductToCartTest() {
        query = RandomUtils.getRandomRealVine();
        mainPage.openPage()
                .hideAllBanners()
                .searchQuery(query)
                .addProductToCart()
                .checkAddingProductToCart();
    }
}
