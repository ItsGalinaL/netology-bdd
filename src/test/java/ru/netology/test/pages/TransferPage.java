package ru.netology.test.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class TransferPage {

    public CardsPage transfer(String amount, String fromCard) {
        SelenideElement form = $(new By.ByTagName("form"));
        form.$("[data-test-id=amount] input").setValue(amount);
        form.$("[data-test-id=from] input").setValue(fromCard);
        form.$("[data-test-id=action-transfer]").click();

        return page(CardsPage.class);
    }
}
