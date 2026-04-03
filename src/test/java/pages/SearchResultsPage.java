package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.TopMenu;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultsPage {
    private SelenideElement   searchResults = $("[data-autotest-target=search-main]"),
            addtoCartButton = $("[data-autotest-target-id=product-item-cart-btn-1]"),
            productNameLabel = $("[data-autotest-target-id=product-item-name-1]");

    private TopMenu topMenu = new TopMenu();
    private CartPage cartPage = new CartPage();
    String productName;

    @Step("Проверка что в поисковом запросе было {query} ")
    public SearchResultsPage checkSearchQuery(String query) {
        searchResults.shouldHave(text(query));
        return this;
    }

    @Step("Добавить товар в корзину")
    public SearchResultsPage addProductToCart() {
        productName = productNameLabel.getText();
        addtoCartButton.click();
        return this;
    }

    @Step("Проверка что продукт в корзине")
    public SearchResultsPage checkAddingProductToCart() {
        topMenu.CartLogoClick();
        cartPage.checkCartProduct(productName);
        return this;
    }
}
