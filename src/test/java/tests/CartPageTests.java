package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.MainPage;
import pages.SearchResultsPage;
import utils.RandomUtils;

public class CartPageTests extends TestBase {
    MainPage mainPage = new MainPage();
    CartPage cartPage = new CartPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();
    RandomUtils randomUtils = new RandomUtils();

    String query;
    int amount;

    @Test
    @DisplayName("Тест изменения количества товара в корзине")
    public void addProductToCartAndChangeAmountTest() {
        query = randomUtils.getRandomRealVine();
        amount = randomUtils.getRandomAmount();
        mainPage.openPage()
                .hideAllBanners()
                .searchQuery(query);
        searchResultsPage.addProductToCart();
        cartPage.cartButtonClick()
                .increaseQuantity(amount)
                .checkSumPrice(amount);
    }

    @Test
    @DisplayName("Тест удаления товаров из корзины")
    public void deleteLastProductFromCartTest() {
        query = randomUtils.getRandomRealVine();
        mainPage.openPage()
                .hideAllBanners()
                .searchQuery(query);

        searchResultsPage.addProductToCart();
        cartPage.cartButtonClick()
                .deleteProduct()
                .chechZeroFinalPrice();
    }

    @Test
    @DisplayName("Тест добавления товара в корзину")
    public void addProductToCartTest() {
        query = randomUtils.getRandomRealVine();
        mainPage.openPage()
                .hideAllBanners()
                .searchQuery(query);
        searchResultsPage.addProductToCart()
                .checkAddingProductToCart();
    }
}
