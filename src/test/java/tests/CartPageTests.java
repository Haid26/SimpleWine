package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.MainPage;

public class CartPageTests extends TestBase {
    MainPage mainPage = new MainPage();
    CartPage cartPage = new CartPage();

    String query;

    @Test
    @DisplayName("Adding Product to cart test")
    public void addProductToCartTest() {
        query = "moet";
        mainPage.openPage()
                .hideAllBanners()
                .searchQuery(query)
                .addProductToCart();
        cartPage.cartButtonClick()
                .increaseQuantity(5)
                .checkSumPrice(5);
    }

    @Test
    @DisplayName("Deleting last Product in cart test")
    public void deleteLastProductFromCartTest() {
        query = "moet";
        mainPage.openPage()
                .hideAllBanners()
                .searchQuery(query)
                .addProductToCart();
        cartPage.cartButtonClick()
                .deleteProduct()
                .chechZeroFinalPrice();
    }
}
