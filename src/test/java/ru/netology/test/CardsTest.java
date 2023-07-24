package ru.netology.test;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.User;
import ru.netology.pages.CardsPage;
import ru.netology.pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardsTest {

    @Test
    @DisplayName("Тест перевода")
    void testCards() {
        User user = DataHelper.getUser();

        LoginPage loginPage = Selenide.open("http://localhost:9999", LoginPage.class);
        CardsPage cardsPage = loginPage.login(user.getLogin(), user.getPassword()).verifyCode(user.getValidationCode());

        int firstCardBalance = cardsPage.getCardBalance(user.getCards()[0]);
        int secondCardBalance = cardsPage.getCardBalance(user.getCards()[1]);

        cardsPage = cardsPage.topUp(user.getCards()[0]).transfer("200", user.getCards()[1]);

        assertEquals(firstCardBalance + 200, cardsPage.getCardBalance(user.getCards()[0]), "Баланс должен быть 10200");
        assertEquals(secondCardBalance - 200, cardsPage.getCardBalance(user.getCards()[1]), "Баланс должен быть 9800");
    }
}
