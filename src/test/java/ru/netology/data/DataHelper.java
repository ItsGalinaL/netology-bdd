package ru.netology.data;

public class DataHelper {

    private DataHelper() {
    }

    public static User getUser() {
        return new User("vasya", "qwerty123", "12345", new String[]{"5559 0000 0000 0001", "5559 0000 0000 0002"});
    }
}
