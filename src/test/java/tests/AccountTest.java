package tests;

import models.Account;
import models.AccountFactory;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class AccountTest extends BaseTest {

    Account account;

    @Test(description = "user can create an account")
    public void createAccount() {
        boolean isHomePageOpened = loginPage
                .open()
                .login("yulion-28-fkcq@force.com", "password555")
                .isPageOpened("Home");
        assertTrue(isHomePageOpened, "HomePage isn't opened");

        boolean isAccountPageOpened = accountPage
                .open()
                .isPageOpened("Accounts");
        assertTrue(isAccountPageOpened, "AccountPage isn't opened");

        accountPage
                .clickNew()
                .createAccount(account = AccountFactory.get())
                .clickSave();
    }
}
