package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.MainPage;
import utils.RandomUtils;

public class CartPageTests extends TestBase {
    MainPage mainPage = new MainPage();
    CartPage cartPage = new CartPage();

    String query;
    int amount;

    @Test
    @DisplayName("Adding Product to cart test and changing amout")
    public void addProductToCartAndChangeAmountTest() {
        query = RandomUtils.getRandomRealVine();
        amount = RandomUtils.getRandomAmount();
        mainPage.openPage()
                .hideAllBanners()
                .searchQuery(query)
                .addProductToCart();
        cartPage.cartButtonClick()
                .increaseQuantity(amount)
                .checkSumPrice(amount);
    }

    @Test
    @DisplayName("Deleting last Product in cart test")
    public void deleteLastProductFromCartTest() {
        query = RandomUtils.getRandomRealVine();
        mainPage.openPage()
                .hideAllBanners()
                .searchQuery(query)
                .addProductToCart();
        cartPage.cartButtonClick()
                .deleteProduct()
                .chechZeroFinalPrice();
    }
}
