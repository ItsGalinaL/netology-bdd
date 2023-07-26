package ru.netology.test;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.pages.CardsPage;
import ru.netology.pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardsTest {

    @Test
    @DisplayName("Тест перевода")
    void testCards() {
        DataHelper.AuthInfo authInfo = DataHelper.getAuthInfo();
        DataHelper.VerificationCode verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        LoginPage loginPage = Selenide.open("http://localhost:9999", LoginPage.class);
        CardsPage cardsPage = loginPage.login(authInfo.getLogin(), authInfo.getPassword()).verifyCode(verificationCode.getCode());

        DataHelper.UserInfo userInfo = DataHelper.getUserInfo(authInfo);
        int firstCardBalance = cardsPage.getCardBalance(userInfo.getCards()[0]);
        int secondCardBalance = cardsPage.getCardBalance(userInfo.getCards()[1]);

        cardsPage = cardsPage.topUp(userInfo.getCards()[0]).transfer("200", userInfo.getCards()[1]);

        assertEquals(firstCardBalance + 200, cardsPage.getCardBalance(userInfo.getCards()[0]), "Баланс должен быть 10200");
        assertEquals(secondCardBalance - 200, cardsPage.getCardBalance(userInfo.getCards()[1]), "Баланс должен быть 9800");
    }
}
