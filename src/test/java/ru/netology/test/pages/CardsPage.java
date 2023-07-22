package ru.netology.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class CardsPage {

    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public int getCardBalance(String card) {
        String cardNumber = card.substring(14);
        SelenideElement cardElement = cards.findBy(Condition.partialText("**** **** ****" + cardNumber));
        return extractBalance(cardElement.getText());
    }

    private int extractBalance(String text) {
        int start = text.indexOf(balanceStart);
        int finish = text.indexOf(balanceFinish);
        String value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public TransferPage topUp(String card) {
        String cardNumber = card.substring(14);
        SelenideElement cardElement = cards.findBy(Condition.partialText("**** **** ****" + cardNumber));
        cardElement.$("[data-test-id=action-deposit]").click();
        return page(TransferPage.class);
    }
}
