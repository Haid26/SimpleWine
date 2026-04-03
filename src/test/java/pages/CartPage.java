package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.Console;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartPage {
    private final SelenideElement productLabel = $("[data-autotest-target-id=cart-available-item-title-1]"),
            productPrice = $("[data-autotest-target-id=cart-available-item-price-1]"),
            productQuantityInput = $("[data-autotest-target=cart-available-item-input]"),
            productQuantityInputLabel = $("[data-autotest-target=cart-available-item-input] ~ span"),
            menuCartButton = $("[data-autotest-target-id=header-user-cart-link]"),
            deleteProductButton = $("[data-autotest-target-id=cart-available-item-delete-btn-1]"),
            cartSum = $("[data-autotest-target-id=cart-receipt-total-value]");

    String price;
    final String emptyPrice = "0 ₽";
    int decimalPrice;

    @Step("Проверка что товар: {value} в корзине")
    public CartPage checkCartProduct(String value) {
        productLabel.shouldHave(text(value));
        return this;
    }

    @Step("Клин по логотипу корзины")
    public CartPage cartButtonClick() {
        menuCartButton.click();
        return this;
    }

    private int transformPriceToInt(String price) {
        price = price.replace(" ", "");
        price = price.replace("₽", "");
        return Integer.parseInt(price);

    }

    private String transformPriceToString(int price) {
        String result = price / 1000 + " " + price % 1000 + " ₽";
        return result;

    }

    @Step("Изменение количества товаров до {quantity}")
    public CartPage increaseQuantity(int quantity) {
        price = productPrice.getText();
        decimalPrice = transformPriceToInt(price);
        productQuantityInputLabel.click();
        productQuantityInput.setValue(quantity + "");
        return this;
    }

    @Step("Проверка что сумма заказа изменилась")
    public CartPage checkSumPrice(int quantity) {
        sleep(5000);
        assertEquals(transformPriceToString(decimalPrice * quantity), productPrice.getText());
        return this;
    }

    @Step("Удаление товара из корзины")
    public CartPage deleteProduct() {
        deleteProductButton.click();
        return this;
    }

    @Step("Проверка стоимости корзины после очистки")
    public CartPage chechZeroFinalPrice() {
        cartSum.shouldHave(text(emptyPrice));
        return this;
    }
    //"В корзине пусто"
}
