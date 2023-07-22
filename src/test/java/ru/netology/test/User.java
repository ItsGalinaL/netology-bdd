package ru.netology.test;

import lombok.Value;

@Value
public class User {

    String login;
    String password;
    String validationCode;
    String[] cards;
}
