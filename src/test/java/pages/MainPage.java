package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.mifmif.common.regex.Main;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class MainPage {
    private final SelenideElement ageBaner = $(".AgeConfirmModal_ageConfirmModal__KQqtt"),
            ageBanerCloseButton = $(".AgeConfirmModal_button__Kiyo1"),
            cityBaner = $(".LocationItem_clarificationPopup__or1zj"),
            cityBanerCloseButton = $(".CityClarificationPopup_closerIcon__Q4R6a"),
            topWidget = $(".widget.js-widget"),
            topWidgetCloseButton = $(".close.js-close"),
            searchInput = $("[data-autotest-target-id=header-search-input]"),
            searchButton = $("[data-autotest-target-id=header-search-go]"),
            searchResults = $("[data-autotest-target-id=search-main-found-alike]"),
            cityListButton = $("[data-autotest-target-id=header-location-dropdown]"),
            citiesListScroll = $(".CityList_list__4uDZm"),
            emailInput = $("[data-autotest-target-id=footer-menu-subscribe-input]"),
            emailInputButton = $(".Input_inputExtraAction__nFLoo"),
            emailCheckboxAgreement = $(".Checkbox_checkMark__F0z4t.checkbox-checkmark"),
            emailSuccess = $(".EmailSubcribe_subscribeSuccess__50ooz"),
            addtoCartButton = $("[data-autotest-target-id=product-item-cart-btn-1]"),
            productNameLabel = $("[data-autotest-target-id=product-item-name-1]"),
            menuCartButton = $("[data-autotest-target-id=header-user-cart-link]");

    private final ElementsCollection citiesList = $$(".location__item");

    String selectedCity, productName;
    CartPage cartPage = new CartPage();

    @Step("Open main page")
    public MainPage openPage() {
        open("/");
        return this;
    }

    @Step("Hide age confirmation modal")
    public MainPage hideAgeBanner() {
        while (!ageBaner.is(visible)) {
            sleep(1000);
        }
        ageBanerCloseButton.click();
        return this;
    }

    @Step("Hide City confirmation modal")
    public MainPage hideCityBaner() {
        if (cityBaner.is(visible))
            cityBanerCloseButton.click();
        return this;
    }

    @Step("Hide banner with timer")
    public MainPage hideTopBaner() {
        $("[title=Закрыть]").click();
        return this;
    }

    @Step("Hide all modals")
    public MainPage hideAllBanners() {
        hideAgeBanner();
        hideCityBaner();
        // hideTopBaner();
        return this;
    }

    @Step("Search {query}")
    public MainPage searchQuery(String query) {
        searchInput.setValue(query);
        searchButton.click();
        return this;
    }

    @Step("Check that {query} was searched")
    public MainPage checkSearchQuery(String query) {
        searchResults.shouldHave(text(query));
        return this;
    }

    @Step("Change city #{index}")
    public MainPage setCity(int index) {
        cityListButton.click();
        $("[role=tooltip]").click();
        selectedCity = citiesList.get(index).getOwnText();
        citiesList.get(index).click();
        return this;
    }

    @Step("Check city selected")
    public MainPage checkCity() {
        cityListButton.shouldHave(text(selectedCity));
        return this;
    }

    @Step("add email to newsletter")
    public MainPage subcribetonewsletter(String email) {
        //emailInput.click();
        emailInput.setValue(email);
        emailCheckboxAgreement.click();
        emailInputButton.click();
        return this;
    }

    @Step("check subscription result")
    public MainPage checkSubscriptionResult() {
        emailSuccess.shouldHave(anyOf(text("Спасибо за подписку!"), text("Спасибо! Вы уже подписаны на нашу рассылку")));
        return this;
    }

    @Step("Add to cart product")
    public MainPage addProductToCart() {
        productName = productNameLabel.getText();
        addtoCartButton.click();
        return this;
    }

    @Step("Check cart with product")
    public MainPage checkAddingProductToCart() {
        menuCartButton.click();
        cartPage.checkCartProduct(productName);
        return this;
    }
}
