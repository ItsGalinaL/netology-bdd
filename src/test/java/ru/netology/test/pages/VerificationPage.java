package ru.netology.test.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class VerificationPage {

    public CardsPage verifyCode(String code) {
        SelenideElement form = $(new By.ByTagName("form"));
        form.$("[data-test-id=code] input").setValue(code);

        form.$("[data-test-id=action-verify]").click();

        return page(CardsPage.class);
    }
}
