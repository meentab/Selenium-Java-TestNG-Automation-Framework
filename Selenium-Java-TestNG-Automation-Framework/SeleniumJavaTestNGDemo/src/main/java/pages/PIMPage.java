package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PIMPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By addEmployeeBtn = By.id("btnAdd");

    public PIMPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAddEmployee() {
        WebElement btn = null;
        By[] possibles = new By[] {
            By.id("btnAdd"),
            By.cssSelector("button#btnAdd"),
            By.cssSelector("button[aria-label*='Add']"),
            By.xpath("//button[contains(.,'Add') or contains(.,'Add Employee')]")
        };

        for (By loc : possibles) {
            try {
                btn = wait.until(ExpectedConditions.elementToBeClickable(loc));
                break;
            } catch (Exception ignored) {}
        }

        if (btn == null) {
            try {
                String src = driver.getPageSource();
                java.nio.file.Files.writeString(java.nio.file.Path.of("target/pim-page-source.html"), src);
            } catch (Exception e) {}
            throw new org.openqa.selenium.NoSuchElementException("Could not locate Add Employee button. Page source saved to target/pim-page-source.html");
        }

        try {
            btn.click();
            return;
        } catch (ElementClickInterceptedException e) {
            // try scrolling into view and clicking via JS
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", btn);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
                return;
            } catch (Exception ignored) {}

            // try Actions moveToElement click
            try {
                new Actions(driver).moveToElement(btn).click().perform();
                return;
            } catch (Exception ignored) {}

            // final retry: wait until clickable then click
            try {
                wait.until(ExpectedConditions.elementToBeClickable(btn));
                btn.click();
                return;
            } catch (Exception ignored) {}
        }
    }

    public void openModule() {
        // direct navigate to PIM module URL
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPimModule");
        // wait briefly for the list or add button to appear
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".oxd-table-card, .oxd-table")));
        } catch (Exception ignored) {}
    }

    // Add PIM-specific helpers here
}
