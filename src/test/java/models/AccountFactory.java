package models;

import com.github.javafaker.Faker;

public class AccountFactory {

    static Faker faker;
    public static Account get() {
        faker = new Faker();
        return new Account(faker.name().fullName(), "-", faker.phoneNumber().phoneNumber(), "46545",
                faker.internet().url(), "100", "5000000", "This description",
                "Street", "City", "State", "12345", "Country");
    }
}
