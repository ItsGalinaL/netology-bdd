package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    public VerificationPage login(String login, String password) {
        SelenideElement form = $(new By.ByTagName("form"));
        form.$("[data-test-id=login] input").setValue(login);
        form.$("[data-test-id=password] input").setValue(password);

        form.$("[data-test-id=action-login]").click();
        return page(VerificationPage.class);
    }
}
