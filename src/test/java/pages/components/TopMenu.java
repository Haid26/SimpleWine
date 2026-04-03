package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.MainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TopMenu {
    private SelenideElement searchInput = $("[data-autotest-target-id=header-search-input]"),
            searchButton = $("[data-autotest-target-id=header-search-go]"),
            cityListButton = $("[data-autotest-target-id=header-location-dropdown]"),
            citiesListScroll = $(".CityList_list__4uDZm"),
            menuCartButton = $("[data-autotest-target-id=header-user-cart-link]");

    @Step("Поиск {query}")
    public void searchQuery(String query) {
        searchInput.setValue(query);
        searchButton.click();
    }

    @Step("Переход в корзину")
    public void CartLogoClick(){
        menuCartButton.click();
    }
}
