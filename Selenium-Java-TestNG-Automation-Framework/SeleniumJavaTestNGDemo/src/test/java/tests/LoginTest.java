package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage lp = new LoginPage(driver);
        lp.open("https://opensource-demo.orangehrmlive.com/");
        lp.login("Admin", "admin123");
        // Add assertions as needed
    }
}
