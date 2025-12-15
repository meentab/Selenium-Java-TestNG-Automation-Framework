package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PIMPage;

public class PIMAddEmployeeTest extends BaseTest {

    @Test
    public void addEmployeeTest() {
        LoginPage lp = new LoginPage(driver);
        lp.open("https://opensource-demo.orangehrmlive.com/");
        lp.login("Admin","admin123");

        PIMPage pim = new PIMPage(driver);
        pim.openModule();
        pim.clickAddEmployee();
        // Add filling employee form and assertions
    }
}
