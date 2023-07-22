package ru.netology.test;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.test.pages.CardsPage;
import ru.netology.test.pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardsTest {

    @Test
    @DisplayName("Тест перевода")
    void testCards() {
        User user = new User("vasya", "qwerty123", "12345", new String[]{"5559 0000 0000 0001", "5559 0000 0000 0002"});

        LoginPage loginPage = Selenide.open("http://localhost:9999", LoginPage.class);
        CardsPage cardsPage = loginPage.login(user.getLogin(), user.getPassword()).verifyCode(user.getValidationCode());

        assertEquals(10000, cardsPage.getCardBalance(user.getCards()[0]), "Начальный баланс должен быть 10000");
        assertEquals(10000, cardsPage.getCardBalance(user.getCards()[1]), "Начальный баланс должен быть 10000");

        cardsPage = cardsPage.topUp(user.getCards()[0]).transfer("200", user.getCards()[1]);

        assertEquals(10200, cardsPage.getCardBalance(user.getCards()[0]), "Баланс должен быть 10200");
        assertEquals(9800, cardsPage.getCardBalance(user.getCards()[1]), "Баланс должен быть 9800");
    }
}
