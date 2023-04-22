import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Exceptions {

    WebDriver driver;
    JavascriptExecutor js;

    @BeforeMethod
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");
        js = (JavascriptExecutor) driver;
    }

    @AfterMethod
    public void finish() {
        driver.quit();
    }

    @Test
    public void execute() {
        WebElement timeAlerClick = driver.findElement(By.id("timerAlertButton"));
        Duration duration = Duration.ofSeconds(3);

        try {
            js.executeScript("$(arguments[0]).click();", timeAlerClick);
            new WebDriverWait(driver, duration).until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException e) {
            System.out.println(e);
        }
    }

    @Test
    public void executeHandling() {
        WebElement timeAlerClick = driver.findElement(By.id("timerAlertButton"));
        js.executeScript("$(arguments[0]).click();", timeAlerClick);

        try {
            Duration duration = Duration.ofSeconds(6);
            new WebDriverWait(driver, duration).until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            System.out.println("Accepted alert");
        } catch (NoAlertPresentException e) {
            System.out.println(e);
        }
    }

    @Test
    public void staleElementReferenceException() {
        WebElement timeAlerClick = driver.findElement(By.id("timerAlertButton"));

        js.executeScript("arguments[0].remove();", timeAlerClick);

        try {
            js.executeScript("$(arguments[0]).click();", timeAlerClick);
        } catch (StaleElementReferenceException e) {
            System.out.println(e);
        }
    }
}
