package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class MainPageTests extends TestBase {
    MainPage mainPage = new MainPage();
    String query;

    @Test
    @DisplayName("Search test")
    public void searchTest() {
        query = "test";
        mainPage.openPage()
                .hideAllBanners()
                .searchQuery(query)
                .checkSearchQuery(query);
    }

    @Test
    @Disabled("Пока не разберусь с hidden списка городов")
    @DisplayName("Change city test")
    public void cityChangeTest() {
        mainPage.openPage()
                .hideAllBanners()
                .setCity(3)
                .checkCity();
    }

    @Test
    @DisplayName("Subscription test")
    public void subscribeByEmailTest() {
        mainPage.openPage()
                .hideAllBanners()
                .subcribetonewsletter("test@test.ru")
                .checkSubscriptionResult();
    }

    @Test
    @DisplayName("Adding Product to cart test")
    public void addProductToCartTest() {
        query = "moet";
        mainPage.openPage()
                .hideAllBanners()
                .searchQuery(query)
                .addProductToCart()
                .checkAddingProductToCart();
    }
}
