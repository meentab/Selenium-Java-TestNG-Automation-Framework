package tests;

import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {
        LoginPage lp = new LoginPage(driver);
        lp.open("https://opensource-demo.orangehrmlive.com/");
        lp.login("Admin","admin123");

        DashboardPage dp = new DashboardPage(driver);
        // Add logout steps and assertions
    }
}
