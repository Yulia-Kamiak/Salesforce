package tests;

import org.testng.annotations.Test;

public class AccountTest extends BaseTest {

    @Test
    public void createAccount() {
        loginPage.open();
        loginPage.login("yulion-28-fkcq@force.com", "password555");
        accountPage.open();
        accountPage.createAccount("This account", "-", "123456", "123456",
                "pampampam.com", "50", "1000000", "This description",
                "Street", "City", "State", "11122", "Country");
    }

}
