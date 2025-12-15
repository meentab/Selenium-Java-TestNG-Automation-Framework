package tests;

import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardValidationTest extends BaseTest {

    @Test
    public void dashboardTitleTest() {
        LoginPage lp = new LoginPage(driver);
        lp.open("https://opensource-demo.orangehrmlive.com/");
        lp.login("Admin","admin123");

        DashboardPage dp = new DashboardPage(driver);
        String title = dp.getTitle();
        // Add assertion to validate title
    }
}
