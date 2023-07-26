package ru.netology.data;

import lombok.Value;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DataHelper {

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    public AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }


    @Value
    public static class VerificationCode {
        String code;
    }

    public VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class UserInfo {
        String[] cards;
    }

    public UserInfo getUserInfo(AuthInfo authInfo) {
        return new UserInfo(new String[]{"5559 0000 0000 0001", "5559 0000 0000 0002"});
    }
}
