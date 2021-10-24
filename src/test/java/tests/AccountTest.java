package tests;

import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import models.Account;
import models.AccountFactory;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class AccountTest extends BaseTest {

    Account account;
    String user;
    String password;

    @TmsLink("teachmeskills")
    @Issue("dev.by")
    @Test(description = "user can create an account")
    public void createAccount() {

        user = System.getenv().getOrDefault("SF_USER", "");
        password = System.getenv().getOrDefault("SF_PASSWORD", "");
        boolean isHomePageOpened = loginPage
                .open()
                .login(user, password)
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
