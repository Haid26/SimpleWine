package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.mifmif.common.regex.Main;
import io.qameta.allure.Step;
import pages.components.TopMenu;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class MainPage {
    private final SelenideElement ageBaner = $(".AgeConfirmModal_ageConfirmModal__KQqtt"),
            ageBanerCloseButton = $(".AgeConfirmModal_button__Kiyo1"),
            cityBaner = $(".LocationItem_clarificationPopup__or1zj"),
            cityBanerCloseButton = $(".CityClarificationPopup_closerIcon__Q4R6a"),
            topWidget = $(".widget.js-widget"),
            topWidgetCloseButton = $(".close.js-close"),
            emailInput = $("[data-autotest-target-id=footer-menu-subscribe-input]"),
            emailInputButton = $(".Input_inputExtraAction__nFLoo"),
            emailCheckboxAgreement = $(".Checkbox_checkMark__F0z4t.checkbox-checkmark"),
            emailSuccess = $(".EmailSubcribe_subscribeSuccess__50ooz");

    private final ElementsCollection citiesList = $$(".location__item");

    private TopMenu topMenu = new TopMenu();

    @Step("Открытие главной страницы")
    public MainPage openPage() {
        open("/");
        return this;
    }

    @Step("Скрытие баннер подтвреждение возраста")
    public MainPage hideAgeBanner() {
        while (!ageBaner.is(visible)) {
            sleep(1000);
        }
        ageBanerCloseButton.click();
        return this;
    }

    @Step("Скрыть подтвреждение выбора города")
    public MainPage hideCityBaner() {
        if (cityBaner.is(visible))
            cityBanerCloseButton.click();
        return this;
    }

    @Step("Скрыть баннер с таймером")
    public MainPage hideTopBaner() {
        $("[title=Закрыть]").click();
        return this;
    }

    @Step("Скрыть все модалки")
    public MainPage hideAllBanners() {
        hideAgeBanner();
        hideCityBaner();
        return this;
    }

    @Step("Поиск {query}")
    public MainPage searchQuery(String query) {
        topMenu.searchQuery(query);
        return this;
    }

    @Step("Добавление емейла в рассылку")
    public MainPage subcribetonewsletter(String email) {
        emailInput.setValue(email);
        emailCheckboxAgreement.click();
        emailInputButton.click();
        return this;
    }

    @Step("Проверка успешной подписки на рассылку")
    public MainPage checkSubscriptionResult() {
        emailSuccess.shouldHave(anyOf(text("Спасибо за подписку!"), text("Спасибо! Вы уже подписаны на нашу рассылку")));
        return this;
    }




}
