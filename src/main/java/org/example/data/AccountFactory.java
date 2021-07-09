package org.example.data;

import net.bytebuddy.utility.RandomString;
import org.example.data.Account;

public class AccountFactory {
    private static RandomString random = new RandomString();

    private static final String LOGIN_EMAIL = "login@login.com";
    private static final String LOGIN_PASSWORD = "password123";
    private static final String LOGIN_INVALID_PASSWORD = "123";

    private static final String FIRST_NAME = random.make(5);
    private static final String LAST_NAME = random.make(7);
    private static final String EMAIL = random.make(5) + "@mail.mail";
    private static String INVALID_EMAIL = "xzlk8@vmani.com";
    private static final String TELEPHONE = "1234567890";
    private static final String PASSWORD = "qwerty";

    public static Account getAccountForRegistration() {
        Account account = new Account(FIRST_NAME, LAST_NAME, EMAIL, TELEPHONE, PASSWORD);
        return account;
    }

    public static Account getAccountForRegistrationInvalidEmail() {
        Account account = new Account(FIRST_NAME, LAST_NAME, INVALID_EMAIL, TELEPHONE, PASSWORD);
        return account;
    }

    public static Account getAccountForLogin() {
        Account account = new Account(LOGIN_EMAIL, LOGIN_PASSWORD);
        return account;
    }

    public static Account getAccountForLoginInvalidPassword() {
        Account account = new Account(LOGIN_EMAIL, LOGIN_INVALID_PASSWORD);
        return account;
    }
}
