package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void invalidLoginTest() {
        LoginPage lp = new LoginPage(driver);
        lp.open("https://opensource-demo.orangehrmlive.com/");
        lp.login("invalid", "invalid");
        // Add validation for error message
    }
}
