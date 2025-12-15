package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By usernameField = By.id("txtUsername");
    private By passwordField = By.id("txtPassword");
    private By loginButton = By.id("btnLogin");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open(String url) {
        driver.get(url);
    }

    public void login(String username, String password) {
        By[] possibleUserLocators = new By[] {
            By.id("txtUsername"),
            By.name("username"),
            By.cssSelector("input[placeholder*='User']"),
            By.cssSelector("input[type='text']")
        };
        By[] possiblePassLocators = new By[] {
            By.id("txtPassword"),
            By.name("password"),
            By.cssSelector("input[type='password']")
        };

        WebElement user = null;
        for (By loc : possibleUserLocators) {
            try {
                user = wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
                break;
            } catch (Exception ignored) {}
        }

        if (user == null) {
            // dump page source to help debugging
            try {
                String src = driver.getPageSource();
                java.nio.file.Files.writeString(java.nio.file.Path.of("target/login-page-source.html"), src);
            } catch (Exception e) {
                // ignore write failures
            }
            throw new org.openqa.selenium.TimeoutException("Could not locate username field using common locators. Page source saved to target/login-page-source.html");
        }

        user.sendKeys(username);

        WebElement pass = null;
        for (By loc : possiblePassLocators) {
            try {
                pass = wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
                break;
            } catch (Exception ignored) {}
        }

        if (pass == null) {
            try {
                String src = driver.getPageSource();
                java.nio.file.Files.writeString(java.nio.file.Path.of("target/login-page-source.html"), src);
            } catch (Exception e) {}
            throw new org.openqa.selenium.TimeoutException("Could not locate password field using common locators. Page source saved to target/login-page-source.html");
        }

        pass.sendKeys(password);

        WebElement btn = null;
        try {
            btn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        } catch (Exception ignored) {}
        if (btn == null) {
            // try common button selectors
            By[] btnLocs = new By[] { By.id("btnLogin"), By.cssSelector("button[type='submit']"), By.cssSelector("button[aria-label*='Login']"), By.xpath("//button[contains(.,'Login')]") };
            for (By loc : btnLocs) {
                try {
                    btn = wait.until(ExpectedConditions.elementToBeClickable(loc));
                    break;
                } catch (Exception ignored) {}
            }
        }

        if (btn == null) {
            try {
                String src = driver.getPageSource();
                java.nio.file.Files.writeString(java.nio.file.Path.of("target/login-page-source.html"), src);
            } catch (Exception e) {}
            throw new org.openqa.selenium.TimeoutException("Could not locate login button. Page source saved to target/login-page-source.html");
        }

        btn.click();
    }
}
