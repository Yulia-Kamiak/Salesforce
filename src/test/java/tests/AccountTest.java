package tests;

import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import models.Account;
import models.AccountFactory;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class AccountTest extends BaseTest {

    Account account;

    @TmsLink("teachmeskills")
    @Issue("dev.by")
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
